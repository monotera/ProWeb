const bodyParser = require("body-parser");
const express = require("express");
const path = require("path");
const http = require("http");

const app = express();

const port = 3000;

app.use(express.static(__dirname + "/public"));

app.use("/*", (req, res) => {
  res
    .status(200)
    .sendFile(path.join(__dirname, "src", "views", "Interests.html"));
});

app.listen(port, () => {
  console.log(`Example app listening at http://localhost:${port}`);
});
