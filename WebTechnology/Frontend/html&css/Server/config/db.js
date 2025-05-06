const mongoose = require ("mongoose");
require("dotenv").config();

const dbconnection = async() => {
    await mongoose.connect(process.env.dbURL)
    .then(()=>{
        console.log(`DB Connection establised succesfully`);
    })
    .catch((error)=> {
        console.log(`DB connection Failed !! ${error.message}`)
        process.exit(1);
    })
}

module.exports = dbconnection;