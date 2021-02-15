import axios from "../axios.config";

export default class Utils {
  async getPlaces(country: String) {
    const place = await axios.get(`autosuggest/v1.0/FR/EUR/fr-FR/`, {
      params: { query: country },
    });
    return place.data.Places[1];
  }
}
