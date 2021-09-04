<template>
  <v-card max-width="344" class="card" dark elevation="3">
    <v-card-title>{{ title }}</v-card-title>
    <v-card-subtitle>{{ `id: ${id} Fecha: ${subTitle}` }}</v-card-subtitle>
    <v-divider></v-divider>
    <v-card-text>
      <p>{{ `Lugar de llegada: ${arrival}` }}</p>
      <p>{{ `Lugar de salida: ${depature}` }}</p>
    </v-card-text>
    <v-card-actions
      ><v-btn @click="deleteTrip" text>
        <router-link class="delete link" :to="`/delete/${id}`">
          Eliminar
        </router-link>
      </v-btn>
      <v-btn class="mod_name" text>
        <router-link class="mod_name link" :to="`/update?id=${id}`">
          Modificar Nombre
        </router-link>
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
export default {
  props: {
    title: String,
    id: Number,
    subTitle: String,
    arrival: String,
    depature: String,
  },
  methods: {
    updateName() {
      this.$router.push("/update_trip?id=1");
    },
    deleteTrip() {
      this.$router.push(`/delete/${this.id}`);
    },
  },
};
</script>

<style lang="scss" scoped>
.card {
  background: #78abd8 !important;
}
.mod_name {
  color: rgb(153, 247, 115) !important;
}
.delete {
  color: rgb(224, 224, 224);
}
</style>
