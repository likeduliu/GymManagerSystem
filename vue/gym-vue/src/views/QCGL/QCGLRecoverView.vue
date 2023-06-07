<template>
    <el-container style="height: 560px; border: 1px solid #eee">

        <el-container>

            <el-main>                
                        <el-form :inline="true" model="recover" class="demo-form-inline">
                            <el-form-item label="返还器材编号">
                            <el-input  v-model="recover.equipmentid" placeholder="返还器材编号"></el-input>      
                            </el-form-item>
                            <el-form-item label="返还人姓名">
                            <el-input  v-model="recover.recoverusername" placeholder="返还人姓名"></el-input>
                            </el-form-item>
                           <el-form-item label="返还器材数量">
                            <el-input  v-model="recover.recoveramount" placeholder="返还器材数量"></el-input>
                            </el-form-item>
                            <el-form-item>
                            <el-button type="primary" @click="onSubmit">回收</el-button>
                            </el-form-item>
                            
                        </el-form>
                    <el-table :data="equipmentrecovers" >
                     <el-table-column prop="recoverid" label="返还编号" width="140">                       
                    </el-table-column>
                    <el-table-column prop="equipmentid" label="返还器材编号" width="120">
                    </el-table-column>
                     <el-table-column prop="recoverusername" label="返还人姓名" width="120">
                    </el-table-column>
                    <el-table-column prop="recoveramount" label="返还器材数量" >
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
                equipmentrecovers: [],
                recover:{
                    equipmenid:'',
                    recoverusername:'',
                    recoveramount:'',
                   
                    
                }
            }
        },
                

        methods:{
            onSubmit(){
                const equipmentrecover={
                    equipmenid:this.equipmenid,
                    recoverusername:this.recoverusername,
                    recoveramount:this.recoveramount,
                   
                   
                }
                axios.post("http://localhost:8080/equipment/Recover",this.recover)
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
            axios.get("http://localhost:8080/equipment/Recover").then(function (resp) {
                    that.equipmentrecovers = resp.data
                }
            )
        },
         updated(){
            var that = this
            axios.get("http://localhost:8080/equipment/Recover").then(function (resp) {
                    that.equipmentrecovers = resp.data
                }
            )
        },
       
        


        
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