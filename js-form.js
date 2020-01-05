const emailReg = /\S+@\S+\.\S+/;
const dateReg = /^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]|(?:Jan|Mar|May|Jul|Aug|Oct|Dec)))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2]|(?:Jan|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)(?:0?2|(?:Feb))\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9]|(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep))|(?:1[0-2]|(?:Oct|Nov|Dec)))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$/;
const firstName = document.querySelector("#firstname");
const lastName = document.querySelector("#lastname");
const date = document.querySelector("#dateob");

function validaTeForm(event) {
  event.preventDefault();
  resetAnswerValues();
  // Write the logic to validate the form fields
  let error = false;
  let errorMessage = "\n";
  const firstNameValue = firstName.value;
  const lastNameValue = lastName.value;
  const emailValue = email.value;
  const dateValue = date.value;
  const genderValue = gender.value;
  const socEconStatus = document.querySelector('input[name="items"]:checked');
  const socEconStatusValue = socEconStatus.value;

  if (!firstNameValue.length) {
    errorMessage += "First name is empty\n";
    error = true;
  }
  if (!lastNameValue.length) {
    errorMessage += "Last name is empty \n";
    error = true;
  }
  if (!emailValue.length) {
    errorMessage += "Email is empty\n";
    error = true;
  }
  if(!emailReg.test(emailValue)) {
    errorMessage += "Email is not valid\n";
    error = true;
  }
  if (!dateReg.test(dateValue)) {
    errorMessage += "The date is not valid\n";
    error = true;
  }
  if (error) {
    alert("Error:" + errorMessage);
    return;
  }

  // Prints user values if everything is correct
  firstNameAnswer.innerHTML += firstNameValue;
  lastNameAnswer.innerHTML += lastNameValue;
  emailAnswer.innerHTML += emailValue;
  dateAnswer.innerHTML += dateValue;
  genderAnswer.innerHTML += genderValue;
  econStatusAnswer.innerHTML += socEconStatusValue;
}
const form = document.querySelector("form");
form.addEventListener("submit", validaTeForm);
form.addEventListener("reset", resetAnswerValues);
//Resets answer values
function resetAnswerValues() {
  firstNameAnswer.innerHTML = "First name: ";
  lastNameAnswer.innerHTML = "Last name: ";
  emailAnswer.innerHTML = "Email: ";
  dateAnswer.innerHTML = "Date: ";
  genderAnswer.innerHTML = "Gender: ";
  econStatusAnswer.innerHTML = "Socioeconomic status: ";
}

//Transition for the menu
const navSlide = () => {
  const burger = document.querySelector(".burger");
  const nav = document.querySelector(".nav-links");
  const navLinks = document.querySelectorAll(".nav-links li");
  //Toggle nav
  burger.addEventListener("click", () => {
    nav.classList.toggle("nav-active");
    //Animate links
    navLinks.forEach((link, index) => {
      if (link.style.animation) {
        link.style.animation = "";//Animated links
      } else {
        link.style.animation = `navLinkFade 0.5s ease forwards ${index / 7 +
          0.4}s`;
      }
    });
    //Burger animation
    burger.classList.toggle('toggle');
  });
};
navSlide();
