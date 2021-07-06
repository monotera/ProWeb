import React from "react";

const Loader = (props) => {
  return (
    <div class="ui active dimmer">
      <div class="ui massive text loader">{props.msg}</div>
    </div>
  );
};
Loader.defaultProps = {
  msg: "Loading...",
};
export default Loader;
