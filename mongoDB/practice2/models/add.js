const mongoose = require('mongoose');

const ProductSchema = mongoose.Schema({
    name : String,
    description : String,
    inStock : Boolean,
    price : Number 
});

module.exports = mongoose.model('Adds', ProductSchema);