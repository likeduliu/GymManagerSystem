<template>
  <div style="height:50px; line-height: 50px; border-bottom: 1px solid #ccc; display: flex; background-color: white">
    <div style="width: 200px; padding-left: 30px; font-weight: 700; color: dodgerblue; font-size: 16px">体育馆场馆管理</div>
    <div style="flex: 1"></div>
    <div style="width: 100px;">
      <el-dropdown>
       <span class="el-dropdown-link" style="line-height: 50px; text-align: center; font-size: 14px">
        <el-icon><el-icon><User /></el-icon></el-icon>用户名
        <el-icon class="el-icon--right el-icon-arrow-down">
          <arrow-down/>
        </el-icon>
        </span>
         <template #dropdown>
            <el-dropdown-menu>
             <el-dropdown-item>Action 1</el-dropdown-item>
             <el-dropdown-item>Action 2</el-dropdown-item>
             <el-dropdown-item>Action 3</el-dropdown-item>
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
</style>

<script>
// import {ArrowDown} from "@element-plus/icons-vue";
// import {User} from "@element-plus/icons-vue";

// export default {
//   name: "APP",
//   components: {
//     ArrowDown,
//     User
//   }
// }
</script>