
import { compileFunction } from 'vm';

<template>
    <el-container style="height: 560px; border: 1px solid #eee">
        <el-container>
            <el-main>
                <template>
                    <el-table :data="competitions" stripe style="width: 100%;">
                        <el-table-column prop="competitionid" lable="比赛编号" width="180">
                        </el-table-column>
                        <el-table-column prop="competitionName" lable="比赛名称" width="400">
                        </el-table-column>
                        <el-table-column v-slot="scope">
                            <el-form size="mini">
                                <el-form-item style="margin: 0;">
                                    <el-button class="del" @click="del(scope.row.competitionid)" size="mini" >删除</el-button>
                                </el-form-item>
                            </el-form>
                        </el-table-column>
                    </el-table>
                </template>
            </el-main>
        </el-container>
    </el-container>
</template>

<script>
import axios from 'axios'
    export default{
        name: "ssglcompetition",
        data(){
            return{
                competitions:[]
            }
        },

        methods:{
            del(competitionid){
                axios.delete("http://localhost:9093/competition/Del/"+competitionid)
            .then(response => {
                    this.updatedate()
                })
                .catch(error => {
          
                console.error(error);
                });
            }},
            created() {
            var that = this
            axios.get("http://localhost:9093/competition").then(function (resp) {
                    that.competitions = resp.data
                }
            )
        },
        updatedate(){
            var that = this
            axios.get("http://localhost:9093/competition").then(function (resp) {
                    that.competitions = resp.data
                }
            )
        }
    }
</script>