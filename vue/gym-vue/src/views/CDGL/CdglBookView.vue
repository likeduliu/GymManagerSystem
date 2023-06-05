<template>
    <el-container style="height: 560px; border: 1px solid #eee">
        <el-container>
            <el-main>
                    <el-form ref="bookform" :model="bookform" label-width="110px" size="mini">
                        <el-form-item label="预约者姓名" prop="bookusername">
                            <el-col :span="10">
                            <el-input v-model="bookform.bookusername" ></el-input>
                            </el-col>
                        </el-form-item>
                        <el-form-item label="预约开始日期" prop="bookstarttime">
                            <el-col :span="5">
                            <el-date-picker type="date" placeholder="选择日期" v-model="bookform.bookstarttime" style="width: 100%;"></el-date-picker>
                            </el-col>
                        </el-form-item>
                        <el-form-item label="预约结束日期" prop="bookendtime">
                            <el-col :span="5">
                            <el-date-picker type="date" placeholder="选择日期" v-model="bookform.bookendtime" style="width: 100%;"></el-date-picker>
                        </el-col>
                        </el-form-item>
                        <el-form-item prop="fieldid" label="预约场地id" :rules="[
                                  { required: true, message: '场地编号不能为空'},
                                  { type: 'number', message: '场地编号必须为数字值'},
                                  {validator: validateFieldId, trigger: 'blur'}
                                ]">
                            <el-input v-model.number="bookform.fieldid" placeholder="选择要预约场地的id" style="width: 175px;"></el-input>
                        </el-form-item>
        
                    <el-form-item size="large">
                        <el-button type="primary" @click="onSubmit(); updated()">立即预约</el-button>
                        <el-button @click="resetForm('bookform')">清空</el-button>
                    </el-form-item>
                    </el-form>
                    

                    <el-table :data="fields">
                        <el-table-column prop="fieldName" label="场地名称" width="120">
                        </el-table-column>
                        <el-table-column prop="fieldid" label="场地编号" width="140">                       
                        </el-table-column>
                        <el-table-column prop="kind" label="类型" width="120" >
                        </el-table-column>
                        <el-table-column prop="rate" label="收费标准 ：元/小时" width="150">
                        </el-table-column>
                        <el-table-column  prop="book" label="预约状态" >
                            <template slot-scope="scope">{{scope.row.book == 1 ? "已预约" : "可预约"}}</template>
                        </el-table-column>
                        
                    </el-table>

            </el-main>

        </el-container>
    </el-container>
</template>


<script>
    import axios from 'axios';

    export default {
        data() {
      return {
          bookform:{
          bookstarttime:'',
          bookendtime:'',
          bookusername:'',
          fieldid:'',
          fieldName:'',
          kind:'',
          rate:'',
          book:''
        },
        fields: []
      };
    },
    methods: {
        //提交表单
        onSubmit(){
                const field={
                    fieldName:this.fieldName,
                    kind:this.kind,
                    book:this.book,
                }
                axios.post("http://localhost:8080/field/Book",this.bookform)
                .then(response => { //更新数据
                    this.updatedate()
                })
                .catch(error => {
          
                console.error(error);
                });                     
            },
            //验证id是否可以预约
            validateFieldId(rule, value, callback) {
                 const fieldIds = this.fields.map(field => field.fieldid); // 获取所有场地的fieldid
                 if (fieldIds.includes(value)) {
                   callback();
                 } else {
                   callback(new Error('场地编号不存在或者无法预约'));
                 }
                },

      //重置表单
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      
      
    },
    //更新数据信息
    updated(){
            var that = this
            axios.get("http://localhost:8080/field/unBook").then(function (resp) {
                    that.fields = resp.data
                }
            )
        },
    created() {
            var that = this
            axios.get("http://localhost:8080/field/unBook").then(function (resp) {
                    that.fields = resp.data
                }
            )
        },
        
        
    }
</script>
