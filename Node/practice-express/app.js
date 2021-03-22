const http = require('http');
const bodyParser = require('body-parser')
const express = require('express');
const path = require('path');
const homeRouter = require('./routes/home');
const aboutUsRouter = require('./routes/aboutUs');

const app = express();

app.use(bodyParser.urlencoded({ extended: false }));
app.use(express.static(path.join(__dirname, 'public')));

//Middlewares
app.use(homeRouter);
app.use('/users', aboutUsRouter);

app.use('/*', (req, res) => {
    res.status(404).sendFile(path.join(__dirname, "views", "error404.html"))
});

app.listen(3000);