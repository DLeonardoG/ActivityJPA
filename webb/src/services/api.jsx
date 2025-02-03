import AxiosConfiguration from '../AxiosConfiguration'; // Importa la instancia configurada

const API_URL = 'http://localhost:3001/api';

// Funciones para Flights
export const getFlights = () => {
  return AxiosConfiguration.get(`/flights`);
};

export const createFlight = (flight) => {
  return AxiosConfiguration.post(`/flights`, flight);
};

export const updateFlight = (id, flight) => {
  return AxiosConfiguration.put(`/flights/${id}`, flight);
};

export const deleteFlight = (id) => {
  return AxiosConfiguration.delete(`/flights/${id}`);
};

// Funciones para Planes
export const getPlanes = () => {
  return AxiosConfiguration.get(`/planes`);
};

export const createPlane = (plane) => {
  return AxiosConfiguration.post(`/planes`, plane);
};

export const updatePlane = (id, plane) => {
  return AxiosConfiguration.put(`/planes/${id}`, plane);
};

export const deletePlane = (id) => {
  return AxiosConfiguration.delete(`/planes/${id}`);
};

// Funciones para Métodos de Pago
export const getPayMethods = () => {
  return AxiosConfiguration.get(`/paymethods`);
};

export const createPayMethod = (payMethod) => {
  return AxiosConfiguration.post(`/paymethods`, payMethod);
};

export const updatePayMethod = (id, payMethod) => {
  return AxiosConfiguration.put(`/paymethods/${id}`, payMethod);
};

export const deletePayMethod = (id) => {
  return AxiosConfiguration.delete(`/paymethods/${id}`);
};

// Funciones para Roles
export const getRoles = () => {
  return AxiosConfiguration.get(`/roles`);
};

export const createRole = (role) => {
  return AxiosConfiguration.post(`/roles`, role);
};

export const updateRole = (id, role) => {
  return AxiosConfiguration.put(`/roles/${id}`, role);
};

export const deleteRole = (id) => {
  return AxiosConfiguration.delete(`/roles/${id}`);
};

// Funciones para Tripulantes
export const getCrewMembers = () => {
  return AxiosConfiguration.get(`/crewmembers`);
};

export const createCrewMember = (crewMember) => {
  return AxiosConfiguration.post(`/crewmembers`, crewMember);
};

export const updateCrewMember = (id, crewMember) => {
  return AxiosConfiguration.put(`/crewmembers/${id}`, crewMember);
};

export const deleteCrewMember = (id) => {
  return AxiosConfiguration.delete(`/crewmembers/${id}`);
};

// Funciones para Aeropuertos
export const getAirports = () => {
  return AxiosConfiguration.get(`/airports`);
};

export const createAirport = (airport) => {
  return AxiosConfiguration.post(`/airports`, airport);
};

export const updateAirport = (id, airport) => {
  return AxiosConfiguration.put(`/airports/${id}`, airport);
};

export const deleteAirport = (id) => {
  return AxiosConfiguration.delete(`/airports/${id}`);
};

// Funciones para Asientos de Clase
export const getClassSeats = () => {
  return AxiosConfiguration.get(`/classseats`);
};

export const createClassSeat = (classSeat) => {
  return AxiosConfiguration.post(`/classseats`, classSeat);
};

export const updateClassSeat = (id, classSeat) => {
  return AxiosConfiguration.put(`/classseats/${id}`, classSeat);
};

export const deleteClassSeat = (id) => {
  return AxiosConfiguration.delete(`/classseats/${id}`);
};

// Funciones para Tickets
export const getTickets = () => {
  return AxiosConfiguration.get(`/tickets`);
};

export const createTicket = (ticket) => {
  return AxiosConfiguration.post(`/tickets`, ticket);
};

export const updateTicket = (id, ticket) => {
  return AxiosConfiguration.put(`/tickets/${id}`, ticket);
};

export const deleteTicket = (id) => {
  return AxiosConfiguration.delete(`/tickets/${id}`);
};

// Funciones para Pasajeros
export const getPassengers = () => {
  return AxiosConfiguration.get(`/passengers`);
};

export const createPassenger = (passenger) => {
  return AxiosConfiguration.post(`/passengers`, passenger);
};

export const updatePassenger = (id, passenger) => {
  return AxiosConfiguration.put(`/passengers/${id}`, passenger);
};

export const deletePassenger = (id) => {
  return AxiosConfiguration.delete(`/passengers/${id}`);
};

// Funciones para Tipos de Mantenimiento
export const getTypesMaintenances = () => {
  return AxiosConfiguration.get(`/typesmaintenances`);
};

export const createTypeMaintenance = (typeMaintenance) => {
  return AxiosConfiguration.post(`/typesmaintenances`, typeMaintenance);
};

export const updateTypeMaintenance = (id, typeMaintenance) => {
  return AxiosConfiguration.put(`/typesmaintenances/${id}`, typeMaintenance);
};

export const deleteTypeMaintenance = (id) => {
  return AxiosConfiguration.delete(`/typesmaintenances/${id}`);
};

// Funciones para Mantenimientos
export const getMaintenances = () => {
  return AxiosConfiguration.get(`/maintenances`);
};

export const createMaintenance = (maintenance) => {
  return AxiosConfiguration.post(`/maintenances`, maintenance);
};

export const updateMaintenance = (id, maintenance) => {
  return AxiosConfiguration.put(`/maintenances/${id}`, maintenance);
};

export const deleteMaintenance = (id) => {
  return AxiosConfiguration.delete(`/maintenances/${id}`);
};