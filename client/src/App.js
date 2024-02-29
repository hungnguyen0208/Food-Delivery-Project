import './App.css';
import { Route, Routes, BrowserRouter } from 'react-router-dom';
import LoginPage from './Feature/Login/LoginPage';

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/login" element={<LoginPage />}></Route>
      </Routes>
    </BrowserRouter>
  )
}
