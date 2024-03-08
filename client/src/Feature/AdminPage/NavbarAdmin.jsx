import React from 'react'
import logo from '../../images/logo.png'

function NavbarAdmin() {
    return (
        <div>
            <nav >
                <div className="container mx-auto px-4 py-2 flex justify-between items-center">
                    <a href="/" className="logo flex items-center">
                        <img src={logo} alt='logo' className='h-8 w-auto' />
                    </a>
                    <ul className="nav-links hidden md:flex space-x-4 bg-gray-900 text-white : text-gray-300 hover:bg-gray-700 hover:text-white rounded-md px-3 py-2 text-sm font-medium">
                        <li><a href="/admin/users" className="nav-link ">User</a></li>
                        <li><a href="/admin/categories" className="nav-link">Categories</a></li>
                        <li><a href="admin/restaurants" className="nav-link">Restaurants</a></li>
                        <li><a href="admin/foods" className="nav-link">Foods</a></li>
                        <li><a href="admin/customers" className="nav-link">Customers</a></li>
                        <li><a href="admin/shipping" className="nav-link">Shipping</a></li>
                        <li><a href="admin/orders" className="nav-link">Orders</a></li>
                        <li><a href="admin/salesreport" className="nav-link">Sales Report</a></li>
                        <li><a href="admin/setting" className="nav-link">Setting</a></li>
                    </ul>
                    <div className="actions hidden md:flex space-x-2">
                        <a href="#" className="btn btn-primary">Order Now</a>
                        <a href="#" className="btn btn-outline">Login</a>
                    </div>
                    <button className="md:hidden toggle-menu focus:outline-none">
                        <svg className="w-6 h-6 text-gray-700" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M4 6h16v12H4zM4 12h16v12H4z"></path></svg>
                    </button>
                </div>
            </nav>
        </div>
    )
}

export default NavbarAdmin