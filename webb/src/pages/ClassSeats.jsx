import React, { useEffect, useState } from 'react';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { createClassSeat, deleteClassSeat, getClassSeats, updateClassSeat } from '../services/api';

const ClassSeats = () => {
  const [classSeats, setClassSeats] = useState([]);
  const [newClassSeat, setNewClassSeat] = useState({ price: '', seatClass: '' });
  const [editingClassSeat, setEditingClassSeat] = useState(null);
  const [searchTerm, setSearchTerm] = useState('');
  const [searchKey, setSearchKey] = useState('seatClass');

  useEffect(() => {
    loadClassSeats();
  }, []);

  const loadClassSeats = async () => {
    try {
      const response = await getClassSeats();
      setClassSeats(response.data);
    } catch (error) {
      console.error('Error loading class seats:', error);
    }
  };

  const handleCreate = async () => {
    if (!newClassSeat.price || !newClassSeat.seatClass) {
      toast.error('All fields must be filled');
      return;
    }

    try {
      await createClassSeat(newClassSeat);
      setNewClassSeat({ price: '', seatClass: '' });
      loadClassSeats();
      toast.success('Class seat added successfully');
    } catch (error) {
      console.error('Error creating class seat:', error);
      toast.error('Error creating class seat');
    }
  };

  const handleUpdate = async (id, updatedClassSeat) => {
    try {
      await updateClassSeat(id, updatedClassSeat);
      loadClassSeats();
      toast.success('Class seat updated successfully');
    } catch (error) {
      console.error('Error updating class seat:', error);
      toast.error('Error updating class seat');
    }
  };

  const handleDelete = async (id) => {
    try {
      await deleteClassSeat(id);
      loadClassSeats();
      toast.success('Class seat deleted successfully');
    } catch (error) {
      console.error('Error deleting class seat:', error);
      toast.error('Error deleting class seat');
    }
  };

  const startEditing = (classSeat) => {
    setEditingClassSeat(classSeat);
  };

  const stopEditing = () => {
    setEditingClassSeat(null);
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setNewClassSeat({ ...newClassSeat, [name]: value });
  };

  const handleEditChange = (e) => {
    const { name, value } = e.target;
    setEditingClassSeat({ ...editingClassSeat, [name]: value });
  };

  const handleEditSubmit = async (e) => {
    e.preventDefault();
    await handleUpdate(editingClassSeat.id, editingClassSeat);
    stopEditing();
  };

  const filteredClassSeats = classSeats.filter((classSeat) => {
    const value = classSeat[searchKey];
    return value && value.toString().toLowerCase().includes(searchTerm.toLowerCase());
  });

  return (
    <div className='min-h-screen'>
      <ToastContainer />
      <h1 className="text-2xl font-bold mb-4 text-center">Class Seats</h1>
      <div className="flex mb-4">
        <select
          value={searchKey}
          onChange={(e) => setSearchKey(e.target.value)}
          className="p-2 bg-gray-800 text-white mr-2"
        >
          <option value="seatClass">Name</option>
          <option value="price">Price</option>
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
        <h2 className="text-xl font-bold mb-4">Create Class Seat</h2>
        <div className="mb-4">
          <label className="block mb-2">Price</label>
          <input
            type="number"
            name="price"
            placeholder="Price"
            value={newClassSeat.price}
            onChange={handleChange}
            className="p-2 mb-2 bg-gray-700 text-white w-full"
          />
          <label className="block mb-2">Seat Class</label>
          <input
            type="text"
            name="seatClass"
            placeholder="Seat Class"
            value={newClassSeat.seatClass}
            onChange={handleChange}
            className="p-2 mb-2 bg-gray-700 text-white w-full"
          />
          <button onClick={handleCreate} className="p-2 bg-blue-500 text-white w-full">Create</button>
        </div>
      </div>
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
        {filteredClassSeats.map((classSeat) => (
          <div key={classSeat.id} className="bg-gray-800 text-white p-4 rounded-md shadow-md">
            <h2 className="text-xl font-bold">Class Seat</h2>
            <p><strong>ID:</strong> {classSeat.id}</p>
            <p><strong>Price:</strong> {classSeat.price}</p>
            <p><strong>Seat Class:</strong> {classSeat.seatClass}</p>
            <button onClick={() => startEditing(classSeat)} className="mt-2 p-2 bg-yellow-500 text-white">Edit</button>
            <button onClick={() => handleDelete(classSeat.id)} className="mt-2 ml-2 p-2 bg-red-500 text-white">Delete</button>
            {editingClassSeat && editingClassSeat.id === classSeat.id && (
              <form onSubmit={handleEditSubmit} className="mt-4">
                <label className="block mb-2">Price</label>
                <input
                  type="number"
                  name="price"
                  value={editingClassSeat.price}
                  onChange={handleEditChange}
                  placeholder={`Editing ${searchKey}`}
                  className="p-2 mb-2 bg-gray-700 text-white w-full"
                />
                <label className="block mb-2">Seat Class</label>
                <input
                  type="text"
                  name="seatClass"
                  value={editingClassSeat.seatClass}
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

export default ClassSeats;
