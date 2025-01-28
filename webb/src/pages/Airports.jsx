import React, { useEffect, useState } from 'react';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { createAirport, deleteAirport, getAirports, updateAirport } from '../services/api';

const Airports = () => {
  const [airports, setAirports] = useState([]);
  const [newAirport, setNewAirport] = useState({ name: '', place: '' });
  const [editingAirport, setEditingAirport] = useState(null);
  const [searchTerm, setSearchTerm] = useState('');
  const [searchKey, setSearchKey] = useState('name');

  useEffect(() => {
    loadAirports();
  }, []);

  const loadAirports = async () => {
    try {
      const response = await getAirports();
      setAirports(response.data);
    } catch (error) {
      console.error('Error loading airports:', error);
    }
  };

  const handleCreate = async () => {
    if (!newAirport.name || !newAirport.place) {
      toast.error('All fields must be filled');
      return;
    }

    try {
      await createAirport(newAirport);
      setNewAirport({ name: '', place: '' });
      loadAirports();
      toast.success('Airport added successfully');
    } catch (error) {
      console.error('Error creating airport:', error);
      toast.error('Error creating airport');
    }
  };

  const handleUpdate = async (id, updatedAirport) => {
    try {
      await updateAirport(id, updatedAirport);
      loadAirports();
      toast.success('Airport updated successfully');
    } catch (error) {
      console.error('Error updating airport:', error);
      toast.error('Error updating airport');
    }
  };

  const handleDelete = async (id) => {
    try {
      await deleteAirport(id);
      loadAirports();
      toast.success('Airport deleted successfully');
    } catch (error) {
      console.error('Error deleting airport:', error);
      toast.error('Error deleting airport');
    }
  };

  const startEditing = (airport) => {
    setEditingAirport(airport);
  };

  const stopEditing = () => {
    setEditingAirport(null);
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setNewAirport({ ...newAirport, [name]: value });
  };

  const handleEditChange = (e) => {
    const { name, value } = e.target;
    setEditingAirport({ ...editingAirport, [name]: value });
  };

  const handleEditSubmit = async (e) => {
    e.preventDefault();
    await handleUpdate(editingAirport.id, editingAirport);
    stopEditing();
  };

  const filteredAirports = airports.filter((airport) => {
    const value = airport[searchKey];
    return value && value.toString().toLowerCase().includes(searchTerm.toLowerCase());
  });

  return (
    <div className='min-h-screen'>
      <ToastContainer />
      <h1 className="text-2xl font-bold text-center mb-4">Airports</h1>
      <div className="flex mb-4">
        <select
          value={searchKey}
          onChange={(e) => setSearchKey(e.target.value)}
          className="p-2 bg-gray-800 text-white mr-2"
        >
          <option value="name">Name</option>
          <option value="place">Place</option>
        </select>
        <input
          type="text"
          placeholder={`Search by ${searchKey}`}
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
          className="p-2 bg-gray-800 text-white w-full"
        />
      </div>
      <div className="mb-4 p-4 bg-gray-800 text-white rounded-md shadow-md">
        <h2 className="text-xl font-bold mb-4">Create Airport</h2>
        <div className="mb-4">
          <label className="block mb-2">Name</label>
          <input
            type="text"
            name="name"
            placeholder="Name"
            value={newAirport.name}
            onChange={handleChange}
            className="p-2 mb-2 bg-gray-700 text-white w-full"
          />
          <label className="block mb-2">Place</label>
          <input
            type="text"
            name="place"
            placeholder="Place"
            value={newAirport.place}
            onChange={handleChange}
            className="p-2 mb-2 bg-gray-700 text-white w-full"
          />
          <button onClick={handleCreate} className="p-2 bg-blue-500 text-white w-full">Create</button>
        </div>
      </div>
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
        {filteredAirports.map((airport) => (
          <div key={airport.id} className="bg-gray-800 text-white p-4 rounded-md shadow-md">
            <h2 className="text-xl font-bold">Airport</h2>
            <p><strong>ID:</strong> {airport.id}</p>
            <p><strong>Name:</strong> {airport.name}</p>
            <p><strong>Place:</strong> {airport.place}</p>
            <button onClick={() => startEditing(airport)} className="mt-2 p-2 bg-yellow-500 text-white">Edit</button>
            <button onClick={() => handleDelete(airport.id)} className="mt-2 ml-2 p-2 bg-red-500 text-white">Delete</button>
            {editingAirport && editingAirport.id === airport.id && (
              <form onSubmit={handleEditSubmit} className="mt-4">
                <label className="block mb-2">Name</label>
                <input
                  type="text"
                  name="name"
                  value={editingAirport.name}
                  onChange={handleEditChange}
                  placeholder={`Editing ${searchKey}`}
                  className="p-2 mb-2 bg-gray-700 text-white w-full"
                />
                <label className="block mb-2">Place</label>
                <input
                  type="text"
                  name="place"
                  value={editingAirport.place}
                  onChange={handleEditChange}
                  placeholder={`Editing ${searchKey}`}
                  className="p-2 mb-2 bg-gray-700 text-white w-full"
                />
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

export default Airports;
