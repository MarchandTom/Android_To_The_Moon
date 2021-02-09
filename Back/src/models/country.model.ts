import Country from "../classes/country";
import storage from "node-persist";

export default class CountryModel {
  getCountries(): Promise<Country[]> {
    return storage.getItem("country");
  }
}
