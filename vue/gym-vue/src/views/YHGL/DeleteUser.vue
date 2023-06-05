<script>

</script>

<template>
  <div>
    <el-form ref="form" :model="form" label-width="200px">
      <el-form-item label="学号/教职工号">
        <p>{userid}</p>
      </el-form-item>

      <el-form-item label="姓名">
        <p>{name}</p>
      </el-form-item>

      <el-form-item label="所属院系/单位">
        <p>{depaterment}</p>
      </el-form-item>

      <el-form-item label="身份证号">
        <p>{id}</p>
      </el-form-item>

      <el-form-item label="联系电话">
        <p>{phone}</p>
      </el-form-item>

      <el-form-item label="住址">
        <p>{address}</p>
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
      }
    }
  },
  methods: {
    onSubmit() {
      console.log('submit!');
    },
    backwards(){
      this.$router.push("SearchUser");
    }
  }
}
</script>