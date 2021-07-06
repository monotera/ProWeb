//AIzaSyCHUCmpR7cT_yDFHC98CZJy2LTms-IwDlM

import React, { useState } from "react";
import DropDown from "./DropDown";
import Convert from "./Convert";

const Translate = ({ options }) => {
  const [lang, setLang] = useState(options[0]);
  const [text, setText] = useState("");
  return (
    <div>
      <div className="ui form">
        <div className="field">
          <label htmlFor="">Enter Text</label>
          <input
            value={text}
            onChange={(e) => setText(e.target.value)}
            type="text"
          />
        </div>
      </div>
      <DropDown
        label={"Select A language"}
        options={options}
        selected={lang}
        onSelectedChange={setLang}
      />
      <hr />
      <h3 className="ui header">Output</h3>
      <Convert text={text} language={lang} />
    </div>
  );
};

export default Translate;
