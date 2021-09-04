<template>
  <h1>Delet</h1>
</template>

<script>
import axios from "axios";
export default {
  mounted() {
    let url = `http://localhost:3000/API/delete_trip/5`;

    axios.delete(url).then((res) => {
      console.log(res);
    });
  },
};
</script>

<style></style>
