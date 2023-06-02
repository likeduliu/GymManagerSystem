<template>
    <el-container style="height: 560px; border: 1px solid #eee">
        <el-container>           
            <el-main>
                <template>
                    
                        <el-table :data="fields" stripe style="width: 100%">
                            <el-table-column prop="fieldid" label="编号" width="180">
                            </el-table-column>
                            <el-table-column prop="fieldName" label="场地" >
                            </el-table-column>
                            <el-table-column v-slot="scope">
                                <el-form size="mini">
                                    <el-form-item style="margin: 0;">
                                        <el-button class="del" @click="del(scope.row.fieldid)" size="mini" >删除</el-button>
                                    </el-form-item>
                                </el-form>
                            </el-table-column>
                    
                     </el-table>
                
                </template>
            </el-main>
        </el-container>
    </el-container>
</template>


<script>
    
    import axios from 'axios'

    export default {
        name: "cdglField",
        data() {
            return {
                fields: []
                
            }
        },
      
        methods:{
        del(fieldid){
           
            axios.delete("http://localhost:8080/field/Del/"+fieldid)
            .then(response => {
            console.log(response.data);
                })
            .catch(error => {
          
            console.error(error);
                });
            
        }},
        created() {
            var that = this
            axios.get("http://localhost:8080/field/").then(function (resp) {
                    that.fields = resp.data
                }
            )
        }
        
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