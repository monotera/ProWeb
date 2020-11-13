export {Clock}
const clockButton = document.querySelector('.clk');
class Clock {
  render(){
    let date = new Date();
    clockButton.innerHTML = (`${date.getHours()}::${date.getMinutes()}::${date.getSeconds()}`);
  }
  start(){
    this.timer = setInterval(()=>{this.render()},1000);
  }
  stop(){
    clearInterval(this.timer);
  }
  
}