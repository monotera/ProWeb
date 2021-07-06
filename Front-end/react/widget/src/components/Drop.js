import React, { useState } from "react";
import DropDown from "./DropDown";

const Drop = ({ options }) => {
  const [selected, setSelected] = useState(options[0]);
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
