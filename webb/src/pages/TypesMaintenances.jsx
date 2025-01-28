import React, { useState, useEffect } from 'react';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { getTypesMaintenances, createTypeMaintenance, updateTypeMaintenance, deleteTypeMaintenance } from '../services/api';

const TypesMaintenances = () => {
  const [typesMaintenances, setTypesMaintenances] = useState([]);
  const [newTypeMaintenance, setNewTypeMaintenance] = useState({ name: '', cost: '' });
  const [editingTypeMaintenance, setEditingTypeMaintenance] = useState(null);
  const [searchTerm, setSearchTerm] = useState('');
  const [searchKey, setSearchKey] = useState('name');

  useEffect(() => {
    loadTypesMaintenances();
  }, []);

  const loadTypesMaintenances = async () => {
    try {
      const response = await getTypesMaintenances();
      setTypesMaintenances(response.data);
    } catch (error) {
      console.error('Error loading types of maintenances:', error);
    }
  };

  const handleCreate = async () => {
    if (!newTypeMaintenance.name || !newTypeMaintenance.cost) {
      toast.error('All fields must be filled');
      return;
    }

    try {
      await createTypeMaintenance(newTypeMaintenance);
      setNewTypeMaintenance({ name: '', cost: '' });
      loadTypesMaintenances();
      toast.success('Type of maintenance added successfully');
    } catch (error) {
      console.error('Error creating type of maintenance:', error);
      toast.error('Error creating type of maintenance');
    }
  };

  const handleUpdate = async (id, updatedTypeMaintenance) => {
    try {
      await updateTypeMaintenance(id, updatedTypeMaintenance);
      loadTypesMaintenances();
      toast.success('Type of maintenance updated successfully');
    } catch (error) {
      console.error('Error updating type of maintenance:', error);
      toast.error('Error updating type of maintenance');
    }
  };

  const handleDelete = async (id) => {
    try {
      await deleteTypeMaintenance(id);
      loadTypesMaintenances();
      toast.success('Type of maintenance deleted successfully');
    } catch (error) {
      console.error('Error deleting type of maintenance:', error);
      toast.error('Error deleting type of maintenance');
    }
  };

  const startEditing = (typeMaintenance) => {
    setEditingTypeMaintenance(typeMaintenance);
  };

  const stopEditing = () => {
    setEditingTypeMaintenance(null);
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setNewTypeMaintenance({ ...newTypeMaintenance, [name]: value });
  };

  const handleEditChange = (e) => {
    const { name, value } = e.target;
    setEditingTypeMaintenance({ ...editingTypeMaintenance, [name]: value });
  };

  const handleEditSubmit = async (e) => {
    e.preventDefault();
    await handleUpdate(editingTypeMaintenance.id, editingTypeMaintenance);
    stopEditing();
  };

  const filteredTypesMaintenances = typesMaintenances.filter((typeMaintenance) => {
    const value = typeMaintenance[searchKey];
    return value && value.toString().toLowerCase().includes(searchTerm.toLowerCase());
  });

  return (
    <div>
      <ToastContainer />
      <h1 className="text-2xl font-bold mb-4">Types of Maintenances</h1>
      <div className="flex mb-4">
        <select
          value={searchKey}
          onChange={(e) => setSearchKey(e.target.value)}
          className="p-2 dark:bg-gray-800 dark:text-white mr-2"
        >
          <option value="name">Name</option>
          <option value="cost">Cost</option>
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
        <h2 className="text-xl font-bold mb-4">Create Type of Maintenance</h2>
        <div className="mb-4">
          <label className="block mb-2">Name</label>
          <input
            type="text"
            name="name"
            placeholder="Name"
            value={newTypeMaintenance.name}
            onChange={handleChange}
            className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
          />
          <label className="block mb-2">Cost</label>
          <input
            type="number"
            name="cost"
            placeholder="Cost"
            value={newTypeMaintenance.cost}
            onChange={handleChange}
            className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
          />
          <button onClick={handleCreate} className="p-2 bg-blue-500 text-white w-full">Create</button>
        </div>
      </div>
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
        {filteredTypesMaintenances.map((typeMaintenance) => (
          <div key={typeMaintenance.id} className="bg-gray-800 text-white p-4 rounded-md shadow-md">
            <h2 className="text-xl font-bold">Type of Maintenance</h2>
            <p><strong>ID:</strong> {typeMaintenance.id}</p>
            <p><strong>Name:</strong> {typeMaintenance.name}</p>
            <p><strong>Cost:</strong> {typeMaintenance.cost}</p>
            <button onClick={() => startEditing(typeMaintenance)} className="mt-2 p-2 bg-yellow-500 text-white">Edit</button>
            <button onClick={() => handleDelete(typeMaintenance.id)} className="mt-2 ml-2 p-2 bg-red-500 text-white">Delete</button>
            {editingTypeMaintenance && editingTypeMaintenance.id === typeMaintenance.id && (
              <form onSubmit={handleEditSubmit} className="mt-4">
                <label className="block mb-2">Name</label>
                <input
                  type="text"
                  name="name"
                  value={editingTypeMaintenance.name}
                  onChange={handleEditChange}
                  className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
                />
                <label className="block mb-2">Cost</label>
                <input
                  type="number"
                  name="cost"
                  value={editingTypeMaintenance.cost}
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

export default TypesMaintenances;
