import { Request, Response } from "express";
import Country from "../classes/country";
import Utils from "../static/travel.static";
import CountryModel from "../models/country.model";

const utils = new Utils();
const countryModel = new CountryModel();

function getRandomInt(max: number) {
  return Math.floor(Math.random() * Math.floor(max));
}

export default class TravelController {
  async getAllCountries() {
    return await countryModel.getCountries();
  }

  async getTenRandomTravel(maxPrice: number, alreadyVisitedCountry: Country[]) {
    const countries: Country[] = await countryModel.getCountries();
    const randomTravel = [];

    for (var i = 0; i < 10; i++) {
      const countryName = countries[getRandomInt(countries.length)].name;
      const checkIfAlreadyVisited = alreadyVisitedCountry.filter((country) => {
        country.name === countryName;
      });

      if (checkIfAlreadyVisited.length > 0) {
        i--;
      } else {
        var travel;
        do {
          travel = await utils.getPlaces(countryName);
        } while (!travel);
        travel.maxPrice = getRandomInt(maxPrice);
        randomTravel.push(travel);
      }
    }

    return randomTravel;
  }
}
