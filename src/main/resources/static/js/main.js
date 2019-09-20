import Vue from 'vue'
// import Vuetify from 'vuetify'
import '@babel/polyfill'
import 'api/resource'
import router from 'router/router'
import App from 'pages/App.vue'
import store from 'store/store'
import { connect } from './util/ws'
import vuetify from './plugin/vuetify'
import 'vuetify/dist/vuetify.min.css'
import * as Sentry from '@sentry/browser'
import * as Integrations from '@sentry/integrations'

Sentry.init({
    dsn: 'https://179091770079497e8934f5d5294f32b0@sentry.io/1731419',
    integrations: [new Integrations.Vue({Vue, attachProps: true})],
})

// This will be changed for all future events
Sentry.setUser({
    id: profile && profile.id,
    username: profile && profile.name
});

if (profile) {
    connect()
}

// Vue.use(Vuetify)


new Vue({
    el: '#app',
    store,
    router,
    vuetify,
    render: a => a(App)
})
