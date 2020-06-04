const footerList = document.querySelector(".footer-wrapper-ul");
const footerLinks = footerList.querySelectorAll("a");
for (let i = 0; i < footerLinks.length; i++) {
  footerLinks[i].addEventListener("click", () => {
    let current = footerList.querySelector(".active");
    current.className = "footer-a";
    footerLinks[i].className = "active";
  });
}