<template>
    <el-container style="height: 560px; border: 1px solid #eee">
        <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
            <el-menu :default-openeds="['2']">
                
                <el-submenu index="1">
                    <template slot="title">用户管理</template>
                </el-submenu>


                <el-submenu index="2">
                    <template slot="title">场地管理</template>
                    <el-menu-item index="1-1">
                        <RouterLink to="/Add"> 添加场地</RouterLink>
                    </el-menu-item>
                    <el-menu-item index="1-2">
                        <RouterLink to="/Del"> 删除场地</RouterLink>
                    </el-menu-item>
                    <el-menu-item index="1-3">
                        <RouterLink to="/Book"> 场地预约</RouterLink>
                    </el-menu-item>
                    <el-menu-item index="1-4">
                        <RouterLink to="/CancleBook"> 场地预约退订</RouterLink>
                    </el-menu-item>
                    <el-menu-item index="1-5">
                        <RouterLink to="/UpdateBook"> 场地预约修改</RouterLink>
                    </el-menu-item>
                    <el-menu-item index="1-6">
                        <RouterLink to="/Reserve"> 校队预留场地</RouterLink>
                    </el-menu-item>
                    <el-menu-item index="1-7">
                        <RouterLink to="/Use"> 使用场地</RouterLink>
                    </el-menu-item>
                    <el-menu-item index="1-8">
                        <RouterLink to="/QueryWeek"> 场地一周信息查询</RouterLink>
                    </el-menu-item>
                    <el-menu-item index="1-9">
                        <RouterLink to="/Rate"> 场地收费标准查询</RouterLink>
                    </el-menu-item>
                    <el-menu-item index="1-10">
                        <RouterLink to="/Notice"> 场地公告管理</RouterLink>
                    </el-menu-item>
                </el-submenu>
                
                <el-submenu index="3">
                    <template slot="title">赛事管理</template>
                </el-submenu>
                <el-submenu index="4">
                    <template slot="title">器材管理</template>
                </el-submenu>
            </el-menu>
        </el-aside>

        <el-container>
            <el-header style="text-align: right; font-size: 12px">
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
    import {RouterLink} from 'vue-router';

    export default {
        name: "cdglField",
        data() {
            return {
                fields: []
            }
        },
        components: {RouterLink},
        created() {
            var that = this
            axios.get("http://localhost:8080").then(function (resp) {
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