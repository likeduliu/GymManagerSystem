<template>
    <el-container style="height: 560px; border: 1px solid #eee">

        <el-container>

            <el-main>                
                        <el-form :inline="true" model="newfield" class="demo-form-inline">
                            <el-form-item label="场地名称">
                            <el-input  v-model="newfield.fieldName" placeholder="场地名称"></el-input>
                            <el-input  v-model="newfield.book" v-show="false" value="2"></el-input>
                            </el-form-item>
                            <el-form-item label="收费标准">
                                <el-select  v-model="newfield.rate" placeholder="收费标准">
                                <el-option label="10元/小时" value="10"></el-option>
                                <el-option label="20元/小时" value="20"></el-option>
                                <el-option label="30元/小时" value="30"></el-option>
                                <el-option label="40元/小时" value="40"></el-option>
                                <el-option label="50元/小时" value="50"></el-option>
                                </el-select>
                            </el-form-item>
                            <el-form-item label="场地种类">
                            <el-select  v-model="newfield.kind" placeholder="场地种类">
                            <el-option label="篮球场" value="篮球场"></el-option>
                            <el-option label="羽毛球场" value="羽毛球场"></el-option>
                            </el-select>
                            </el-form-item>

                            <el-form-item>
                            <el-button type="primary" @click="onSubmit">添加</el-button>
                            </el-form-item>
                        </el-form>
                    
                    <el-table :data="fields" >
                        <el-table-column prop="fieldName" label="场地名称" width="120">
                        </el-table-column>
                        <el-table-column prop="fieldid" label="场地编号" width="140">                       
                        </el-table-column>                        
                        <el-table-column  prop="book" label="预约状态" width="120">
                            <template slot-scope="scope">{{scope.row.book == 1 ? "已预约" : "可预约"}}</template>
                        </el-table-column>
                        <el-table-column prop="kind" label="类型" width="120" >
                        </el-table-column>
                        <el-table-column prop="rate" label="收费标准 ：元/小时" >
                        </el-table-column>

                    </el-table>

            </el-main>


        </el-container>
    </el-container>
</template>


<script>
   import axios from 'axios';


   export default {
        name: "cdglField",
        data() {
            return {
                fields: [],
                newfield:{
                    fieldName:'',
                    kind:'',
                    book:'2',
                    rate:'',
                }
            }
        },


        methods:{
            onSubmit(){
                const field={
                    fieldName:this.fieldName,
                    kind:this.kind,
                    book:this.book,
                }
                axios.post("http://localhost:8080/field/Add",this.newfield)
                .then(response => { //更新数据
                    this.updatedate()
                })
                .catch(error => {
          
                console.error(error);
                });                     
            }
            
        },
        created() {
            var that = this
            axios.get("http://localhost:8080/field/").then(function (resp) {
                    that.fields = resp.data
                }
            )
        },
        updated(){
            var that = this
            axios.get("http://localhost:8080/field/").then(function (resp) {
                    that.fields = resp.data
                }
            )
        }
  }
</script>
