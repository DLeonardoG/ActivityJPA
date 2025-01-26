import React from 'react';
import { Link } from 'react-router-dom';
import { AiFillHome, AiOutlineUnorderedList } from 'react-icons/ai';

const Menu = () => {
  return (
    <div className="w-64 h-screen bg-gray-800 text-white">
      <div className="p-4">
        <h1 className="text-3xl font-bold">Panel de Control</h1>
      </div>
      <ul>
        <li className="p-4 hover:bg-gray-700">
          <Link to="/airports" className="flex items-center">
            <AiFillHome className="mr-2" />
            Airports
          </Link>
        </li>
        <li className="p-4 hover:bg-gray-700">
          <Link to="/classseats" className="flex items-center">
            <AiOutlineUnorderedList className="mr-2" />
            Class Seats
          </Link>
        </li>
        <li className="p-4 hover:bg-gray-700">
          <Link to="/flights" className="flex items-center">
            <AiFillHome className="mr-2" />
            Flights
          </Link>
        </li>
        <li className="p-4 hover:bg-gray-700">
          <Link to="/paymethods" className="flex items-center">
            <AiFillHome className="mr-2" />
            Pay Methods
          </Link>
        </li>
        <li className="p-4 hover:bg-gray-700">
          <Link to="/roles" className="flex items-center">
            <AiFillHome className="mr-2" />
            Roles
          </Link>
        </li>
        <li className="p-4 hover:bg-gray-700">
          <Link to="/crewmembers" className="flex items-center">
            <AiFillHome className="mr-2" />
            Crew Members
          </Link>
        </li>
        {/* Añadir los demás enlaces de endpoints */}
      </ul>
    </div>
  );
};

export default Menu;
