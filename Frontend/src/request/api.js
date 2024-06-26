import axios from "axios";

export const api = axios.create({
    baseURL: `https://json-server-wi8c.onrender.com`
    //process.env.REACT_APP_URL_SERVER_HOSTNAME
    //https://project-java2.onrender.com
    //http://localhost:8080
});


export async function getApi(url) {
    try{
        const res = await api.get(url, {
            withCredentials: true,
            headers: {
                // Authorization: `Bearer ${token}`,
                "Content-Type" : "application/json",
            }
        });
        return res.data;
    }catch (error) {

        console.error("error", error)
        throw error;
    }
}

export async function postApi(url, data) {
    try{
        const res = await api.post(url, data, {
            withCredentials: true,
            headers: {
                // Authorization: `Bearer ${token}`,
                "Content-Type" : "application/json",
            }
        });
        return res.data;
    }catch (error) {

        console.error("error", error)
        throw error;
    }
}