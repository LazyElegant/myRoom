<template>
  <el-row>
    <el-col :span="24"><div class="grid-content bg-purple-dark">
      <img src="../img/logo.jpg" class="logo">
      <div class="muen">
        <router-link to="/main">督办首页</router-link>
        <router-link to="/createProject">督办立项</router-link>
        <router-link to="">承办汇总</router-link>
        <router-link to="">点评汇总</router-link>
        <router-link to="">督办台账</router-link>
      </div>
      <div style="float: right;line-height: 56px;margin-right: 20px;color: #000000">
        {{user.name}}
        <button @click="logout">注销</button>
      </div>

    </div>
    </el-col>
    <el-col :span="18">
      <el-card class="t">
        <div slot="header">
          <b style="float: left;margin-top: 10px">|</b> <span style="float: left;margin-top: 10px"> 我的办件</span>

          <el-button style="float: right; padding: 3px 0" type="text" @click="logShow">更多</el-button>
          <span style="float: right;margin-right: 10px" >信息提醒<span style="color: red">({{this.logCount}})</span></span>
        </div>
          <el-tabs style="float: left;margin-left: 20px" v-model="activeName" @tab-click="handleClick">
            <el-tab-pane label="待办" name="first" style="width: 1050px">

              <el-table :key='tableKey'
                        :data="List.list"
                        element-loading-text="拼命加载中..."
                        max-height="650"
                        stripe
                        element-loading-spinner="el-icon-loading"
                        highlight-current-row
                        height="250"
                        style="width: 100%;">
                <el-table-column align="center"
                                 label="项目名称"
                                 prop="title">
                </el-table-column>
                <el-table-column align="center"
                                 label="项目内容"
                                 prop="content">
                </el-table-column>
                <el-table-column align="center"
                                 label="发起人"
                                 prop="submitter">
                </el-table-column>
                <el-table-column align="center"
                                 label="审核部门"
                                 prop="checkDepartment">
                </el-table-column>
                <el-table-column align="center"
                                 label="协助部门"
                                 prop="conductDepartment">
                </el-table-column>
                <el-table-column align="center"
                                 label="创建时间"
                                 prop="creatTime">
                </el-table-column>
                <el-table-column align="center"
                                 label="开始时间"
                                 prop="startTime">
                </el-table-column>
                <el-table-column align="center"
                                 label="结束时间"
                                 prop="endTime">
                </el-table-column>
                <el-table-column align="center"
                                 label="优先度">
                  <template slot-scope="scope">
                    <span v-if="scope.row.priority === 1" STYLE="color: lightgreen">低</span>
                    <span v-else-if="scope.row.priority === 2" STYLE="color: khaki">中</span>
                    <span v-else-if="scope.row.priority === 3" STYLE="color: red">高</span>
                  </template>
                </el-table-column>

                <el-table-column align="center"
                                 label="进度">
                  <template slot-scope="scope">
                    <span v-if="scope.row.rate === 0" @click="check(scope.row)" class="simulateA">待审核</span>
                    <span v-else-if="scope.row.rate === 1 && scope.row.dateType === 1" @click="accept(scope.row)"  class="simulateA">审核通过,确认接受办理</span>
                    <span v-else-if="scope.row.rate === 2 && scope.row.dateType === 1" @click="action(scope.row)" class="simulateA">待办理</span>
                    <span v-else-if="scope.row.rate === 1 && scope.row.dateType === 2" @click="log">审核通过,确认接受办理</span>
                    <span v-else-if="scope.row.rate === 2 && scope.row.dateType === 2" @click="log">待办理</span>
                    <span v-else>/</span>
                  </template>
                </el-table-column>
              </el-table>
            </el-tab-pane>
            <el-tab-pane label="经办" name="second" style="width: 1050px">

              <el-table :key='tableKey'
                        :data="PassList.list"
                        element-loading-text="拼命加载中..."
                        max-height="650"
                        stripe
                        element-loading-spinner="el-icon-loading"
                        highlight-current-row
                        height="250"
                        style="width: 100%;">
                <el-table-column align="center"
                                 label="项目名称"
                                 prop="title">
                </el-table-column>
                <el-table-column align="center"
                                 label="项目内容"
                                 prop="content">
                </el-table-column>
                <el-table-column align="center"
                                 label="发起人"
                                 prop="submitter">
                </el-table-column>
                <el-table-column align="center"
                                 label="审核部门"
                                 prop="checkDepartment">
                </el-table-column>
                <el-table-column align="center"
                                 label="协助部门"
                                 prop="conductDepartment">
                </el-table-column>
                <el-table-column align="center"
                                 label="创建时间"
                                 prop="creatTime">
                </el-table-column>
                <el-table-column align="center"
                                 label="操作">
                  <template slot-scope="scope">
                    <span v-if="scope.row.rate === 0">发起立项</span>
                    <span v-else-if="scope.row.rate === 1">通过审核</span>
                    <span v-else-if="scope.row.rate === 2">确认办理</span>
                    <span v-else-if="scope.row.rate === 3">办理结束</span>
                    <span v-else>退回</span>
                  </template>
                </el-table-column>
              </el-table>

            </el-tab-pane>
          </el-tabs>
      </el-card>
    </el-col>
    <el-col :span="6">

      <el-card class="a">
        <div slot="header">
          <b style="float: left;margin-top: 10px">|</b> <span style="float: left;margin-top: 10px"> 立项任务概览</span>
        </div>
        <div>
          <ve-ring :data="ringChartData" ></ve-ring>
        </div>
      </el-card>
    </el-col>
    <el-col :span="18">
      <el-card class="t">
        <div slot="header">
          <b style="float: left;margin-top: 10px">|</b> <span style="float: left;margin-top: 10px"> 督办任务</span>
          <el-button style="float: right; padding: 3px 0" type="text">更多</el-button>
          <el-tabs style="float: left;margin-left: 20px"  v-model="secondName">
            <el-tab-pane label="我的立项" name="first" style="width: 1050px">

              <el-table :key='tableKey'
                        :data="List.list"
                        element-loading-text="拼命加载中..."
                        max-height="650"
                        stripe
                        element-loading-spinner="el-icon-loading"
                        highlight-current-row
                        height="250"
                        style="width: 100%;">

                <el-table-column type="index"
                                 fixed
                                 prop="id"
                                 label="ID"
                                 align="center"
                                 width="150"
                                 :index="MaterialIndexMethod">
                </el-table-column>


                <el-table-column align="center"
                                 label="项目编号"
                                 prop="id">
                </el-table-column>
                <el-table-column align="center"
                                 label="项目名称"
                                 prop="title">
                </el-table-column>
                <el-table-column align="center"
                                 label="项目内容"
                                 prop="content">
                </el-table-column>
                <el-table-column align="center"
                                 label="发起人"
                                 prop="submitter">
                </el-table-column>
                <el-table-column align="center"
                                 label="审核部门"
                                 prop="checkDepartment">
                </el-table-column>
                <el-table-column align="center"
                                 label="协助部门"
                                 prop="conductDepartment">
                </el-table-column>
                <el-table-column align="center"
                                 label="创建时间"
                                 prop="creatTime">
                </el-table-column>
              </el-table>

            </el-tab-pane>
          </el-tabs>
        </div>
      </el-card>
    </el-col>
    <el-col :span="6">

      <el-card class="a">
        <div slot="header">
          <b style="float: left;margin-top: 10px">|</b> <span style="float: left;margin-top: 10px"> 立项任务来源</span>
        </div>
        <div>
          <ve-histogram :data="histogramChartData" ></ve-histogram>
        </div>
      </el-card>
    </el-col>

    <el-dialog title="审核立项"
               :visible.sync="checkViewVisible"
               @close="closeCapacity"
               width="800px">
      <el-form :model="checkFrom"
               label-width="150px"
               style="margin-top: 20px">
        <el-form-item label="立项题目："
                      prop="title">
          <el-input style="width: 300px; margin-right: 5px;"
                    class="filter-item"
                    clearable
                    v-model="checkFrom.title" :disabled="true"></el-input>

        </el-form-item>
        <el-form-item label="立项内容："
                      prop="content">
          <el-input style="width: 500px; margin-right: 5px;font-size: 18px"
                    :rows="6"
                    type="textarea"
                    class="filter-item"
                    clearable
                    v-model="checkFrom.content" :disabled="true"></el-input>

        </el-form-item>
        <el-form-item label="提交人："
                      prop="submitter">
          <el-input style="width: 300px; margin-right: 5px;"
                    class="filter-item"
                    clearable
                    v-model="checkFrom.submitter" :disabled="true"></el-input>

        </el-form-item>
        <el-form-item label="审核部门："
                      prop="checkDepartment">

          <el-input style="width: 300px; margin-right: 5px;"
                    class="filter-item"
                    clearable
                    v-model="checkFrom.checkDepartment" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="协助部门："
                      prop="conductDepartment">
          <el-input style="width: 300px; margin-right: 5px;"
                    class="filter-item"
                    clearable
                    v-model="checkFrom.conductDepartment" :disabled="true"></el-input>
        </el-form-item>
      </el-form>

      <div slot="footer"
           class="dialog-footer">
        <el-button @click="returnCheck">退 回</el-button>
        <el-button @click="passProject" type="primary">通 过</el-button>
      </div>
    </el-dialog>

    <el-dialog title="确认办理立项"
               :visible.sync="acceptViewVisible"
               @close="closeAccept"
               width="800px">
      <el-form :model="checkFrom"
               label-width="150px"
               style="margin-top: 20px">
        <el-form-item label="立项题目："
                      prop="title">
          <el-input style="width: 300px; margin-right: 5px;"
                    class="filter-item"
                    clearable
                    v-model="checkFrom.title" :disabled="true"></el-input>

        </el-form-item>
        <el-form-item label="立项内容："
                      prop="content">
          <el-input style="width: 500px; margin-right: 5px;font-size: 18px"
                    :rows="6"
                    type="textarea"
                    class="filter-item"
                    clearable
                    v-model="checkFrom.content" :disabled="true"></el-input>

        </el-form-item>
        <el-form-item label="提交人："
                      prop="submitter">
          <el-input style="width: 300px; margin-right: 5px;"
                    class="filter-item"
                    clearable
                    v-model="checkFrom.submitter" :disabled="true"></el-input>

        </el-form-item>
        <el-form-item label="审核部门："
                      prop="checkDepartment">

          <el-input style="width: 300px; margin-right: 5px;"
                    class="filter-item"
                    clearable
                    v-model="checkFrom.checkDepartment" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="协助部门："
                      prop="conductDepartment">
          <el-input style="width: 300px; margin-right: 5px;"
                    class="filter-item"
                    clearable
                    v-model="checkFrom.conductDepartment" :disabled="true"></el-input>
        </el-form-item>
      </el-form>

      <div slot="footer"
           class="dialog-footer">
        <el-button @click="returnCheck">退 回</el-button>
        <el-button @click="acceptProject" type="primary">接 受</el-button>
      </div>
    </el-dialog>

    <el-dialog
      title="提示"
      :visible.sync="dialogVisible"
      width="30%">
      <span>是否已经完成项目</span>
      <span slot="footer" class="dialog-footer">
    <el-button @click="returnCheck">退 回</el-button>
    <el-button type="primary" @click="actionProject">已经完成项目</el-button>
  </span>
    </el-dialog>

    <el-dialog
      title="提示"
      :visible.sync="logViewVisible"
      width="30%">
      <div v-for="item in logForm" style="padding: 20px;background-color: #DCDFE6">
        <span v-text="'该 ‘'+item.title + '‘任务需要处理，请及时处理'"></span>
      </div>
    </el-dialog>
  </el-row>
