import React from 'react'
import ExploreRestaurant from './ExploreRestaurant'
import ExploreFood from './ExploreFood'
import Navbar from '../Components/Navbar'
import Hero from './Hero'

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