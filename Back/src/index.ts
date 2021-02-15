import express from "express";
import { json } from "body-parser";
import storage from "node-persist";
import { TravelRouter } from "./routes/travel.router";
import { country as _country } from "./datas/_country";

const app = express();

app.use(json());

//Implementation des routes
app.use("/travel", TravelRouter);

storage.init().then(() => {
  storage.setItem("country", _country);
});

app.listen(3000, () => {
  console.log("server is listening on port 3000");
});
