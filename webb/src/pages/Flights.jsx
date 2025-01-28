import React, { useState, useEffect } from 'react';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import {
  getFlights, createFlight, updateFlight, deleteFlight,
  getAirports, getPlanes, getCrewMembers
} from '../services/api';

const Flights = () => {
  const [flights, setFlights] = useState([]);
  const [newFlight, setNewFlight] = useState({ date: '', dateArrived: '', origin: '', destination: '', plane: '', crewMembers: [] });
  const [editingFlight, setEditingFlight] = useState(null);
  const [airports, setAirports] = useState([]);
  const [planes, setPlanes] = useState([]);
  const [crewMembers, setCrewMembers] = useState([]);
  const [searchTerm, setSearchTerm] = useState('');
  const [searchKey, setSearchKey] = useState('date');

  useEffect(() => {
    loadFlights();
    loadAirports();
    loadPlanes();
    loadCrewMembers();
  }, []);

  const loadFlights = async () => {
    try {
      const response = await getFlights();
      setFlights(response.data);
    } catch (error) {
      console.error('Error loading flights:', error);
    }
  };

  const loadAirports = async () => {
    try {
      const response = await getAirports();
      setAirports(response.data);
    } catch (error) {
      console.error('Error loading airports:', error);
    }
  };

  const loadPlanes = async () => {
    try {
      const response = await getPlanes();
      setPlanes(response.data);
    } catch (error) {
      console.error('Error loading planes:', error);
    }
  };

  const loadCrewMembers = async () => {
    try {
      const response = await getCrewMembers();
      setCrewMembers(response.data);
    } catch (error) {
      console.error('Error loading crew members:', error);
    }
  };

  const handleCreate = async () => {
    if (!newFlight.date || !newFlight.dateArrived || !newFlight.origin || !newFlight.destination || !newFlight.plane || newFlight.crewMembers.length === 0) {
      toast.error('All fields must be filled');
      return;
    }

    if (newFlight.origin === newFlight.destination) {
      toast.error('Origin and destination cannot be the same');
      return;
    }

    try {
      await createFlight(newFlight);
      setNewFlight({ date: '', dateArrived: '', origin: '', destination: '', plane: '', crewMembers: [] });
      loadFlights();
      toast.success('Flight added successfully');
    } catch (error) {
      console.error('Error creating flight:', error);
      toast.error('Error creating flight');
    }
  };

  const handleUpdate = async (id, updatedFlight) => {
    try {
      await updateFlight(id, updatedFlight);
      loadFlights();
      toast.success('Flight updated successfully');
    } catch (error) {
      console.error('Error updating flight:', error);
      toast.error('Error updating flight');
    }
  };

  const handleDelete = async (id) => {
    try {
      await deleteFlight(id);
      loadFlights();
      toast.success('Flight deleted successfully');
    } catch (error) {
      console.error('Error deleting flight:', error);
      toast.error('Error deleting flight');
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
    if (name === 'crewMembers') {
      setNewFlight({ ...newFlight, crewMembers: [...newFlight.crewMembers, value] });
    } else {
      setNewFlight({ ...newFlight, [name]: value });
    }
  };

  const handleRemoveCrewMember = (member) => {
    setNewFlight({ ...newFlight, crewMembers: newFlight.crewMembers.filter(m => m !== member) });
  };

  const handleEditChange = (e) => {
    const { name, value } = e.target;
    if (name === 'crewMembers') {
      setEditingFlight({ ...editingFlight, crewMembers: [...editingFlight.crewMembers, value] });
    } else {
      setEditingFlight({ ...editingFlight, [name]: value });
    }
  };

  const handleEditSubmit = async (e) => {
    e.preventDefault();
    await handleUpdate(editingFlight.id, editingFlight);
    stopEditing();
  };

  const filteredFlights = flights.filter((flight) => {
    const value = flight[searchKey];
    return value && value.toString().toLowerCase().includes(searchTerm.toLowerCase());
  });

  return (
    <div className='min-h-screen'>
      <ToastContainer />
      <h1 className="text-2xl font-bold mb-4  text-center">Flights</h1>
      <div className="flex mb-4">
        <select
          value={searchKey}
          onChange={(e) => setSearchKey(e.target.value)}
          className="p-2 dark:bg-gray-800 dark:text-white mr-2"
        >
          <option value="date">Date</option>
          <option value="dateArrived">Date Arrived</option>
          <option value="origin">Origin</option>
          <option value="destination">Destination</option>
          <option value="plane">Plane</option>
        </select>
        <input
          type="text"
          placeholder={`Search by ${searchKey}`}
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
          className="p-2 dark:bg-gray-800 dark:text-white w-full"
        />
      </div>
      <div className="mb-4 p-4 bg-gray-800 text-white rounded-md shadow-md">
        <h2 className="text-xl font-bold mb-4">Create Flight</h2>
        <div className="mb-4">
          <label className="block mb-2">Date</label>
          <input
            type="datetime-local"
            name="date"
            placeholder="Date"
            value={newFlight.date}
            onChange={handleChange}
            className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
          />
          <label className="block mb-2">Date Arrived</label>
          <input
            type="datetime-local"
            name="dateArrived"
            placeholder="Date Arrived"
            value={newFlight.dateArrived}
            onChange={handleChange}
            className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
          />
          <label className="block mb-2">Origin</label>
          <select
            name="origin"
            value={newFlight.origin}
            onChange={handleChange}
            className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
          >
            <option value="" disabled>Select Origin</option>
            {airports.map((airport) => (
              <option key={airport.id} value={airport.name}>{airport.name}</option>
            ))}
          </select>
          <label className="block mb-2">Destination</label>
          <select
            name="destination"
            value={newFlight.destination}
            onChange={handleChange}
            className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
          >
            <option value="" disabled>Select Destination</option>
            {airports.map((airport) => (
              <option key={airport.id} value={airport.name}>{airport.name}</option>
            ))}
          </select>
          <label className="block mb-2">Plane</label>
          <select
            name="plane"
            value={newFlight.plane}
            onChange={handleChange}
            className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
            >
            <option value="" disabled>Select Plane</option>
            {planes.map((plane) => (
              <option key={plane.id} value={plane.name}>{plane.name}</option>
            ))}
          </select>
          <label className="block mb-2">Crew Members</label>
          <select
            name="crewMembers"
            value=""
            onChange={handleChange}
            className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
          >
            <option value="" disabled>Add Crew Member</option>
            {crewMembers.map((crewMember) => (
              <option key={crewMember.id} value={crewMember.idmember}>{crewMember.idmember}</option>
            ))}
          </select>
          <div className="mb-4">
            {newFlight.crewMembers.map((member, index) => (
              <div key={index} className="flex items-center mb-2">
                <span className="p-2 dark:bg-gray-700 dark:text-white w-full mr-2">{member}</span>
                <button onClick={() => handleRemoveCrewMember(member)} className="p-2 bg-red-500 text-white">Remove</button>
              </div>
            ))}
          </div>
          <button onClick={handleCreate} className="p-2 bg-blue-500 text-white w-full">Create</button>
        </div>
      </div>
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
        {filteredFlights.map((flight) => (
          <div key={flight.id} className="bg-gray-800 text-white p-4 rounded-md shadow-md">
            <h2 className="text-xl font-bold">Flight</h2>
            <p><strong>ID:</strong> {flight.id}</p>
            <p><strong>Date:</strong> {flight.date}</p>
            <p><strong>Date Arrived:</strong> {flight.dateArrived}</p>
            <p><strong>Origin:</strong> {flight.origin}</p>
            <p><strong>Destination:</strong> {flight.destination}</p>
            <p><strong>Plane:</strong> {flight.plane}</p>
            <p><strong>Crew Members:</strong> {flight.crewMembers.join(', ')}</p>
            <button onClick={() => startEditing(flight)} className="mt-2 p-2 bg-yellow-500 text-white">Edit</button>
            <button onClick={() => handleDelete(flight.id)} className="mt-2 ml-2 p-2 bg-red-500 text-white">Delete</button>
            {editingFlight && editingFlight.id === flight.id && (
              <form onSubmit={handleEditSubmit} className="mt-4">
                <label className="block mb-2">Date</label>
                <input
                  type="datetime-local"
                  name="date"
                  value={editingFlight.date}
                  onChange={handleEditChange}
                  className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
                />
                <label className="block mb-2">Date Arrived</label>
                <input
                  type="datetime-local"
                  name="dateArrived"
                  value={editingFlight.dateArrived}
                  onChange={handleEditChange}
                  className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
                />
                <label className="block mb-2">Origin</label>
                <select
                  name="origin"
                  value={editingFlight.origin}
                  onChange={handleEditChange}
                  className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
                >
                  <option value="" disabled>Select Origin</option>
                  {airports.map((airport) => (
                    <option key={airport.id} value={airport.name}>{airport.name}</option>
                  ))}
                </select>
                <label className="block mb-2">Destination</label>
                <select
                  name="destination"
                  value={editingFlight.destination}
                  onChange={handleEditChange}
                  className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
                >
                  <option value="" disabled>Select Destination</option>
                  {airports.map((airport) => (
                    <option key={airport.id} value={airport.name}>{airport.name}</option>
                  ))}
                </select>
                <label className="block mb-2">Plane</label>
                <select
                  name="plane"
                  value={editingFlight.plane}
                  onChange={handleEditChange}
                  className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
                >
                  <option value="" disabled>Select Plane</option>
                  {planes.map((plane) => (
                    <option key={plane.id} value={plane.name}>{plane.name}</option>
                  ))}
                </select>
                <label className="block mb-2">Crew Members</label>
                <select
                  name="crewMembers"
                  value=""
                  onChange={handleEditChange}
                  className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
                >
                  <option value="" disabled>Add Crew Member</option>
                  {crewMembers.map((crewMember) => (
                    <option key={crewMember.id} value={crewMember.idmember}>{crewMember.idmember}</option>
                  ))}
                </select>
                <div className="mb-4">
                  {editingFlight.crewMembers.map((member, index) => (
                    <div key={index} className="flex items-center mb-2">
                      <span className="p-2 dark:bg-gray-700 dark:text-white w-full mr-2">{member}</span>
                      <button onClick={() => setEditingFlight({ ...editingFlight, crewMembers: editingFlight.crewMembers.filter(m => m !== member) })} className="p-2 bg-red-500 text-white">Remove</button>
                    </div>
                  ))}
                </div>
                <button type="submit" className="p-2 bg-yellow-500 text-white w-full">Save</button>
                <button onClick={stopEditing} className="p-2 bg-gray-500 text-white w-full mt-2">Cancel</button>
              </form>
            )}
          </div>
        ))}
      </div>
    </div>
  );
};

export default Flights;

