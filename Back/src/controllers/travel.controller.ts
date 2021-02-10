import { Request, Response } from "express";
import axios from "../axios.config";
import Country from "../classes/country";
import Utils from "../static/travel.static";

const utils = new Utils();

export default class TravelController {
    async getAll(req:Request,res:Response){
        const countries:Country[] = await utils.get10RandomCountries();
        
        countries.forEach(async country => {
            const places = await utils.getPlaces(country.code);
            console.log("country: "+country.code, JSON.stringify(places))
        })
        // const travels = await axios.get(`FR/EUR/fr-FR/FR-sky/${}/${req.params.depart}`)
    }
}