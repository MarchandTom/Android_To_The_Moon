import { Router, Request, Response } from "express";
import TravelController from "../controllers/travel.controller";

const controller = new TravelController();
const router = Router();

router.get("/", async (req: Request, res: Response) => {
  controller.getAll(req, res);
});

export { router as TravelRouter };
