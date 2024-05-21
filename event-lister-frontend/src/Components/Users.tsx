import React from "react";
import '../../node_modules/bootstrap/dist/css/bootstrap.css'
import { useGetAllUsers } from "../GraphQL/UserQueries";
import { User } from "../Models/User";

export default function UserList() {

    const { loading, error, data } = useGetAllUsers();
    
    if (loading) return <p>Loading...</p>;
    if (error) return <p>Error: {error.message}</p>;

    return (
        <div>
            <table className="table table-dark table-striped mx-auto"
                style={{width:"80%"}}>
                <thead>
                    <tr>
                        <th colSpan={4}>
                            USERS LIST
                        </th>
                    </tr>
                    <tr>
                        <th>Id</th>
                        <th>NAME</th>
                        <th>EMAIL</th>
                        <th>CREATED</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        data?.getUser.map(
                            (user : User) =>
                                <tr key = { user.id.toString() } >
                                    <td> { user.id.toString() } </td>
                                    <td> { user.name } </td>
                                    <td> { user.email } </td>
                                    <td> { user.created } </td>
                                </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    );
}