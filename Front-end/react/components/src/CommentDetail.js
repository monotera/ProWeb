import React from "react";

const CommentDeatil = (props) => {
  console.log(props);
  return (
    <div className="comment">
      <a href="/" className="avatar">
        <img src={props.img} alt="Avatar" />
      </a>
      <div className="content">
        <a href="/" className="author">
          {props.author}
        </a>
        <div className="metadata">
          <span className="date">Today at {props.time} PM</span>
        </div>
        <div className="text">{props.post}</div>
      </div>
    </div>
  );
};

export default CommentDeatil;
