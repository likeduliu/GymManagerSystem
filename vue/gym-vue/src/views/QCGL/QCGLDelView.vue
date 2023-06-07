<template>
    <el-container style="height: 560px; border: 1px solid #eee">
        <el-container>           
            <el-main>
                <template>
                    
                        <el-table :data="equipments" stripe style="width: 100%">
                            <el-table-column prop="equipmentid" label="器材编号" width="180">
                            </el-table-column>
                            <el-table-column prop="equipmentname" label="器材名称" >
                            </el-table-column>
                            <el-table-column prop="amount" label="器材数量" width="120">
                            </el-table-column>
                            <el-table-column  prop="state" label="器材状态" >
                            <template slot-scope="scope">{{scope.row.state == 2? "不可租用" : "可租用"}}</template>
                            </el-table-column>
                            <el-table-column v-slot="scope">
                                <el-form size="mini">
                                    <el-form-item style="margin: 0;">
                                        <el-button class="del" @click="del(scope.row.equipmentid)" size="mini" >删除</el-button>
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
     
        data() {
            return {
                equipments: []
                
            }
        },
      
        methods:{
        del(equipmentid){
           
            axios.delete("http://localhost:8080/equipment/Del/"+equipmentid)
            .then(response => {
                    this.updated()
                    
                })
                .catch(error => {
          
                console.error(error);
                });
            
        },
        updated(){
            var that = this
            axios.get("http://localhost:8080/equipment/").then(function (resp) {
                    that.equipments = resp.data
                }
            )
        }
        
        },
        created() {
            var that = this
            axios.get("http://localhost:8080/equipment/").then(function (resp) {
                    that.equipments = resp.data
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