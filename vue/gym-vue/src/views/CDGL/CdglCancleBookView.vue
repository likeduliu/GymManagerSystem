<template>
    <el-container style="height: 560px; border: 1px solid #eee">
        
        <el-container>
            <el-main>
                
                    <el-table :data="reservations">
                        <el-table-column prop="reservation_id" label="预约编号" width="120">
                        </el-table-column>
                        <el-table-column prop="fieldid" label="场地编号" width="140">                       
                        </el-table-column>
                        <el-table-column label="预约日期" width="120" >
                            <template slot-scope="scope1">
                                            <div>{{ scope1.row.reservation_date | formatDate }}</div>
                            </template>
                        </el-table-column>
                        <el-table-column prop="starttime" label="预约开始时间" width="120">
                        </el-table-column>
                        <el-table-column  prop="endtime" label="预约结束" >
                        </el-table-column>
                        <el-table-column>
                            <template slot-scope="scope">
                                <el-button @click="canclebook(scope.row.reservation_id)">取消预约</el-button>
                            </template>
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
          bookform:{
          starttime:'',
          endtime:'',
          bookusername:'',
          fieldid:'',
          fieldName:'',
          kind:'',
          rate:'',
          book:'',
          reservation_id:''
        },
        reservations: []
      };
    },
    methods:{
        canclebook(reservation_id){
            axios.post("http://localhost:8082/field/CancleBook/"+reservation_id)
            .then(response => {
                    this.update()
                })
                .catch(error => {
                console.error(error);
                });
        },
        update(){
            var that = this
            axios.get("http://localhost:8082/field/Booked").then(function (resp) {
                    that.reservations = resp.data
                }
            )
        },
    },
    
    created() {
            var that = this
            axios.get("http://localhost:8082/field/Booked").then(function (resp) {
                    that.reservations = resp.data
                }
            )
        },

    filters: {
            formatDate(value) {
                const dateObject = new Date(value);
                const year = dateObject.getFullYear();
                const month = (dateObject.getMonth() + 1).toString().padStart(2, '0');
                const day = dateObject.getDate().toString().padStart(2, '0');
                return `${year}-${month}-${day}`;
              }
            },

    }
</script>
