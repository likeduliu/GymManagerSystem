<template>
    <el-container style="height: 560px; border: 1px solid #eee">
        
        <el-container>
        
            <el-main>
                <el-table :data="fields">
                    <el-table-column prop="fieldName" label="场地名称" width="140">
                    </el-table-column>
                    <el-table-column prop="bookusername" label="预约者" width="120">
                    </el-table-column>
                    <el-table-column  label="预约开始时间">
                        <template slot-scope="scope">
                                <div>{{ fields[scope.row.fieldid].bookstarttime | formatDate }}</div>
                        </template>
                    </el-table-column>
                    <el-table-column prop="bookendtime" label="预约结束时间">
                        <template slot-scope="scope">
                                <div>{{ fields[scope.row.fieldid].bookendtime | formatDate }}</div>
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
          bookstarttime:'',
          bookendtime:'',
          bookusername:'',
          fieldid:'',
          fieldName:'',
          kind:'',
          rate:'',
          book:''
        },
        fields: [],
        
        
      };
    },
        methods: {
          
             
           
        },
        created() {
            var self = this
            const dateString=''
            axios.get("http://localhost:8080/field/Booked").then(function (resp) {
                    self.fields = resp.data;
                                        
                    
                },
               
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
