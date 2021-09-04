<template>
  <v-main class="products">
    <ProductCard
      v-for="trip in trips"
      :key="trip.id"
      :id="trip.id"
      :title="trip.name"
      :subTitle="trip.date"
      :arrival="trip.place_arrival"
      :depature="trip.place_departure"
    />
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
    let url = "http://localhost:3000/API/trips";
    axios.get(url).then(({ data }) => {
      this.trips = data;
    });
  },
};
</script>

<style lang="scss" scoped></style>
