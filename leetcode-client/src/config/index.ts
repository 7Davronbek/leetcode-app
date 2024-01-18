import axios from "axios";
// import {TOKEN} from "@/constant"

export default axios.create({
    baseURL: "http://localhost:8080",
    headers: {
        "Content-type": "application/json",
        // "Authorization": `Bearer ${localStorage.getItem(TOKEN)}`,
    },
    withCredentials: true
});