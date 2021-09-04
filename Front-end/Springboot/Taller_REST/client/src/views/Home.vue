<template>
  <v-main class="products">
    <div class="products-container">
      <ProductCard
        class="card"
        v-for="trip in trips"
        :key="trip.id"
        :id="trip.id"
        :title="trip.name"
        :subTitle="trip.date"
        :arrival="trip.place_arrival"
        :depature="trip.place_departure"
      />
    </div>
  </v-main>
</template>

<script>
import ProductCard from "../components/ProductCard.vue";
import axios from "axios";
export default {
  components: {
    ProductCard,
  },
  data: () => ({
    trips: [],
  }),
  mounted() {
    let url = `${this.$store.getters.getUrlBase}trips`;
    axios.get(url).then(({ data }) => {
      this.trips = data;
    });
  },
};
</script>

<style lang="scss" scoped>
.products-container {
  margin: 5rem;
  display: flex;
  flex-direction: row;
  justify-content: center;
  flex-flow: row wrap;
}

.card {
  margin: 1em;
}
</style>
