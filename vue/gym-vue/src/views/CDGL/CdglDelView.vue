<template>
    <el-container style="height: 560px; border: 1px solid #eee">
        <el-container>           
            <el-main>              
                        <el-table :data="fields">
                            <el-table-column prop="fieldid" label="编号" width="180" >
                            </el-table-column>
                            <el-table-column prop="fieldName" label="场地" width="400" >
                            </el-table-column>
                            <el-table-column v-slot="scope">
                                <el-form style=" margin: 0;">
                                    <el-form-item style="margin: 0;">
                                        <el-button class="del" @click="del(scope.row.fieldid)" size="mini">删除</el-button>
                                    </el-form-item>
                                </el-form>
                            </el-table-column>
                     </el-table>
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
                loading:true,
                fields: []               
            }
        },
        
        methods:{
        del(fieldid){ 

                const that=this;
            axios.delete("http://localhost:8082/field/reservationExits/"+fieldid)
            .then(function(resp){
                if (resp.data===true){
                    axios.delete("http://localhost:8082/field/Del/"+fieldid)
                    .then(response => {
                        that.updated()
                        that.$message({
                                  message: '删除成功',
                                  type: 'success'
                                });
                    })
                    .catch(error => {
                        console.error(error);
                    });
                }
                else if(resp.data===false){
                    that.$confirm('您要删除的场地还有预约记录, 是否继续?', '提示', {
                      confirmButtonText: '确定',
                      cancelButtonText: '取消',
                      type: 'warning'
                    })
                    .then(() => {
                        axios.delete("http://localhost:8082/field/Del/"+fieldid)
                            .then(response => {
                                that.updated()
                                that.$message({
                                          message: '删除成功',
                                          type: 'success'
                                        });
                            })
                            .catch(error => {
                                console.error(error);
                            });
                      console.log('用户点击了确认按钮');
                    })
                    .catch(() => {
                      console.log('用户点击了取消按钮或关闭对话框');
                    });   
                }
            })
            
        },
        updated(){
            var that = this
            axios.get("http://localhost:8082/field/").then(function (resp) {
                    that.fields = resp.data
                }
            )
        }
    
    
    },
        created() {
            var that = this
            axios.get("http://localhost:8082/field/").then(function (resp) {
                    that.fields = resp.data
                    
                }
            )
        },
       
        
    }
</script>
<style>
.el-table__row {
  height: 30px;
}
</style>

