<template>
  <div>
    <!--    头部导航栏-->
    <HeadNav />

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

export default {
  name:"app",
  components:{
    HeadNav,
    SideNav,
  }
}
</script>