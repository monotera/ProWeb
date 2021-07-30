const hamburger = document.querySelector(".hamburger");
const navLinks = document.querySelector(".nav-links");
const links = document.querySelectorAll(".nav-links li");
const headerHome = document.querySelector(".header-home");
const headerTitleHome = document.querySelector(".header-title-home");

hamburger.addEventListener("click", () => {
  navLinks.classList.toggle("nav-open");
  headerHome.classList.toggle("header-home-open");
  hamburger.classList.toggle("hamburger-open");
  headerTitleHome.classList.toggle("header-title-home-open");
});
