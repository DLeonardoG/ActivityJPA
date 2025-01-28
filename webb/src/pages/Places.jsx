import React, { useState, useEffect } from 'react';
import { getFlights, createFlight, updateFlight, deleteFlight } from '../services/api';

const Flights = () => {
  const [flights, setFlights] = useState([]);
  const [newFlight, setNewFlight] = useState({ name: '', destination: '' });

  useEffect(() => {
    loadFlights();
  }, []);

  const loadFlights = async () => {
    const response = await getFlights();
    setFlights(response.data);
  };

  const handleCreate = async () => {
    await createFlight(newFlight);
    setNewFlight({ name: '', destination: '' });
    loadFlights();
  };

  const handleUpdate = async (id, updatedFlight) => {
    await updateFlight(id, updatedFlight);
    loadFlights();
  };

  const handleDelete = async (id) => {
    await deleteFlight(id);
    loadFlights();
  };

  return (
    <div className='min-h-screen'>
      <h1 className="text-2xl font-bold mb-4  text-center">Flights</h1>
      <div>
        <input
          type="text"
          placeholder="Name"
          value={newFlight.name}
          onChange={(e) => setNewFlight({ ...newFlight, name: e.target.value })}
          className="p-2 mb-2"
        />
        <input
          type="text"
          placeholder="Destination"
          value={newFlight.destination}
          onChange={(e) => setNewFlight({ ...newFlight, destination: e.target.value })}
          className="p-2 mb-2"
        />
        <button onClick={handleCreate} className="p-2 bg-blue-500 text-white">Create</button>
      </div>
      <ul>
        {flights.map((flight) => (
          <li key={flight.id} className="mb-2">
            {flight.name} - {flight.destination}
            <button onClick={() => handleUpdate(flight.id, { ...flight, name: 'Updated Name' })} className="ml-4 text-yellow-500">Update</button>
            <button onClick={() => handleDelete(flight.id)} className="ml-4 text-red-500">Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Flights;
