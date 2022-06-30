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
    <el-col :span="24">
      <div class="title">
        <span style="line-height: 56px;margin-left: 20px">督办立项</span>
      </div>
    </el-col>
    <el-col :span="24">
      <el-tabs style="float: left;margin-left: 20px" v-model="activeName"  @tab-click="handleClick">
        <el-tab-pane label="申请立项" name="apply" >
          <el-card :body-style="{ padding: '0px' }" style="float:left;width: 200px;margin-top: 150px;margin-left: 450px">
            <i class="el-icon-more" style="font-size: 105px;margin-left:50px"></i>
            <div style="padding: 14px;">
              <div class="bottom clearfix">
                <el-button type="text" style="margin-left: 60px" >批量立项</el-button>
              </div>
            </div>
          </el-card>
          <el-card :body-style="{ padding: '0px' }" style="float:left;width: 200px;margin-top: 150px;margin-left: 120px">
            <i class="el-icon-s-check" style="font-size: 105px;margin-left:50px"></i>
            <div style="padding: 14px;">
              <div class="bottom clearfix">
                <el-button type="text" style="margin-left: 60px" @click="onceProject">单项立项</el-button>
              </div>
            </div>
          </el-card>
        </el-tab-pane>
        <el-tab-pane label="单项立项记录" name="once" style="width: 1500px">
          <el-table :key='tableKey'
                    :data="List.list"
                    element-loading-text="拼命加载中..."
                    max-height="650"
                    stripe
                    element-loading-spinner="el-icon-loading"
                    highlight-current-row
                    style="width: 100%">
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
            <el-table-column align="center"
                             label="进度">
              <template slot-scope="scope">
                <span v-if="scope.row.rate === 0">待审核</span>
                <span v-else-if="scope.row.rate === 1">审核通过</span>
                <span v-else-if="scope.row.rate === 2">待办理</span>
                <span v-else>/</span>
              </template>
            </el-table-column>
          </el-table>

        </el-tab-pane>
        <el-tab-pane label="批量立项记录" name="more"></el-tab-pane>
      </el-tabs>

    </el-col>

    <el-dialog title="单项立项"
               :visible.sync="CapacityViewVisible"
               @close="closeCapacity"
               width="800px">
      <el-form :model="CapacityFrom"
               :rules="rules"
               label-width="150px"
               style="margin-top: 20px">
        <el-form-item label="立项题目："
                      prop="title">
          <el-input style="width: 300px; margin-right: 5px;"
                    class="filter-item"
                    clearable
                    v-model="CapacityFrom.title"></el-input>

        </el-form-item>
        <el-form-item label="立项内容："
                      prop="content">
          <el-input style="width: 500px; margin-right: 5px;font-size: 18px"
                    :rows="6"
                    type="textarea"
                    class="filter-item"
                    clearable
                    v-model="CapacityFrom.content"></el-input>

        </el-form-item>
        <el-form-item label="选择审核部门："
                      prop="checkDepartment">
          <el-select style="width: 300px" v-model="CapacityFrom.checkDepartment" placeholder="请选择部门">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="选择协助部门："
                      prop="conductDepartment">
          <el-select style="width: 300px" v-model="CapacityFrom.conductDepartment" placeholder="请选择部门">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="开始与结束日期："
                      prop="Date">
          <el-date-picker
            v-model="searchDateDay"
            @change="changeDayFilter"
            type="daterange"
            range-separator="至"
            start-placeholder="开始日期"
            end-placeholder="结束日期"
            value-format="yyyy-MM-dd">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="优先级："
                      prop="Date">

          <el-select style="width: 300px" v-model="CapacityFrom.priority" placeholder="请选择优先级">
            <el-option
              v-for="item in priorityOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>

      </el-form>

      <div slot="footer"
           class="dialog-footer">
        <el-button @click="closeCapacity">取 消</el-button>
        <el-button @click="insertProject" type="primary">提 交</el-button>
      </div>
    </el-dialog>
  </el-row>
</template>

