<template>
    <el-container style="height: 560px; border: 1px solid #eee">
        

        <el-container>
            <el-main>
                <el-form ref="form" :model="sizeForm" label-width="110px" size="mini">
                    <el-form-item label="预约者姓名">
                        <el-input v-model="sizeForm.name" ></el-input>
                    </el-form-item>
                    <el-form-item label="预约时间">
                        <el-col :span="11">
                        <el-date-picker type="date" placeholder="选择日期" v-model="sizeForm.date1" style="width: 100%;"></el-date-picker>
                        </el-col>
                        <el-col class="line" span="1">--</el-col>
                        <el-col :span="11">
                        <el-time-picker placeholder="选择时间" v-model="sizeForm.date2" style="width: 100%;"></el-time-picker>
                        </el-col>
                    </el-form-item>
                    
                    
                    <el-form-item size="large">
                        <el-button type="primary" @click="onSubmit">立即预约</el-button>
                        <el-button>清空</el-button>
                    </el-form-item>
                    </el-form>
            </el-main>


        </el-container>
    </el-container>
</template>


<script>
    

    export default {
        data() {
      return {
        sizeForm: {
          name: '',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        }
      };
    },
    methods: {
      onSubmit() {
        console.log('submit!');
      }
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