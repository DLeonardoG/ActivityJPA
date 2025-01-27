import React, { useEffect, useState } from 'react';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { createPayMethod, deletePayMethod, getPayMethods, updatePayMethod } from '../services/api';

const PayMethods = () => {
  const [payMethods, setPayMethods] = useState([]);
  const [newPayMethod, setNewPayMethod] = useState({ payMethod: '' });
  const [editingPayMethod, setEditingPayMethod] = useState(null);
  const [searchTerm, setSearchTerm] = useState('');
  const [searchKey, setSearchKey] = useState('payMethod');

  useEffect(() => {
    loadPayMethods();
  }, []);

  const loadPayMethods = async () => {
    try {
      const response = await getPayMethods();
      setPayMethods(response.data);
    } catch (error) {
      console.error('Error loading pay methods:', error);
    }
  };

  const handleCreate = async () => {
    if (!newPayMethod.payMethod) {
      toast.error('Pay method cannot be empty');
      return;
    }

    try {
      await createPayMethod(newPayMethod);
      setNewPayMethod({ payMethod: '' });
      loadPayMethods();
      toast.success('Pay method added successfully');
    } catch (error) {
      console.error('Error creating pay method:', error);
      toast.error('Error creating pay method');
    }
  };

  const handleUpdate = async (id, updatedPayMethod) => {
    try {
      await updatePayMethod(id, updatedPayMethod);
      loadPayMethods();
      toast.success('Pay method updated successfully');
    } catch (error) {
      console.error('Error updating pay method:', error);
      toast.error('Error updating pay method');
    }
  };

  const handleDelete = async (id) => {
    try {
      await deletePayMethod(id);
      loadPayMethods();
      toast.success('Pay method deleted successfully');
    } catch (error) {
      console.error('Error deleting pay method:', error);
      toast.error('Error deleting pay method');
    }
  };

  const startEditing = (payMethod) => {
    setEditingPayMethod(payMethod);
  };

  const stopEditing = () => {
    setEditingPayMethod(null);
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setNewPayMethod({ ...newPayMethod, [name]: value });
  };

  const handleEditChange = (e) => {
    const { name, value } = e.target;
    setEditingPayMethod({ ...editingPayMethod, [name]: value });
  };

  const handleEditSubmit = async (e) => {
    e.preventDefault();
    await handleUpdate(editingPayMethod.id, editingPayMethod);
    stopEditing();
  };

  const filteredPayMethods = payMethods.filter((payMethod) => {
    const value = payMethod[searchKey];
    return value && value.toString().toLowerCase().includes(searchTerm.toLowerCase());
  });

  return (
    <div>
      <ToastContainer />
      <h1 className="text-2xl font-bold mb-4">Pay Methods</h1>
      <div className="flex mb-4">
        <select
          value={searchKey}
          onChange={(e) => setSearchKey(e.target.value)}
          className="p-2 bg-gray-800 text-white mr-2"
        >
          <option value="payMethod">Method</option>
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
        <h2 className="text-xl font-bold mb-4">Create Pay Method</h2>
        <div className="mb-4">
          <label className="block mb-2">Pay Method</label>
          <input
            type="text"
            name="payMethod"
            placeholder="Pay Method"
            value={newPayMethod.payMethod}
            onChange={handleChange}
            className="p-2 mb-2 bg-gray-700 text-white w-full"
          />
          <button onClick={handleCreate} className="p-2 bg-blue-500 text-white w-full">Create</button>
        </div>
      </div>
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
        {filteredPayMethods.map((payMethod) => (
          <div key={payMethod.id} className="bg-gray-800 text-white p-4 rounded-md shadow-md">
            <h2 className="text-xl font-bold">Pay Method</h2>
            <p><strong>ID:</strong> {payMethod.id}</p>
            <p><strong>Method:</strong> {payMethod.payMethod}</p>
            <button onClick={() => startEditing(payMethod)} className="mt-2 p-2 bg-yellow-500 text-white">Edit</button>
            <button onClick={() => handleDelete(payMethod.id)} className="mt-2 ml-2 p-2 bg-red-500 text-white">Delete</button>
            {editingPayMethod && editingPayMethod.id === payMethod.id && (
              <form onSubmit={handleEditSubmit} className="mt-4">
                <label className="block mb-2">Pay Method</label>
                <input
                  type="text"
                  name="payMethod"
                  value={editingPayMethod.payMethod}
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

export default PayMethods;
