const express = require("express");
const path = require("path");

const products = [];

const router = express.Router();

router.get("/add-product", (req, res, next) => {
    res.render("add-product", { docTitle: "Add-product", path: "/add-product" });
});

router.post("/add-product", (req, res) => {
    products.push({ title: req.body.title });
    res.redirect("/");
});

exports.routes = router;
exports.products = products;