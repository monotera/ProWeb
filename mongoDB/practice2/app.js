const express = require("express");
const mongoose = require('mongoose');
const app = express();
const bodyParser = require('body-parser');
require('dotenv/config');

//settings
app.set("port", process.env.PORT || 3000);
app.use(bodyParser.json());
//Import routes
const addRoute = require('./routes/database.js');


//Server listening
app.listen(app.get("port"), () => {
  console.log("Server on port ", app.get("port"));
});


//Routes



//Middlewares
app.use('/database', addRoute);


//Conection 

mongoose.connect(process.env.DB_CONNECTION, { useNewUrlParser: true , useUnifiedTopology: true}, () => {
    console.log('Connected to the db');
});

