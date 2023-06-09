
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
        <el-select v-model="form.depatermentID" placeholder="请选择" style="width: 350px">
          <el-option label="数学与计算机学院" value="10"></el-option>
          <el-option label="文学与新闻传播院" value="14"></el-option>
          <el-option label="水产学院" value="2"></el-option>
          <el-option label="党委办公室" value="1"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="身份证号">
        <el-input v-model="form.id"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="load">显示所有用户</el-button>
<!--        <el-button type="primary" @click="submitForm">根据条件查询</el-button>-->
<!--        <el-button type="primary" @click="resetform">重置条件</el-button>-->
      </el-form-item>
    </el-form>

    <el-table
        :data="userdata"
        :row-class-name="tablerowclassname"
        style="width: 100%"
        @row-click="handleRowClick">
      <el-table-column type="expand" >
        <template v-slot:="scope">
          <el-form label-position="left" inline class="demo-table-expand">
            <el-form-item label="姓名">
              <span>{{ scope.row.name }}</span>
            </el-form-item>
            <el-form-item label="院系">
              <span>{{ scope.row.departmentID }}</span>
            </el-form-item>
            <el-form-item label="学号/教职工号" >
              <span>{{ scope.row.userID }}</span>
            </el-form-item>
            <el-form-item label="身份证号">
              <span>{{ scope.row.id }}</span>
            </el-form-item>
            <el-form-item label="联系电话">
              <span>{{ scope.row.phone }}</span>
            </el-form-item>
            <el-form-item label="地址">
              <span>{{ scope.row.address }}</span>
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
      <el-table-column label="操作" >
        <template slot-scope="scope">
          <el-button
              size="mini"
              @click="handleEdit(scope.row)">管理角色</el-button>
          <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.row)">删除</el-button>
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
import axios from "axios";
import {forEach} from "core-js/stable/dom-collections";

export default {
  data() {
    return {
      row:{
        name:'',
        userid:''
      },
      form: {
        userid:'',
        name: '',
        departmentID: '',
        id: '',
      },
      userdata:[
        {name:'',
         depatermentID:'',
          userID:'',
          id:'',
          phone:'',
          address:'',
          roleid:''
         }
      ]
    }
  },
  methods: {
    submitForm() {
      console.log(this.form)
      this.$refs.form.validate(valid => {
        if (valid) {
          // 发送登录请求
          axios.post('/SearchUserBy',
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
                  this.userdata=[];
                  this.userdata=response.data;
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
    resetform(){
      document.getElementById("searchform").reset();
    },
    // handleRowClick(row){
    //   localStorage.setItem('row_info',row)
    //   console.log(row);
    // },
    handleEdit(e) {
      console.log(e)

      this.$router.push(
          {
            name:'ManagerRole',
            params:{
              e
            }
          }
      );
      },
    handleDelete(e){
      console.log(e)

      this.$router.push(
          {
            name:'DeleteUser',
            params:{
              e
            }
          }
      );
    },
    load(){
      this.$refs.form.validate(valid => {
        if (valid) {
          // 发送登录请求
          axios.get("/SearchUser")
              .then(response => {
                this.userdata=[];
                this.userdata=response.data;
                var role = this.userdata[1].roleID
                console.log(role)
                for( var i =0;i++;i<((this.userdata).getLength())){
                  var role = this.userdata[i].roleID
                  console.log(role)
                  if(role === 1){
                    this.prop.role = "超级管理员"
                  }
                }
                console.log(this.userdata)
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
  }
}
</script>