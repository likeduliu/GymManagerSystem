<script>

import {transitionProps as form} from "vue/src/platforms/web/runtime/components/transition";
import {defineComponent} from "vue";

export default defineComponent({
  computed: {
    form() {
      return form
    }
  }
})

</script>

<template>
  <div>
    <el-form ref="form" model="form" rules="rules" id="userform" label-width="200px">
      <el-form-item label="学号/教职工号 * ">
        <el-input v-model="form.userid"></el-input>
      </el-form-item>

      <el-form-item label="姓名 * ">
        <el-input v-model="form.name"></el-input>
      </el-form-item>

      <el-form-item label="所属院系/单位">
        <el-select v-model="form.departermentid" placeholder="请选择" style="width: 350px">
          <el-option label="党委办公室" value="1"></el-option>
          <el-option label="水产学院" value="2"></el-option>
          <el-option label="食品科技学院" value="3"></el-option>
          <el-option label="海洋与气象学院" value="4"></el-option>
          <el-option label="滨海农业学院" value="5"></el-option>
          <el-option label="机械工业学院" value="6"></el-option>
          <el-option label="海洋工程于能源学院" value="7"></el-option>
          <el-option label="经济学院" value="8"></el-option>
          <el-option label="管理学院" value="9"></el-option>
          <el-option label="数学与计算机学院" value="10"></el-option>
          <el-option label="电子与信息工程学院" value="11"></el-option>
          <el-option label="化学与环境学院" value="12"></el-option>
          <el-option label="船舶与海运学院" value="13"></el-option>
          <el-option label="文学与新闻传播学院" value="14"></el-option>
          <el-option label="法政学院" value="15"></el-option>
          <el-option label="外国语学院" value="16"></el-option>
          <el-option label="中歌艺术学院" value="17"></el-option>
          <el-option label="体育与休闲学院" value="18"></el-option>

        </el-select>
      </el-form-item>

      <el-form-item label="角色">
        <el-select v-model="form.roleid" placeholder="请选择" style="width: 350px">
          <el-option label="超级管理员" value="1"></el-option>
          <el-option label="场地管理员" value="2"></el-option>
          <el-option label="器材管理员" value="3"></el-option>
          <el-option label="赛事管理员" value="4"></el-option>
          <el-option label="普通用户" value="5"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="身份证号 * ">
        <el-input v-model="form.id"></el-input>
      </el-form-item>

      <el-form-item label="联系电话 * ">
        <el-input v-model="form.phone"></el-input>
      </el-form-item>

      <el-form-item label="住址">
        <el-input v-model="form.address"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitForm">确认注册</el-button>
        <el-button type="primary" @click="test">重置</el-button>
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
</style>

<script>

import axios from "axios";

export default {
  data() {
    return {
      token:{},
      form: {
        userid: '',
        name: '',
        departermentid: '',
        roleid:'',
        id: '',
        phone: '',
        address: ''
      }
    }
  },
  mounted(){
    this.token=localStorage.getItem('logintoken')

    console.log(this.token)

  },
  methods:
      {
        submitForm() {
          console.log(this.form)
          this.$refs.form.validate(valid => {
            if (valid) {
              // 发送登录请求
              axios.post('/InitUser',
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
                      this.$message.success('注册成功！')
                    }else {
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
        resetform(){
          document.getElementById("userform").reset()
        },
        test(){
          let data=localStorage.getItem('loginuser')
          var obj=JSON.parse(data)
          console.log(obj)
        }
      }
}
</script>