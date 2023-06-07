<script setup>

</script>

<template>
  <div>

    <el-form ref="form" :model="form" :rules="rules" label-width="150px" >
      <el-form-item><img src="../static/pic/校徽.png" width="200px" ></el-form-item>

      <el-form-item><label>欢迎使用海大体育馆系统！</label></el-form-item>

      <el-form-item label="学号/教职工号" prop="UserID">
        <el-input v-model="form.userid"></el-input>
      </el-form-item>

      <el-form-item label="密码" prop="Password">
        <el-input v-model="form.pw" type="password"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitForm('form')">立即登录</el-button>
        <el-button @click="resetForm('form')">重置</el-button>
      </el-form-item>
    </el-form>
    <router-view/>
  </div>
</template>

<style scoped>
.el-form{
  margin-top: 80px;
  margin-left: 25%;
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
  data() {
    return {
      form: {
        userid:"",
        pw:""
      },
      rules:{
        userid:[
          {required:true,message:"学号/教职工号不能为空！",trigger:"blur"},
        ],
        pw:[
          {required:true,message:"密码不能为空！",trigger:"blur"}
        ]
      }
    }
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert("submit!");
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
  },
}
</script>