import axios from 'axios';
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';

function CreateUserPage() {
    const [formData, setFormData] = useState({
        email: '',
        password: '',
        fullname: '',
        roleId: null
    });

    const navigate = useNavigate();

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        const roleIdValue = name === "roleId" ? parseInt(value, 10) : value;
        setFormData({
            ...formData,
            [name]: roleIdValue,
        });
    }

    const handleSubmit = async (e) => {
        e.preventDefault();

        const token = localStorage.getItem("token");

        if (!token) {
            // redirect to login
            return;
        }

        try {
            const response = await axios.post('http://localhost:8080/client/signup', formData, {
                headers: { Authorization: `Bearer ${token}` }
            });
            if (response.data.successful) {
                navigate('/admin/users', { replace: true });
            }

        } catch (error) {
            console.log(error);
        }
    }

    console.log(formData);

    return (
        <div className="max-w-md mx-auto my-8 p-6 bg-white rounded-md shadow-md">
            <h2 className="text-2xl font-semibold mb-6">Manage Users | Create new User</h2>
            <form onSubmit={handleSubmit}>
                <div className="mb-4">
                    <label className="block text-sm font-medium text-gray-600">Email:</label>
                    <input
                        className="w-full p-2 border border-gray-300 rounded-md"
                        type="email"
                        name="email"
                        value={formData.email}
                        onChange={handleInputChange}
                        required
                    />
                </div>
                <div className="mb-4">
                    <label className="block text-sm font-medium text-gray-600">Fullname:</label>
                    <input
                        className="w-full p-2 border border-gray-300 rounded-md"
                        type="text"
                        name="fullname"
                        value={formData.fullname}
                        onChange={handleInputChange}
                        required
                        minLength="8"
                        maxLength="20"
                    />
                </div>
                <div className="mb-4">
                    <label className="block text-sm font-medium text-gray-600">Password:</label>
                    <input
                        className="w-full p-2 border border-gray-300 rounded-md"
                        type="password"
                        name="password"
                        value={formData.password}
                        onChange={handleInputChange}
                        required
                    />
                </div>
                <div className="mb-4">
                    <label className="block text-sm font-medium text-gray-600">Roles:</label>
                    <div className="grid grid-cols-2 gap-4">
                        <div>
                            <label className="flex items-center">
                                <input
                                    type="radio"
                                    name="roleId"
                                    value="1"
                                    checked={formData.roleId === 1}
                                    onChange={handleInputChange}
                                    className="mr-2" />
                                Admin
                            </label>
                        </div>
                        <div>
                            <label className="flex items-center">
                                <input
                                    type="radio"
                                    name="roleId"
                                    value="2"
                                    checked={formData.roleId === 2}
                                    onChange={handleInputChange}
                                    className="mr-2" />
                                User
                            </label>
                        </div>
                        <div>
                            <label className="flex items-center">
                                <input
                                    type="radio"
                                    name="roleId"
                                    value="3"
                                    checked={formData.roleId === 3}
                                    onChange={handleInputChange}
                                    className="mr-2" />
                                Salesperson
                            </label>
                        </div>
                        <div>
                            <label className="flex items-center">
                                <input
                                    type="radio"
                                    name="roleId"
                                    value="4"
                                    checked={formData.roleId === 4}
                                    onChange={handleInputChange}
                                    className="mr-2" />
                                Editor
                            </label>
                        </div>
                        <div>
                            <label className="flex items-center">
                                <input
                                    type="radio"
                                    name="roleId"
                                    value="5"
                                    checked={formData.roleId === 5}
                                    onChange={handleInputChange}
                                    className="mr-2" />
                                Shipper
                            </label>
                        </div>
                        <div>
                            <label className="flex items-center">
                                <input
                                    type="radio"
                                    name="roleId"
                                    value="6"
                                    checked={formData.roleId === 6}
                                    onChange={handleInputChange}
                                    className="mr-2" />
                                Assistant
                            </label>
                        </div>
                    </div>
                </div>
                <div className="flex space-x-4">
                    <input
                        type="submit"
                        value="Save"
                        className="bg-blue-500 text-white px-4 py-2 rounded-md hover:bg-blue-700 cursor-pointer"
                    />
                    <input
                        type="button"
                        value="Cancel"
                        className="bg-gray-300 text-gray-700 px-4 py-2 rounded-md hover:bg-gray-400 cursor-pointer"
                    />
                </div>
            </form>
        </div>
    )
}

export default CreateUserPage