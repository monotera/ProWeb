import React from "react";

class SearchBar extends React.Component {
  state = { term: "" };
  onFormSubmit(e) {
    e.preventDefault();
    this.props.onSubmit(this.state.term);
  }
  render() {
    return (
      <div className="ui segment">
        <form onSubmit={(e) => this.onFormSubmit(e)} className="ui form">
          <label htmlFor="">Image Search</label>
          <input
            className="field"
            type="text"
            value={this.state.term}
            onChange={(e) => this.setState({ term: e.target.value })}
          />
        </form>
      </div>
    );
  }
}

export default SearchBar;
