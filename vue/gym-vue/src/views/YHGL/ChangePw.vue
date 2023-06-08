
<template>
  <div>
    <el-form ref="form" :model="form" label-width="200px" id="changepwform">
      <el-form-item label="学号/教职工号">
        <span>{{ user_id }}</span>
      </el-form-item>

      <el-form-item label="旧密码">
        <el-input v-model="form.oldpw"></el-input>
      </el-form-item>

      <el-form-item label="新密码">
        <el-input v-model="form.newpw"></el-input>
      </el-form-item>

<!--      <el-form-item label="确认密码">-->
<!--        <el-input v-model="form.confirmnewpw"></el-input>-->
<!--      </el-form-item>-->

      <el-form-item>
        <el-button type="primary" @click="submitForm">确认修改</el-button>
        <el-button type="primary" @click="resetForm">重置</el-button>
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
import axios from "axios";

const userData = localStorage.getItem('loginuser');
const parsedData = JSON.parse(userData);
export default {
  data() {
    return {
      user_id: "",
      form: {
        oldpw: '',
        newpw: '',
        // confirmnewpw: '',
        userid:""
      }
    };
  },
  methods: {
    submitForm() {
      this.form.userid=this.user_id
      console.log(this.form)
      this.$refs.form.validate(valid => {
        if (valid) {
          // 发送登录请求
          axios.post('/ChangePassword',
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
                  let user = JSON.stringify(response.data.data)
                  localStorage.setItem('loginuser',user)
                  const data=localStorage.getItem('loginuser')

                  console.log(data)

                  this.$router.push('/index');
                }else {
                  // 如果登录失败，显示错误提示信息
                  this.$message.error(response.data.message);
                }
              })
              .catch(error => {
                console.log(error);
              });
        } else {
          console.log('error submit');
          return false;
        }
      });
    },
    resetForm() {
      document.getElementById("changepwform").reset();
    },
    create() {
      console.log(parsedData);
      this.user_id = parsedData.userID;
    }
  },
  created() {
    this.create();
  }
}

</script>