import axios from 'axios';
import React, { Fragment, useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import { Dialog, Transition } from '@headlessui/react'
import { XMarkIcon } from '@heroicons/react/24/outline'

function RestaurantDetails() {
    const { id } = useParams();
    const [open, setOpen] = useState(true)

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


    return (
        <>
            {!restaurantDetail ? (
                <section>
                    <h1>This restaurant does not exist!</h1>
                    <br />
                    <p>
                        <a href="http://localhost:3000/home">Go to Home</a>
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
                                                <a key={food.id} href="" className="group" onClick={() => setOpen(true)}>
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
                                                <Transition.Root show={open} as={Fragment}>
                                                    <Dialog as="div" className="relative z-10" onClose={setOpen}>
                                                        <Transition.Child
                                                            as={Fragment}
                                                            enter="ease-in-out duration-500"
                                                            enterFrom="opacity-0"
                                                            enterTo="opacity-100"
                                                            leave="ease-in-out duration-500"
                                                            leaveFrom="opacity-100"
                                                            leaveTo="opacity-0"
                                                        >
                                                            <div className="fixed inset-0 bg-gray-500 bg-opacity-75 transition-opacity" />
                                                        </Transition.Child>

                                                        <div className="fixed inset-0 overflow-hidden">
                                                            <div className="absolute inset-0 overflow-hidden">
                                                                <div className="pointer-events-none fixed inset-y-0 right-0 flex max-w-full pl-10">
                                                                    <Transition.Child
                                                                        as={Fragment}
                                                                        enter="transform transition ease-in-out duration-500 sm:duration-700"
                                                                        enterFrom="translate-x-full"
                                                                        enterTo="translate-x-0"
                                                                        leave="transform transition ease-in-out duration-500 sm:duration-700"
                                                                        leaveFrom="translate-x-0"
                                                                        leaveTo="translate-x-full"
                                                                    >
                                                                        <Dialog.Panel className="pointer-events-auto w-screen max-w-md">
                                                                            <div className="flex h-full flex-col overflow-y-scroll bg-white shadow-xl">
                                                                                <div className="flex-1 overflow-y-auto px-4 py-6 sm:px-6">
                                                                                    <div className="flex items-start justify-between">
                                                                                        <Dialog.Title className="text-lg font-medium text-gray-900">Your choices</Dialog.Title>
                                                                                        <div className="ml-3 flex h-7 items-center">
                                                                                            <button
                                                                                                type="button"
                                                                                                className="relative -m-2 p-2 text-gray-400 hover:text-gray-500"
                                                                                                onClick={() => setOpen(false)}
                                                                                            >
                                                                                                <span className="absolute -inset-0.5" />
                                                                                                <span className="sr-only">Close panel</span>
                                                                                                <XMarkIcon className="h-6 w-6" aria-hidden="true" />
                                                                                            </button>
                                                                                        </div>
                                                                                    </div>

                                                                                    <div className="mt-8">
                                                                                        <div className="flow-root">
                                                                                            <ul role="list" className="-my-6 divide-y divide-gray-200">

                                                                                                <li className="flex py-6">
                                                                                                    <div className="h-24 w-24 flex-shrink-0 overflow-hidden rounded-md border border-gray-200">
                                                                                                        <img
                                                                                                            src={`${menuLink}/file/${food.image}`}
                                                                                                            alt={food.title}
                                                                                                            className="h-full w-full object-cover object-center"
                                                                                                        />
                                                                                                    </div>

                                                                                                    <div className="ml-4 flex flex-1 flex-col">
                                                                                                        <div>
                                                                                                            <div className="flex justify-between text-base font-medium text-gray-900">
                                                                                                                <h3>
                                                                                                                    <p>{food.name}</p>
                                                                                                                </h3>
                                                                                                                <p className="ml-4">{food.price}</p>
                                                                                                            </div>
                                                                                                            <p className="mt-1 text-sm text-gray-500">{food.description}</p>
                                                                                                        </div>
                                                                                                        <div className="flex flex-1 items-end justify-between text-sm">
                                                                                                            <p className="text-gray-500">Price {food.price}</p>

                                                                                                            <div className="flex">
                                                                                                                <button
                                                                                                                    type="button"
                                                                                                                    className="font-medium text-indigo-600 hover:text-indigo-500"
                                                                                                                >
                                                                                                                    Remove
                                                                                                                </button>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                </li>

                                                                                            </ul>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>

                                                                                <div className="border-t border-gray-200 px-4 py-6 sm:px-6">
                                                                                    <div className="flex justify-between text-base font-medium text-gray-900">
                                                                                        <p>Add to Cart</p>
                                                                                        <p>{food.price}</p>
                                                                                    </div>
                                                                                    <p className="mt-0.5 text-sm text-gray-500">Shipping and taxes calculated at checkout.</p>
                                                                                    <div className="mt-6">
                                                                                        <a
                                                                                            href="#"
                                                                                            className="flex items-center justify-center rounded-md border border-transparent bg-indigo-600 px-6 py-3 text-base font-medium text-white shadow-sm hover:bg-indigo-700"
                                                                                        >
                                                                                            Checkout
                                                                                        </a>
                                                                                    </div>
                                                                                    <div className="mt-6 flex justify-center text-center text-sm text-gray-500">
                                                                                        <p>
                                                                                            or{' '}
                                                                                            <button
                                                                                                type="button"
                                                                                                className="font-medium text-indigo-600 hover:text-indigo-500"
                                                                                                onClick={() => setOpen(false)}
                                                                                            >
                                                                                                Continue Shopping
                                                                                                <span aria-hidden="true"> &rarr;</span>
                                                                                            </button>
                                                                                        </p>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </Dialog.Panel>
                                                                    </Transition.Child>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </Dialog>
                                                </Transition.Root>
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