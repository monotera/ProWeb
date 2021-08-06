const rows = document.querySelectorAll(".row");

rows.forEach((row, index) => {
  if (index === 0) row.classList.add("title");
  else if (index % 2 === 0) row.classList.add("even");
  else row.classList.add("odd");
});
