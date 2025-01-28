import React, { useState, useEffect } from 'react';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { getPassengers, createPassenger, updatePassenger, deletePassenger } from '../services/api';

const Passengers = () => {
  const [passengers, setPassengers] = useState([]);
  const [newPassenger, setNewPassenger] = useState({ name: '', idpassenger: '' });
  const [editingPassenger, setEditingPassenger] = useState(null);
  const [searchTerm, setSearchTerm] = useState('');
  const [searchKey, setSearchKey] = useState('name');

  useEffect(() => {
    loadPassengers();
  }, []);

  const loadPassengers = async () => {
    try {
      const response = await getPassengers();
      setPassengers(response.data);
    } catch (error) {
      console.error('Error loading passengers:', error);
    }
  };

  const handleCreate = async () => {
    if (!newPassenger.name || !newPassenger.idpassenger) {
      toast.error('All fields must be filled');
      return;
    }

    try {
      await createPassenger(newPassenger);
      setNewPassenger({ name: '', idpassenger: '' });
      loadPassengers();
      toast.success('Passenger added successfully');
    } catch (error) {
      console.error('Error creating passenger:', error);
      toast.error('Error creating passenger');
    }
  };

  const handleUpdate = async (id, updatedPassenger) => {
    try {
      await updatePassenger(id, updatedPassenger);
      loadPassengers();
      toast.success('Passenger updated successfully');
    } catch (error) {
      console.error('Error updating passenger:', error);
      toast.error('Error updating passenger');
    }
  };

  const handleDelete = async (id) => {
    try {
      await deletePassenger(id);
      loadPassengers();
      toast.success('Passenger deleted successfully');
    } catch (error) {
      console.error('Error deleting passenger:', error);
      toast.error('Error deleting passenger');
    }
  };

  const startEditing = (passenger) => {
    setEditingPassenger(passenger);
  };

  const stopEditing = () => {
    setEditingPassenger(null);
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setNewPassenger({ ...newPassenger, [name]: value });
  };

  const handleEditChange = (e) => {
    const { name, value } = e.target;
    setEditingPassenger({ ...editingPassenger, [name]: value });
  };

  const handleEditSubmit = async (e) => {
    e.preventDefault();
    await handleUpdate(editingPassenger.id, editingPassenger);
    stopEditing();
  };

  const filteredPassengers = passengers.filter((passenger) => {
    const value = passenger[searchKey];
    return value && value.toString().toLowerCase().includes(searchTerm.toLowerCase());
  });

  return (
    <div>
      <ToastContainer />
      <h1 className="text-2xl font-bold mb-4">Passengers</h1>
      <div className="flex mb-4">
        <select
          value={searchKey}
          onChange={(e) => setSearchKey(e.target.value)}
          className="p-2 dark:bg-gray-800 dark:text-white mr-2"
        >
          <option value="name">Name</option>
          <option value="idpassenger">ID Passenger</option>
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
        <h2 className="text-xl font-bold mb-4">Create Passenger</h2>
        <div className="mb-4">
          <label className="block mb-2">Name</label>
          <input
            type="text"
            name="name"
            placeholder="Name"
            value={newPassenger.name}
            onChange={handleChange}
            className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
          />
          <label className="block mb-2">ID Passenger</label>
          <input
            type="text"
            name="idpassenger"
            placeholder="ID Passenger"
            value={newPassenger.idpassenger}
            onChange={handleChange}
            className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
          />
          <button onClick={handleCreate} className="p-2 bg-blue-500 text-white w-full">Create</button>
        </div>
      </div>
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
        {filteredPassengers.map((passenger) => (
          <div key={passenger.id} className="bg-gray-800 text-white p-4 rounded-md shadow-md">
            <h2 className="text-xl font-bold">Passenger</h2>
            <p><strong>ID:</strong> {passenger.id}</p>
            <p><strong>Name:</strong> {passenger.name}</p>
            <p><strong>ID Passenger:</strong> {passenger.idpassenger}</p>
            <button onClick={() => startEditing(passenger)} className="mt-2 p-2 bg-yellow-500 text-white">Edit</button>
            <button onClick={() => handleDelete(passenger.id)} className="mt-2 ml-2 p-2 bg-red-500 text-white">Delete</button>
            {editingPassenger && editingPassenger.id === passenger.id && (
              <form onSubmit={handleEditSubmit} className="mt-4">
                <label className="block mb-2">Name</label>
                <input
                  type="text"
                  name="name"
                  value={editingPassenger.name}
                  onChange={handleEditChange}
                  className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
                />
                <label className="block mb-2">ID Passenger</label>
                <input
                  type="text"
                  name="idpassenger"
                  value={editingPassenger.idpassenger}
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

export default Passengers;
