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
    <el-form ref="form" model="form" id="searchform" label-width="200px">
      <el-form-item label="学号/教职工号" style="margin-top: 50px">
        <el-input v-model="form.userid"></el-input>
      </el-form-item>

      <el-form-item label="姓名">
        <el-input v-model="form.name"></el-input>
      </el-form-item>

      <el-form-item label="所属院系/单位">
        <el-select v-model="form.depaterment" placeholder="请选择" style="width: 350px">
          <el-option label="数学与计算机学院" value="MathsAndComputer"></el-option>
          <el-option label="文学与传媒院" value="ArtsandCommunications"></el-option>
          <el-option label="水产学院" value="Fisheries"></el-option>
          <el-option label="后勤集团" value="BackCrews"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="身份证号">
        <el-input v-model="form.id"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">查询</el-button>
        <el-button type="primary" @click="resetform">重置</el-button>
      </el-form-item>
    </el-form>

    <el-table
        :data="userdata"
        style="width: 100%">
      <el-table-column type="expand" >
        <template slot-scope="props">
          <el-form label-position="left" inline class="demo-table-expand">
            <el-form-item label="姓名">
              <span>{{ props.row.name }}</span>
            </el-form-item>
            <el-form-item label="院系">
              <span>{{ props.row.depaterment }}</span>
            </el-form-item>
            <el-form-item label="学号/教职工号">
              <span>{{ props.row.userid }}</span>
            </el-form-item>
            <el-form-item label="身份证号">
              <span>{{ props.row.id }}</span>
            </el-form-item>
            <el-form-item label="联系电话">
              <span>{{ props.row.phone }}</span>
            </el-form-item>
            <el-form-item label="地址">
              <span>{{ props.row.address }}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column
          sortable
          label="学号/教职工号"
          prop="userid">
      </el-table-column>
      <el-table-column
          label="姓名"
          prop="name">
      </el-table-column>
      <el-table-column
          label="角色"
          prop="role">
      </el-table-column>
      <el-table-column label="操作">
        <template>
          <el-button
              size="mini"
              @click="handleEdit()">管理角色</el-button>
          <el-button
              size="mini"
              type="danger"
              @click="handleDelete()">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <RouterView/>
  </div>
</template>

<style scoped>
.el-form{
  text-align: center;
}
.el-input{
  width: 350px;
}

.demo-table-expand {
  font-size: 0;
}
.demo-table-expand label {
  width: 90px;
  color: #99a9bf;
}
.demo-table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  width: 50%;
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
      },
      userdata:[
        {
          userid: '202011701308',
          name: '黄林旭',
          depaterment: '数学与计算机学院',
          role: '超级管理员',
          address: '海乐',
          phone: '15777777777',
          id: '440000000000000000'
        },        {
          userid: '202011701307',
          name: '黄林旭',
          depaterment: '数学与计算机学院',
          role: '超级管理员',
          address: '海乐',
          phone: '15777777777',
          id: '440000000000000000'
        }
      ]
    }
  },
  methods: {
    onSubmit() {
      console.log('submit!');
    },
    resetform(){
      document.getElementById("searchform").reset();
    },
    handleEdit(){
      this.$router.push("ManagerRole");
    },
    handleDelete(){
      this.$router.push("/DeleteUser");
    }
  }
}
</script>