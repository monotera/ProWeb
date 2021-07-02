import React, { useState } from "react";
import Accordion from "./components/Accordion";
import Search from "./components/Search";
import Drop from "./components/Drop";
import Translate from "./components/Translate";
// const items = [
//     {
//       title: "What is react",
//       content: "React is a front end javascript framework",
//     },
//     {
//       title: "Why us react",
//       content: "React is a front end javascript framework",
//     },
//     {
//       title: "What is react",
//       content: "React is a front end javascript framework",
//     },
// ];
const options = [
  {
    label: "The color red",
    color: "red",
  },
  {
    label: "The color blue",
    color: "blue",
  },
  {
    label: "The color purple",
    color: "purple",
  },
];

const lang = [
  { label: "Afrikaans", value: "af" },
  { label: "Arabic", value: "ar" },
  { label: "Hindi", value: "hi" },
];
// eslint-disable-next-line import/no-anonymous-default-export
export default () => {
  //   const [selected, setSelected] = useState(options[0]);
  //   const [showDropDown, setShowDropDown] = useState(true);
  return (
    <div>
      {/* <button onClick={() => setShowDropDown(!showDropDown)}>
        Toggle DropDown
      </button>
      {showDropDown ? (
        <Drop
          selected={selected}
          setSelected={setSelected}
          options={options}
        ></Drop>
      ) : null} */}
      <Translate options={lang} />
    </div>
  );
};
