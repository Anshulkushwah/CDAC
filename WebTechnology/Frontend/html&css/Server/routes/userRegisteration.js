const express = require("express");
const router = express.Router();

const {registration,
    login, accountDelete, updatePassword} = require("../controller/register");

    const verifyToken = require("../middleware/verifyToken")

    router.post("/login", login);
    router.post("/signup",registration);
    router.post("/accountDelete",accountDelete);
    router.post("/updatePassword",verifyToken,updatePassword);

    module.exports = router;