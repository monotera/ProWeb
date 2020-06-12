const mongoose = require("mongoose");

mongoose
  .connect("mongodb://localhost/notes-db-app", {
    useCreateIndex: true,
    useNewUrlParser: true,
    useFindAndModify: false,
  })
  .then((db) => console.log("Data base is connected"))
  .catch((err) => console.error(err));

//Mongoose settings
mongoose.set("useNewUrlParser", true);
mongoose.set("useFindAndModify", false);
mongoose.set("useCreateIndex", true);
mongoose.set("useUnifiedTopology", true);