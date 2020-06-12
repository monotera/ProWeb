const express = require('express');
const router = express.Router();


router.get('/users/singin',(req,res) => {
    res.send('Logging...');
});

router.get('/users/singup',(req,res) => {
    res.send("hewo");
});

module.exports = router;