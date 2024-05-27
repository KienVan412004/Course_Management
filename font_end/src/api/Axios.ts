import axios from "axios";
const user = localStorage.getItem("userName");
const pass = localStorage.getItem("password");
const axiosAll = axios.create({
  baseURL: "http://localhost:8080/api/",
  auth: {
    username: user || "admin@gmail.com",
    password: pass || "123456",
  },
});
export default axiosAll;
