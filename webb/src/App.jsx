import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import { useState, useEffect } from 'react';

function App() {
  // estado para los endpoints de la api
  const [endpoints, setEndpoints] = useState([]);

  // cargar los endpoints desde la api
  useEffect(() => {
    const fetchEndpoints = async () => {
      try {
        const response = await fetch('http://localhost:3001/api/endpoint'); // url de tu api
        const data = await response.json();
        setEndpoints(data); // guardar el array completo
      } catch (error) {
        console.error('Error fetching API endpoints:', error);
      }
    };

    fetchEndpoints();
  }, []);

  return (
    <Router>
      <div className="flex h-screen">
        {/* Sidebar */}
        <div className="w-64 bg-blue-700 text-white p-4">
          <h1 className="text-2xl font-bold">NovaAir Dashboard</h1>
          <ul className="mt-6">
            {endpoints.map((endpoint) => (
              <li key={endpoint.id} className="mb-4">
                <Link
                  to={endpoint.route}
                  className="cursor-pointer hover:bg-blue-500 p-2 rounded block"
                >
                  {endpoint.name.charAt(0).toUpperCase() + endpoint.name.slice(1)}
                </Link>
              </li>
            ))}
          </ul>
        </div>

        {/* Content */}
        <div className="flex-1 bg-gray-100 p-6">
          <Routes>
            {/* Ruta dinámica para cada endpoint */}
            {endpoints.map((endpoint) => (
              <Route
                key={endpoint.id}
                path={endpoint.route}
                element={<EndpointPage endpoint={endpoint.name} />}
              />
            ))}
            {/* Ruta por defecto */}
            <Route path="/" element={<HomePage />} />
          </Routes>
        </div>
      </div>
    </Router>
  );
}

// Componente para la página principal
function HomePage() {
  return <h2 className="text-xl font-semibold">Welcome to the Dashboard</h2>;
}

// Componente dinámico para cada endpoint
function EndpointPage({ endpoint }) {
  const [data, setData] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch(`/api/endpoint${endpoint}`);
        const result = await response.json();
        setData(result);
      } catch (error) {
        console.error('Error fetching endpoint data:', error);
      }
    };

    fetchData();
  }, [endpoint]);

  return (
    <div>
      <h2 className="text-xl font-semibold mb-4">Endpoint: {endpoint}</h2>
      <pre className="bg-white p-4 rounded shadow">
        {JSON.stringify(data, null, 2)}
      </pre>
    </div>
  );
}

export default App;
