<script>

</script>

<template>
  <div>
    <el-form ref="form" :model="form" label-width="200px">
      <el-form-item label="学号/教职工号">
        <p>{{ userid }}</p>
      </el-form-item>

      <el-form-item label="姓名">
        <p>{{ username }}</p>
      </el-form-item>

      <el-form-item label="所属院系/单位">
        <p>{{ userdepartmentID }}</p>
      </el-form-item>

      <el-form-item label="身份证号">
        <p>{{ useridf }}</p>
      </el-form-item>

      <el-form-item label="联系电话">
        <p>{{ userphone }}</p>
      </el-form-item>

      <el-form-item label="住址">
        <p>{{ useraddress }}</p>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">确认删除</el-button>
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
  width: 350px;
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
      userid:"",
      username:"",
      userdepartmentID:"",
      useridf:"",
      userphone:"",
      useraddress:"",
      form: {
        userid:'',
      }
    }
  },
  methods: {
    onSubmit() {
      this.form.userid=this.userid
      console.log(this.form)
      this.$refs.form.validate(valid => {
        if (valid) {
          // 发送登录请求
          axios.post('/DeleteUser',
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
    const userID=this.$route.params.e.userID
    const name=this.$route.params.e.name
    const departmentID=this.$route.params.e.departmentID
    const id=this.$route.params.e.id
    const phone=this.$route.params.e.phone
    const address=this.$route.params.e.address
    this.userid=userID
    this.username=name
    this.userdepartmentID=departmentID
    this.useridf=id
    this.userphone=phone
    this.useraddress=address
    console.log(userID)
    // const userid=this.$route.params.e.userID
    // const username=this.$route.params.e.name
    // this.user_id=userid
    // this.user_name=username
  }
}
</script>