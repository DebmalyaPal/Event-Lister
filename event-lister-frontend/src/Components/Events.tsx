import React, { useEffect, useState } from "react";
import '../../node_modules/bootstrap/dist/css/bootstrap.css'
import { useGetAllEvents } from "../GraphQL/EventQueries";
import { Event } from "../Models/Event";


export default function EventList() {

    const { loading, error, data } = useGetAllEvents();

    if (loading) return <p>Loading...</p>;
    if (error) return <p>Error: {error.message}</p>;

    return (
        <div>
            <table className="table table-dark table-striped mx-auto"
                style={{width:"80%"}}>
                <thead>
                    <tr>
                        <th colSpan={4}>
                            EVENTS LIST
                        </th>
                    </tr>
                    <tr>
                        <th>Id</th>
                        <th>Type</th>
                        <th>Date</th>
                        <th>Description</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        data?.getEvent.map(
                            (event : Event) =>
                                <tr key = { event.id.toString() }>
                                    <td> { event.id.toString() } </td>
                                    <td> { event.event_type } </td>
                                    <td> { event.date } </td>
                                    <td> { event.description } </td>
                                </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    );
}