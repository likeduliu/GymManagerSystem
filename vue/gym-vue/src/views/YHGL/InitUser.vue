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
    <el-form ref="form" model="form" rules="rules" label-width="200px">
      <el-form-item label="学号/教职工号 * ">
        <el-input v-model="form.userid"></el-input>
      </el-form-item>

      <el-form-item label="姓名 * ">
        <el-input v-model="form.name"></el-input>
      </el-form-item>

      <el-form-item label="所属院系/单位">
        <el-select v-model="form.departerment" placeholder="请选择" style="width: 350px">
          <el-option label="数学与计算机学院" value="MathsAndComputer"></el-option>
          <el-option label="文学与传媒院" value="ArtsandCommunications"></el-option>
          <el-option label="水产学院" value="Fisheries"></el-option>
          <el-option label="后勤集团" value="BackCrews"></el-option>
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
        <el-button type="primary" @click="submitForm('form')">确认注册</el-button>
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
  width: 350px;
}
</style>

<script>

import axios from "axios";

export default {
  data() {
    return {
      form: {
        userid:'',
        name: '',
        departerment: '',
        id: '',
        phone: '',
        address:''
      }
    }
  },
  methods:
      {
        submitForm(form) {
          console.log('submit!');
          var parms = new URLSearchParams;
          parms.append('UserID', form.userid);
          parms.append('', '');
          parms.append('', '');
          parms.append('', '');
          parms.append('', '');
          parms.append('', '');
          parms.append('', '');
        }
      }

}
</script>