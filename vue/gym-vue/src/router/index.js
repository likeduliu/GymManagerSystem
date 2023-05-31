import Vue from 'vue'
import VueRouter from 'vue-router'


Vue.use(VueRouter)

const routes = [
    {
        // 登陆页面
        path:'/login',
        name:'Login',
        component:()=>import('../views/LoginPage.vue'),
    },
    {
        // 欢迎页面
        path:'/index',
        name:'index',
        component:()=>import('../views/WelcomePage.vue'),
    },
    {
        // 主页面
        path: '/',
        name: 'home',
        redirect:'/index',
        component: ()=>import('../views/HomeView.vue'),
        // 菜单
        children:[
            {
                path:'/InitUser',
                name:'InitUser',
                component:()=>import('../views/YHGL/InitUser.vue')
            },
            {
                path:'/ManagerRole',
                name:'ManagerRole',
                component:()=>import('../views/YHGL/ManagerRole.vue')
            },
            {
                path:'/ChangePw',
                name:'ChangePw',
                component:()=>import('../views/YHGL/ChangePw.vue')
            },
            {
                path:'/SearchUser',
                name:'SearchUser',
                component:()=>import('../views/YHGL/SearchUser.vue')
            },
            {
                path:'/DeleteUser',
                name:'DeleteUser',
                component:()=>import('../views/YHGL/DeleteUser.vue')
            },

        ]
    },
    {
        path:'/home',
        name:'home',
        component:() => import('../views/HomeView.vue'),
        children:[
            {
                path:'/InitUser',
                name:'InitUser',
                component:()=>import('../views/YHGL/InitUser.vue'),
            },
        ]
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
    },
    {
        path: '/InitUser',
        name: 'InitUser',
        component: () => import( '../views/CDGL/CdglUseView.vue')
    }

]

const router = new VueRouter({
    routes
})

export default router
