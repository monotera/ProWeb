let firstSelect = document.querySelector("#select1");
let secondSelect = document.querySelector("#select2");

let addBtn = document.querySelector("#addBtn");
let removeBtn = document.querySelector("#removeBtn");

addBtn.addEventListener("click", () => {
  let selectedElements = getSelectValues(firstSelect);

  for (let i = 0; i < selectedElements.length; i++) {
    let option = document.createElement("option");
    option.text = selectedElements[i];
    secondSelect.add(option);
    for (let j = 0; j < firstSelect.length; j++) {
      if (firstSelect.options[j].value == selectedElements[i]) {
        firstSelect.remove(j);
        break;
      }
    }
  }
});

removeBtn.addEventListener("click", () => {
    let selectedElements = getSelectValues(secondSelect);
  
    for (let i = 0; i < selectedElements.length; i++) {
      let option = document.createElement("option");
      option.text = selectedElements[i];
      firstSelect.add(option);
      for (let j = 0; j < secondSelect.length; j++) {
        if (secondSelect.options[j].value == selectedElements[i]) {
          secondSelect.remove(j);
          break;
        }
      }
    }
  });

function getSelectValues(select) {
  var result = [];
  var options = select && select.options;
  var opt;

  for (var i = 0, iLen = options.length; i < iLen; i++) {
    opt = options[i];

    if (opt.selected) {
      result.push(opt.value || opt.text);
    }
  }
  return result;
}
