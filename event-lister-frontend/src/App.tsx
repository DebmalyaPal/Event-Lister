import { gql, useQuery } from '@apollo/client';
import EventList from './Components/Events';
import UserList from './Components/Users';

function App() {

  console.log("ABC");

  const GET_EVENTS = gql`
    query {
      getEvent{
          id
          event_type
          description
        }
      }`;

  const { loading, error, data } = useQuery(GET_EVENTS);

  console.log(loading);
  console.log(error?.graphQLErrors);
  console.log(data);
  
  return (
    <div className="App">
      <h1>Learn React</h1>
      <EventList/>
      <UserList/>
    </div>
  );
}

export default App;
