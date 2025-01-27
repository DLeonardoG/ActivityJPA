import React, { useState } from 'react';
import Login from './login';
import App from './App';

const Page = () => {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  return (
    <>
      {/*{!isLoggedIn && <Login onLoginSuccess={() => setIsLoggedIn(true)} />}*/}
      {isLoggedIn && <App />}
    </>
  );
};

export default Page;
