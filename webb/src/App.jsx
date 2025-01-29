import React, { useContext } from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import { AuthContext, AuthProvider } from './context/AuthContext';
import Menu from './components/Menu';
import Login from './pages/Login';
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

const PrivateRoute = ({ element: Element, ...rest }) => {
  const { isAuthenticated } = useContext(AuthContext);
  return isAuthenticated ? <Element {...rest} /> : <Navigate to="/" />;
};


const App = () => {
  return (
    <AuthProvider>
      <Router>
        <div className="flex">
          <Menu />
          <div className="flex-1 p-4 bg-gray-900 text-white">
            <Routes>
              <Route path="/" element={<Login />} />
              <Route path="/airports" element={<PrivateRoute element={Airports} />} />
              <Route path="/classseats" element={<PrivateRoute element={ClassSeats} />} />
              <Route path="/flights" element={<PrivateRoute element={Flights} />} />
              <Route path="/tickets" element={<PrivateRoute element={Tickets} />} />
              <Route path="/crewmembers" element={<PrivateRoute element={CrewMembers} />} />
              <Route path="/maintenances" element={<PrivateRoute element={Maintenances} />} />
              <Route path="/passengers" element={<PrivateRoute element={Passengers} />} />
              <Route path="/paymethods" element={<PrivateRoute element={PayMethods} />} />
              <Route path="/places" element={<PrivateRoute element={Places} />} />
              <Route path="/planes" element={<PrivateRoute element={Planes} />} />
              <Route path="/roles" element={<PrivateRoute element={Roles} />} />
              <Route path="/typesmaintenances" element={<PrivateRoute element={TypesMaintenances} />} />
            </Routes>
          </div>
        </div>
      </Router>
    </AuthProvider>
  );
};

export default App;
