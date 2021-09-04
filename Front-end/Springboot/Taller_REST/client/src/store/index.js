import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    url_base: "http://localhost:3000/API/",
  },
  getters: {
    getUrlBase: (state) => {
      return state.url_base;
    },
  },
  mutations: {},
  actions: {},
  modules: {},
});
