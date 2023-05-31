<template>
    <el-container style="height: 560px; border: 1px solid #eee">
       
        <el-container>
            <el-header style="text-align: right; font-size: 12px">
                <span class="fl">场地收费标准查询</span>
                <el-dropdown>
                    <i class="el-icon-setting" style="margin-right: 15px"></i>
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item>个人资料</el-dropdown-item>
                        <el-dropdown-item>退出</el-dropdown-item>
                        <el-dropdown-item>更换账号</el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
                <span>admin</span>
            </el-header>


            <el-main>
                <el-table :data="tableData">
                    <el-table-column label="添加场地" width="140">
                    </el-table-column>
                    <el-table-column prop="name" label="姓名" width="120">
                    </el-table-column>
                    <el-table-column prop="address" label="地址">
                    </el-table-column>
                </el-table>
                
            </el-main>


        </el-container>
    </el-container>
</template>


<script>
  

    export default {
        methods: {
            handleSizeChange(val) {
                console.log(`每页 ${val} 条`);
            },
            handleCurrentChange(val) {
                console.log(`当前页: ${val}`);
            }
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