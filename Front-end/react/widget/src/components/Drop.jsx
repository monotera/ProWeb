import React from "react";
import DropDown from "./DropDown";

const Drop = ({ selected, setSelected, options }) => {
  return (
    <div>
      <DropDown
        label={"Select a color"}
        options={options}
        selected={selected}
        onSelectedChange={setSelected}
      />
      <p style={{ color: selected.color }}>{` ${selected.label}`}</p>
    </div>
  );
};

export default Drop;
