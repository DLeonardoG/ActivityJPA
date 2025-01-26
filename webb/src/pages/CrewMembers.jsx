import React, { useState, useEffect } from 'react';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { getCrewMembers, createCrewMember, updateCrewMember, deleteCrewMember, getRoles } from '../services/api';

const CrewMembers = () => {
  const [crewMembers, setCrewMembers] = useState([]);
  const [newCrewMember, setNewCrewMember] = useState({ name: '', roleName: '', idmember: '' });
  const [editingCrewMember, setEditingCrewMember] = useState(null);
  const [roles, setRoles] = useState([]);
  const [searchTerm, setSearchTerm] = useState('');
  const [searchKey, setSearchKey] = useState('name');

  useEffect(() => {
    loadCrewMembers();
    loadRoles();
  }, []);

  const loadCrewMembers = async () => {
    try {
      const response = await getCrewMembers();
      setCrewMembers(response.data);
    } catch (error) {
      console.error('Error loading crew members:', error);
    }
  };

  const loadRoles = async () => {
    try {
      const response = await getRoles();
      setRoles(response.data);
    } catch (error) {
      console.error('Error loading roles:', error);
    }
  };

  const handleCreate = async () => {
    if (!newCrewMember.name || !newCrewMember.roleName || !newCrewMember.idmember) {
      toast.error('All fields must be filled');
      return;
    }

    try {
      await createCrewMember(newCrewMember);
      setNewCrewMember({ name: '', roleName: '', idmember: '' });
      loadCrewMembers();
      toast.success('Crew member added successfully');
    } catch (error) {
      console.error('Error creating crew member:', error);
      toast.error('Error creating crew member');
    }
  };

  const handleUpdate = async (id, updatedCrewMember) => {
    try {
      await updateCrewMember(id, updatedCrewMember);
      loadCrewMembers();
      toast.success('Crew member updated successfully');
    } catch (error) {
      console.error('Error updating crew member:', error);
      toast.error('Error updating crew member');
    }
  };

  const handleDelete = async (id) => {
    try {
      await deleteCrewMember(id);
      loadCrewMembers();
      toast.success('Crew member deleted successfully');
    } catch (error) {
      console.error('Error deleting crew member:', error);
      toast.error('Error deleting crew member');
    }
  };

  const startEditing = (crewMember) => {
    setEditingCrewMember(crewMember);
  };

  const stopEditing = () => {
    setEditingCrewMember(null);
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setNewCrewMember({ ...newCrewMember, [name]: value });
  };

  const handleEditChange = (e) => {
    const { name, value } = e.target;
    setEditingCrewMember({ ...editingCrewMember, [name]: value });
  };

  const handleEditSubmit = async (e) => {
    e.preventDefault();
    await handleUpdate(editingCrewMember.id, editingCrewMember);
    stopEditing();
  };

  const filteredCrewMembers = crewMembers.filter((crewMember) => {
    const value = crewMember[searchKey];
    return value && value.toString().toLowerCase().includes(searchTerm.toLowerCase());
  });

  return (
    <div>
      <ToastContainer />
      <h1 className="text-2xl font-bold mb-4">Crew Members</h1>
      <div className="flex mb-4">
        <select
          value={searchKey}
          onChange={(e) => setSearchKey(e.target.value)}
          className="p-2 dark:bg-gray-800 dark:text-white mr-2"
        >
          <option value="name">Name</option>
          <option value="roleName">Role</option>
          <option value="idmember">ID Member</option>
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
        <h2 className="text-xl font-bold mb-4">Create Crew Member</h2>
        <div className="mb-4">
          <label className="block mb-2">Name</label>
          <input
            type="text"
            name="name"
            placeholder="Name"
            value={newCrewMember.name}
            onChange={handleChange}
            className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
          />
          <label className="block mb-2">Role</label>
          <select
            name="roleName"
            value={newCrewMember.roleName}
            onChange={handleChange}
            className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
          >
            <option value="" disabled>Select Role</option>
            {roles.map((role) => (
              <option key={role.id} value={role.role}>{role.role}</option>
            ))}
          </select>
          <label className="block mb-2">ID Member</label>
          <input
            type="text"
            name="idmember"
            placeholder="ID Member"
            value={newCrewMember.idmember}
            onChange={handleChange}
            className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
          />
          <button onClick={handleCreate} className="p-2 bg-blue-500 text-white w-full">Create</button>
        </div>
      </div>
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
        {filteredCrewMembers.map((crewMember) => (
          <div key={crewMember.id} className="bg-gray-800 text-white p-4 rounded-md shadow-md">
            <h2 className="text-xl font-bold">Crew Member</h2>
            <p><strong>ID:</strong> {crewMember.id}</p>
            <p><strong>Name:</strong> {crewMember.name}</p>
            <p><strong>Role:</strong> {crewMember.roleName}</p>
            <p><strong>ID Member:</strong> {crewMember.idmember}</p>
            <button onClick={() => startEditing(crewMember)} className="mt-2 p-2 bg-yellow-500 text-white">Edit</button>
            <button onClick={() => handleDelete(crewMember.id)} className="mt-2 ml-2 p-2 bg-red-500 text-white">Delete</button>
            {editingCrewMember && editingCrewMember.id === crewMember.id && (
              <form onSubmit={handleEditSubmit} className="mt-4">
                <label className="block mb-2">Name</label>
                <input
                  type="text"
                  name="name"
                  value={editingCrewMember.name}
                  onChange={handleEditChange}
                  placeholder={`Editing ${searchKey}`}
                  className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
                />
                <label className="block mb-2">Role</label>
                <select
                  name="roleName"
                  value={editingCrewMember.roleName}
                  onChange={handleEditChange}
                  className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
                >
                  <option value="" disabled>Select Role</option>
                  {roles.map((role) => (
                    <option key={role.id} value={role.role}>{role.role}</option>
                  ))}
                </select>
                <label className="block mb-2">ID Member</label>
                <input
                  type="text"
                  name="idmember"
                  value={editingCrewMember.idmember}
                  onChange={handleEditChange}
                  placeholder={`Editing ${searchKey}`}
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

export default CrewMembers;
