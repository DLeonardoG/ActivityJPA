import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import {
  AiFillHome,
  AiOutlineUnorderedList,
  AiOutlineMenu,
  AiOutlineClose,
  AiFillBank,
  AiFillTool,
  AiFillCar,
  AiOutlineSolution,
  AiFillCarryOut,
  AiOutlineCreditCard,
  AiFillSetting,
  AiFillControl,
  AiFillAlert
} from 'react-icons/ai';
import { FaHome, FaPlaneDeparture, FaUserFriends } from 'react-icons/fa';
import {  MdAirplanemodeActive, MdOutlineManageAccounts } from 'react-icons/md';

const Menu = () => {
  const [isOpen, setIsOpen] = useState(false);

  const toggleMenu = () => {
    setIsOpen(!isOpen);
  };

  return (
    <div className="h-full md:h-screen fixed top-0 left-0 z-50">
      <div className="flex justify-between items-center p-4 bg-gray-800 text-white">
        <button onClick={toggleMenu} className="focus:outline-none">
          {isOpen ? <AiOutlineClose size={30} /> : <AiOutlineMenu size={30} />}
        </button>
      </div>
      <div className={`${isOpen ? 'block' : 'hidden'} w-full h-full bg-gray-800 text-white overflow-y-auto`}>
        <ul className="p-4">
          <li className="p-4 hover:bg-gray-700">
            <Link to="/classseats" className="flex items-center">
              <AiOutlineUnorderedList className="mr-2" />
              Class Seats
            </Link>
          </li>
          <li className="p-4 hover:bg-gray-700">
            <Link to="/flights" className="flex items-center">
              <FaPlaneDeparture className="mr-2" />
              Flights
            </Link>
          </li>
          <li className="p-4 hover:bg-gray-700">
            <Link to="/roles" className="flex items-center">
              <MdOutlineManageAccounts className="mr-2" />
              Roles
            </Link>
          </li>
          <li className="p-4 hover:bg-gray-700">
            <Link to="/crewmembers" className="flex items-center">
              <FaUserFriends className="mr-2" />
              Crew Members
            </Link>
          </li>
          <li className="p-4 hover:bg-gray-700">
            <Link to="/airports" className="flex items-center">
              <AiFillBank className="mr-2" />
              Airports
            </Link>
          </li>
          <li className="p-4 hover:bg-gray-700">
            <Link to="/maintenances" className="flex items-center">
              <FaHome className="mr-2" />
              Maintenances
            </Link>
          </li>
          <li className="p-4 hover:bg-gray-700">
            <Link to="/passengers" className="flex items-center">
              <AiOutlineSolution className="mr-2" />
              Passengers
            </Link>
          </li>
          <li className="p-4 hover:bg-gray-700">
            <Link to="/planes" className="flex items-center">
              <MdAirplanemodeActive className="mr-2" />
              Planes
            </Link>
          </li>
          <li className="p-4 hover:bg-gray-700">
            <Link to="/tickets" className="flex items-center">
              <AiFillCarryOut className="mr-2" />
              Tickets
            </Link>
          </li>
          <li className="p-4 hover:bg-gray-700">
            <Link to="/typesmaintenances" className="flex items-center">
              <AiFillTool className="mr-2" />
              Types Maintenances
            </Link>
          </li>
        </ul>
      </div>
    </div>
  );
};

export default Menu;
