import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Delete from "../views/Delete.vue";
import UpdateName from "@/views/UpdateName";
import Create from "@/views/Create";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/delete/:id",
    name: "Delete",
    component: Delete,
  },
  {
    path: "/update",
    name: "Update",
    component: UpdateName,
  },
  {
    path: "/create",
    name: "create",
    component: Create,
  },
];

const router = new VueRouter({
  index: "/default.html",
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
