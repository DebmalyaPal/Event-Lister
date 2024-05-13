import React from 'react';
import logo from './logo.svg';
import './App.css';
import EventList from './Components/Events';
import UserList from './Components/Users';

function App() {
  return (
    <div className="App">
      <h1>Learn React</h1>
      <EventList/>
      <UserList/>
    </div>
  );
}

export default App;
