<template>
    <el-container style="height: 560px; border: 1px solid #eee">

        <el-container>

            <el-main>                
                        <el-form :inline="true" model="book" class="demo-form-inline">
                            <el-form-item label="租用器材编号">
                            <el-input  v-model="book.equipmentid" placeholder="租用器材编号"></el-input>
                             
                            </el-form-item>
                            <el-form-item label="租用人姓名">
                            <el-input  v-model="book.bookusername" placeholder="租用人姓名" :disabled="true"></el-input>
                            </el-form-item>
                           <!-- <el-form-item label="租用器材数量">
                            <el-input  v-model="book.bookamount" placeholder="租用器材数量" ></el-input>
                            </el-form-item> -->
                            <el-form-item label="租用器材数量">
                            <el-input-number v-model="book.bookamount" @change="handleChange" :min="1" :max="10" label="租用器材数量"></el-input-number>
                            </el-form-item> 

                             <el-form-item label="租用开始日期" prop="bookstarttime">
                            <el-col :span="15">
                            <el-date-picker type="date" placeholder="选择日期"  v-model="book.bookstarttime" style="width: 100%;"></el-date-picker>
                           
                            </el-col>
                        </el-form-item>
                        <el-form-item label="租用结束日期" prop="bookendtime">
                            <el-col :span="15">
                            <el-date-picker  type="date" placeholder="选择日期"  v-model="book.bookendtime" style="width: 100%;"></el-date-picker>
                        
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
                    equipmentid:'',
                    bookusername:'',
                    bookamount:'',
                    bookstarttime:'',
                    bookendtime:'',
                    userID:'',
                    
                }
            }
        },
                

        methods:{
            onSubmit(){
                const username = String(localStorage.getItem('loginname'))
                const userid = localStorage.getItem('loginuserid')
                const obj = JSON.parse(userid)
                this.book.userID=obj
                console.log(obj)
                // console.log(this.book.userID)
                // console.log(username)
                // console.log(userid)
               
                console.log(this.book)
                axios.post("http://localhost:8080/equipment/Book",this.book )
                .then(response => { //更新数据
                    this.updated()
                  
                })
                .catch(error => {
          
                console.error(error);
                });  
                                   
            },
              updated(userID){
            var that = this
            const username = localStorage.getItem('loginname')
            this.book.bookusername = username
            const userid = localStorage.getItem('loginuserid')
                const obj = JSON.parse(userid)
                userID=obj
            axios.get("http://localhost:8080/equipment/Book/"+userID).then(function (resp) {
                    that.equipmentbooks = resp.data
                }
            )

        },
        handleChange(value) {
        console.log(value);
      }

            
            
        },
        
        created(userID) {
            var that = this
            const username = localStorage.getItem('loginname')
            this.book.bookusername = username
            const userid = localStorage.getItem('loginuserid')
                const obj = JSON.parse(userid)
                userID=obj
            axios.get("http://localhost:8080/equipment/Book/"+userID).then(function (resp) {
                    that.equipmentbooks = resp.data
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