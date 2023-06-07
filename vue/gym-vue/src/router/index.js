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
        redirect:'/login',
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
    // {
    //     path:'/home',
    //     name:'home',
    //     component:() => import('../views/HomeView.vue'),
    //     children:[
    //         {
    //             path:'/InitUser',
    //             name:'InitUser',
    //             component:()=>import('../views/YHGL/InitUser.vue'),
    //         },
    //     ]
    // },
    {
        path: '/field/All',
        name: 'all',
        component: () => import( '../views/CDGL/CdglView.vue')
    },
    {
        path: '/field/Add',
        name: 'add',
        component: () => import( '../views/CDGL/CdglAddView.vue')
    },
    {
        path: '/field/Book',
        name: 'book',
        component: () => import( '../views/CDGL/CdglBookView.vue')
    },
    {
        path: '/field/CancleBook',
        name: 'canclebook',
        component: () => import( '../views/CDGL/CdglCancleBookView.vue')
    },
    {
        path: '/field/Del',
        name: 'del',
        component: () => import( '../views/CDGL/CdglDelView.vue')
    },
    {
        path: '/field/Notice',
        name: 'notice',
        component: () => import( '../views/CDGL/CdglNoticeView.vue')
    },
    {
        path: '/field/QueryWeek',
        name: 'aqueryweek',
        component: () => import( '../views/CDGL/CdglQueryWeekView.vue')
    },
    {
        path: '/field/Rate',
        name: 'rate',
        component: () => import( '../views/CDGL/CdglRateView.vue')
    },
    {
        path: '/field/Reserve',
        name: 'reserve',
        component: () => import( '../views/CDGL/CdglReserveView.vue')
    },
    {
        path: '/field/UpdateBook',
        name: 'updateBook',
        component: () => import( '../views/CDGL/CdglUpdateBookView.vue')
    },
    {
        path: '/field/Use',
        name: 'use',
        component: () => import( '../views/CDGL/CdglUseView.vue')
    },
    {
        path: '/InitUser',
        name: 'InitUser',
        component: () => import( '../views/CDGL/CdglUseView.vue')
    } ,
    {
        path: '/equipment/All',
        name: 'all',
        component: () => import( '../views/QCGL/QCGLQueryView.vue')
    },
    {
        path: '/equipment/Add',
        name: 'add',
        component: () => import( '../views/QCGL/QCGLAddView.vue')
    },
    {
        path: '/equipment/Del',
        name: 'del',
        component: () => import( '../views/QCGL/QCGLDelView.vue')
    },
    {
        path: '/equipment/QueryRate',
        name: 'rate',
        component: () => import( '../views/QCGL/QCGLQueryRateView.vue')
    },
    {
        path: '/equipment/Book',
        name: 'book',
        component: () => import( '../views/QCGL/QCGLBookView.vue')
    },
    {
        path: '/equipment/Recover',
        name: 'recover',
        component: () => import( '../views/QCGL/QCGLRecoverView.vue')
    },
    {
        path: '/equipment/Repair',
        name: 'repair',
        component: () => import( '../views/QCGL/QCGLRepairView.vue')
    },
    





]

const router = new VueRouter({
    routes
})

export default router
