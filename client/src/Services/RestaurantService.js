import axios from "axios";

const fetchRestaurantDetail = async () => {
    const token = localStorage.getItem("token");

    if (!token) {

        return;
    }

    try {
        const response = await axios.get(`http://localhost:8080/restaurant/detail?id=${id}`, {
            headers: { Authorization: `Bearer ${token}` }
        });
        return response;
    } catch (error) {
        console.log(error);
    }
};