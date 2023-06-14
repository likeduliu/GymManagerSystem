<template>
    <el-container style="height: 560px; border: 1px solid #eee">
        
        <el-container>
            <el-main>
                 <el-form :inline="true" model="book" class="demo-form-inline">
                 <el-form-item label="器材编号">
                            <el-input  v-model="book.equipmentid" placeholder="器材编号"></el-input>      
                            </el-form-item>
                             <el-form-item>
                            <el-button type="primary" @click="onSubmit">查询</el-button>
                            </el-form-item>
               
                 </el-form>
                 
                <el-table :data="equipments" >
                     <el-table-column prop="equipmentid" label="器材编号" width="140">                       
                    </el-table-column>
                    <el-table-column prop="equipmentname" label="器材名称" width="120">
                    </el-table-column>
                    <el-table-column prop="amount" label="器材数量" width="120">
                    </el-table-column>
                     <el-table-column prop="rate" label="器材收费标准" width="120">
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
                    book:{
                      equipmentid: '',
                } 
            }
        },
        methods:{
            
         onSubmit(){
            // var that=this
            var equipmentid=this.book.equipmentid
            console.log(equipmentid)
            axios.get("http://localhost:8080/equipment/QueryRate/"+equipmentid )
                .then(response => { //更新数据
                   this.equipments = response.data;
                               

                  
                })
                .catch(error => {
          
                console.error(error);
                });  
         },
       
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