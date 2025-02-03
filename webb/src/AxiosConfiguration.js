import axios from 'axios';

const AxiosConfiguration = axios.create({
    baseURL: "http://localhost:3001/api",
});

AxiosConfiguration.interceptors.request.use((config) => {
    const token = localStorage.getItem("token");
    if (token) {
        config.headers["Authorization"] = `Bearer ${token}`;
    }
    return config;
}, (error) => {
    console.log("holaa")
    return Promise.reject(error);   
});

export default AxiosConfiguration;