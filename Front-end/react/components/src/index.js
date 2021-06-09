import React from "react";
import ReactDOM from "react-dom";
import faker from "faker";
import CommentDetail from "./CommentDetail";
import AprovalCard from "./AprovalCard";
const App = () => {
  return (
    <div className="ui container comments">
      <AprovalCard>
        <CommentDetail
          author="Alex"
          img={faker.image.avatar()}
          time="7:00"
          post="Wow my second props!"
        />
      </AprovalCard>

      <AprovalCard>
        <CommentDetail
          author="Sam"
          img={faker.image.avatar()}
          time="10:00"
          post="Bye props!"
        />
      </AprovalCard>

      <AprovalCard>
        <CommentDetail
          author="Sara"
          img={faker.image.avatar()}
          time="6:00"
          post="Wow my first props!"
        />
      </AprovalCard>
    </div>
  );
};
ReactDOM.render(<App />, document.querySelector("#root"));
