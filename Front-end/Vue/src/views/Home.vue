<template>
  <div class="home">
    <div class="home__greetings">
      <h1>Welcome to <strong class="home__twotter">Twotter!</strong></h1>
      <h2>Choose your user:</h2>
    </div>
    <div class="users-list">
      <router-link
        class="home__username"
        v-for="user in users"
        :to="{ name: 'UserProfile', params: { userId: user.id } }"
        :key="user.id"
        >{{ user.username }}</router-link
      >
    </div>
  </div>
</template>

<script>
import { users } from "../assets/users";
export default {
  name: "Home",
  setup() {
    return {
      users,
    };
  },
};
</script>
<style lang="scss" scoped>
.home {
  min-height: 80vh;
  @media screen and (min-width: 768px) {
    align-items: center;
    display: flex;
    flex-flow: column;
    justify-content: center;
  }

  .home__greetings {
    font-size: 1rem;
    margin: 2.5rem;
    text-align: center;
    @media screen and (min-width: 768px) {
      font-size: 2.5rem;
    }
  }

  .home__twotter {
    color: lightseagreen;
  }
  .users-list {
    display: flex;
    flex-flow: column wrap;
    @media screen and (min-width: 768px) {
      flex-flow: row;
    }
  }
  .home__username {
    background-color: lightpink;
    border: 1px solid black;
    border-radius: 5px;
    font-size: 1.5rem;
    margin: 1rem;
    padding: 0.5rem;
    text-align: center;
    transition: all 0.4s ease;
    &:hover {
      background-color: lightseagreen;
      color: white;
    }
  }
}
</style>
