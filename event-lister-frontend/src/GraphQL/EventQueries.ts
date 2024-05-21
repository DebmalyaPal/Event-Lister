import { gql, QueryResult, useQuery } from "@apollo/client";
import { Event } from "../Models/Event";

export const GET_ALL_EVENTS = gql`
    query {
        getEvent {
            id
            event_type
            description
        }
    }
`;

export function useGetAllEvents() {
    return useQuery(GET_ALL_EVENTS);
}