<template>
    <el-container style="height: 560px; border: 1px solid #eee">
        <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
            <el-menu :default-openeds="['1']">
                <el-submenu index="1">
                    <template slot="title">场地管理功能列表</template>
                    <el-menu-item index="1-1">
                        <RouterLink to="/Add"> 添加场地</RouterLink>
                    </el-menu-item>
                    <el-menu-item index="1-2">
                        <RouterLink to="/Del"> 删除场地</RouterLink>
                    </el-menu-item>
                    <el-menu-item index="1-3">
                        <RouterLink to="/Book"> 场地预约</RouterLink>
                    </el-menu-item>
                    <el-menu-item index="1-4">
                        <RouterLink to="/CancleBook"> 场地预约退订</RouterLink>
                    </el-menu-item>
                    <el-menu-item index="1-5">
                        <RouterLink to="/UpdateBook"> 场地预约修改</RouterLink>
                    </el-menu-item>
                    <el-menu-item index="1-6">
                        <RouterLink to="/Reserve"> 校队预留场地</RouterLink>
                    </el-menu-item>
                    <el-menu-item index="1-7">
                        <RouterLink to="/Use"> 使用场地</RouterLink>
                    </el-menu-item>
                    <el-menu-item index="1-8">
                        <RouterLink to="/QueryWeek"> 场地一周信息查询</RouterLink>
                    </el-menu-item>
                    <el-menu-item index="1-9">
                        <RouterLink to="/Rate"> 场地收费标准查询</RouterLink>
                    </el-menu-item>
                    <el-menu-item index="1-10">
                        <RouterLink to="/Notice"> 场地公告管理</RouterLink>
                    </el-menu-item>

                </el-submenu>
            </el-menu>
        </el-aside>

        <el-container>
            <el-header style="text-align: right; font-size: 12px">
                <span class="fl">添加场地</span>
                <el-dropdown>
                    <i class="el-icon-setting" style="margin-right: 15px"></i>
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item>个人资料</el-dropdown-item>
                        <el-dropdown-item>退出</el-dropdown-item>
                        <el-dropdown-item>更换账号</el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
                <span>admin</span>
            </el-header>


            <el-main>
                <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                        <el-form-item label="密码" prop="pass">
                            <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
                        </el-form-item>

                        <el-form-item label="确认密码" prop="checkPass">
                            <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
                        </el-form-item>

                        <el-form-item label="年龄" prop="age">
                            <el-input v-model.number="ruleForm.age"></el-input>
                        </el-form-item>

                        <el-form-item>
                            <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
                            <el-button @click="resetForm('ruleForm')">重置</el-button>
                        </el-form-item>
                        
                </el-form>

            </el-main>


        </el-container>
    </el-container>
</template>


<script>
    import {RouterLink} from 'vue-router';

    export default {
        data() {
      var checkAge = (rule, value, callback) => {
        if (!value) {
          return callback(new Error('年龄不能为空'));
        }
        setTimeout(() => {
          if (!Number.isInteger(value)) {
            callback(new Error('请输入数字值'));
          } else {
            if (value < 18) {
              callback(new Error('必须年满18岁'));
            } else {
              callback();
            }
          }
        }, 1000);
      };
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          if (this.ruleForm.checkPass !== '') {
            this.$refs.ruleForm.validateField('checkPass');
          }
          callback();
        }
      };
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.ruleForm.pass) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };
      return {
        ruleForm: {
          pass: '',
          checkPass: '',
          age: ''
        },
        rules: {
          pass: [
            { validator: validatePass, trigger: 'blur' }
          ],
          checkPass: [
            { validator: validatePass2, trigger: 'blur' }
          ],
          age: [
            { validator: checkAge, trigger: 'blur' }
          ]
        }
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    },
        
        components: {RouterLink}
    }
</script>
<style>
    .el-header {
        background-color: #B3C0D1;
        color: #333;
        line-height: 60px;
    }

    .el-aside {
        color: #333;
    }

    .fl {
        float: left;
    }

    a {
        text-decoration: none;
        color: black;
    }

    .router-link-active {
        text-decoration: none;
        color: black;
    }
</style>