<script>
export default {
  name: "createProject",
  data() {
    return {
      user: {
        name: undefined
      },
      searchDateDay: [],
      listProject:{
        page: 1,
        limit: 10
      },
      tableKey: 0,
      List:{
        list: [],
        total: null
      },
      activeName: 'apply',
      CapacityViewVisible:false,
      CapacityFrom:{
        title:undefined,
        content:undefined,
        checkDepartment:undefined,
        conductDepartment:undefined,
        startTime:undefined,
        endTime:undefined,
        priority:undefined
      },
      rules:{
        title:[{
          required: true,
          message: "不能为空",
          trigger: "change"
        }],
        content:[{
          required: true,
          message: "不能为空",
          trigger: "change"
        }],
        checkDepartment:[{
          required: true,
          message: "不能为空",
          trigger: "change"
        }],
        conductDepartment:[{
          required: true,
          message: "不能为空",
          trigger: "change"
        }]
      },
      options: [

      ],
      priorityOptions:[{
          value: 1,
          label: '低'
        },
        {
          value: 2,
          label: '中'
        },
        {
          value: 3,
          label: '高'
        }
      ]
    }
  },
  created() {

    let isLogin = JSON.parse(sessionStorage.getItem("isLogin"));
    this.user.name = isLogin.name

    this.axios({
      method:"get",
      url:"http://localhost:8081/department/list"
    }).then(repos => {
      repos.data.forEach(item =>{
        this.options.push({
          value: item.id,
          label: item.name
        })
      })

    }).catch(function (error){
      console.log(error)
    })
  },
  methods: {
    changeDayFilter(e) {
      let [startDate, endDate] = e || [];
      this.CapacityFrom.startTime = startDate !== undefined ? startDate +" 00:00:00" : undefined;
      this.CapacityFrom.endTime =  endDate !== undefined ? endDate +" 23:59:59" : undefined;

    },
    logout(){
      this.$router.push({path:'/logout'})
    },
    getOnceProject(){
      this.axios({
        method:"get",
        url:"http://localhost:8081/project/list"
      }).then(repos => {
        this.List.list = repos.data
        this.List.total = repos.data.length
      }).catch(function (error){
        console.log(error)
      })
    },
    closeCapacity(){
      this.CapacityViewVisible = false
    },
    onceProject(){
      this.CapacityViewVisible = true
    },
    insertProject(){

      let isLogin = JSON.parse(sessionStorage.getItem("isLogin"));
      console.log(this.CapacityFrom)

      this.axios({
        method:"post",
        url:"http://localhost:8081/project/insert",
        data: {
          id : Number(this.CapacityFrom.id),
          title : this.CapacityFrom.title,
          content : this.CapacityFrom.content,
          submitterId : isLogin.id,
          checkDepartment : this.CapacityFrom.checkDepartment,
          conductDepartment : this.CapacityFrom.conductDepartment,
          startTime: this.CapacityFrom.startTime,
          endTime: this.CapacityFrom.endTime,
          priority : this.CapacityFrom.priority
        }
      }).then(repos => {
        if (repos.data > 0){
          this.$message({
            message: '提交成功',
            type: 'success'
          });
        }else{
          this.$message({
            message: '提交失败',
            type: 'warning'
          });
        }
        this.CapacityViewVisible = false;
      }).catch(function (error){
        console.log(error)
      })
    },
    MaterialIndexMethod(index) {
      return (this.listProject.page - 1) * this.listProject.limit + index + 1;
    },
    showDate(){
      console.log(this.CapacityFrom.startTime)
    },
    handleClick(){
      this.listProject.page = 1
      this.listProject.limit = 10;
      if(this.activeName === "once"){
        this.getOnceProject();
      }
    },
  }
}
</script>

<style scoped>
body{
  margin: 0px;
}
.title{
  height: 56px;
  margin: 10px;
  -moz-box-shadow:0 0 3px 3px #e5e3e3;
  -webkit-box-shadow:0 0 3px 3px  #e5e3e3;
  box-shadow:0 0 5px 5px  #e5e3e3;
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
