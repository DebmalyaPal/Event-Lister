import { gql, QueryResult, useQuery } from "@apollo/client";
import { User } from "../Models/User";

export const GET_ALL_USERS = gql`
    query {
        getUser {
            id
            name
            email
            created
        }
    }
`;

export function useGetAllUsers() {
    return useQuery(GET_ALL_USERS);
}