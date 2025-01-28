import React, { useState, useEffect } from 'react';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import {
  getMaintenances, createMaintenance, updateMaintenance, deleteMaintenance,
  getPlanes, getTypesMaintenances
} from '../services/api';

const Maintenances = () => {
  const [maintenances, setMaintenances] = useState([]);
  const [newMaintenance, setNewMaintenance] = useState({ date: '', costFinal: '', plane: '', typesMaintenances: [] });
  const [editingMaintenance, setEditingMaintenance] = useState(null);
  const [planes, setPlanes] = useState([]);
  const [typesMaintenances, setTypesMaintenances] = useState([]);
  const [searchTerm, setSearchTerm] = useState('');
  const [searchKey, setSearchKey] = useState('date');

  useEffect(() => {
    loadMaintenances();
    loadPlanes();
    loadTypesMaintenances();
  }, []);

  const loadMaintenances = async () => {
    try {
      const response = await getMaintenances();
      setMaintenances(response.data);
    } catch (error) {
      console.error('Error loading maintenances:', error);
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

  const loadTypesMaintenances = async () => {
    try {
      const response = await getTypesMaintenances();
      setTypesMaintenances(response.data);
    } catch (error) {
      console.error('Error loading types of maintenances:', error);
    }
  };

  const handleCreate = async () => {
    if (!newMaintenance.date || !newMaintenance.costFinal || !newMaintenance.plane || newMaintenance.typesMaintenances.length === 0) {
      toast.error('All fields must be filled');
      return;
    }

    try {
      await createMaintenance(newMaintenance);
      setNewMaintenance({ date: '', costFinal: '', plane: '', typesMaintenances: [] });
      loadMaintenances();
      toast.success('Maintenance added successfully');
    } catch (error) {
      console.error('Error creating maintenance:', error);
      toast.error('Error creating maintenance');
    }
  };

  const handleUpdate = async (id, updatedMaintenance) => {
    try {
      await updateMaintenance(id, updatedMaintenance);
      loadMaintenances();
      toast.success('Maintenance updated successfully');
    } catch (error) {
      console.error('Error updating maintenance:', error);
      toast.error('Error updating maintenance');
    }
  };

  const handleDelete = async (id) => {
    try {
      await deleteMaintenance(id);
      loadMaintenances();
      toast.success('Maintenance deleted successfully');
    } catch (error) {
      console.error('Error deleting maintenance:', error);
      toast.error('Error deleting maintenance');
    }
  };

  const startEditing = (maintenance) => {
    setEditingMaintenance(maintenance);
  };

  const stopEditing = () => {
    setEditingMaintenance(null);
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    if (name === 'typesMaintenances') {
      setNewMaintenance({ ...newMaintenance, typesMaintenances: [...newMaintenance.typesMaintenances, value] });
    } else {
      setNewMaintenance({ ...newMaintenance, [name]: value });
    }
  };

  const handleRemoveTypeMaintenance = (type) => {
    setNewMaintenance({ ...newMaintenance, typesMaintenances: newMaintenance.typesMaintenances.filter(t => t !== type) });
  };

  const handleEditChange = (e) => {
    const { name, value } = e.target;
    if (name === 'typesMaintenances') {
      setEditingMaintenance({ ...editingMaintenance, typesMaintenances: [...editingMaintenance.typesMaintenances, value] });
    } else {
      setEditingMaintenance({ ...editingMaintenance, [name]: value });
    }
  };

  const handleEditSubmit = async (e) => {
    e.preventDefault();
    await handleUpdate(editingMaintenance.id, editingMaintenance);
    stopEditing();
  };

  const filteredMaintenances = maintenances.filter((maintenance) => {
    const value = maintenance[searchKey];
    return value && value.toString().toLowerCase().includes(searchTerm.toLowerCase());
  });

  return (
    <div>
      <ToastContainer />
      <h1 className="text-2xl font-bold mb-4">Maintenances</h1>
      <div className="flex mb-4">
        <select
          value={searchKey}
          onChange={(e) => setSearchKey(e.target.value)}
          className="p-2 dark:bg-gray-800 dark:text-white mr-2"
        >
          <option value="date">Date</option>
          <option value="costFinal">Cost Final</option>
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
        <h2 className="text-xl font-bold mb-4">Create Maintenance</h2>
        <div className="mb-4">
          <label className="block mb-2">Date</label>
          <input
            type="date"
            name="date"
            placeholder="Date"
            value={newMaintenance.date}
            onChange={handleChange}
            className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
          />
          <label className="block mb-2">Cost Final</label>
          <input
            type="number"
            name="costFinal"
            placeholder="Cost Final"
            value={newMaintenance.costFinal}
            onChange={handleChange}
            className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
          />
          <label className="block mb-2">Plane</label>
          <select
            name="plane"
            value={newMaintenance.plane}
            onChange={handleChange}
            className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
          >
            <option value="" disabled>Select Plane</option>
            {planes.map((plane) => (
              <option key={plane.id} value={plane.name}>{plane.name}</option>
            ))}
          </select>
          <label className="block mb-2">Types of Maintenance</label>
          <select
            name="typesMaintenances"
            value=""
            onChange={handleChange}
            className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
          >
            <option value="" disabled>Add Type of Maintenance</option>
            {typesMaintenances.map((type) => (
              <option key={type.id} value={type.name}>{type.name}</option>
            ))}
          </select>
          <div className="mb-4">
            {newMaintenance.typesMaintenances.map((type, index) => (
              <div key={index} className="flex items-center mb-2">
                <span className="p-2 dark:bg-gray-700 dark:text-white w-full mr-2">{type}</span>
                <button onClick={() => handleRemoveTypeMaintenance(type)} className="p-2 bg-red-500 text-white">Remove</button>
              </div>
            ))}
          </div>
          <button onClick={handleCreate} className="p-2 bg-blue-500 text-white w-full">Create</button>
        </div>
      </div>
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
        {filteredMaintenances.map((maintenance) => (
          <div key={maintenance.id} className="bg-gray-800 text-white p-4 rounded-md shadow-md">
            <h2 className="text-xl font-bold">Maintenance</h2>
            <p><strong>ID:</strong> {maintenance.id}</p>
            <p><strong>Date:</strong> {maintenance.date}</p>
            <p><strong>Cost Final:</strong> {maintenance.costFinal}</p>
            <p><strong>Plane:</strong> {maintenance.plane}</p>
            <p><strong>Types of Maintenance:</strong> {maintenance.typesMaintenances.join(', ')}</p>
            <button onClick={() => startEditing(maintenance)} className="mt-2 p-2 bg-yellow-500 text-white">Edit</button>
            <button onClick={() => handleDelete(maintenance.id)} className="mt-2 ml-2 p-2 bg-red-500 text-white">Delete</button>
            {editingMaintenance && editingMaintenance.id === maintenance.id && (
              <form onSubmit={handleEditSubmit} className="mt-4">
                <label className="block mb-2">Date</label>
                <input
                  type="date"
                  name="date"
                  value={editingMaintenance.date}
                  onChange={handleEditChange}
                  className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
                />
                <label className="block mb-2">Cost Final</label>
                <input
                  type="number"
                  name="costFinal"
                  value={editingMaintenance.costFinal}
                  onChange={handleEditChange}
                  className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
                />
                <label className="block mb-2">Plane</label>
                <select
                  name="plane"
                  value={editingMaintenance.plane}
                  onChange={handleEditChange}
                  className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
                >
                  <option value="" disabled>Select Plane</option>
                  {planes.map((plane) => (
                    <option key={plane.id} value={plane.name}>{plane.name}</option>
                  ))}
                </select>
                <label className="block mb-2">Types of Maintenance</label>
                <select
                  name="typesMaintenances"
                  value=""
                  onChange={handleEditChange}
                  className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
                >
                  <option value="" disabled>Add Type of Maintenance</option>
                  {typesMaintenances.map((type) => (
                    <option key={type.id} value={type.name}>{type.name}</option>
                  ))}
                </select>
                <div className="mb-4">
                  {editingMaintenance.typesMaintenances.map((type, index) => (
                    <div key={index} className="flex items-center mb-2">
                      <span className="p-2 dark:bg-gray-700 dark:text-white w-full mr-2">{type}</span>
                      <button onClick={() => setEditingMaintenance({ ...editingMaintenance, typesMaintenances: editingMaintenance.typesMaintenances.filter(t => t !== type) })} className="p-2 bg-red-500 text-white">Remove</button>
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

export default Maintenances;
