<template>
  <div class="user-profile">
    <div class="user-profile__sidebar">
      <div class="user-profile__user-panel">
        <h1 class="user-profile__username">@{{ user.username }}</h1>
        <div class="user-profile__admin-badge" v-if="user.isAdmin">Admin</div>
        <div class="user-profile__admin-badge" v-if="!user.isAdmin">User</div>
        <div class="user-profile__follower-count">
          <strong>followers: </strong> {{ followers }}
        </div>
      </div>
      <create-twoot-panel @add-twoot="addTwoot" />
    </div>
    <div class="user-profile__twoots-wrapper">
      <twoot-item
        v-for="twoot in user.twoots"
        :key="twoot.id"
        :username="user.username"
        :twoot="twoot"
        @favourite="toggleFavorite"
      />
    </div>
  </div>
</template>

<script>
import CreateTwootPanel from "./CreateTwootPanel.vue";
import TwootItem from "./TwootItem.vue";
export default {
  components: { TwootItem, CreateTwootPanel },
  name: "UserProfile",
  data() {
    return {
      followers: 0,
      user: {
        id: 1,
        username: "monotera",
        fistName: "Nelson",
        lastName: "Mosquera",
        email: "email@gmail.com",
        isAdmin: false,
        twoots: [
          { id: 1, content: "My first Twoot" },
          { id: 2, content: "Hello world" },
        ],
      },
    };
  },
  watch: {
    followers(newFollowerCount, oldFollowerCount) {
      if (oldFollowerCount < newFollowerCount) {
        console.log(`${this.user.username} gained a folower`);
      }
    },
  },
  computed: {},
  methods: {
    followUser() {
      this.followers++;
    },
    toggleFavorite(id) {
      console.log(`favoutied twoot ${id}`);
    },
    addTwoot(twoot) {
      this.user.twoots.unshift({
        id: this.user.twoots.length + 1,
        content: twoot,
      });
    },
  },
  mounted() {
    this.followUser();
  },
};
</script>

<style lang="scss" scoped>
.user-profile {
  display: flex;
  flex-direction: column;
  padding: 2rem 1rem;
  @media screen and (min-width: 768px) {
    display: grid;
    grid-template-columns: 1fr 3fr;
    padding: 2rem 1rem;
  }
  .user-profile__sidebar {
    @media screen and (min-width: 768px) {
      margin-right: 1rem;
    }
    .user-profile__user-panel {
      display: flex;
      flex-direction: column;
      padding: 0.9rem;
      background-color: white;
      border-radius: 5px;
      border: 1px solid #dfe3e8;
      margin-bottom: auto;
      text-align: center;
      @media screen and (min-width: 768px) {
        text-align: start;
      }
      .user-profile__username {
        margin: 0;
        padding-bottom: 0.4rem;
      }
      .user-profile__follower-count {
        padding-top: 1rem;
      }
      .user-profile__admin-badge {
        background: rebeccapurple;
        color: white;
        border-radius: 5px;
        padding: 0.4rem 1rem;
        font-weight: bold;
        @media screen and (min-width: 768px) {
          margin-right: 25rem;
        }
      }
    }
  }
}
</style>
