const app = new Vue({
  el: "#app",
  data: {
    title: "Hello world with vue",
    products: [
      { name: "Apple", stock: 0 },
      { name: "Lenovo", stock: 200 },
      { name: "Dell", stock: 350 },
      { name: "HP", stock: 250 },
    ],
  },
});
