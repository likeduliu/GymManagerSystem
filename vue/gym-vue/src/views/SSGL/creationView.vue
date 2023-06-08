 <template>
    <el-container style="height: 560px; border: 1px solid #eee">

        <el-container>

            <el-main> 

                <el-form :model="newcompetition">
                <el-form-item label="比赛名称">
                    <el-input v-model="newcompetition.competitionName" placeholder="比赛名称"></el-input>  
                </el-form-item>
                <el-form-item label="比赛场地">
                    <el-select v-model="newcompetition.place" placeholder="比赛场地">
                        <el-option label="东区体育场" value="东区体育场"></el-option>
                        <el-option label="西区体育场" value="西区体育场"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="比赛日期">
                    <el-col :span="11">
                        <el-date-picker type="date" placeholder="选择日期" v-model="newcompetition.date" style="width: 100%;"></el-date-picker>
                    </el-col>
                </el-form-item>
                <el-form-item label="开始时间">
                    <el-input v-model="newcompetition.starttime" placeholder="开始时间"></el-input>
                </el-form-item>
                <el-form-item label="结束时间">
                    <el-input v-model="newcompetition.endtime" placeholder="结束时间"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="onSubmit">创建</el-button>
                </el-form-item>
            </el-form>

                <el-table :data="competition">
                    <el-table-column prop="competitionName" label="比赛名称" width="120">
                    </el-table-column>
                    <el-table-column prop="place" label="比赛位置" width="120">
                    </el-table-column>
                    <el-table-column prop="date" label="比赛日期" width="120">
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
// import { createDecipheriv } from 'crypto';
export default {
    name:"ssglcompetition",
    data() {
        return {
            competition: [],
            newcompetition:{
                competitionName:'',
                place:'',
                date:'',
                starttime:'',
                endtime:'',
            }
        }
    },


    methods:{
        onSubmit(){
            const competition={
                competitionName:this.competitionName,
                place:this.place,
                data:this.data,
                starttime:this.starttime,
                endtime:this.endtime,
            }
            axios.post("http://localhost:8080/competition/Add",this.newcompetition)
            .then(response => {//更新数据
                this.updatedate()
            })
            .catch(error => {
                console.error(error);
            });
        }
    },
    created() {
        var that = this
        axios.get("http://localhost:8080/competition/").then(function (resp) {
                    that.competition = resp.data
                }
            )
    },
    updated(){
            var that = this
            axios.get("http://localhost:8080/competition/").then(function (resp) {
                    that.competition = resp.data
                }
            )
        }
}
</script>


