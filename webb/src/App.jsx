import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Menu from './components/Menu';
import Airports from './pages/Airports';
import ClassSeats from './pages/ClassSeats';
import Flights from './pages/Flights';
import Tickets from './pages/Tickets';
import CrewMembers from './pages/CrewMembers';
import Maintenances from './pages/Maintenances';
import Passengers from './pages/Passengers';
import PayMethods from './pages/PayMethods';
import Places from './pages/Places';
import Planes from './pages/Planes';
import Roles from './pages/Roles';
import TypesMaintenances from './pages/TypesMaintenances';

const App = () => {
  return (
    <Router>
      <div className="flex">
        <Menu />
        <div className="flex-1 p-4 dark:bg-gray-900 dark:text-white">
          <Routes>
            <Route path="/airports" element={<Airports />} />
            <Route path="/classseats" element={<ClassSeats />} />
            <Route path="/flights" element={<Flights />} />
            <Route path="/tickets" element={<Tickets />} />
            <Route path="/crewmembers" element={<CrewMembers />} />
            <Route path="/maintenances" element={<Maintenances />} />
            <Route path="/passengers" element={<Passengers />} />
            <Route path="/paymethods" element={<PayMethods />} />
            <Route path="/places" element={<Places />} />
            <Route path="/planes" element={<Planes />} />
            <Route path="/roles" element={<Roles />} />
            <Route path="/typesmaintenances" element={<TypesMaintenances />} />
          </Routes>
        </div>
      </div>
    </Router>
  );
};

export default App;
