<template>
  <div>
    <!--    头部导航栏-->
    <div style="height:50px; line-height: 50px; border-bottom: 1px solid #ccc; display: flex; background-color: white">
      <div style="width: 200px; padding-left: 30px; font-weight: 700; color: dodgerblue; font-size: 16px"><router-link to="/index">体育馆场馆管理</router-link></div>
      <div style="flex: 1"></div>
      <div style="width: 100px;">
        <el-dropdown>
       <span class="el-dropdown-link" style="line-height: 50px; text-align: center; font-size: 14px">
        <span class="iconfont icon-yonghu"></span>
         <span id="nav">{{ user_name }}</span>
        <el-icon class="el-icon--right el-icon-arrow-down">
          <arrow-down/>
        </el-icon>
        </span>
          <template #dropdown>
            <el-dropdown-menu>
              <!--             <el-dropdown-item>个人信息</el-dropdown-item>-->
              <!--             <el-dropdown-item>更换账号</el-dropdown-item>-->
              <el-dropdown-item><el-button style="border: none" @click="Quit">退出</el-button>></el-dropdown-item>
            </el-dropdown-menu>
          </template>
        </el-dropdown>
      </div>
    </div>

    <!--    主体-->
    <div style="display: flex">
      <!--      侧边导航栏-->
      <SideNav />
      <!--      主体-->
      <router-view style="flex: 1"/>
    </div>
  </div>
</template>


<script>
import HeadNav from "@/components/HeadNav.vue";
import SideNav from "@/components/SideNav.vue";
import Vue from "vue";


export default {
  el: "#nav",
  components: {
    HeadNav,
    SideNav,
  },
  data() {
    return {
      user_name: "", // 初始化为空字符串
    };
  },
  methods:{
    Quit(){
      localStorage.clear();
      this.user_name="";
      this.$router.push("/login")
      location.reload()
    },
  },
  updated() {
    const userData = localStorage.getItem('loginuser');
    const parsedData = JSON.parse(userData);
    this.user_name = parsedData.name; // 从本地存储中获取用户名并设置给 user_name
  },
}
</script>