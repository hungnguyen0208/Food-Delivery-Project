import React from 'react'
import ExploreRestaurant from './ExploreRestaurant'
import ExploreFood from './ExploreFood'
import Hero from './Hero'

function Homepage() {
    return (
        <div>
            <Hero />
            <ExploreRestaurant />
            <ExploreFood />
        </div>
    )
}

export default Homepage