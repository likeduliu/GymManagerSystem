<script setup>

</script>

<template>
    <div>
      <el-form :model="form" ref="form" :rules="rules" label-position="left" label-width="80px" class="login-form" id="loginform">
        <el-form-item><img src="../static/pic/校徽.png" width="200px" ></el-form-item>
        <el-form-item><label>欢迎使用海大体育馆系统！</label></el-form-item>
        <el-form-item label="账号" prop="userId" style="width: 400px;margin-left: 40%">
          <el-input v-model="form.userID" placeholder="请输入用户名"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password" style="width: 400px;margin-left: 40%">
          <el-input type="password" v-model="form.Password" placeholder="请输入密码"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm">登录</el-button>
          <el-button @click="resetForm">重置</el-button>
        </el-form-item>
      </el-form>
  </div>
</template>

<style>
.el-form{
  margin-top: 80px;
  text-align: center;
}
.el-input{
  width: 300px;
}
label{
  color: dodgerblue;
  font-size: 24px;
}
</style>

<script>
import axios from 'axios';
console.log(localStorage.getItem('logintoken'))
const api = axios.create({
  baseURL: '/api', // 基础URL  api接口

});
api.interceptors.request.use(
    config => {
      const token = localStorage.getItem('userid');
      if (token) {
        config.headers['token'] = token;
      }
      config.headers['Content-Type'] = 'application/json';
      return config;
    },
    error => {
      // 处理请求错误
      return Promise.reject(error);
    }
);
export default {
  data() {
    return {
      test:[],
      form: {
        userID: '',
        Password: ''
      },
      rules: {
        userID: [
          { required: true, message: '请输入用户名', trigger: 'blur' }
        ],
        Password: [
          { required: true, message: '请输入密码', trigger: 'blur' }
        ]
      }
    };
  },
  methods: {
    submitForm() {
      console.log(this.form)
      this.$refs.form.validate(valid => {
        if (valid) {
          // 发送登录请求
          axios.post('/login',
              this.form,
              {
                headers: {  //头部参数
                  ContentType: 'application/json',
                  token:sessionStorage.getItem('token')
                }
              }
          )
              .then(response => {
                // 登录成功后跳转到首页
                if (response.data.code === 0) {
                  this.$message.success(response.data.message)
                  // 将返回的用户数据存储到本地
                  console.log(response)
                  let user = JSON.stringify(response.data.data)
                  let roleid = JSON.stringify(response.data.data.roleID)
                  let userid = JSON.stringify(response.data.data.userID)
                  let username = response.data.data.name
                  localStorage.setItem('loginuser',user)
                  localStorage.setItem('loginname',username)
                  localStorage.setItem('logintoken',roleid)
                  localStorage.setItem('loginuserid',userid)
                  console.log(user)
                console.log(username)
                  const data=localStorage.getItem('loginuser')
                  const token=localStorage.getItem('logintoken')
                  console.log(token)
                  console.log(data)
                  this.$router.push('/index').then(()=>{
                    location.reload();
                  });
                  // this.$router.go('/index')
                  

                } else {
                  // 如果登录失败，显示错误提示信息
                  this.$message.error(response.data.message);
                }
              })
              .catch(error => {
                console.log(error);
                this.$message.error('登录失败');
              });
        } else {
          console.log('error submit');
          return false;
        }
      });
    },
    resetForm() {
      document.getElementById("loginform").reset();
    },
  }
};
</script>


