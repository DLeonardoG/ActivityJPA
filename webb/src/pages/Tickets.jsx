import React, { useState, useEffect } from 'react';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import {
  getTickets, createTicket, updateTicket, deleteTicket,
  getFlights, getClassSeats, getPassengers, getPayMethods
} from '../services/api';

const Tickets = () => {
  const [tickets, setTickets] = useState([]);
  const [newTicket, setNewTicket] = useState({ dateBuy: '', dateFlight: '', seat: '', flight: '', classSeat: '', passenger: '', payMethod: '' });
  const [editingTicket, setEditingTicket] = useState(null);
  const [flights, setFlights] = useState([]);
  const [classSeats, setClassSeats] = useState([]);
  const [passengers, setPassengers] = useState([]);
  const [payMethods, setPayMethods] = useState([]);
  const [searchTerm, setSearchTerm] = useState('');
  const [searchKey, setSearchKey] = useState('dateBuy');

  useEffect(() => {
    loadTickets();
    loadFlights();
    loadClassSeats();
    loadPassengers();
    loadPayMethods();
  }, []);

  const loadTickets = async () => {
    try {
      const response = await getTickets();
      setTickets(response.data);
    } catch (error) {
      console.error('Error loading tickets:', error);
    }
  };

  const loadFlights = async () => {
    try {
      const response = await getFlights();
      setFlights(response.data);
    } catch (error) {
      console.error('Error loading flights:', error);
    }
  };

  const loadClassSeats = async () => {
    try {
      const response = await getClassSeats();
      setClassSeats(response.data);
    } catch (error) {
      console.error('Error loading class seats:', error);
    }
  };

  const loadPassengers = async () => {
    try {
      const response = await getPassengers();
      setPassengers(response.data);
    } catch (error) {
      console.error('Error loading passengers:', error);
    }
  };

  const loadPayMethods = async () => {
    try {
      const response = await getPayMethods();
      setPayMethods(response.data);
    } catch (error) {
      console.error('Error loading pay methods:', error);
    }
  };

  const handleCreate = async () => {
    if (!newTicket.dateBuy || !newTicket.dateFlight || !newTicket.seat || !newTicket.flight || !newTicket.classSeat || !newTicket.passenger || !newTicket.payMethod) {
      toast.error('All fields must be filled');
      return;
    }

    // Verificar que no exista otro ticket con el mismo id de flight y seat
    const existingTicket = tickets.find(ticket => ticket.flight === newTicket.flight && ticket.seat === newTicket.seat);
    if (existingTicket) {
      toast.error('A ticket with the same seat already exists for this flight');
      return;
    }

    try {
      await createTicket(newTicket);
      setNewTicket({ dateBuy: '', dateFlight: '', seat: '', flight: '', classSeat: '', passenger: '', payMethod: '' });
      loadTickets();
      toast.success('Ticket added successfully');
    } catch (error) {
      console.error('Error creating ticket:', error);
      toast.error('Error creating ticket');
    }
  };

  const handleUpdate = async (id, updatedTicket) => {
    try {
      await updateTicket(id, updatedTicket);
      loadTickets();
      toast.success('Ticket updated successfully');
    } catch (error) {
      console.error('Error updating ticket:', error);
      toast.error('Error updating ticket');
    }
  };

  const handleDelete = async (id) => {
    try {
      await deleteTicket(id);
      loadTickets();
      toast.success('Ticket deleted successfully');
    } catch (error) {
      console.error('Error deleting ticket:', error);
      toast.error('Error deleting ticket');
    }
  };

  const startEditing = (ticket) => {
    setEditingTicket(ticket);
  };

  const stopEditing = () => {
    setEditingTicket(null);
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setNewTicket({ ...newTicket, [name]: value });
  };

  const handleEditChange = (e) => {
    const { name, value } = e.target;
    setEditingTicket({ ...editingTicket, [name]: value });
  };

  const handleEditSubmit = async (e) => {
    e.preventDefault();
    await handleUpdate(editingTicket.id, editingTicket);
    stopEditing();
  };

  const filteredTickets = tickets.filter((ticket) => {
    const value = ticket[searchKey];
    return value && value.toString().toLowerCase().includes(searchTerm.toLowerCase());
  });

  return (
    <div className='min-h-screen'>
      <ToastContainer />
      <h1 className="text-2xl font-bold mb-4  text-center">Tickets</h1>
      <div className="flex mb-4">
        <select
          value={searchKey}
          onChange={(e) => setSearchKey(e.target.value)}
          className="p-2 dark:bg-gray-800 dark:text-white mr-2"
        >
          <option value="dateBuy">Date Buy</option>
          <option value="dateFlight">Date Flight</option>
          <option value="seat">Seat</option>
          <option value="flight">Flight</option>
          <option value="classSeat">Class Seat</option>
          <option value="passenger">Passenger</option>
          <option value="payMethod">Pay Method</option>
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
        <h2 className="text-xl font-bold mb-4">Create Ticket</h2>
        <div className="mb-4">
          <label className="block mb-2">Date Buy</label>
          <input
            type="datetime-local"
            name="dateBuy"
            placeholder="Date Buy"
            value={newTicket.dateBuy}
            onChange={handleChange}
            className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
          />
          <label className="block mb-2">Date Flight</label>
          <input
            type="datetime-local"
            name="dateFlight"
            placeholder="Date Flight"
            value={newTicket.dateFlight}
            onChange={handleChange}
            className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
          />
          <label className="block mb-2">Seat</label>
          <div className="flex mb-2">
            <select
              name="seatLetter"
              value={newTicket.seat.charAt(0)}
              onChange={(e) => setNewTicket({ ...newTicket, seat: `${e.target.value}${newTicket.seat.charAt(1)}` })}
              className="p-2 dark:bg-gray-700 dark:text-white w-full mr-2"
            >
              <option value="" disabled>Select Letter</option>
              {['A', 'B', 'C', 'D', 'E', 'F', 'G'].map((letter) => (
                <option key={letter} value={letter}>{letter}</option>
              ))}
            </select>
            <select
              name="seatNumber"
              value={newTicket.seat.charAt(1)}
              onChange={(e) => setNewTicket({ ...newTicket, seat: `${newTicket.seat.charAt(0)}${e.target.value}` })}
              className="p-2 dark:bg-gray-700 dark:text-white w-full"
            >
              <option value="" disabled>Select Number</option>
              {Array.from({ length: 10 }, (_, i) => i + 1).map((number) => (
                <option key={number} value={number}>{number}</option>
              ))}
            </select>
          </div>
          <label className="block mb-2">Flight</label>
          <select
            name="flight"
            value={newTicket.flight}
            onChange={handleChange}
            className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
          >
            <option value="" disabled>Select Flight</option>
            {flights.map((flight) => (
              <option key={flight.id} value={flight.id}>{flight.id}</option>
            ))}
          </select>
          <label className="block mb-2">Class Seat</label>
          <select
            name="classSeat"
            value={newTicket.classSeat}
            onChange={handleChange}
            className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
          >
            <option value="" disabled>Select Class Seat</option>
            {classSeats.map((classSeat) => (
              <option key={classSeat.id} value={classSeat.seatClass}>{classSeat.seatClass}</option>
            ))}
                    </select>
          <label className="block mb-2">Passenger</label>
          <select
            name="passenger"
            value={newTicket.passenger}
            onChange={handleChange}
            className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
          >
            <option value="" disabled>Select Passenger</option>
            {passengers.map((passenger) => (
              <option key={passenger.id} value={passenger.idpassenger}>{passenger.idpassenger}</option>
            ))}
          </select>
          <label className="block mb-2">Pay Method</label>
          <select
            name="payMethod"
            value={newTicket.payMethod}
            onChange={handleChange}
            className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
          >
            <option value="" disabled>Select Pay Method</option>
            {payMethods.map((payMethod) => (
              <option key={payMethod.id} value={payMethod.payMethod}>{payMethod.payMethod}</option>
            ))}
          </select>
          <button onClick={handleCreate} className="p-2 bg-blue-500 text-white w-full">Create</button>
        </div>
      </div>
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
        {filteredTickets.map((ticket) => (
          <div key={ticket.id} className="bg-gray-800 text-white p-4 rounded-md shadow-md">
            <h2 className="text-xl font-bold">Ticket</h2>
            <p><strong>ID:</strong> {ticket.id}</p>
            <p><strong>Date Buy:</strong> {ticket.dateBuy}</p>
            <p><strong>Date Flight:</strong> {ticket.dateFlight}</p>
            <p><strong>Seat:</strong> {ticket.seat}</p>
            <p><strong>Flight:</strong> {ticket.flight}</p>
            <p><strong>Class Seat:</strong> {ticket.classSeat}</p>
            <p><strong>Passenger:</strong> {ticket.passenger}</p>
            <p><strong>Pay Method:</strong> {ticket.payMethod}</p>
            <button onClick={() => startEditing(ticket)} className="mt-2 p-2 bg-yellow-500 text-white">Edit</button>
            <button onClick={() => handleDelete(ticket.id)} className="mt-2 ml-2 p-2 bg-red-500 text-white">Delete</button>
            {editingTicket && editingTicket.id === ticket.id && (
              <form onSubmit={handleEditSubmit} className="mt-4">
                <label className="block mb-2">Date Buy</label>
                <input
                  type="datetime-local"
                  name="dateBuy"
                  value={editingTicket.dateBuy}
                  onChange={handleEditChange}
                  className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
                />
                <label className="block mb-2">Date Flight</label>
                <input
                  type="datetime-local"
                  name="dateFlight"
                  value={editingTicket.dateFlight}
                  onChange={handleEditChange}
                  className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
                />
                <label className="block mb-2">Seat</label>
                <div className="flex mb-2">
                  <select
                    name="seatLetter"
                    value={editingTicket.seat.charAt(0)}
                    onChange={(e) => setEditingTicket({ ...editingTicket, seat: `${e.target.value}${editingTicket.seat.charAt(1)}` })}
                    className="p-2 dark:bg-gray-700 dark:text-white w-full mr-2"
                  >
                    <option value="" disabled>Select Letter</option>
                    {['A', 'B', 'C', 'D', 'E', 'F', 'G'].map((letter) => (
                      <option key={letter} value={letter}>{letter}</option>
                    ))}
                  </select>
                  <select
                    name="seatNumber"
                    value={editingTicket.seat.charAt(1)}
                    onChange={(e) => setEditingTicket({ ...editingTicket, seat: `${editingTicket.seat.charAt(0)}${e.target.value}` })}
                    className="p-2 dark:bg-gray-700 dark:text-white w-full"
                  >
                    <option value="" disabled>Select Number</option>
                    {Array.from({ length: 10 }, (_, i) => i + 1).map((number) => (
                      <option key={number} value={number}>{number}</option>
                    ))}
                  </select>
                </div>
                <label className="block mb-2">Flight</label>
                <select
                  name="flight"
                  value={editingTicket.flight}
                  onChange={handleEditChange}
                  className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
                >
                  <option value="" disabled>Select Flight</option>
                  {flights.map((flight) => (
                    <option key={flight.id} value={flight.id}>{flight.id}</option>
                  ))}
                </select>
                <label className="block mb-2">Class Seat</label>
                <select
                  name="classSeat"
                  value={editingTicket.classSeat}
                  onChange={handleEditChange}
                  className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
                >
                  <option value="" disabled>Select Class Seat</option>
                  {classSeats.map((classSeat) => (
                    <option key={classSeat.id} value={classSeat.seatClass}>{classSeat.seatClass}</option>
                  ))}
                </select>
                <label className="block mb-2">Passenger</label>
                <select
                  name="passenger"
                  value={editingTicket.passenger}
                  onChange={handleEditChange}
                  className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
                >
                  <option value="" disabled>Select Passenger</option>
                  {passengers.map((passenger) => (
                    <option key={passenger.id} value={passenger.idpassenger}>{passenger.idpassenger}</option>
                  ))}
                </select>
                <label className="block mb-2">Pay Method</label>
                <select
                  name="payMethod"
                  value={editingTicket.payMethod}
                  onChange={handleEditChange}
                  className="p-2 mb-2 dark:bg-gray-700 dark:text-white w-full"
                >
                  <option value="" disabled>Select Pay Method</option>
                  {payMethods.map((payMethod) => (
                    <option key={payMethod.id} value={payMethod.payMethod}>{payMethod.payMethod}</option>
                  ))}
                </select>
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

export default Tickets;

