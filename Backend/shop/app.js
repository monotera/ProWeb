const http = require("http");
const bodyParser = require("body-parser");
const express = require("express");
const path = require("path");
const app = express();

app.set("view engine", "ejs");
app.set("views", "views");

const adminData = require("./routes/admin");
const shopRoutes = require("./routes/shop");

app.use(bodyParser.urlencoded({ extended: false }));
app.use(express.static(path.join(__dirname, "public")));

//Middlewares
app.use(adminData.routes);
app.use(shopRoutes);
app.use("/*", (req, res) => {
    res.status(404).render("error404", { docTitle: "Error 404" });
});

app.listen(3000, () => {
    console.log("Conected via port 3000");
});