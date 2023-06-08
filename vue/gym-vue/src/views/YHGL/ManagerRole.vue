<script>

</script>

<template>
  <div>
    <el-form ref="form" :model="form" label-width="200px">
      <el-form-item label="学号/教职工号">
        <p>{{ user_id }}</p>
      </el-form-item>

      <el-form-item label="姓名">
        <p>{{ user_name }}</p>
      </el-form-item>

      <el-form-item label="用户角色">
        <el-radio-group v-model="form.roleid">
          <el-radio-button label="1" value="1">超级管理员</el-radio-button>
          <el-radio-button label="2" value="2">场地管理员</el-radio-button>
          <el-radio-button label="3" value="3">器材管理员</el-radio-button>
          <el-radio-button label="4" value="4">赛事管理员</el-radio-button>
          <el-radio-button label="5" value="5">普通用户</el-radio-button>
        </el-radio-group>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">确认修改</el-button>
        <el-button type="primary" @click="backwards">取消</el-button>
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
import axios from "axios";

export default {
  data() {
    return {
      user_name:"",
      user_id:"",
      form: {
        roleid:'',
        userid:''
      }
    }
  },

  methods: {
    onSubmit() {
      this.form.userid=this.user_id
      console.log(this.form)
      this.$refs.form.validate(valid => {
        if (valid) {
          // 发送登录请求
          axios.post('/ManagerRole',
              this.form,
              {
                headers: {  //头部参数
                  ContentType: 'application/json',
                  token:sessionStorage.getItem('token')
                }
              }
          )
              .then(response => {
                this.$router.push("SearchUser")
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
    backwards(){
      this.$router.push("SearchUser");
    }
  },
  mounted(){
    const userid=this.$route.params.e.userID
    const username=this.$route.params.e.name
    this.user_id=userid
    this.user_name=username
  }
}
</script>