const express = require("express");
const App = express();

require("dotenv").config();
const PORT = process.env.PORT;
const authRoutes = require("./routes/userRegisteration");

App.use(express.json());

App.use("/v1/api/auth", authRoutes);

const database = require("./config/db")
database();

App.get("/",(req,res)=>{
    res.send(`This is your HomePage !!`)
})

App.listen(PORT,()=>{
    console.log(`App is listen on PORT : ${PORT}`);
})