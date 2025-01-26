import React, { useState, useEffect } from 'react';
import { getFlights, createFlight, updateFlight, deleteFlight, getAirports, getPlanes } from '../services/api';

const Flights = () => {
  const [flights, setFlights] = useState([]);
  const [newFlight, setNewFlight] = useState({ date: '', dateArrived: '', idDestination: '', idOrigin: '', idPlane: '' });
  const [airports, setAirports] = useState([]);
  const [planes, setPlanes] = useState([]);
  const [editingFlight, setEditingFlight] = useState(null);

  useEffect(() => {
    loadFlights();
    loadAirports();
    loadPlanes();
  }, []);

  const loadFlights = async () => {
    try {
      const response = await getFlights();
      console.log('Flights:', response.data);
      setFlights(response.data);
    } catch (error) {
      console.error('Error loading flights:', error);
    }
  };

  const loadAirports = async () => {
    try {
      const response = await getAirports();
      console.log('Airports:', response.data);
      setAirports(response.data);
    } catch (error) {
      console.error('Error loading airports:', error);
    }
  };

  const loadPlanes = async () => {
    try {
      const response = await getPlanes();
      console.log('Planes:', response.data);
      setPlanes(response.data);
    } catch (error) {
      console.error('Error loading planes:', error);
    }
  };

  const handleCreate = async () => {
    try {
      await createFlight(newFlight);
      setNewFlight({ date: '', dateArrived: '', idDestination: '', idOrigin: '', idPlane: '' });
      loadFlights();
    } catch (error) {
      console.error('Error creating flight:', error);
    }
  };

  const handleUpdate = async (id, updatedFlight) => {
    try {
      await updateFlight(id, updatedFlight);
      loadFlights();
    } catch (error) {
      console.error('Error updating flight:', error);
    }
  };

  const handleDelete = async (id) => {
    try {
      await deleteFlight(id);
      loadFlights();
    } catch (error) {
      console.error('Error deleting flight:', error);
    }
  };

  const startEditing = (flight) => {
    setEditingFlight(flight);
  };

  const stopEditing = () => {
    setEditingFlight(null);
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setNewFlight({ ...newFlight, [name]: value });
  };

  const handleEditChange = (e) => {
    const { name, value } = e.target;
    setEditingFlight({ ...editingFlight, [name]: value });
  };

  const handleEditSubmit = async (e) => {
    e.preventDefault();
    await handleUpdate(editingFlight.id, editingFlight);
    stopEditing();
  };

  return (
    <div>
  {/*     <h1 className="text-2xl font-bold mb-4">Flights</h1>
      <div className="mb-4">
        <input
          type="datetime-local"
          name="date"
          placeholder="Date"
          value={newFlight.date}
          onChange={handleChange}
          className="p-2 mb-2 dark:bg-gray-800 dark:text-white"
        />
        <input
          type="datetime-local"
          name="dateArrived"
          placeholder="Date Arrived"
          value={newFlight.dateArrived}
          onChange={handleChange}
          className="p-2 mb-2 dark:bg-gray-800 dark:text-white"
        />
        <select
          name="idDestination"
          value={newFlight.idDestination}
          onChange={handleChange}
          className="p-2 mb-2 dark:bg-gray-800 dark:text-white"
        >
          <option value="" disabled>Select Destination</option>
          {airports.map((airport) => (
            <option key={airport.id} value={airport.id}>{airport.name}</option>
          ))}
        </select>
        <select
          name="idOrigin"
          value={newFlight.idOrigin}
          onChange={handleChange}
          className="p-2 mb-2 dark:bg-gray-800 dark:text-white"
        >
          <option value="" disabled>Select Origin</option>
          {airports.map((airport) => (
            <option key={airport.id} value={airport.id}>{airport.name}</option>
          ))}
        </select>
        <select
          name="idPlane"
          value={newFlight.idPlane}
          onChange={handleChange}
          className="p-2 mb-2 dark:bg-gray-800 dark:text-white"
        >
          <option value="" disabled>Select Plane</option>
          {planes.map((plane) => (
            <option key={plane.id} value={plane.id}>{plane.model}</option>
          ))}
        </select>
        <button onClick={handleCreate} className="p-2 bg-blue-500 text-white">Create</button>
      </div>
      <ul>
        {flights.map((flight) => (
          <li key={flight.id} className="mb-2">
            {flight.date} - {flight.dateArrived}
            <button onClick={() => startEditing(flight)} className="ml-4 text-yellow-500">Edit</button>
            <button onClick={() => handleDelete(flight.id)} className="ml-4 text-red-500">Delete</button>
            {editingFlight && editingFlight.id === flight.id && (
              <form onSubmit={handleEditSubmit}>
                <input
                  type="datetime-local"
                  name="date"
                  value={editingFlight.date}
                  onChange={handleEditChange}
                  className="p-2 mb-2 dark:bg-gray-800 dark:text-white"
                />
                <input
                  type="datetime-local"
                  name="dateArrived"
                  value={editingFlight.dateArrived}
                  onChange={handleEditChange}
                  className="p-2 mb-2 dark:bg-gray-800 dark:text-white"
                />
                <select
                  name="idDestination"
                  value={editingFlight.idDestination}
                  onChange={handleEditChange}
                  className="p-2 mb-2 dark:bg-gray-800 dark:text-white"
                >
                  <option value="" disabled>Select Destination</option>
                  {airports.map((airport) => (
                    <option key={airport.id} value={airport.id}>{airport.name}</option>
                  ))}
                </select>
                <select
                  name="idOrigin"
                  value={editingFlight.idOrigin}
                  onChange={handleEditChange}
                  className="p-2 mb-2 dark:bg-gray-800 dark:text-white"
                >
                  <option value="" disabled>Select Origin</option>
                  {airports.map((airport) => (
                    <option key={airport.id} value={airport.id}>{airport.name}</option>
                  ))}
                </select>
                <select
                  name="idPlane"
                  value={editingFlight.idPlane}
                  onChange={handleEditChange}
                  className="p-2 mb-2 dark:bg-gray-800 dark:text-white"
                >
                  <option value="" disabled>Select Plane</option>
                  {planes.map((plane) => (
                    <option key={plane.id} value={plane.id}>{plane.model}</option>
                  ))}
                </select>
                <button type="submit" className="p-2 bg-yellow-500 text-white">Save</button>
                <button onClick={stopEditing} className="p-2 bg-gray-500 text-white ml-2">Cancel</button>
              </form>
            )}
            <ul className="ml-4">
              {flight.origin && flight.origin.originFlights.map((originFlight) => (
                <li key={originFlight.id}>
                  {originFlight.date} - {originFlight.dateArrived}
                </li>
              ))}
            </ul>
          </li>
        ))}
      </ul> */}
    </div>
  );
};

export default Flights;
