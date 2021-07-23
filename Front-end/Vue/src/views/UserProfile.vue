<template>
  <div class="user-profile">
    <div class="user-profile__sidebar">
      <div class="user-profile__user-panel">
        <h1 class="user-profile__username">@{{ state.user.username }}</h1>
        <div class="user-profile__admin-badge" v-if="state.user.isAdmin">Admin</div>
        <div class="user-profile__admin-badge" v-if="!state.user.isAdmin">User</div>
        <div class="user-profile__follower-count">
          <strong>followers: </strong> {{ state.followers }}
        </div>
      </div>
      <create-twoot-panel @add-twoot="addTwoot" />
    </div>
    <div class="user-profile__twoots-wrapper">
      <twoot-item
        v-for="twoot in state.user.twoots"
        :key="twoot.id"
        :username="state.user.username"
        :twoot="twoot"
      />
    </div>
  </div>
</template>

<script>
import CreateTwootPanel from "../components/CreateTwootPanel";
import TwootItem from "../components/TwootItem";
import { useRoute } from "vue-router";
import { users } from "../assets/users";
import { reactive, computed } from "vue";
export default {
  components: { TwootItem, CreateTwootPanel },
  name: "UserProfile",
  setup() {
    const route = useRoute();
    const userId = computed(() => route.params.userId);

    const state = reactive({
      followers: 0,
      user: users[userId.value - 1] || users[0],
    });
    function addTwoot(twoot) {
      state.user.twoots.unshift({
        id: state.user.twoots.length + 1,
        content: twoot,
      });
    }
    return {
      state,
      addTwoot,
      userId,
    };
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
