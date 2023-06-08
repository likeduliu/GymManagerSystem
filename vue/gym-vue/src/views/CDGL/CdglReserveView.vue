<template>
    <el-container style="height: 560px; border: 1px solid #eee">
       
        <el-container>
            
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