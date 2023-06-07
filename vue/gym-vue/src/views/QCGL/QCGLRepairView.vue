<template>
    <el-container style="height: 560px; border: 1px solid #eee">

        <el-container>

            <el-main>                
                        <el-form :inline="true" model="repair" class="demo-form-inline">
                            <el-form-item label="维修器材编号">
                            <el-input  v-model="repair.equipmentid" placeholder="维修器材编号"></el-input>      
                            </el-form-item>
                           <el-form-item label="维修器材数量">
                            <el-input  v-model="repair.repairamount" placeholder="维修器材数量"></el-input>
                            </el-form-item>
                            <el-form-item>
                            <el-button type="primary" @click="onSubmit">维修</el-button>
                            </el-form-item>
                            
                        </el-form>
                    <el-table :data="equipmentrepairs" >
                     <el-table-column prop="repairid" label="维修编号" width="140">                       
                    </el-table-column>
                    <el-table-column prop="equipmentid" label="维修器材编号" width="120">
                    </el-table-column>
                    <el-table-column prop="repairamount" label="维修器材数量" >
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
                equipmentrepairs: [],
                repair:{
                    equipmentid:'',
                    repairamount:'',
                   
                    
                }
            }
        },
                

        methods:{
            onSubmit(){
                const equipmentrepair={
                    equipmentid:this.equipmentid,
                    repairamount:this.repairamount,
                    
                   
                   
                }
                axios.post("http://localhost:8080/equipment/Repair",this.repair)
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
            axios.get("http://localhost:8080/equipment/Repair").then(function (resp) {
                    that.equipmentrepairs = resp.data
                }
            )
        },
         updated(){
            var that = this
            axios.get("http://localhost:8080/equipment/Repair").then(function (resp) {
                    that.equipmentrepairs = resp.data
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