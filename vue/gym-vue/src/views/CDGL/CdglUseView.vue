<template>
    <el-container style="height: 560px; border: 1px solid #eee">
        <el-container>
          
            <el-main>
                <el-table :data="tableData">
                    <el-table-column label="场地费用结算" width="140">
                    </el-table-column>
                    <el-table-column prop="name" label="姓名" width="120">
                    </el-table-column>
                    <el-table-column prop="address" label="地址">
                    </el-table-column>
                </el-table>
                <template>
                  <div>
                    <p>计时器：{{ formattedTime }}</p>
                        <button @click="startTimer" :disabled="isTimerRunning">开始</button>
                        <button @click="pauseTimer" :disabled="!isTimerRunning">暂停</button>
                        <button @click="endTimer" :disabled="!isTimerRunning">结束</button>
                        <p>费用：{{ calculateFee() }}</p>
                  </div>
                </template>

                
            </el-main>


        </el-container>
    </el-container>
</template>


<script>  
    export default {
        data() {
    return {
      startTime: null, // 计时器开始时间
      endTime: null, // 计时器结束时间
      isTimerRunning: false // 计时器是否正在运行
    };
  },
  computed: {
    formattedTime() {
      if (this.startTime && !this.endTime) {
        // 计时器正在运行中
        const currentTime = new Date().getTime();
        const elapsedMilliseconds = currentTime - this.startTime;
        return this.formatTime(elapsedMilliseconds);
      } else if (this.startTime && this.endTime) {
        // 计时器已结束
        const elapsedMilliseconds = this.endTime - this.startTime;
        return this.formatTime(elapsedMilliseconds);
      } else {
        // 计时器未开始
        return '00:00:00';
      }
    }
  },
        methods: {
            formatTime(milliseconds) {
              const seconds = Math.floor((milliseconds / 1000) % 60);
              const minutes = Math.floor((milliseconds / (1000 * 60)) % 60);
              const hours = Math.floor((milliseconds / (1000 * 60 * 60)) % 24);
              return `${this.padTime(hours)}:${this.padTime(minutes)}:${this.padTime(seconds)}`;
            },
            padTime(time) {
              return time.toString().padStart(2, '0');
            },
            startTimer() {
              this.startTime = new Date().getTime();
              this.endTime = null;
              this.isTimerRunning = true;
            },
            pauseTimer() {
              this.endTime = new Date().getTime();
              this.isTimerRunning = false;
            },
            endTimer() {
              this.endTime = new Date().getTime();
              this.isTimerRunning = false;
              this.saveRecord(); // 保存记录和计算费用
            },
            calculateFee() {
              if (this.startTime && this.endTime) {
                const elapsedMilliseconds = this.endTime - this.startTime;
                // 根据你的收费策略进行费用计算
                // 这里只是一个示例，你需要根据实际情况进行调整
                const hours = Math.ceil(elapsedMilliseconds / (1000 * 60 * 60));
                const ratePerHour = 10; // 每小时费率
                const fee = hours * ratePerHour;
                return fee;
              }
              return 0;
            },
            
        },       
    }
</script>
