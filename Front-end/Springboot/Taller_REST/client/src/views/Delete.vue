<template>
  <div class="delete-wrapper">
    <h1>
      El paseo {{ deleted_object.name }} con id {{ deleted_object.id }} se ha
      eliminado!
    </h1>
    <img src="../assets/img/success.svg" />
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      deleted_object: null,
    };
  },
  mounted() {
    let url = `${this.$store.getters.getUrlBase}delete_trip/${this.$route.params.id}`;

    axios.delete(url).then((res) => {
      this.deleted_object = res.data;
    });
  },
};
</script>

<style scoped>
.delete-wrapper {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  width: 100vw;
  height: 100%;
}
h1 {
  text-align: center;
}
img {
  width: 500px;
}
</style>
