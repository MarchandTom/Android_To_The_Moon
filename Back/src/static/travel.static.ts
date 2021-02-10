import axios from "../axios.config";
import Country from "../classes/country";

export default class Utils{

    async getPlaces(country:String) {
        const place = await axios.get(`countries/fr-FR/${country}`);
        return place; 
    }

    async get10RandomCountries():Promise<Country[]> {
        const countries = await axios.get("countries/fr-FR");
        const tenCountries = [];
        for(let i = 0;i<10;i++){
          const randomIndex = Math.floor(Math.random() * Math.floor(countries.data.Countries.length));
          tenCountries.push(countries.data.Countries[randomIndex]);
        }
        return tenCountries;
      }
}