import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom';

function ExploreRestaurant() {

    const [restaurants, setRestaurants] = useState([]);
    useEffect(() => {
        const fetchRestaurants = async () => {
            const token = localStorage.getItem("token");

            if (!token) {
                // redirect to login
                return;
            }

            try {
                const response = await axios.get('http://localhost:8080/restaurant', {
                    headers: { Authorization: `Bearer ${token}` }
                });
                setRestaurants(response.data.data);
            } catch (error) {
                console.log(error);
            }
        };

        fetchRestaurants();
    }, []);

    //console.log(restaurants);
    const restaurantLink = 'http://localhost:8080/restaurant';

    return (
        <div className="bg-white">
            <div className="mx-auto max-w-2xl px-4 py-16 sm:px-6 sm:py-24 lg:max-w-7xl lg:px-8">
                <h2 className="not-sr-onlysr-only">Restaurants</h2>

                <div className="grid grid-cols-1 gap-x-6 gap-y-10 sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 xl:gap-x-8">
                    {restaurants.map((restaurant) => (
                        <div key={restaurant.id} href="#" className="group">
                            <Link to={`/restaurant/detail/${restaurant.id}`}>
                                <div className="aspect-h-1 aspect-w-1 w-full overflow-hidden rounded-lg bg-gray-200 xl:aspect-h-8 xl:aspect-w-7">
                                    <img
                                        src={`${restaurantLink}/file/${restaurant.image}`}
                                        alt={restaurant.title}
                                        className="h-full w-full object-cover object-center group-hover:opacity-75"
                                    />
                                </div>
                                <h3 className="mt-1 text-lg font-medium text-gray-900">{restaurant.title}</h3>
                                <p className="mt-4 text-sm text-gray-700">{restaurant.subtitle}</p>
                                <p className="mt-4 text-sm text-gray-700">{restaurant.freeShip ? "Free Ship" : ""}</p>
                            </Link>
                        </div>
                    ))}
                </div>
            </div>
        </div>
    )
}

export default ExploreRestaurant
