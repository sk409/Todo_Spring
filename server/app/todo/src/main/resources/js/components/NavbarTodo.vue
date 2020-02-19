<template>
  <div>
    <v-navigation-drawer v-model="visible" app>
      <v-list>
        <v-list-item v-for="navItem in navItems" :key="navItem.title" :href="navItem.href">
          <v-list-item-title>{{navItem.title}}</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
    <v-app-bar color="primary" app dark>
      <v-app-bar-nav-icon @click="visible = !visible"></v-app-bar-nav-icon>
    </v-app-bar>
  </div>
</template>

<script>
export default {
  data() {
    return {
      navItems: [
        {
          title: "全てのTODO",
          href: "/todos"
        }
      ],
      visible: false
    };
  }
};
</script>

