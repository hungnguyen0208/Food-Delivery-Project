import React, { useEffect, useState } from 'react'
import NavbarAdmin from '../NavbarAdmin'
import axios from 'axios';

function ManageUsersPage() {
    const [users, setUsers] = useState([]);

    useEffect(() => {
        const fetchCategories = async () => {
            const token = localStorage.getItem("token");

            if (!token) {
                // redirect to login
                return;
            }

            try {
                const response = await axios.get('http://localhost:8080/user', {
                    headers: { Authorization: `Bearer ${token}` }
                });
                setUsers(response.data);

            } catch (error) {
                console.log(error);
            }
        };

        fetchCategories();
    }, []);

    console.log(users);

    const handleEdit = (userId) => { };
    const handleDelete = (userId) => { };

    return (
        <div>
            <NavbarAdmin />
            <div className="container mx-auto px-4 py-2">
                <h2 className="text-3xl font-semibold mb-4">Manage Users</h2>
                <a href='/admin/users/create'
                    className="bg-green-500 hover:bg-green-700 text-white py-2 px-4 rounded inline-block">Create new user</a>
                <div className="overflow-x-auto rounded-lg shadow-md">
                    <table className="min-w-full bg-white border border-gray-300">
                        <thead>
                            <tr>
                                <th className="py-2 px-4 border-b text-left font-semibold text-sm text-gray-700">User ID</th>
                                <th className="py-2 px-4 border-b text-left font-semibold text-sm text-gray-700">Username</th>
                                <th className="py-2 px-4 border-b text-left font-semibold text-sm text-gray-700">Fullname</th>
                                <th className="py-2 px-4 border-b text-left font-semibold text-sm text-gray-700">Created date</th>
                                <th className="py-2 px-4 border-b text-left font-semibold text-sm text-gray-700">Role</th>
                            </tr>
                        </thead>
                        <tbody>
                            {users.map((user) => (
                                <tr key={user.id}>
                                    <td className="py-2 px-4 border-b">{user.id}</td>
                                    <td className="py-2 px-4 border-b">{user.userName}</td>
                                    <td className="py-2 px-4 border-b">{user.fullname}</td>
                                    <td className="py-2 px-4 border-b">{user.createDate}</td>
                                    <td className="py-2 px-4 border-b">{user.role}</td>
                                    <td className="py-2 px-4 border-b text-right">
                                        <button
                                            className="bg-blue-500 hover:bg-blue-700 text-white py-1 px-2 mr-2 rounded"
                                            onClick={() => handleEdit(user.id)}
                                        >
                                            Edit
                                        </button>
                                        <button
                                            className="bg-red-500 hover:bg-red-700 text-white py-1 px-2 rounded"
                                            onClick={() => handleDelete(user.id)}
                                        >
                                            Delete
                                        </button>
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    )
}

export default ManageUsersPage