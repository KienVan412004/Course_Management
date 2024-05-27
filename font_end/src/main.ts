import "./assets/main.css";

import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import Vue3Toastify, { type ToastContainerOptions } from "vue3-toastify";
import "vue3-toastify/dist/index.css";
import { QuillEditor } from "@vueup/vue-quill";
import "@vueup/vue-quill/dist/vue-quill.snow.css";
import PrimeVue from "primevue/config";
import "primevue/resources/themes/aura-light-green/theme.css";

const app = createApp(App);
app.use(Vue3Toastify, {
  autoClose: 3000,
} as ToastContainerOptions);

app.use(PrimeVue);
app.component("QuillEditor", QuillEditor);
app.use(router);
app.mount("#app");
