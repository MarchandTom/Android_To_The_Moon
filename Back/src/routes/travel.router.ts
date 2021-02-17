import { Router, Request, Response } from "express";
import TravelController from "../controllers/travel.controller";

const controller = new TravelController();
const router = Router();

router.get("/country", async (req: Request, res: Response) => {
  res.send(await controller.getAllCountries());
});

router.get("/travel", async (req: Request, res: Response) => {
  const maxPrice = req.body.maxPrice;
  const alreadyVisitedCountry = req.body.alreadyVisitedCountry;

  try {
    const travel = await controller.getTenRandomTravel(
      maxPrice,
      alreadyVisitedCountry
    );

    res.send(travel);
  } catch (err) {
    res.send(err);
  }
});

export { router as TravelRouter };
