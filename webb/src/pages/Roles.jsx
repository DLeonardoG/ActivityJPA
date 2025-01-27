import React, { useEffect, useState } from 'react';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { createRole, deleteRole, getRoles, updateRole } from '../services/api';

const Roles = () => {
  const [roles, setRoles] = useState([]);
  const [newRole, setNewRole] = useState({ role: '' });
  const [editingRole, setEditingRole] = useState(null);
  const [searchTerm, setSearchTerm] = useState('');
  const [searchKey, setSearchKey] = useState('role');

  useEffect(() => {
    loadRoles();
  }, []);

  const loadRoles = async () => {
    try {
      const response = await getRoles();
      setRoles(response.data);
    } catch (error) {
      console.error('Error loading roles:', error);
    }
  };

  const handleCreate = async () => {
    if (!newRole.role) {
      toast.error('Role cannot be empty');
      return;
    }

    try {
      await createRole(newRole);
      setNewRole({ role: '' });
      loadRoles();
      toast.success('Role added successfully');
    } catch (error) {
      console.error('Error creating role:', error);
      toast.error('Error creating role');
    }
  };

  const handleUpdate = async (id, updatedRole) => {
    try {
      await updateRole(id, updatedRole);
      loadRoles();
      toast.success('Role updated successfully');
    } catch (error) {
      console.error('Error updating role:', error);
      toast.error('Error updating role');
    }
  };

  const handleDelete = async (id) => {
    try {
      await deleteRole(id);
      loadRoles();
      toast.success('Role deleted successfully');
    } catch (error) {
      console.error('Error deleting role:', error);
      toast.error('Error deleting role');
    }
  };

  const startEditing = (role) => {
    setEditingRole(role);
  };

  const stopEditing = () => {
    setEditingRole(null);
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setNewRole({ ...newRole, [name]: value });
  };

  const handleEditChange = (e) => {
    const { name, value } = e.target;
    setEditingRole({ ...editingRole, [name]: value });
  };

  const handleEditSubmit = async (e) => {
    e.preventDefault();
    await handleUpdate(editingRole.id, editingRole);
    stopEditing();
  };

  const filteredRoles = roles.filter((role) => {
    const value = role[searchKey];
    return value && value.toString().toLowerCase().includes(searchTerm.toLowerCase());
  });

  return (
    <div>
      <ToastContainer />
      <h1 className="text-2xl font-bold mb-4">Roles</h1>
      <div className="flex mb-4">
        <select
          value={searchKey}
          onChange={(e) => setSearchKey(e.target.value)}
          className="p-2 bg-gray-800 text-white mr-2"
        >
          <option value="role">Role</option>
          <option value="id">ID</option>
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
        <h2 className="text-xl font-bold mb-4">Create Role</h2>
        <div className="mb-4">
          <label className="block mb-2">Role</label>
          <input
            type="text"
            name="role"
            placeholder="Role"
            value={newRole.role}
            onChange={handleChange}
            className="p-2 mb-2 bg-gray-700 text-white w-full"
          />
          <button onClick={handleCreate} className="p-2 bg-blue-500 text-white w-full">Create</button>
        </div>
      </div>
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
        {filteredRoles.map((role) => (
          <div key={role.id} className="bg-gray-800 text-white p-4 rounded-md shadow-md">
            <h2 className="text-xl font-bold">Role</h2>
            <p><strong>ID:</strong> {role.id}</p>
            <p><strong>Role:</strong> {role.role}</p>
            <button onClick={() => startEditing(role)} className="mt-2 p-2 bg-yellow-500 text-white">Edit</button>
            <button onClick={() => handleDelete(role.id)} className="mt-2 ml-2 p-2 bg-red-500 text-white">Delete</button>
            {editingRole && editingRole.id === role.id && (
              <form onSubmit={handleEditSubmit} className="mt-4">
                <label className="block mb-2">Role</label>
                <input
                  type="text"
                  name="role"
                  value={editingRole.role}
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

export default Roles;
