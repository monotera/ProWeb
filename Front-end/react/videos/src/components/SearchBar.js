import React from "react";

class SearchBar extends React.Component {
  state = { term: "" };

  onFormSubmit = (e) => {
    e.preventDefault();
    //Call back from Parent
    this.props.onFormSubmit(this.state.term);
  };
  render() {
    return (
      <div className="search-bar ui segment">
        <form onSubmit={this.onFormSubmit} className="ui form">
          <div className="field">
            <label htmlFor="">Video Search</label>
            <input
              value={this.state.term}
              onChange={(e) => {
                this.setState({ term: e.target.value });
              }}
              type="text"
            />
          </div>
        </form>
      </div>
    );
  }
}
export default SearchBar;
