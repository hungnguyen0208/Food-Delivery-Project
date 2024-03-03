import axios from 'axios';
import React, { useEffect, useState } from 'react'

function ExploreFood() {

    const [categories, setCategories] = useState([]);
    useEffect(() => {
        const fetchCategories = async () => {
            const token = localStorage.getItem("token");

            if (!token) {
                // redirect to login
                return;
            }

            try {
                const response = await axios.get('http://localhost:8080/category', {
                    headers: { Authorization: `Bearer ${token}` }
                });
                setCategories(response.data.data);
            } catch (error) {
                console.log(error);
            }
        };

        fetchCategories();
    }, []);

    console.log(categories);
    const menuLink = 'http://localhost:8080/menu';

    return (
        <div className="bg-white">
            <div className="mx-auto max-w-2xl px-4 py-16 sm:px-6 sm:py-24 lg:max-w-7xl lg:px-8">

                <div className="mt-6 grid grid-cols-1 gap-x-6 gap-y-10 sm:grid-cols-2 lg:grid-cols-4 xl:gap-x-8">
                    {categories.map((category) => (
                        <div key={category.id} className="group relative">
                            <h2 className="text-2xl font-bold tracking-tight text-gray-900">{category.name}</h2>
                            <div>
                                {category.menus.slice(0, 3).map((menuItem) => (
                                    <div key={menuItem.id} >
                                        <div className="aspect-h-1 aspect-w-1 w-full overflow-hidden rounded-md bg-gray-200 lg:aspect-none group-hover:opacity-75 lg:h-80">

                                            <img
                                                src={`${menuLink}/file/${menuItem.image}`}
                                                alt={category.menus.name}
                                                className="h-full w-full object-cover object-center lg:h-full lg:w-full"
                                            />
                                        </div>
                                        <div className="mt-4 flex justify-between">
                                            <div>
                                                <h3 className="text-sm text-gray-700">
                                                    <a href="#">
                                                        <span aria-hidden="true" className="absolute inset-0" />
                                                        {menuItem.name}
                                                    </a>
                                                </h3>
                                                <p className="mt-1 font-medium text-gray-900">{menuItem.title}</p>
                                            </div>
                                            <p className="mt-1 font-medium text-red-900">{menuItem.freeShip ? "Free Ship" : ""}</p>
                                        </div>
                                    </div>
                                ))}
                            </div>
                        </div>
                    ))}
                </div>
            </div>
        </div>
    )
}

export default ExploreFood;