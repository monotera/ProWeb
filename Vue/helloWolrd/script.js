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
    newProduct: "",
    total: 0
  },
  methods: {
    addProduct() {
      this.products.push({
        name: this.newProduct,
        stock: 0,
      });
      this.newProduct = ""
    },
  },
  computed: {
    sumProducts(){
      this.total = 0;
      for(product of this.products){
        this.total += product.stock;
      }
      return this.total;
    }
  }
});
