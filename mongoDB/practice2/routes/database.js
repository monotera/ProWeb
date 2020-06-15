const express = require("express");
const router = express.Router();
const Adds = require("../models/add");

router.get("/", (req, res) => {
    res.send("options");
});

router.get("/add", async (req, res) => {
    try{
        const products = await Adds.find();
        res.json(products);
    }catch(err){
        res.json({message : err});
    }
});

router.post("/add", async (req, res) => {

    const add = new Adds({
        name: req.body.name,
        description: req.body.description,
        inStock: req.body.inStock,
        price: req.body.price,
    });

    try {
        const savesAdd = await add.save();
        res.json(savesAdd);
    } catch (err) {
        res.json(err);
    }
});

module.exports = router;