import React, { useState, useEffect } from 'react';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { getPlanes, createPlane, updatePlane, deletePlane } from '../services/api';

const Planes = () => {
  const [planes, setPlanes] = useState([]);
  const [newPlane, setNewPlane] = useState({ model: '', name: '', numSeat: '' });
  const [editingPlane, setEditingPlane] = useState(null);
  const [searchTerm, setSearchTerm] = useState('');
  const [searchKey, setSearchKey] = useState('model');

  useEffect(() => {
    loadPlanes();
  }, []);

  const loadPlanes = async () => {
    try {
      const response = await getPlanes();
      setPlanes(response.data);
    } catch (error) {
      console.error('Error loading planes:', error);
    }
  };

  const handleCreate = async () => {
    if (!newPlane.model || !newPlane.name || !newPlane.numSeat) {
      toast.error('All fields must be filled');
      return;
    }

    try {
      await createPlane(newPlane);
      setNewPlane({ model: '', name: '', numSeat: '' });
      loadPlanes();
      toast.success('Plane added successfully');
    } catch (error) {
      console.error('Error creating plane:', error);
      toast.error('Error creating plane');
    }
  };

  const handleUpdate = async (id, updatedPlane) => {
    try {
      await updatePlane(id, updatedPlane);
      loadPlanes();
      toast.success('Plane updated successfully');
    } catch (error) {
      console.error('Error updating plane:', error);
      toast.error('Error updating plane');
    }
  };

  const handleDelete = async (id) => {
    try {
      await deletePlane(id);
      loadPlanes();
      toast.success('Plane deleted successfully');
    } catch (error) {
      console.error('Error deleting plane:', error);
      toast.error('Error deleting plane');
    }
  };

  const startEditing = (plane) => {
    setEditingPlane(plane);
  };

  const stopEditing = () => {
    setEditingPlane(null);
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setNewPlane({ ...newPlane, [name]: value });
  };

  const handleEditChange = (e) => {
    const { name, value } = e.target;
    setEditingPlane({ ...editingPlane, [name]: value });
  };

  const handleEditSubmit = async (e) => {
    e.preventDefault();
    await handleUpdate(editingPlane.id, editingPlane);
    stopEditing();
  };

  const filteredPlanes = planes.filter((plane) => {
    const value = plane[searchKey];
    return value && value.toString().toLowerCase().includes(searchTerm.toLowerCase());
  });

  return (
    <div>
      <ToastContainer />
      <h1 className="text-2xl font-bold mb-4">Planes</h1>
      <div className="flex mb-4">
        <select
          value={searchKey}
          onChange={(e) => setSearchKey(e.target.value)}
          className="p-2 dark:bg-gray-800 dark:text-white mr-2"
        >
          <option value="model">Model</option>
          <option value="name">Name</option>
          <option value="numSeat">Number of Seats</option>
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
        <h2 className="text-xl font-bold mb-4">Create Plane</h2>
        <div className="mb-4">
          <label className="block mb-2">Model</label>
          <input
            type="text"
            name="model"
            placeholder="Model"
            value={newPlane.model}
            onChange={handleChange}
            className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
          />
          <label className="block mb-2">Name</label>
          <input
            type="text"
            name="name"
            placeholder="Name"
            value={newPlane.name}
            onChange={handleChange}
            className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
          />
          <label className="block mb-2">Number of Seats</label>
          <input
            type="number"
            name="numSeat"
            placeholder="Number of Seats"
            value={newPlane.numSeat}
            onChange={handleChange}
            className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
          />
          <button onClick={handleCreate} className="p-2 bg-blue-500 text-white w-full">Create</button>
        </div>
      </div>
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
        {filteredPlanes.map((plane) => (
          <div key={plane.id} className="bg-gray-800 text-white p-4 rounded-md shadow-md">
            <h2 className="text-xl font-bold">Plane</h2>
            <p><strong>ID:</strong> {plane.id}</p>
            <p><strong>Model:</strong> {plane.model}</p>
            <p><strong>Name:</strong> {plane.name}</p>
            <p><strong>Number of Seats:</strong> {plane.numSeat}</p>
            <button onClick={() => startEditing(plane)} className="mt-2 p-2 bg-yellow-500 text-white">Edit</button>
            <button onClick={() => handleDelete(plane.id)} className="mt-2 ml-2 p-2 bg-red-500 text-white">Delete</button>
            {editingPlane && editingPlane.id === plane.id && (
              <form onSubmit={handleEditSubmit} className="mt-4">
                <label className="block mb-2">Model</label>
                <input
                  type="text"
                  name="model"
                  value={editingPlane.model}
                  onChange={handleEditChange}
                  className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
                />
                <label className="block mb-2">Name</label>
                <input
                  type="text"
                  name="name"
                  value={editingPlane.name}
                  onChange={handleEditChange}
                  className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
                />
                <label className="block mb-2">Number of Seats</label>
                <input
                  type="number"
                  name="numSeat"
                  value={editingPlane.numSeat}
                  onChange={handleEditChange}
                  className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
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

export default Planes;
