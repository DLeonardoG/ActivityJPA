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