import './App.css';
import { Route, Routes, BrowserRouter } from 'react-router-dom';
import Homepage from './Feature/Homepage/Homepage'
import LoginPage from './Feature/Login/LoginPage'

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/home" element={<Homepage />}></Route>
        <Route path="/login" element={<LoginPage />}></Route>
      </Routes>
    </BrowserRouter>
  )
}
