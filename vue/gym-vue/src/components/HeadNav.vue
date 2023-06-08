<template>
  <div style="height:50px; line-height: 50px; border-bottom: 1px solid #ccc; display: flex; background-color: white">
    <div style="width: 200px; padding-left: 30px; font-weight: 700; color: dodgerblue; font-size: 16px"><router-link to="/index">体育馆场馆管理</router-link></div>
    <div style="flex: 1"></div>
    <div style="width: 100px;">
      <el-dropdown>
       <span class="el-dropdown-link" style="line-height: 50px; text-align: center; font-size: 14px">
        <span class="iconfont icon-yonghu"></span>
         <span id="username">{{username}}</span>
        <el-icon class="el-icon--right el-icon-arrow-down">
          <arrow-down/>
        </el-icon>
        </span>
         <template #dropdown>
            <el-dropdown-menu>
<!--             <el-dropdown-item>个人信息</el-dropdown-item>-->
<!--             <el-dropdown-item>更换账号</el-dropdown-item>-->
              <el-dropdown-item><el-button>退出</el-button>></el-dropdown-item>
            </el-dropdown-menu>
         </template>
      </el-dropdown>
    </div>
  </div>

</template>

<style>
.el-dropdown-link:focus {
  outline: none;
}
a:link{
  color: dodgerblue;
  text-decoration: none;
}
a:visited{
  color: dodgerblue;
}
a:hover{
  color: dodgerblue;
}
a:active{
  color: dodgerblue;
}

</style>

<script>



let data=localStorage.getItem('loginuser')


// export default {
//   name: "APP",
//   data(){
//     return{
//       user:[]
//     }
//   },
//   methods:{
//     // this.user=data
//   }
// }
</script>