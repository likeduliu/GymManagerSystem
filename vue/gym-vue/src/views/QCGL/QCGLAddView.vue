<template>
    <el-container style="height: 560px; border: 1px solid #eee">

        <el-container>

            <el-main>                
                        <el-form :inline="true" model="newequipment" class="demo-form-inline">
                            <el-form-item label="器材名称">
                            <el-input  v-model="newequipment.equipmentname" placeholder="器材名称"></el-input>
                             <el-input  v-model="newequipment.state" v-show="false" value="1"></el-input>
                             
                            </el-form-item>
                            <el-form-item>
                           <el-input  v-model="newequipment.amount" placeholder="器材数量"></el-input>
                            </el-form-item>
                            <el-form-item>
                            <el-button type="primary" @click="onSubmit">添加</el-button>
                            </el-form-item>
                            


                        </el-form>
                    <el-table :data="equipments" >
                     <el-table-column prop="equipmentid" label="器材编号" width="140">                       
                    </el-table-column>
                    <el-table-column prop="equipmentname" label="器材名称" width="120">
                    </el-table-column>
                    <el-table-column prop="amount" label="器材数量" width="120">
                    </el-table-column>
                    <el-table-column  prop="state" label="器材状态" >
                         <template slot-scope="scope">{{scope.row.state == 2? "不可租用" : "可租用"}}</template>
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
                equipments: [],
                newequipment:{
                    equipmentname:'',
                    state:'1',
                    amount:'',
                    
                }
            }
        },


        methods:{
            onSubmit(){
                const equipment={
                    equipmentname:this.equipmentname,
                    state:this.state,
                    amount:this.amount,
                   
                }
                axios.post("http://localhost:8080/equipment/Add",this.newequipment)
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
            axios.get("http://localhost:8080/equipment/").then(function (resp) {
                    that.equipments = resp.data
                }
            )
        },
        updated(){
            var that = this
            axios.get("http://localhost:8080/equipment/").then(function (resp) {
                    that.equipments = resp.data
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