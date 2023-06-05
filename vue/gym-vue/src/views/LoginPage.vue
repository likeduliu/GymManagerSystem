<script setup>

</script>

<template>

    <div class="container-fluid">
      <div class="row justify-content-center mt-5">
        <div class="col-md-4 col-sm-6">
          <div class="card">
            <div class="card-header">{{ title }}</div>
            <div class="card-body">
              <form>
                <div class="form-group">
                  <label for="username">用户名</label>
                  <input
                      v-model="username"
                      type="text"
                      class="form-control"
                      placeholder="请输入用户名"
                  />
                </div>
                <div class="form-group">
                  <label for="password">密码</label>
                  <input
                      v-model="password"
                      type="password"
                      class="form-control"
                      placeholder="请输入密码"
                  />
                </div>
                <button
                    type="button"
                    class="btn btn-primary btn-block"
                    @click="login"
                >
                  登录
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>

  <!--  <div>-->

<!--    <el-form ref="form" :model="form" :rules="rules" id="loginform" label-width="150px">-->
<!--      <el-form-item><img src="../static/pic/校徽.png" width="200px" ></el-form-item>-->

<!--      <el-form-item><label>欢迎使用海大体育馆系统！</label></el-form-item>-->

<!--      <el-form-item label="学号/教职工号" prop="UserID">-->
<!--        <el-input v-model="form.userid"></el-input>-->
<!--      </el-form-item>-->

<!--      <el-form-item label="密码" prop="Password">-->
<!--        <el-input v-model="form.pw" type="password"></el-input>-->
<!--      </el-form-item>-->

<!--      <el-form-item>-->
<!--        <el-button type="primary" @click="submitForm('form')">立即登录</el-button>-->
<!--        <el-button @click="resetForm">重置</el-button>-->
<!--      </el-form-item>-->
<!--    </el-form>-->
<!--    <router-view/>-->
<!--  </div>-->
</template>

<style>
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
import axios from "axios";

export default {
  data() {
    return {
      title: "登录",
      username: "",
      password: ""
    };
  },
  methods: {
    async login() {
      try {
        const response = await axios.post("/api/login", {
          username: this.username,
          password: this.password
        });

        if (response.status === 200) {
          this.$store.commit("setUser", response.data);
          this.$router.push("/index");
        } else {
          alert("登录失败");
        }
      } catch (err) {
        console.error(err);
        alert("登录失败");
      }
    }
  }
};
// export default {
//   data() {
//     return {
//       form: {
//         userid:"",
//         pw:"",
//         role:""
//       },
//       rules:{
//         userid:[
//           {required:true,message:"学号/教职工号不能为空！",trigger:"blur"},
//         ],
//         pw:[
//           {required:true,message:"密码不能为空！",trigger:"blur"}
//         ]
//       }
//     }
//   },
//   methods: {
//     submitForm(formName) {
//       this.$refs[formName].validate((valid) => {
//         if (valid) {
//           alert("submit!");
//         } else {
//           console.log("error submit!!");
//           return false;
//         }
//       });
//     },
//     resetForm() {
//       document.getElementById("loginform").reset();
//     },
//   },
//   demo(){
//     // 超级
//     if (this.role === 'superadmin') {
//
//       window.localStorage.setItem('roles','superadmin')
//     // 场地
//     } else if (this.role === 'cdadmin') {
//
//       window.localStorage.setItem('roles','cdadmin')
//     // 器材
//     }  else if (this.role === 'qcadmin') {
//
//       window.localStorage.setItem('roles','qcadmin')
//     // 赛事
//     }  else if (this.role === 'ssadmin') {
//
//       window.localStorage.setItem('roles','ssadmin')
//     // 赛事
//     } else if (this.role === 'user') {
//
//       window.localStorage.setItem('roles','user')
//
//     }
//
//   }
// }
</script>