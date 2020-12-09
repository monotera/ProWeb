<template>
  <form
    class="create-twoot-panel"
    @submit.prevent="createNewTwoot"
    :class="{ '--exceeded': newTwootCharacterCount > 180 }"
  >
    <label for="newTwoot"
      ><strong>New Twoot</strong> ({{ newTwootCharacterCount }}/180)</label
    >
    <textarea id="newTwoot" rows="4" v-model="state.newTwootContent" />
    <div class="create-twoot-panel__submit">
      <div class="create-twoot-type">
        <label for="newTwootType"><strong>Type: </strong></label>
        <select id="newTwootType" v-model="state.selectedTwootType">
          <option
            :value="option.value"
            v-for="(option, index) in state.twootType"
            :key="index"
          >
            {{ option.name }}
          </option>
        </select>
      </div>
      <button>Twoot It!!</button>
    </div>
  </form>
</template>

<script>
import { reactive, computed } from "vue";
export default {
  name: "CreateTwootPanel",
  setup(props, ctx) {
    const state = reactive({
      newTwootContent: "",
      selectedTwootType: "instant",
      twootType: [
        { value: "draft", name: "Draft" },
        { value: "instant", name: "Instant Twoot" },
      ],
    });

    const newTwootCharacterCount = computed(() => state.newTwootContent.length);

    function createNewTwoot() {
      if (state.newTwootContent && state.selectedTwootType !== "draft") {
        ctx.emit("add-twoot", state.newTwootContent);
        state.newTwootContent = "";
      }
    }
    return {
      state,
      newTwootCharacterCount,
      createNewTwoot,
    };
  },
};
</script>

<style lang="scss">
.create-twoot-panel {
  padding: 1.5rem 0;
  display: flex;
  flex-direction: column;
  textarea {
    border: 1px solid #dfe3e8;
    border-radius: 5px;
  }
  .create-twoot-panel__submit {
    display: flex;
    flex-direction: column;
    .create-twoot-type {
      padding: 1rem 0;
    }
    button {
      padding: 5px 20px;
      margin: auto 0;
      border-radius: 5px;
      border: none;
      background-color: lightseagreen;
      color: white;
      font-weight: bold;
    }
  }
  select {
    border-radius: 5px;
  }
  &.--exceeded {
    color: red;
    border-color: red;
    .create-twoot-panel__submit {
      button {
        background-color: red;
        color: white;
      }
    }
  }
}
</style>
