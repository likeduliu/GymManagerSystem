<template>
    <el-container style="border: 1px solid #eee">
        <el-container>
            
            <el-main>
                <h2>公告列表<el-button @click="addNotice" type="primary" size="mini" style="margin-left: 20px;">添加</el-button></h2>
                <el-table :data="fieldnotice" style="width: 100%" height="300">
                  <el-table-column prop="fieldnoticetitle" label="标题"></el-table-column>
                  <el-table-column prop="fieldnoticebody" label="内容"></el-table-column>
                  <el-table-column label="操作">
                    <template slot-scope="scope">
                      <el-button @click="editNotice(scope.row.fieldnoticeid)" type="primary" size="small">编辑</el-button>
                      <el-button @click="deleteNotice(scope.row.fieldnoticeid)" type="danger" size="small">删除</el-button>
                    </template>
                  </el-table-column>
                </el-table>

                <h2>添加/编辑公告</h2>
                 <el-form ref="noticeForm" :model="currentNotice" label-width="80px" style="max-width: 500px">
                   <el-form-item label="标题" required>
                     <el-input v-model="currentNotice.fieldnoticetitle"></el-input>
                   </el-form-item>
                   <el-form-item label="内容" required>
                     <el-input type="textarea" v-model="currentNotice.fieldnoticebody" rows="5"></el-input>
                   </el-form-item>
                   <el-form-item>
                     <el-button type="primary" @click="saveNotice">{{ editingIndex === -1 ? '添加' : '保存' }}</el-button>
                   </el-form-item>
                 </el-form>

            </el-main>


        </el-container>
    </el-container>
</template>


<script>
    import axios from 'axios';
    export default {
        data() {
    return {
      editingIndex :-1,
      fieldnotice: [],
      currentNotice: {
        fieldnoticeid:'',
        fieldnoticetitle: '',
        fieldnoticebody: ''
      }
    };
  },
        methods: {
            editNotice(fieldnoticeid){
                var that = this
                 axios.get("http://localhost:8082/field/NoticeEdit/"+fieldnoticeid).then(function (resp) {
                    that.currentNotice = resp.data                 
                } )  
                this.editingIndex=1;                             
            },
            saveNotice(){
                if(this.editingIndex===1){
                    axios.post("http://localhost:8082/field/UpdateFieldNotice",this.currentNotice)
                    .then(response => { //更新数据
                        this.update()
                    })
                    .catch(error => {
                    console.error(error);
                    });                 
                }else{
                    axios.post("http://localhost:8082/field/AddFieldNotice",this.currentNotice)
                    .then(response => { //更新数据
                        this.update()
                    })
                    .catch(error => {
                    console.error(error);
                    });                

                }

            },
            update(){
                var that = this
                axios.get("http://localhost:8082/field/Notice").then(function (resp) {
                    that.fieldnotice = resp.data                 
                }
            )
            },
            deleteNotice(fieldnoticeid){
                var that = this
                 axios.get("http://localhost:8082/field/NoticeDelete/"+fieldnoticeid)
                 .then(response => { //更新数据
                        this.update()
                    })
                    .catch(error => {
                    
                    console.error(error);
                    });  
            },
            addNotice(){
                this.currentNotice.fieldnoticeid=null
                this.currentNotice.fieldnoticebody=""
                this.currentNotice.fieldnoticetitle=""
                this.editingIndex = -1
            }

            
        },
        created() {
            var that = this
            axios.get("http://localhost:8082/field/Notice").then(function (resp) {
                    that.fieldnotice = resp.data                 
                }
            )
        },
        mounted() {
          this.$nextTick(() => {
            // 在 DOM 更新后执行布局操作
            this.$refs.noticeForm.doLayout();
          });
        },


    }
</script>
