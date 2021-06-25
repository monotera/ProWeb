import React from "react";
import SearchBar from "./SearchBar";
import youtube from "../API/youtube";
import VideoList from "./VideoList";
import VideoDetail from "./videoDetail";
class App extends React.Component {
  state = { videos: [], selectedVideo: null };

  componentDidMount() {
    this.onTermSubmit("buildings");
  }

  onTermSubmit = async (term) => {
    const { data } = await youtube.get("/search", {
      params: {
        q: term,
      },
    });
    this.setState({
      videos: data.items,
      selectedVideo: data.items[0],
    });
  };
  onVideoSelect = (v) => {
    this.setState({ selectedVideo: v });
  };
  render() {
    return (
      <div className="ui container">
        <SearchBar onFormSubmit={this.onTermSubmit} />
        <div className="ui grid">
          <div className="ui row">
            <div className="eleven wide column">
              <VideoDetail video={this.state.selectedVideo} />
            </div>
            <div className="five wide column">
              <VideoList
                onVideoSelect={this.onVideoSelect}
                videos={this.state.videos}
              />
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default App;
