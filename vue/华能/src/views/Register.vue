<template>
  <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="login-box">
    <h3 class="login-title">注册</h3>
    <el-form-item label="用户ID" prop="id">
      <el-input v-model="ruleForm.id" autocomplete="off" :disabled="true"></el-input>
    </el-form-item>
    <el-form-item label="用户名" prop="name">
      <el-input v-model="ruleForm.name" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="密码" prop="password">
      <el-input type="password" v-model="ruleForm.password" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="确认密码" prop="checkPass">
      <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="选择部门">
      <el-select v-model="ruleForm.department" placeholder="请选择部门">
        <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value">
        </el-option>
      </el-select>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm">注册</el-button>
      <el-button @click="resetForm">重置</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
export default {
  name: "Register",
  data() {
    var check = (rule,value,callback) => {
      if(this.resetForm.password !== this.checkPass){
        return callback(new Error("两次密码不一致"))
      }
    }
    return {
      ruleForm: {
        id:undefined,
        name:undefined,
        password:undefined,
        checkPass:undefined,
        department:undefined
      },
      rules: {
        name:[{
          required: true,
          message: "不能为空",
          trigger: "change"
        }],
        password:[{
          required: true,
          message: "不能为空",
          trigger: "change"
        }],
        checkPass:[{
          required: true,
          message: "不能为空",
          validator:check,
          trigger: "change"
        }]

      },
      options: [

      ]
    };
  },
  created() {
    var num = '';
    for (var i=0 ; i<9; i++){
       num =num +  Math.floor(Math.random()*10)
    }
    this.ruleForm.id = num;

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
    submitForm() {
      if (this.ruleForm.name === undefined || this.ruleForm.name === ''){
        this.$message({
          message: '用户名不可为空',
          type: 'warning'
        });
        return;
      }
      if (this.ruleForm.password === undefined || this.ruleForm.password === ''){
        this.$message({
          message: '密码不可为空',
          type: 'warning'
        });
        return;
      }
      if (this.ruleForm.checkPass !== this.ruleForm.password){
        this.$message({
          message: '两次密码不一致',
          type: 'warning'
        });
        return;
      }

      this.axios({
        method:"post",
        url:"http://localhost:8081/user/register",
        data: {
          id : Number(this.ruleForm.id),
          name : this.ruleForm.name,
          password : this.ruleForm.password,
          departmentId : this.ruleForm.department
        }
      }).then(repos => {
        if (repos.data){
          this.$message({
            message: '注册成功',
            type: 'success'
          });
          this.$router.push({path:'/Login'})
        }else {
          this.$message({
            message: '注册失败',
            type: 'warning'
          });
        }
      }).catch(function (error){
        console.log(error)
      })
    },
    resetForm() {
      this.ruleForm.name = "";
      this.ruleForm.password = "";
      this.ruleForm.checkPass = "";
    }
  }
}
</script>

<style scoped>
.login-box {
  width: 400px;
  margin: 140px auto;
  border: 1px solid #DCDFE6;
  padding: 20px;
  border-radius: 5px;
  box-shadow: 0 0 30px #DCDFE6;
}
.login-title{
  text-align: center;
}

</style>
