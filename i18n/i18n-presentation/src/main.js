import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

import './assets/main.css'
import i18n from './i18n/i18n'

const app = createApp(App)

app.use(router)

app.use(i18n) //avant app.mount('#app)

app.mount('#app')
