import React, { useState, useContext } from 'react';
import { useNavigate } from 'react-router-dom';
import { AuthContext } from '../context/AuthContext';
import 'react-toastify/dist/ReactToastify.css';

const Login = () => {
  const [credentials, setCredentials] = useState({ username: '', password: '' });
  const navigate = useNavigate();
  const { login } = useContext(AuthContext);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setCredentials({ ...credentials, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    
    // Construir la URL con los parámetros de la consulta
    const url = new URL('http://localhost:3001/login');
    const params = {
      username: credentials.username,
      password: credentials.password,
    };
    
    // Añadir los parámetros a la URL
    Object.keys(params).forEach(key => url.searchParams.append(key, params[key]));
    
    // Realizar la solicitud GET (ya que estamos usando parámetros en la URL)
    const response = await fetch(url, {
      method: 'POST', // Cambiar a GET porque estamos usando parámetros de consulta
    });
    
    if (response.ok) {
      const data = await response.json();
      const token = data.token; // El token es retornado aquí
      login(token); // Guardamos el token en el contexto
      navigate('/airports'); // Redirige a la página de aeropuertos
    } else {
      alert('Error de autenticación');
    }
  };
  
  return (
    <div className="flex items-center justify-center h-screen bg-gray-900">
      <div className="w-full max-w-xs">
        <form onSubmit={handleSubmit} className="bg-gray-800 shadow-md rounded px-8 pt-6 pb-8 mb-4">
          <h1 className="text-2xl font-bold text-white mb-4">Login</h1>
          <div className="mb-4">
            <label className="block text-white text-sm font-bold mb-2" htmlFor="username">
              Username
            </label>
            <input
              type="text"
              name="username"
              id="username"
              placeholder="Username"
              value={credentials.username}
              onChange={handleChange}
              className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            />
          </div>
          <div className="mb-6">
            <label className="block text-white text-sm font-bold mb-2" htmlFor="password">
              Password
            </label>
            <input
              type="password"
              name="password"
              id="password"
              placeholder="Password"
              value={credentials.password}
              onChange={handleChange}
              className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 mb-3 leading-tight focus:outline-none focus:shadow-outline"
            />
          </div>
          <div className="flex items-center justify-between">
            <button
              type="submit"
              className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
            >
              Login
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default Login;
