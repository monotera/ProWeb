import {Clock} from './Module/clockClass.js';

let clock = new Clock();
const startButton = document.querySelector('.startBtn');
const stopButton = document.querySelector('.stopBtn');
startButton.addEventListener('click',()=>{  
    startButton.disabled = true;
    stopButton.disabled = false;
    clock.start()});
stopButton.addEventListener('click',()=>{
    startButton.disabled = false;
    stopButton.disabled = true;
    clock.stop()});