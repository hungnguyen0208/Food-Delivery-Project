import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'

function RestaurantDetails() {
    const { id } = useParams();

    const [restaurantDetail, setRestaurantDetail] = useState([]);
    useEffect(() => {
        const fetchRestaurantDetail = async () => {
            const token = localStorage.getItem("token");

            if (!token) {
                // redirect to login
                return;
            }

            try {
                const response = await axios.get(`http://localhost:8080/restaurant/detail?id=${id}`, {
                    headers: { Authorization: `Bearer ${token}` }
                });
                setRestaurantDetail(response.data.data);
            } catch (error) {
                console.log(error);
            }
        };

        fetchRestaurantDetail();

    }, [id]);

    const restaurantLink = 'http://localhost:8080/restaurant';
    const menuLink = 'http://localhost:8080/menu';

    //console.log(restaurantDetail);
    return (
        <>
            {!restaurantDetail ? (
                <section>
                    <h1>This restaurant does not exist!</h1>
                    <br />
                    <p>
                        <a href="http://localhost:3000">Go to Home</a>
                    </p>
                </section>
            ) : (
                <div>
                    <div className="bg-white">
                        <div className="mx-auto grid max-w-2xl grid-cols-1 items-center gap-x-8 gap-y-16 px-4 py-24 sm:px-6 sm:py-32 lg:max-w-7xl lg:grid-cols-2 lg:px-8">
                            <div className="flex lg:flex-row flex-col items-center justify-center lg:h-screen">
                                <div className="lg:w-1/2 px-4">
                                    <h2 className="text-3xl font-bold tracking-tight text-gray-900 sm:text-4xl">{restaurantDetail.title}</h2>
                                    <p className="mt-4 text-gray-500">{restaurantDetail.subtitle}</p>
                                    <p className="mt-4 text-gray-500">{`Description: ${restaurantDetail.description}`}</p>
                                    <p className="mt-4 text-gray-500">{`Address: ${restaurantDetail.address}`}</p>
                                    <h2 className="text-3xl font-bold tracking-tight text-gray-900 sm:text-2xl">{`Rating: ${restaurantDetail.rating}`}</h2>
                                </div>
                                <div className="hidden lg:block lg:w-1/2 lg:overflow-hidden rounded-lg object-cover">
                                    <img
                                        src={`${restaurantLink}/file/${restaurantDetail.image}`}
                                        alt={restaurantDetail.title}
                                        className="w-24 h-24 mx-auto"
                                    />
                                </div>
                            </div>

                            <dl className="mt-16 grid grid-cols-1 gap-x-6 gap-y-10 sm:grid-cols-2 sm:gap-y-16 lg:gap-x-8">
                                {restaurantDetail.categories && restaurantDetail.categories.map((category) => (
                                    <div key={category.id} className="border-t border-gray-200 pt-4">
                                        <dt className="font-medium text-gray-900">{category.name}</dt>
                                        {category.menus && category.menus.map((food) => (
                                            <div key={food.id} className="border-t border-gray-200 pt-4">
                                                <a key={food.id} href="" className="group">
                                                    <div className="aspect-h-1 aspect-w-1 w-full overflow-hidden rounded-lg bg-gray-200 xl:aspect-h-8 xl:aspect-w-7">
                                                        <img
                                                            src={`${menuLink}/file/${food.image}`}
                                                            alt={food.title}
                                                            className="h-full w-full object-cover object-center group-hover:opacity-75"
                                                        />
                                                    </div>
                                                    <h3 className="mt-1 text-lg font-medium text-gray-900">{food.title}</h3>
                                                    <p className="mt-4 text-sm text-gray-700">{food.freeShip ? "Free Ship" : ""}</p>
                                                </a>
                                            </div>
                                        ))}
                                    </div>
                                ))}
                            </dl>
                        </div>
                    </div>
                </div >
            )
            }
        </>
    )
}

export default RestaurantDetails