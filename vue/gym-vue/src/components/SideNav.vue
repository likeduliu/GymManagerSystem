<script setup>

</script>

<template>
  <div>
    <el-menu
        default-active="2"
        class="el-menu-vertical-demo"
        @open="handleOpen"
        @close="handleClose"
        router
    >
      <el-submenu index="1" v-if="(token)!=null">
        <template #title>
          <span class="iconfont icon-yonghuguanli"></span>
          &emsp;
          <span>用户管理</span>
        </template>
        <el-menu-item index="/User/InitUser" v-if="parseInt(token)===1">普通用户注册</el-menu-item>
<!--        <el-menu-item index="/ManagerRole">用户角色管理</el-menu-item>-->
        <el-menu-item index="/User/ChangePw">修改密码</el-menu-item>
        <el-menu-item index="/User/SearchUser" v-if="parseInt(token)===1">查询用户</el-menu-item>
<!--        <el-menu-item index="DeleteUser">删除用户</el-menu-item>-->
      </el-submenu>

      <el-submenu index="2" v-if="token!=null">
        <template #title>
          <span class="iconfont icon-changdi"></span>
          &emsp;
          <span>场地管理</span>
        </template>
        <el-menu-item index="/field/All">全部场地</el-menu-item>
        <el-menu-item index="/field/Add" v-if="parseInt(token)===1 || parseInt(token)===2">添加场地</el-menu-item>
        <el-menu-item index="/field/Del" v-if="parseInt(token)===1 || parseInt(token)===2">删除场地</el-menu-item>
        <el-menu-item index="/field/Book">预约场地</el-menu-item>
        <el-menu-item index="/field/CancleBook">取消预约</el-menu-item>
        <el-menu-item index="/field/Use">场地费用查询</el-menu-item>
        <el-menu-item index="/field/Notice" v-if="parseInt(token)===1 || parseInt(token)===2">场地公告管理</el-menu-item>
      </el-submenu>

      <el-submenu index="3" v-if="token!=null">
        <template #title>
          <span class="iconfont icon-saishi"></span>
          &emsp;
          <span>赛事管理</span>
        </template>
        <el-menu-item index="/competition/information">比赛信息</el-menu-item>
        <el-menu-item index="/competition/creation" v-if="parseInt(token)===1 || parseInt(token)===4">比赛创建</el-menu-item>
        <el-menu-item index="/competition/cancellation" v-if="parseInt(token)===1 || parseInt(token)===4">比赛取消</el-menu-item>
      </el-submenu>

      <el-submenu index="4" v-if="token!=null">
        <template #title>
          <span class="iconfont icon-icon_changdiguanli"></span>
          &emsp;
          <span>器材管理</span>
        </template>
       <el-menu-item index="/equipment/All">全部器材</el-menu-item>
        <el-menu-item index="/equipment/Add" v-if="parseInt(token)===1 || parseInt(token)===2">添加器材</el-menu-item>
        <el-menu-item index="/equipment/Del" v-if="parseInt(token)===1 || parseInt(token)===2">删除器材</el-menu-item>
        <el-menu-item index="/equipment/Book">租用器材</el-menu-item>
        <el-menu-item index="/equipment/Repair" v-if="parseInt(token)===1 || parseInt(token)===2">器材维护</el-menu-item>
        <el-menu-item index="/equipment/Recover">回收器材</el-menu-item>
        <el-menu-item index="/equipment/QueryRate">器材收费查询</el-menu-item>
        
      </el-submenu>
    </el-menu>

  </div>
</template>

<style>
.el-menu-vertical-demo{
  width: 250px;
}

</style>

<script>
import {ref} from "vue";

const token = ref(localStorage.getItem('logintoken'))
console.log("1")
export default{
  data(){
    return{

    };
  },
  methods:{
  },

}
</script>