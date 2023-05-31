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
      <el-submenu index="1">
        <template #title>
          <i class="el-icon-message"></i>
          <el-icon><User /></el-icon>
          <span class="iconfont .icon-yonghuguanli"></span>
          <span>用户管理</span>
        </template>
        <el-menu-item index="/InitUser">普通用户注册</el-menu-item>
        <el-menu-item index="/ManagerRole">用户角色管理</el-menu-item>
        <el-menu-item index="ChangePw">修改密码</el-menu-item>
        <el-menu-item index="SearchUser">查询用户</el-menu-item>
        <el-menu-item index="DeleteUser">删除用户</el-menu-item>
      </el-submenu>

      <el-submenu index="2">
        <template #title>
          <el-icon><Ticket /></el-icon>
          <span>场地管理</span>
        </template>
        <el-menu-item index="/Add">功能</el-menu-item>
        <el-menu-item index="/Book">功能</el-menu-item>

      </el-submenu>

      <el-submenu index="3">
        <template #title>
          <el-icon><Calendar /></el-icon>
          <span>赛事管理</span>
        </template>
        <el-menu-item index="/">功能</el-menu-item>
      </el-submenu>

      <el-submenu index="4">
        <template #title>
          <el-icon><Calendar /></el-icon>
          <span>赛事管理</span>
        </template>
        <el-menu-item index="/">功能</el-menu-item>
      </el-submenu>
    </el-menu>

  </div>
</template>

<link rel="stylesheet" href="./iconfont.css">
<style>
.el-menu-vertical-demo{
  width: 250px;
}


</style>

<script>
// import {Document,Location,Setting,Menu,User,Calendar,Ticket,Basketball} from "@element-plus/icons-vue";
//
// export default {
//   name: "APP",
//   components: {
//     Document,Menu,Location,Setting,User,Calendar,Ticket,Basketball
//   }
// }
</script>