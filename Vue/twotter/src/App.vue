<template>
  <div id="app">
    <nav class="app__nav">
      <h1 class="nav__logo">Twotter</h1>
      <h2 class="nav__user">@{{ user.username }}</h2>
    </nav>
    <user-profile />
  </div>
</template>

<script>
import UserProfile from "./components/UserProfile.vue";
export default {
  name: "App",
  components: { UserProfile },
  data() {
    {
      return {
        user: {
          username: "Monotera",
        },
      };
    }
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
  }
}
</style>
