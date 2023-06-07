<template>
    <el-container style="height: 560px; border: 1px solid #eee">
        <el-container>
          
            <el-main>
                <el-table :data="combinedData">
                    <el-table-column prop="reservation_id" label="预约编号" width="120">
                    </el-table-column>
                    <el-table-column prop="fieldid" label="场地编号" width="100">
                    </el-table-column>
                    <el-table-column  label="预约日期" width="120">
                      <template slot-scope="scope1">
                                            <div>{{ scope1.row.reservation_date | formatDate }}</div>
                            </template>
                    </el-table-column>
                    <el-table-column prop="starttime" label="预约开始时间" width="120">
                    </el-table-column>
                    <el-table-column prop="endtime" label="预约结束时间" width="120">
                    </el-table-column>
                    <el-table-column prop="hour" label="预约时长" width="120">
                    </el-table-column>
                    <el-table-column prop="rate" label="场地收费标准">
                    </el-table-column>
                    <el-table-column prop="" label="应付费用">
                      <template slot-scope="scope">
                          {{ scope.row.rate * scope.row.hour }}
                        </template>
                    </el-table-column>
                    
                </el-table>   
            </el-main>


        </el-container>
    </el-container>
</template>


<script>  
import axios from 'axios'
    export default {
        data() {
    return {
      reservations:[],
      fields:[],
    
  }
  
                                 
    },
    created() {
            var that = this
            axios.get("http://localhost:8080/field/Coast").then(function (resp) {
                    that.reservations = resp.data
                }
            )


            axios.get("http://localhost:8080/field/").then(function (resp) {
                    that.fields = resp.data
                }
            )

            this.combineData = [...this.reservations, ...this.fields.rate];
        
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



            //把2个数据源结合起来
            computed: {
              combinedData() {
                return this.reservations.map((reservation) => {
                  const field = this.fields.find((f) => f.fieldid === reservation.fieldid);
                  return {
                    ...reservation,
                    rate: field ? field.rate : null,
                  };
                });
              },
            },


    
  }
</script>
