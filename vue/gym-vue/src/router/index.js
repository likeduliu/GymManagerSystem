import Vue from 'vue'
import VueRouter from 'vue-router'


Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'home',
        component: () => import( '../views/CDGL/CdglView.vue')
    },
    {
        path: '/Add',
        name: 'add',
        component: () => import( '../views/CDGL/CdglAddView.vue')
    },
    {
        path: '/Book',
        name: 'book',
        component: () => import( '../views/CDGL/CdglBookView.vue')
    },
    {
        path: '/CancleBook',
        name: 'canclebook',
        component: () => import( '../views/CDGL/CdglCancleBookView.vue')
    },
    {
        path: '/Del',
        name: 'del',
        component: () => import( '../views/CDGL/CdglDelView.vue')
    },
    {
        path: '/Notice',
        name: 'notice',
        component: () => import( '../views/CDGL/CdglNoticeView.vue')
    },
    {
        path: '/QueryWeek',
        name: 'aqueryweek',
        component: () => import( '../views/CDGL/CdglQueryWeekView.vue')
    },
    {
        path: '/Rate',
        name: 'rate',
        component: () => import( '../views/CDGL/CdglRateView.vue')
    },
    {
        path: '/Reserve',
        name: 'reserve',
        component: () => import( '../views/CDGL/CdglReserveView.vue')
    },
    {
        path: '/UpdateBook',
        name: 'updateBook',
        component: () => import( '../views/CDGL/CdglUpdateBookView.vue')
    },
    {
        path: '/Use',
        name: 'use',
        component: () => import( '../views/CDGL/CdglUseView.vue')
    }

]

const router = new VueRouter({
    routes
})

export default router
