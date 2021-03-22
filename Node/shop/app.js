const http = require('http');
const bodyParser = require('body-parser')
const express = require('express');
const path = require('path');
const app = express();

const adminRoutes = require('./routes/admin');
const shopRoutes = require('./routes/shop');

app.use(bodyParser.urlencoded({ extended: false }));
app.use(express.static(path.join(__dirname, 'public')));

//Middlewares
app.use(adminRoutes);
app.use(shopRoutes);

app.use('/*', (req, res) => {
    res.status(404).sendFile(path.join(__dirname, "views", "error404.html"))
});

app.listen(3000);