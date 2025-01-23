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
        setEndpoints(data); // guardar el array com pleto
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
          <h1 className="text-2xl font-bold">NovaAir</h1>
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
  return <h2 className="text-xl font-semibold">Welcome to my house bababa</h2>;
}

function EndpointPage({ endpoint }) {
  const [data, setData] = useState([]);
  const [searchTerm, setSearchTerm] = useState('');
  const [filteredData, setFilteredData] = useState([]);
  const [editItem, setEditItem] = useState(null);
  const [searchBy, setSearchBy] = useState(''); 
  const [newItem, setNewItem] = useState({});
  const [isAdding, setIsAdding] = useState(false);



  // Fetch data
  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch(`http://localhost:3001/api/${endpoint}`);
        const result = await response.json();
        setData(result);
        setFilteredData(result);
      } catch (error) {
        console.error('Error fetching endpoint data:', error);
      }
    };
    fetchData();
  }, [endpoint]);

  // Filter data
  useEffect(() => {
    setFilteredData(
      data.filter((item) =>
        searchBy
          ? item[searchBy]?.toString().toLowerCase().includes(searchTerm.toLowerCase())
          : Object.values(item)
              .join(' ')
              .toLowerCase()
              .includes(searchTerm.toLowerCase())
      )
    );
  }, [searchTerm, searchBy, data]);
  

  const handleSearchChange = (e) => setSearchTerm(e.target.value);

  const handleDelete = async (id) => {
    try {
      const response = await fetch(`http://localhost:3001/api/${endpoint}/${id}`, {
        method: 'DELETE',
      });
      if (response.ok) {
        setData(data.filter((item) => item.id !== id));
      }
    } catch (error) {
      console.error(error);
    }
  };
  const handleEdit = (item) => setEditItem(item);

  const handleSaveEdit = async () => {
    try {
      const response = await fetch(`http://localhost:3001/api/${endpoint}/${editItem.id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(editItem),
      });
      if (response.ok) {
        setData(data.map((item) => (item.id === editItem.id ? editItem : item)));
        setEditItem(null);
      }
    } catch (error) {
      console.error(error);
    }
  };
 const handleAddNew = async () => {
  try {
    const response = await fetch(`http://localhost:3001/api/${endpoint}`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(newItem), // No incluye el id
    });

    if (response.ok) {
      const addedItem = await response.json();
      setData([...data, addedItem]);
      setFilteredData([...filteredData, addedItem]);
      setIsAdding(false); // Cierra el modal
      setNewItem({}); // Limpia el formulario
    } else {
      console.error('Failed to add the new item.');
    }
  } catch (error) {
    console.error('Error adding the new item:', error);
  }
};
  return (
    <div>
      <h2 className="text-xl font-semibold mb-4">{endpoint}</h2>
      <div className="mb-6 flex gap-4 items-center">
      <select
        className="p-2 border border-gray-300 rounded"
        value={searchBy}
        onChange={(e) => setSearchBy(e.target.value)}
      >
        <option value="">All</option>
        {data.length > 0 &&
          Object.keys(data[0]).map((key) => (
            <option key={key} value={key}>
              {key}
            </option>
          ))}
      </select>
      <input
        type="text"
        placeholder="Search..."
        className="p-2 border border-gray-300 rounded w-full"
        value={searchTerm}
        onChange={handleSearchChange}
      />
    </div>
      {/* Modal */}
      {/* Modal */}
{editItem && (
  <div className="fixed inset-0 bg-black bg-opacity-50 flex justify-center items-center">
    <div className="bg-white p-6 rounded shadow-lg w-96">
      <h3 className="text-lg font-semibold mb-4">Edit Item</h3>
      {Object.entries(editItem).map(([key, value]) => (
        <div key={key} className="mb-4">
          <label className="block font-bold capitalize">{key}</label>
          {key === 'id' ? (
            // Mostrar el id como texto
            <p className="bg-gray-100 p-2 rounded">{value}</p>
          ) : (
            // Mostrar los demás atributos como inputs
            <input
              type="text"
              value={value}
              className="w-full p-2 border border-gray-300 rounded"
              onChange={(e) =>
                setEditItem({ ...editItem, [key]: e.target.value })
              }
            />
          )}
        </div>
      ))}
      <div className="flex justify-end space-x-4">
        <button
          className="bg-gray-500 text-white py-1 px-3 rounded hover:bg-gray-600"
          onClick={() => setEditItem(null)}
        >
          Cancel
        </button>
        <button
          className="bg-green-500 text-white py-1 px-3 rounded hover:bg-green-600"
          onClick={handleSaveEdit}
        >
          Save
        </button>
      </div>
    </div>
  </div>
)}

      {isAdding && (
  <div className="fixed inset-0 bg-black bg-opacity-50 flex justify-center items-center">
    <div className="bg-white p-6 rounded shadow-lg w-96">
      <h3 className="text-lg font-semibold mb-4">Add New Item</h3>
      {Object.keys(data[0] || {})
        .filter((key) => key !== 'id') 
        .map((key) => (
          <div key={key} className="mb-4">
            <label className="block font-bold capitalize">{key}</label>
            <input
              type="text"
              className="w-full p-2 border border-gray-300 rounded"
              value={newItem[key] || ''}
              onChange={(e) =>
                setNewItem({ ...newItem, [key]: e.target.value })
              }
            />
          </div>
        ))}
      <div className="flex justify-end space-x-4">
        <button
          className="bg-gray-500 text-white py-1 px-3 rounded hover:bg-gray-600"
          onClick={() => setIsAdding(false)}
        >
          Cancel
        </button>
        <button
          className="bg-green-500 text-white py-1 px-3 rounded hover:bg-green-600"
          onClick={handleAddNew}
        >
          Add
        </button>
      </div>
    </div>
  </div>
)}
      <div className="flex justify-between mb-6">
        <h2 className="text-xl font-semibold">{endpoint}</h2>
        <button
          className="bg-blue-500 text-white py-1 px-3 rounded hover:bg-blue-600"
          onClick={() => setIsAdding(true)}
        >
          Add New
        </button>
      </div>
      <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-4">
        {filteredData.map((item) => (
          <div
            key={item.id}
            className="bg-white p-4 rounded shadow border border-gray-300"
          >
            {Object.entries(item).map(([key, value]) => (
              <div key={key} className="mb-2">
                <span className="font-bold capitalize">{key}:</span> {value}
              </div>
            ))}
            <div className="mt-4 flex justify-end space-x-2">
              <button
                className="bg-blue-500 text-white py-1 px-3 rounded hover:bg-blue-600"
                onClick={() => handleEdit(item)}
              >
                Edit
              </button>
              <button
                className="bg-red-500 text-white py-1 px-3 rounded hover:bg-red-600"
                onClick={() => handleDelete(item.id)}
              >
                Delete
              </button>
            </div>
          </div>
        ))} 
      </div>
    </div>
  );
}
export default App;
