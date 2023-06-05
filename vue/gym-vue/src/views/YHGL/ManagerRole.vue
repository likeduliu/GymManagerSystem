<script>

</script>

<template>
  <div>
    <el-form ref="form" :model="form" label-width="200px">
      <el-form-item label="学号/教职工号">
        <p>{userid}</p>
      </el-form-item>

      <el-form-item label="姓名">
        <p>{name}</p>
      </el-form-item>

      <el-form-item label="用户角色">
        <el-radio-group v-model="form.resource">
          <el-radio-button label="超级管理员"></el-radio-button>
          <el-radio-button label="场地管理员"></el-radio-button>
          <el-radio-button label="器材管理员"></el-radio-button>
          <el-radio-button label="赛事管理员"></el-radio-button>
          <el-radio-button label="普通用户"></el-radio-button>
        </el-radio-group>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">确认修改</el-button>
        <el-button>取消</el-button>
      </el-form-item>

    </el-form>

    <RouterView/>
  </div>
</template>

<style scoped>
.el-form{
  margin-top: 80px;
  margin-left: 300px;
}
.el-input{
  //width: 500px;
}
p{
  margin: 0 auto;
}
</style>

<script>
export default {
  data() {
    return {
      form: {
        radio:'超级管理员'
      }
    }
  },

  methods: {
    onSubmit() {
      console.log('submit!');
    }
  }
}
</script>