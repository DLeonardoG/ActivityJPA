import axios from 'axios';

const API_URL = 'http://localhost:3001/api';

export const getFlights = () => {
  return axios.get(`${API_URL}/flights`);
};

export const createFlight = (flight) => {
  return axios.post(`${API_URL}/flights`, flight);
};

export const updateFlight = (id, flight) => {
  return axios.put(`${API_URL}/flights/${id}`, flight);
};

export const deleteFlight = (id) => {
  return axios.delete(`${API_URL}/flights/${id}`);
};

export const getPlanes = () => {
  return axios.get(`${API_URL}/planes`);
};

export const getPayMethods = () => {
  return axios.get(`${API_URL}/paymethods`);
};

export const createPayMethod = (payMethod) => {
  return axios.post(`${API_URL}/paymethods`, payMethod);
};

export const updatePayMethod = (id, payMethod) => {
  return axios.put(`${API_URL}/paymethods/${id}`, payMethod);
};

export const deletePayMethod = (id) => {
  return axios.delete(`${API_URL}/paymethods/${id}`);
};

export const getRoles = () => {
  return axios.get(`${API_URL}/roles`);
};

export const createRole = (role) => {
  return axios.post(`${API_URL}/roles`, role);
};

export const updateRole = (id, role) => {
  return axios.put(`${API_URL}/roles/${id}`, role);
};

export const deleteRole = (id) => {
  return axios.delete(`${API_URL}/roles/${id}`);
};

export const getCrewMembers = () => {
  return axios.get(`${API_URL}/crewmembers`);
};

export const createCrewMember = (crewMember) => {
  return axios.post(`${API_URL}/crewmembers`, crewMember);
};

export const updateCrewMember = (id, crewMember) => {
  return axios.put(`${API_URL}/crewmembers/${id}`, crewMember);
};

export const deleteCrewMember = (id) => {
  return axios.delete(`${API_URL}/crewmembers/${id}`);
};

export const getAirports = () => {
  return axios.get(`${API_URL}/airports`);
};

export const createAirport = (airport) => {
  return axios.post(`${API_URL}/airports`, airport);
};

export const updateAirport = (id, airport) => {
  return axios.put(`${API_URL}/airports/${id}`, airport);
};

export const deleteAirport = (id) => {
  return axios.delete(`${API_URL}/airports/${id}`);
};

export const getClassSeats = () => {
  return axios.get(`${API_URL}/classseats`);
};

export const createClassSeat = (classSeat) => {
  return axios.post(`${API_URL}/classseats`, classSeat);
};

export const updateClassSeat = (id, classSeat) => {
  return axios.put(`${API_URL}/classseats/${id}`, classSeat);
};

export const deleteClassSeat = (id) => {
  return axios.delete(`${API_URL}/classseats/${id}`);
};

export const getTickets = () => {
  return axios.get(`${API_URL}/tickets`);
};

export const createTicket = (ticket) => {
  return axios.post(`${API_URL}/tickets`, ticket);
};

export const updateTicket = (id, ticket) => {
  return axios.put(`${API_URL}/tickets/${id}`, ticket);
};

export const deleteTicket = (id) => {
  return axios.delete(`${API_URL}/tickets/${id}`);
};

export const getPassengers = () => {
  return axios.get(`${API_URL}/passengers`);
};

export const getTypesMaintenances = () => {
  return axios.get(`${API_URL}/typesmaintenances`);
};

export const createTypeMaintenance = (typeMaintenance) => {
  return axios.post(`${API_URL}/typesmaintenances`, typeMaintenance);
};

export const updateTypeMaintenance = (id, typeMaintenance) => {
  return axios.put(`${API_URL}/typesmaintenances/${id}`, typeMaintenance);
};

export const deleteTypeMaintenance = (id) => {
  return axios.delete(`${API_URL}/typesmaintenances/${id}`);
};

export const getMaintenances = () => {
  return axios.get(`${API_URL}/maintenances`);
};

export const createMaintenance = (maintenance) => {
  return axios.post(`${API_URL}/maintenances`, maintenance);
};

export const updateMaintenance = (id, maintenance) => {
  return axios.put(`${API_URL}/maintenances/${id}`, maintenance);
};

export const deleteMaintenance = (id) => {
  return axios.delete(`${API_URL}/maintenances/${id}`);
};

export const createPassenger = (passenger) => {
  return axios.post(`${API_URL}/passengers`, passenger);
};

export const updatePassenger = (id, passenger) => {
  return axios.put(`${API_URL}/passengers/${id}`, passenger);
};

export const deletePassenger = (id) => {
  return axios.delete(`${API_URL}/passengers/${id}`);
};

export const createPlane = (plane) => {
  return axios.post(`${API_URL}/planes`, plane);
};

export const updatePlane = (id, plane) => {
  return axios.put(`${API_URL}/planes/${id}`, plane);
};

export const deletePlane = (id) => {
  return axios.delete(`${API_URL}/planes/${id}`);
};