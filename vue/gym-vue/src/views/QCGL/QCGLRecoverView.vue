<template>
    <el-container style="height: 560px; border: 1px solid #eee">

        <el-container>

            <el-main>                
                  <el-table :data="equipmentrecovers" >
                     <el-table-column prop="bookid" label="租用编号" width="140">                       
                    </el-table-column>
                    <el-table-column prop="equipmentid" label="租用器材编号" width="120">
                    </el-table-column>
                     <el-table-column prop="bookusername" label="租用人姓名" width="120">
                    </el-table-column>
                    <el-table-column prop="bookamount" label="租用器材数量" width="120">
                    </el-table-column>
                   <el-table-column prop="bookstarttime" label="租用开始日期" width="150">
                    </el-table-column>
                   <el-table-column prop="bookendtime" label="租用结束日期" >
                    </el-table-column>
                     
                     <el-table-column v-slot="scope">
                                <el-form size="mini">
                                    <el-form-item style="margin: 0;">
                                        <el-button class="del" @click="del(scope.row.bookid)" size="mini" >已回收</el-button>
                                    </el-form-item>
                                </el-form>
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
                
            }
        },
                

        methods:{
             del(bookid){
           
            axios.delete("http://localhost:8080/equipment/Recover/"+bookid)
            .then(response => {
                    this.updated()
                    
                })
                .catch(error => {
          
                console.error(error);
                });
            
        },
        updated(){
            var that = this
            axios.get("http://localhost:8080/equipment/Recover/").then(function (resp) {
                    that.equipmentrecovers = resp.data
                }
            )
        }
        
            
        },
        created() {
            var that = this
            axios.get("http://localhost:8080/equipment/Recover/").then(function (resp) {
                    that.equipmentrecovers = resp.data
                }
            )
        },
          
       
        
       
        //  updated(){
        //     var that = this
        //     axios.get("http://localhost:8080/equipment/Recover").then(function (resp) {
        //             that.equipmentrecovers = resp.data
        //         }
        //     )
        // },
       
        


        
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