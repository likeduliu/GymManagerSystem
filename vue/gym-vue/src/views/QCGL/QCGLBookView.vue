<template>
    <el-container style="height: 560px; border: 1px solid #eee">

        <el-container>

            <el-main>                
                        <el-form :inline="true" model="book" class="demo-form-inline">
                            <el-form-item label="租用器材编号">
                            <el-input  v-model="book.equipmentid" placeholder="租用器材编号"></el-input>
                             
                            </el-form-item>
                            <el-form-item label="租用人姓名">
                            <el-input  v-model="book.bookusername" placeholder="租用人姓名"></el-input>
                            </el-form-item>
                           <el-form-item label="租用器材数量">
                            <el-input  v-model="book.bookamount" placeholder="租用器材数量"></el-input>
                            </el-form-item>

                           

                             <el-form-item label="租用开始日期" prop="bookstarttime">
                            <el-col :span="15">
                            <el-date-picker type="date" placeholder="选择日期"  v-model="book.bookstarttime" style="width: 100%;"></el-date-picker>
                            <!-- <template slot-scope="scope1">
                            <div>{{ scope1.row.book.bookstarttime | formatDate }}</div>
                            </template> -->
                            </el-col>
                        </el-form-item>
                        <el-form-item label="租用结束日期" prop="bookendtime">
                            <el-col :span="15">
                            <el-date-picker  type="date" placeholder="选择日期"  v-model="book.bookendtime" style="width: 100%;"></el-date-picker>
                        <!-- <template slot-scope="scope1">
                            <div>{{ scope1.row.book.bookendtime | formatDate }}</div>
                            </template> -->
                        </el-col>
                        </el-form-item>
                            <el-form-item>
                            <el-button type="primary" @click="onSubmit">租用</el-button>
                            </el-form-item>
                            


                        </el-form>
                    <el-table :data="equipmentbooks" >
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
                equipmentbooks: [],
                book:{
                    equipmenid:'',
                    bookusername:'',
                    bookamount:'',
                    bookstarttime:'',
                    bookendtime:'',
                    
                }
            }
        },
                

        methods:{
            onSubmit(){
                const equipmentbook={
                    equipmenid:this.equipmenid,
                    bookusername:this.bookusername,
                    bookamount:this.bookamount,
                    bookstarttime:this.bookstarttime,
                    bookendtime:this.bookendtime,
                   
                }
                axios.post("http://localhost:8080/equipment/Book",this.book)
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
            axios.get("http://localhost:8080/equipment/Book").then(function (resp) {
                    that.equipmentbooks = resp.data
                }
            )
        },
         updated(){
            var that = this
            axios.get("http://localhost:8080/equipment/Book").then(function (resp) {
                    that.equipmentbooks = resp.data
                }
            )
        },
        // filters: {
        //         formatDate(value) {
        //         const dateObject = new Date(value);
        //         const year = dateObject.getFullYear();
        //         const month = (dateObject.getMonth() + 1).toString().padStart(2, '0');
        //         const day = dateObject.getDate().toString().padStart(2, '0');
        //         return `${year}-${month}-${day}`;
        //         }
        //         },
        


        
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