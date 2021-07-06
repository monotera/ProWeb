import axios from "axios";

const KEY = "AIzaSyCOCezUJayTG6V9e43380VRjQotqj-t6NU";

export default axios.create({
  baseURL: "https://www.googleapis.com/youtube/v3",
  params: {
    part: "snippet",
    type: "video",
    maxResult: 5,
    key: KEY,
  },
});
