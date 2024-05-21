import { gql, useQuery } from '@apollo/client';
import { useState } from 'react';
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
