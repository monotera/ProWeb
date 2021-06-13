import axios from "axios";

export default axios.create({
  baseURL: "https://api.unsplash.com",
  headers: {
    Authorization: "Client-ID rZRc2RCe5BvvzOE3sWfhvq6alChQ20_kJPUY3KieNT8",
  },
});
