const mongoose = require("mongoose");
var express = require("express");
var app = express();
const path = require("path");
const bodyParser = require("body-parser");

//settings
app.set("views", __dirname + "/views");
app.set("view engine", "ejs");
app.set('port', process.env.PORT || 3000);

//Middlewares
app.use(bodyParser.urlencoded({extended: false}));
app.use(express.static(path.join(__dirname, "public")));

//Mongoose settings
mongoose.set("useNewUrlParser", true);
mongoose.set("useFindAndModify", false);
mongoose.set("useCreateIndex", true);
mongoose.set("useUnifiedTopology", true);

//Server listening
app.listen(app.get('port'), () => {
  console.log('Server on port ', app.get('port'));
});
mongoose
  .connect("mongodb://localhost/notes-db-app", {
    useCreateIndex: true,
    useNewUrlParser: true,
    useFindAndModify: false,
  })
  .then((db) => console.log("Data base is connected"))
  .catch((err) => console.error(err));

// variables

var productSchema = new mongoose.Schema({
  prdId: String,
  name: {
    type: String,
  },
  price: Number,
});
var Product = mongoose.model("Product", productSchema);

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
