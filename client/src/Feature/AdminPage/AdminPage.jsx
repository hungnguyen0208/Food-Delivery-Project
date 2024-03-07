import React from 'react'
import logo from '../../images/logo.png'

function AdminPage() {
    return (
        <>
            <div>
                <nav >
                    <div class="container mx-auto px-4 py-2 flex justify-between items-center">
                        <a href="/" class="logo flex items-center">
                            <img src={logo} alt='logo' className='h-8 w-auto' />
                        </a>
                        <ul class="nav-links hidden md:flex space-x-4 bg-gray-900 text-white : text-gray-300 hover:bg-gray-700 hover:text-white rounded-md px-3 py-2 text-sm font-medium">
                            <li><a href="/admin/users" class="nav-link ">User</a></li>
                            <li><a href="/admin/categories" class="nav-link">Categories</a></li>
                            <li><a href="admin/restaurants" class="nav-link">Restaurants</a></li>
                            <li><a href="admin/foods" class="nav-link">Foods</a></li>
                            <li><a href="admin/customers" class="nav-link">Customers</a></li>
                            <li><a href="admin/shipping" class="nav-link">Shipping</a></li>
                            <li><a href="admin/orders" class="nav-link">Orders</a></li>
                            <li><a href="admin/salesreport" class="nav-link">Sales Report</a></li>
                            <li><a href="admin/setting" class="nav-link">Setting</a></li>
                        </ul>
                        <div class="actions hidden md:flex space-x-2">
                            <a href="#" class="btn btn-primary">Order Now</a>
                            <a href="#" class="btn btn-outline">Login</a>
                        </div>
                        <button class="md:hidden toggle-menu focus:outline-none">
                            <svg class="w-6 h-6 text-gray-700" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16v12H4zM4 12h16v12H4z"></path></svg>
                        </button>
                    </div>
                </nav>
            </div>
            <div>
                <h1>Welcome to the admin page</h1>
            </div>
        </>
    )
}

export default AdminPage