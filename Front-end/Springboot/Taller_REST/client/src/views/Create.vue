<template>
  <v-main>
    <v-container class="update-wrapper">
      <h1>Crear un nuevo Paseo</h1>
      <v-row align="center" justify="center">
        <v-col cols="12" sm="4">
          <v-form ref="form" v-model="valid" lazy-validation>
            <v-text-field
              v-model="nameText"
              :counter="20"
              :rules="nameRules"
              label="Nombre"
              required
            ></v-text-field>
            <v-text-field
              v-model="salida"
              :counter="40"
              :rules="lugarRules"
              label="Lugar de salida"
              required
            ></v-text-field>
            <v-text-field
              v-model="llegada"
              :counter="40"
              :rules="lugarRules"
              label="Lugar de llegada"
              required
            ></v-text-field>
            <v-text-field
              v-model="fecha"
              :counter="10"
              :rules="dateRules"
              label="Fecha (aaaa-mm-dd)"
              required
            ></v-text-field>
            <v-btn
              :disabled="!valid"
              color="success"
              class="mr-4"
              @click="validate"
            >
              Crear paseo
            </v-btn>
          </v-form>
        </v-col>
      </v-row>
    </v-container>
  </v-main>
</template>

<script>
import axios from "axios";
export default {
  data: () => ({
    valid: true,
    nameText: "",
    salida: "",
    llegada: "",
    fecha: "",
    nameRules: [
      (v) => !!v || "Se requiere el nombre",
      (v) =>
        (v && v.length <= 20) || "El nombre no debe exceder los 20 caracteres",
    ],
    dateRules: [
      (v) => !!v || "Se requiere la fecha",
      (v) =>
        (v && v.length <= 10) || "El nombre no debe exceder los 10 caracteres",
    ],
    lugarRules: [
      (v) => !!v || "Se requiere el lugar",
      (v) =>
        (v && v.length <= 40) || "El nombre no debe exceder los 40 caracteres",
    ],
    select: null,
  }),

  methods: {
    validate() {
      if (this.$refs.form.validate()) {
        let url = `${this.$store.getters.getUrlBase}create_trip`;
        axios
          .post(url, {
            name: this.nameText,
            place_departure: this.salida,
            place_arrival: this.llegada,
            date: this.fecha,
          })
          .then(() => this.$router.push("/"));
      }
    },
  },
};
</script>

<style scoped>
h1 {
  text-align: center;
  width: 100%;
  margin-top: 5rem;
}
</style>
