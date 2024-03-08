import './App.css';
import { Route, Routes, BrowserRouter } from 'react-router-dom';
import Homepage from './Feature/Homepage/Homepage'
import LoginPage from './Feature/Login/LoginPage'
import RestaurantDetailPage from './Feature/Restaurants/RestaurantDetailPage';
import AdminPage from './Feature/AdminPage/AdminPage';
import ManageUsersPage from './Feature/AdminPage/Users/ManageUsersPage';
import CreateUserPage from './Feature/AdminPage/Users/CreateUserPage';
import SignupPage from './Feature/Login/Signup';

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Homepage />}></Route>
        <Route path="/login" element={<LoginPage />}></Route>
        <Route path="/signup" element={<SignupPage />} ></Route>
        <Route path="/restaurant/detail/:id" element={<RestaurantDetailPage />}></Route>
        <Route path="/admin" element={<AdminPage />} ></Route>
        <Route path="/admin/users" element={<ManageUsersPage />} ></Route>
        <Route path="/admin/users/create" element={<CreateUserPage />} ></Route>
      </Routes>
    </BrowserRouter>
  )
}