</template>

<script>
import Vue from 'vue'
import VCharts from 'v-charts'
Vue.use(VCharts)
export default {
  data() {
    return {
      activeName: 'first',
      secondName: 'first',
      checkViewVisible: false,
      acceptViewVisible:false,
      dialogVisible :false,
      user: {
        name: undefined
      },
      tableKey: 0,
      List:{
        list: [],
        total: null
      },

      //环形图
      ringChartData: {
        columns: ['状态', '数量'],
        rows: []
      },
      histogramChartData: {
        columns: ['部门','项目来源'],
        rows: []
      },
      PassList:{
        list: [],
        total: null
      },
      CountList:{
        list: [],
        total: null
      },
      listProject:{
        page: 1,
        limit: 10
      },
      checkFrom:{
        id:undefined,
        title:undefined,
        content:undefined,
        submitter:undefined,
        checkDepartment:undefined,
        conductDepartment:undefined
      },
      logForm:[],
      logViewVisible:false,
      logCount : 0
    }
  },
  created() {
    let isLogin = JSON.parse(sessionStorage.getItem("isLogin"));
    this.user.name = isLogin.name;
    this.getBacklog();
    this.getPassBacklog()
    this.getCountBacklog();
    this.axios({
      method:"get",
      url:"http://localhost:8081/project/countDepartment/"+isLogin.department_id
    }).then(repos => {
      repos.data.forEach(item =>{
        this.histogramChartData.rows.push({
          '部门':item.name,'项目来源':item.count
        })
      })

    }).catch(function (error){
      console.log(error)
    })

  },
  methods: {
    getBacklog(){
      let isLogin = JSON.parse(sessionStorage.getItem("isLogin"));
      this.axios({
        method:"get",
        url:"http://localhost:8081/project/listBacklog/"+isLogin.department_id
      }).then(repos => {
        this.List.list = repos.data
        this.List.total = repos.data.length
        this.CountList.list = []
        this.logCount = 0
        this.List.list.forEach(item =>{
          var start = new Date(item.startTime).getTime()
          var end = new Date(item.endTime).getTime()
          var date = new Date(this.addDate()).getTime()
          console.log(this.addDate())
          console.log(item.startTime)
          console.log(item.endTime)
          console.log(date)
          console.log(start)
          console.log(end)


          if (start < date && date < end ){
            item.dateType = 1
            this.logCount = this.logCount + 1;
            this.logForm.push(item)
          }else {
            item.dateType = 2
          }
          console.log(item.dateType)
        })

        let zero = 0;
        let one = 0;
        let two = 0;

        this.ringChartData.rows = []

        this.List.list.forEach(item =>{
          if (item.rate === 0 ){
            zero = zero +1;
          }else if (item.rate === 1){
            one = one +1
          }else if (item.rate === 2){
            two = two +1
          }
        })
        this.ringChartData.rows.push({
          '状态': '待审核', '数量': zero
        })
        this.ringChartData.rows.push({
          '状态': '待确认', '数量': one
        })
        this.ringChartData.rows.push({
          '状态': '执行中', '数量': two
        })
      }).catch(function (error){
        console.log(error)
      })
    },
    getPassBacklog(){
      let isLogin = JSON.parse(sessionStorage.getItem("isLogin"));
      this.axios({
        method:"get",
        url:"http://localhost:8081/action/list/"+isLogin.id
      }).then(repos => {
        this.PassList.list = repos.data
        this.PassList.total = repos.data.length
        this.CountList.list = []
        this.List.list.forEach(item=>{
          this.CountList.list.push(item);
        })
        this.PassList.list.forEach(item=>{
          this.CountList.list.push(item);
        })
      }).catch(function (error){
        console.log(error)
      })
    },
    getCountBacklog(){

      console.log(this.CountList)
    },
    logout(){
      this.$router.push({path:'/logout'})
    },
    MaterialIndexMethod(index) {
      return (this.listProject.page - 1) * this.listProject.limit + index + 1;
    },
    check(row){
      this.checkFrom = row;
      this.checkViewVisible = true;
    },
    closeCapacity(){
      this.checkViewVisible = false
    },
    returnCheck(){
      this.axios({
        method:"post",
        url:"http://localhost:8081/project/sendBacklog/"+ this.checkFrom.id
      }).then(repos => {

        if(repos.data > 0){
          this.$message({
            message: '已退回',
            type: 'success'
          });

          let isLogin = JSON.parse(sessionStorage.getItem("isLogin"));
          this.axios({
            method:"post",
            url:"http://localhost:8081/action/insert",
            data: {
              conductor : isLogin.id,
              projectId : this.checkFrom.id,
              rate : 99
            }
          }).then();

        }
        this.checkViewVisible = false;
        this.getBacklog();
        this.getPassBacklog();
      }).catch(function (error){
        console.log(error)
      })

    },
    handleClick(){
      this.listProject.page = 1
      this.listProject.limit = 10;
      if(this.activeName === "first"){
        this.getBacklog();
      }
      if (this.activeName === "second"){
        this.getPassBacklog()
      }
    },
    passProject(){
      this.axios({
        method:"post",
        url:"http://localhost:8081/project/passBacklog/"+ this.checkFrom.id
      }).then(repos => {

        if(repos.data > 0) {
          this.$message({
            message: '已通过',
            type: 'success'
          });

          let isLogin = JSON.parse(sessionStorage.getItem("isLogin"));
          this.axios({
            method:"post",
            url:"http://localhost:8081/action/insert",
            data: {
              conductor : isLogin.id,
              projectId : this.checkFrom.id,
              rate : 1
            }
          }).then();
          this.checkViewVisible = false;
          this.getBacklog();
          this.getPassBacklog();
        }
      })
    },
    acceptProject(){
      this.axios({
        method:"post",
        url:"http://localhost:8081/project/acceptProject/"+ this.checkFrom.id
      }).then(repos => {

        if(repos.data > 0) {
          this.$message({
            message: '已确认',
            type: 'success'
          });

          let isLogin = JSON.parse(sessionStorage.getItem("isLogin"));
          this.axios({
            method:"post",
            url:"http://localhost:8081/action/insert",
            data: {
              conductor : isLogin.id,
              projectId : this.checkFrom.id,
              rate : 2
            }
          }).then();
          this.checkViewVisible = false;
          this.getBacklog();
          this.getPassBacklog();
        }
      })
    },
    closeAccept(){
      this.acceptViewVisible = false;
    },
    accept(row){
      this.checkFrom = row
      this.acceptViewVisible = true
    },
    action(row){
      this.checkFrom.id =row.id
      this.dialogVisible = true
    },
    addDate(){
      const nowDate = new Date();
      const date = {
        year: nowDate.getFullYear(),
        month: nowDate.getMonth() + 1,
        date: nowDate.getDate(),
      }
      const newmonth = date.month>10?date.month:'0'+date.month
      const day = date.date>10?date.date:'0'+date.date
      return new Date().getFullYear() +
        "-" +
        (new Date().getMonth() + 1) +
        "-" +
        new Date().getDate() +
        " " +
        new Date().getHours() +
        ":" +
        new Date().getMinutes() +
        ":" +
        new Date().getSeconds();

    },
    actionProject(){
      this.axios({
        method:"post",
        url:"http://localhost:8081/project/actionProject/"+ this.checkFrom.id
      }).then(repos => {

        if(repos.data > 0) {
          this.$message({
            message: '已确认',
            type: 'success'
          });

          let isLogin = JSON.parse(sessionStorage.getItem("isLogin"));
          this.axios({
            method:"post",
            url:"http://localhost:8081/action/insert",
            data: {
              conductor : isLogin.id,
              projectId : this.checkFrom.id,
              rate : 3
            }
          }).then();
          this.checkViewVisible = false;
          this.getBacklog();
          this.getPassBacklog();
        }
      })
    },
    log(){
      this.$message('时间未到或已过期');
    },
    logShow(){
      this.logViewVisible = true
      console.log(this.logForm)
    }
  }
}
</script>

<style>
.simulateA{
  color: rgba(0, 102, 255, 0.53);
}
.simulateA:hover{
  cursor:pointer
}
.t{
  height: 410px;
  margin: 10px;
}
.a{
  margin:10px;
  height: 410px
}
body{
  margin: 0px;
}
.logo{
  width: 350px;
  height:56px;
  float: left;
}
.bg-purple-dark {
  background: #ffffff;
}
.grid-content {
  min-height: 56px;
}
a{
  text-decoration: none;
  line-height: 56px;
  margin-left: 20px;
  color: #000000;
}
a:hover{
  text-decoration: none;
  background-color: #000000;
  color: white;
  padding: 18px 0px;
}
.muen{
  float: left;
  margin-left: 100px;
}
</style>
