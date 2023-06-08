<template>
    <el-container style="height: 560px;border: 1px solid #eee;">

        <el-container>
             <el-main>
                <el-table :data="competition">
                    <el-table-column prop="competitionid" label="比赛编号" width="140">
                    </el-table-column>
                    <el-table-column prop="competitionName" label="比赛名称" width="120">
                    </el-table-column>
                    <el-table-column prop="place" label="比赛位置" width="120">
                    </el-table-column>
                    <el-table-column prop="data" label="比赛日期" width="120">
                    </el-table-column>
                    <el-table-column prop="starttime" label="开始时间" width="120">
                    </el-table-column>
                    <el-table-column prop="endtime" label="结束时间" width="120">
                    </el-table-column>
                </el-table>
            </el-main>
        </el-container>
     
    </el-container>
</template>
<script>
import axios from 'axios';
export default {
    name: "ssglcompetition",
    data() {
        return {
            competition: []
        }
    },
    created() {
            var that = this
            axios.get("http://localhost:9093/competition").then(function (resp) {
                    that.competition = resp.data
                }
            )
        }
}
</script>