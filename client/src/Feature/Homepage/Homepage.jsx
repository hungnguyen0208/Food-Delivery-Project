import React from 'react'
import ExploreRestaurant from './ExploreRestaurant'
import Navbar from '../Components/Navbar'
import ExploreFood from './ExploreFood'

function Homepage() {
    return (
        <div>
            <Navbar />
            <ExploreRestaurant />
            <ExploreFood />
        </div>
    )
}

export default Homepage