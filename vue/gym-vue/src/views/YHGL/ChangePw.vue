<script>

</script>

<template>
  <div>
    <el-form ref="form" :model="form" label-width="200px">
      <el-form-item label="学号/教职工号">
        <p>{userid}</p>
      </el-form-item>

      <el-form-item label="旧密码">
        <el-input v-model="form.oldpw"></el-input>
      </el-form-item>

      <el-form-item label="新密码">
        <el-input v-model="form.newpw"></el-input>
      </el-form-item>

      <el-form-item label="确认密码">
        <el-input v-model="form.confirmnewpw"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">确认修改</el-button>
        <el-button type="primary" @click="resetform">重置</el-button>
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
  width: 350px;
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
        userid:'',
        name: '',
        depaterment: '',
        id: '',
        phone: '',
        address:''
      }
    }
  },
  methods: {
    onSubmit() {
      console.log('submit!');
    },
    resetform(){
      document.getElementById("userform").reset()
    }
  }
}
</script>