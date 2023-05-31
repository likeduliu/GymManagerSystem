<template>
    <el-container style="height: 560px; border: 1px solid #eee">
        
        <el-container>
            <el-main>
                <el-table :data="fields" >
                    <el-table-column prop="fieldName" label="场地名称" width="120">
                    </el-table-column>
                    <el-table-column prop="fieldid" label="场地编号" width="140">                       
                    </el-table-column>
                    <el-table-column prop="fieldName" label="场地名称" width="120">
                    </el-table-column>
                    <el-table-column  prop="book" label="预约状态" width="120">
                        <template slot-scope="scope">{{scope.row.book == 1 ? "已预约" : "可预约"}}</template>
                    </el-table-column>
                    <el-table-column prop="kind" label="类型" width="120" >
                    </el-table-column>
                    <el-table-column prop="rate" label="收费标准" >
                    </el-table-column>

                </el-table>
            </el-main>


        </el-container>
    </el-container>
</template>


<script>
    import axios from 'axios';
    export default {
        name: "cdglField",
        data() {
            return {
                fields: []
            }
        },
        created() {
            var that = this
            axios.get("http://10.144.20.209:8080").then(function (resp) {
                    that.fields = resp.data

                }
            )
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