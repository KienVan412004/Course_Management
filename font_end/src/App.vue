<script setup lang="ts">
import { RouterLink, RouterView } from "vue-router";
import HelloWorld from "./components/HelloWorld.vue";
import Menu from "./layout/Menu.vue";

import { useRoute } from "vue-router";
</script>

<template>
  <RouterView />
</template>
