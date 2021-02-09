import { Router, Request, Response } from "express";
import CountryController from "../controllers/country.controller";

const controller = new CountryController();
const router = Router();

router.get("/", async (req: Request, res: Response) => {
  controller.getAll(req, res);
});

// router.get("/:id", async (req: Request, res: Response) =>
//   controller.getById(req, res)
// );

// router.post("/", async (req: Request, res: Response) =>
//   controller.postOrder(req, res)
// );

export { router as CountryRouter };
