<script setup>
import SideNav from '@/components/SideNav.vue';


</script>

<template>
  <div>


    <el-form ref="form" :model="form" label-width="150px">
      <el-form-item><img src="../static/pic/校徽.png" width="200px" ></el-form-item>
      
      <el-form-item><label>欢迎使用海大体育馆系统！</label></el-form-item>

      <el-form-item></el-form-item>

    </el-form>
    <router-view/>

  </div>
</template>

<style scoped>
.el-form{

  text-align: center;
}

.el-input{
  width: 400px;
}

.el-form-item__content{
  width: 400px;
}

label{
  color: dodgerblue;
  font-size: 24px;
}

</style>

<script>
export default {
    components: { SideNav }
}

</script>