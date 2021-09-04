<template>
  <nav>
    <h1>Travelly</h1>
    <ul>
      <li>
        <router-link class="link" to="/">Productos</router-link>
      </li>
      <li>
        <router-link class="link" to="/create_products">Crear</router-link>
      </li>
      <li>
        <router-link class="link" to="/update_product">Modificar</router-link>
      </li>
      <li>
        <router-link class="link" to="/delete_product">Eliminar</router-link>
      </li>
    </ul>
  </nav>
</template>

<script>
export default {};
</script>

<style scoped lang="scss">
nav {
  background-color: #202752;
  color: white;
  display: flex;
  align-items: center;
  padding: 0 10rem;
  justify-content: center;
  min-height: 10vh;
}
h1 {
  flex: 2 1 40rem;
  font-family: "Pattaya", sans-serif;
}
ul {
  flex: 1 1 40rem;
  display: flex;
  list-style: none;
  font-family: "Montserrat", sans-serif;
  font-weight: 600;
  justify-content: space-around;
  .link {
    color: white;
    text-decoration: none;
  }
  .router-link-active {
    color: rgb(71, 245, 245);
  }
}
</style>
