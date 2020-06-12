const express = require("express");
const path = require("path");
const bodyParser = require("body-parser");
const mongoose = require('mongoose');

//Init
const app = express();
require('./database');


//settings
app.set("views", __dirname + "/views");
app.set("view engine", "ejs");
app.set('port', process.env.PORT || 3000);

//Middlewares
app.use(bodyParser.urlencoded({extended: false}));
app.use(express.static(path.join(__dirname, "public")));

//Server listening
app.listen(app.get('port'), () => {
  console.log('Server on port ', app.get('port'));
});

//Variables
let productSchema = new mongoose.Schema({
  prdId: String,
  name: {
    type: String,
  },
  price: Number,
});
let Product = mongoose.model("Product", productSchema);

//getters
app.get("/", function (req, res) {
  res.render("index.ejs");
});
app.get("/add", function (req, res) {
  res.render("addProducts.ejs");
});
app.get("/viewall", function (req, res) {
  Product.find({}, function (err, prds) {
    console.log("\nProducts !");
    console.log(prds);
    renderResult(res, prds, "Product List from MongoDB :");
  });
});

//POST
app.post("/new", function (req, res) {
  console.log(req.body);
  new Product({
    prdId: req.body.ProductId,
    name: req.body.ProductName,
    price: req.body.ProductPrice,
  }).save(function (err, prd) {
    if (err) res.json(err);
    else res.send("Product Successfully Added !");
  });
});

//Render
function renderResult(res, prds, msg) {
  res.render(
    "display.ejs",
    {
      message: msg,
      products: prds,
    },
    function (err, result) {
      if (!err) {
        res.end(result);
      } else {
        res.end("Oops ! An error occurred.");
        console.log(err);
      }
    }
  );
}
