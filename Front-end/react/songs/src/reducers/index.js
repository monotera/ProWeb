import { combineReducers } from "redux";

const songsReducer = () => {
  return [
    { title: "Ride", duration: "4:05" },
    { title: "Toxic", duration: "3:05" },
    { title: "Carnaval", duration: "4:55" },
    { title: "Caminsa negra", duration: "4:35" },
  ];
};

const selectedSongReducer = (selectedSong = null, action) => {
  if (action.type === "SONG_SELECTED") {
    return action.payload;
  }
  return selectedSong;
};

export default combineReducers({
  songs: songsReducer,
  selectedSong: selectedSongReducer,
});
