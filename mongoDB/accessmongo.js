mongoose = require("mongoose");
var express = require("express"),
  http = require("http");
var app = express();
const path = require('path');

app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');
app.use(express.bodyParser());
app.use(express.methodOverride());
app.use(app.router);
app.use(express.static(path.join(__dirname, 'public')));

http.createServer(app).listen(3000, function () {
  console.log("Server is listening on port 3000");
});

app.get("/", function (req, res) {
  res.render("index.ejs");
});

mongoose.connect("mongodb://localhost/test");

var productSchema = new mongoose.Schema({
  prdId: String,
  name: { type: String },
  price: Number,
});

var Product = mongoose.model("Product", productSchema);

app.get("/add", function (req, res) {
  res.render("addProducts.ejs");
});

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

app.get("/viewall", function (req, res) {
  Product.find({}, function (err, prds) {
    console.log("\nProducts !");
    console.log(prds);
    renderResult(res, prds, "Product List from MongoDB :");
  });
});

function renderResult(res, prds, msg) {
  res.render("display.ejs", { message: msg, products: prds }, function (
    err,
    result
  ) {
    if (!err) {
      res.end(result);
    } else {
      res.end("Oops ! An error occurred.");
      console.log(err);
    }
  });
}
