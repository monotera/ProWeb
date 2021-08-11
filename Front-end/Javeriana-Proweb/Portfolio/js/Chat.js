const userName = document.querySelector("#GET-name");
const msg = document.querySelector("#GET-msg");
const sendBtn = document.querySelector("#send-btn");
const clearBtn = document.querySelector("#clear-btn");
const errorMsg = document.querySelector("#error-msg");
const errorName = document.querySelector("#error-name");
const msgsSection = document.querySelector("#msgs");

sendBtn.addEventListener("click", () => {
  let error = false;
  if (userName.value === "") {
    userName.classList.add("error");
    error = true;
    errorName.textContent = "The name must not be empty.";
  }
  if (msg.value.length > 300 || msg.value === "") {
    msg.classList.add("error");
    errorMsg.textContent =
      "The message must not be empty or cannot exceed 300 characters.";
    error = true;
  }
  if (!error) {
    let div = document.createElement("div");
    let usernameTitle = document.createElement("h3");
    let text = document.createTextNode(`Name: ${userName.value}`);
    let msgTitle = document.createElement("p");
    let msgContent = document.createTextNode(`Message: ${msg.value}`);
    usernameTitle.appendChild(text);
    msgTitle.appendChild(msgContent);
    div.appendChild(usernameTitle);
    div.appendChild(msgTitle);
    msgsSection.appendChild(div);
    userName.classList.remove("error");
    msg.classList.remove("error");
    userName.value = "";
    msg.value = "";
    errorMsg.textContent = "";
    errorName.textContent = "";
  }
});

clearBtn.addEventListener("click", () => {
  userName.classList.remove("error");
  msg.classList.remove("error");
  userName.value = "";
  msg.value = "";
  errorMsg.textContent = "";
  errorName.textContent = "";
});
