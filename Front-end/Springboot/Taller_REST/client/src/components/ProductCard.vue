<template>
  <v-container>
    <v-row align="center" justify="center">
      <v-col cols="12" sm="4">
        <v-card max-width="344" class="card" dark elevation="3">
          <v-card-title>{{ title }}</v-card-title>
          <v-card-subtitle>{{ `id: ${id} ${subTitle}` }}</v-card-subtitle>
          <v-divider></v-divider>
          <v-card-text>
            <p>{{ `Lugar de llegada: ${arrival}` }}</p>
            <p>{{ `Lugar de salida: ${depature}` }}</p>
          </v-card-text>
          <v-card-actions
            ><v-btn class="delete" @click="deleteTrip" text>
              Eliminar
            </v-btn>
            <v-btn class="mod_name" @click="updateName" text>
              Modificar Nombre
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
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
      this.$router.push("/delete");
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
  color: rgb(207, 207, 207);
}
</style>
