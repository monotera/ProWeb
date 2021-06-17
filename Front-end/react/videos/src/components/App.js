import React from "react";
import SearchBar from "./SearchBar";
import youtube from "../API/youtube";
import VideoList from "./VideoList";
class App extends React.Component {
  state = { videos: [], selectedVideo: null };
  onTermSubmit = async (term) => {
    const { data } = await youtube.get("/search", {
      params: {
        q: term,
      },
    });
    this.setState({ videos: data.items });
  };
  onVideoSelect = (v) => {
    console.log("Fomr the app!", v);
  };
  render() {
    return (
      <div className="ui container">
        <SearchBar onFormSubmit={this.onTermSubmit} />
        <VideoList
          onVideoSelect={this.onVideoSelect}
          videos={this.state.videos}
        />
      </div>
    );
  }
}

export default App;
