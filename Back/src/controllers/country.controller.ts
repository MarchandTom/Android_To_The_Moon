import { Request, Response } from "express";
import Country from "../classes/country";
import CountryModel from "../models/country.model";
import axios from "../axios.config";

const model = new CountryModel();

export default class CountryController {
  async getAll(req: Request, res: Response) {
    const countries = await axios.get("countries/fr-FR");
    return res.json(countries.data.Countries);
  }
}
