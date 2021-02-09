import express from "express";
import { json } from "body-parser";
import storage from "node-persist";
import { CountryRouter } from "./routes/country.router";
import { country as _country } from "./datas/_country";

const app = express();
app.use(json());

//Implementation des routes
app.use("/country", CountryRouter);

storage.init().then(() => {
  storage.setItem("country", _country);
});

app.listen(3000, () => {
  console.log("server is listening on port 3000");
});
