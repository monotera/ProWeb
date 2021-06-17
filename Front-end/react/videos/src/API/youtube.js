import axios from "axios";

const KEY = "AIzaSyAgiHUP2DW5TmeVfwL93oSUVtWxYOk1uOI";

export default axios.create({
  baseURL: "https://www.googleapis.com/youtube/v3",
  params: {
    part: "snippet",
    type: "video",
    maxResult: 5,
    key: KEY,
  },
});
