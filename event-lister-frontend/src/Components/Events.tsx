import React, { useEffect, useState } from "react";
import '../../node_modules/bootstrap/dist/css/bootstrap.css'

export interface Event {
    id : Number,
    event_type : String,
    date : String,
    description : String
}


export default function EventList() {

    const [eventList, setEventList] = useState<Event[]>([])

    function fetchEventList() {
        const response = fetch ("http://localhost:9000/event").then(
            response => response.json()
        ).then(response => setEventList(response))
    }

    useEffect (
        () => { fetchEventList(); },
        []
    );
    
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
                        eventList.map(event =>
                                <tr key = { event.id.toString() }>
                                    <td>{ event.id.toString() }</td>
                                    <td>{ event.event_type }</td>
                                    <td>{ event.date }</td>
                                    <td>{ event.description }</td>
                                </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    );
}