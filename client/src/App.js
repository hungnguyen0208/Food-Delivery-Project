import './App.css';
import { Route, Routes, BrowserRouter } from 'react-router-dom';
import Homepage from './Feature/Homepage/Homepage'
import LoginPage from './Feature/Login/LoginPage'
import RestaurantDetailPage from './Feature/Restaurants/RestaurantDetailPage';
import AdminPage from './Feature/AdminPage/AdminPage';

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Homepage />}></Route>
        <Route path="/login" element={<LoginPage />}></Route>
        <Route path="/restaurant/detail/:id" element={<RestaurantDetailPage />}></Route>
        <Route path="/admin" element={<AdminPage />} ></Route>
      </Routes>
    </BrowserRouter>
  )
}
