<template>
  <v-footer class="footer" dark :padless="paddles">
    <v-card
      flat
      tile
      width="100%"
      class="indigo footer-card lighten-1 white--text text-center"
    >
      <v-card-text>
        <v-btn
          v-for="(icon, index) in icons"
          :key="icon"
          :index="index"
          class="mx-4"
          icon
        >
          <a :href="links[index]">
            <v-icon large class="icon" size="24px">
              {{ icon }}
            </v-icon>
          </a>
        </v-btn>
      </v-card-text>

      <v-divider></v-divider>

      <v-card-text class="white--text">
        {{ new Date().getFullYear() }} —
        <strong>Nelson Mosquera </strong>
      </v-card-text>
    </v-card>
  </v-footer>
</template>

<script>
export default {
  data: () => ({
    icons: ["mdi-github", "mdi-linkedin"],
    links: [
      "https://github.com/monotera",
      "https://www.linkedin.com/in/nelson-mosquera-2414aa170/",
    ],
    paddles: true,
  }),
};
</script>

<style scoped lang="scss">
.footer {
  position: absolute;
  left: 0;
  bottom: 0;
  overflow: hidden;
  width: 100vw;
}
.footer-card {
  padding: 1rem;
}

.icon {
  border-radius: 1em;
  padding: 1em;
  color: white !important;
  font-size: 2em;
}
</style>
