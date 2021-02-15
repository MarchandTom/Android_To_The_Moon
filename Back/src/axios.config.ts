const axios = require("axios");

const instance = axios.create({
  baseURL:
    "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/",
  timeout: 1000,
  headers: {
    "x-rapidapi-key": "7b776e1a35msh22a6f2242c3ac2cp1b19b2jsnbfd0067c7057",
    "x-rapidapi-host": "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com",
  },
});

export default instance;
