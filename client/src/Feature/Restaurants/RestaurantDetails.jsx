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
    }, []);

    console.log(restaurantDetail);
    const restaurantLink = 'http://localhost:8080/restaurant';
    return (
        <div>
            <h2>Restaurant Detail - {id}</h2>
        </div>
    )
}

export default RestaurantDetails