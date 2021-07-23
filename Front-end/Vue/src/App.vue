<template>
  <div id="app">
    <nav class="app__nav">
      <router-link to="/"><h1 class="nav__logo">Twotter</h1> </router-link>
      <a class = "nav__user"  v-if="user" href="https://github.com/monotera">@{{ user.username }}</a>
    </nav>
    <router-view />
  </div>
</template>

<script>
import { useStore } from "vuex";
import { computed } from "vue";
export default {
  name: "App",
  setup() {
    const store = useStore();
    const user = computed(() => store.state.User.user);
    return {
      user,
    };
  },
};
</script>

<style lang="scss">
#app {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  background-color: #f3f5fa;
  font-family: Avenir, Helvetica, Arial, sans-serif;

  min-height: 100vh;
}
.app__nav {
  align-items: center;
  background-color: lightseagreen;
  color: white;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  margin: auto;
  min-height: 10vh;
  padding: 10px 5%;

  .nav__logo {
    font-size: 1.8rem;
    font-weight: bold;
  }
  .nav__user {
    font-weight: bold;
    font-size: 1.7rem;
  }
}
</style>
