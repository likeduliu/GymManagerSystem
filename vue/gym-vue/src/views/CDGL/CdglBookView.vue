<template>
    <el-container style="height: 560px; border: 1px solid #eee">
        <el-container>
            <el-main>
                    <el-form ref="bookform" :model="bookform" label-width="110px" size="mini">
                        <el-form-item label="预约者姓名" prop="UserID" hidden>
                            <el-col :span="4">
                            <el-input v-model="bookform.UserID" ></el-input>
                            </el-col>
                        </el-form-item>
                        <el-form-item label="预约日期" prop="reservation_date" >
                            <el-col :span="5">
                            <el-date-picker type="date" placeholder="选择日期" v-model="bookform.reservation_date" :picker-options="datepickerOption"></el-date-picker>
                            </el-col>
                        </el-form-item>

                        <el-form-item label="预约开始时间" prop="bookstarttime">
                           <el-col :span="5">
                             <el-time-select :picker-options="timePickerOptions" placeholder="选择时间" v-model="bookform.starttime" :format="timeFormat"></el-time-select>
                           </el-col>
                        </el-form-item>
                        <el-form-item label="预约结束时间" prop="bookendtime">
                           <el-col :span="5">
                             <el-time-select :picker-options="timePickerOptions" placeholder="选择时间" v-model="bookform.endtime" :format="timeFormat"></el-time-select>
                           </el-col>
                        </el-form-item>
                        
                        <el-form-item prop="fieldid" label="预约场地id" :rules="[
                                  { required: true, message: '场地编号不能为空'},
                                  { type: 'number', message: '场地编号必须为数字值'},
                                  {validator: validateFieldId, trigger: 'blur'}
                                ]">
                            <el-input v-model.number="bookform.fieldid" placeholder="选择要预约场地的id" style="width: 175px;"></el-input>
                        </el-form-item>
        
                    <el-form-item size="large">
                        <el-button type="primary" @click="onSubmit(); updated()">立即预约</el-button>
                        <el-button @click="resetForm('bookform')">清空</el-button>
                    </el-form-item>
                    </el-form>
                     
                    <el-table :data="fields" >
                    <el-table-column type="expand">
                        <template v-slot="scope">
                               <el-button @click="showtime(scope.row.fieldid)" style="margin: 0;" size="mini">刷新</el-button>
                               <el-table :data="reservations">
                                <el-table-column label="预定编号" prop="reservation_id" width="100">
                                </el-table-column>
                                <el-table-column label="预约人" prop="username" width="100">
                                </el-table-column>
                                <el-table-column  label="预约日期" width="100">
                                    <template slot-scope="scope1">
                                            <div>{{ scope1.row.reservation_date | formatDate }}</div>
                                    </template>
                                </el-table-column>
                                <el-table-column label="开始时间" prop="starttime" width="100">
                                </el-table-column>
                                <el-table-column label="结束时间" prop="endtime" >
                                </el-table-column>
                               </el-table>
                        </template>
                    </el-table-column>
                        <el-table-column prop="fieldName" label="场地名称" width="120">
                        </el-table-column>
                        <el-table-column prop="fieldid" label="场地编号" width="140">                       
                        </el-table-column>
                        <el-table-column prop="kind" label="类型" width="120" >
                        </el-table-column>
                        <el-table-column prop="rate" label="收费标准 ：元/小时" width="150">
                        </el-table-column>
                        <el-table-column  prop="location" label="场地位置" >
                            
                        </el-table-column>
                        
                    </el-table>

            </el-main>

        </el-container>
    </el-container>
</template>


<script>
    import axios from 'axios';
    import moment from 'moment';

    export default {
        data() {
      return {
          bookform:{
          reservation_date:'',
          starttime:'',
          endtime:'',
          fieldid:'',
          fieldName:'',
          kind:'',
          rate:'',
          book:'',
          hour:'',
          username:'',
          
        },
        fields: [],
        reservations:[],
        combineData:[],
        timePickerOptions: {
        start: '08:00', // 可选的开始时间
        step: '01:00', // 时间间隔为1小时
        end: '21:00' // 可选的结束时间
       },
       datepickerOption:{
        disabledDate(date) {
          const today = new Date();
          today.setHours(0, 0, 0, 0); // 将时间设为今天的凌晨
          return date < today; // 返回true表示禁用该日期
        },
       },
       timeFormat: 'HH:00' // 时间格式为小时:00
        
      };
    },
    methods: {
        //提交表单
        onSubmit(){
                //const userid=localStorage.getItem('userid')
                
                const starttime=moment(this.bookform.starttime,"HH:mm");
                const endtime=moment(this.bookform.endtime,"HH:mm");

                const hourDiff = endtime.diff(starttime, "hours");
                //console.log(hourDiff);
                this.bookform.hour=hourDiff
                this.bookform.username=localStorage.getItem('loginname')
                // console.log(this.username)
                console.log(localStorage.getItem('loginname'))
                axios.post("http://localhost:8082/field/Book",this.bookform)
                .then(response => { //更新数据

                    this.updated()
                    console.log(response.data)
                    if(response.data==="notExist"){
                        alert("很抱歉，您预约的场地不存在")
                    }
                    else if(response.data==="overbook"){
                        alert("很抱歉，您对多只能预约5个场地")
                    }
                    else if (response.data===false) {
                        alert("很抱歉，您选择的时间和别人冲突了")
                    }else 
                    {
                        alert("恭喜您预约成功！")
                    }
                })
                .catch(error => {
                console.error(error);
                });                     
            },
            //验证id是否可以预约
            validateFieldId(rule, value, callback) {
                 const fieldIds = this.fields.map(field => field.fieldid); // 获取所有场地的fieldid
                 if (fieldIds.includes(value)) {
                   callback();
                 } else {
                   callback(new Error('场地编号不存在或者无法预约'));
                 }
                },

      //重置表单
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      
      updated(){
            var that = this
            axios.get("http://localhost:8082/field/unBook").then(function (resp) {
                    that.fields = resp.data
                }
            )
        },
        showtime(fieldid){
            var that=this
            axios.get("http://localhost:8082/field/unBook2/"+fieldid)
            .then(function (resp) {
                    that.reservations = resp.data
                })
                .catch(error => {
                console.error(error);
                });   
                      
        },
                
    },
    
    created() {
            var that = this
            axios.get("http://localhost:8082/field/unBook").then(function (resp) {
                    that.fields = resp.data
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
