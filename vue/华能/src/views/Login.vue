<template>
  <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="login-box">
    <h3 class="login-title">登录</h3>
    <el-form-item label="用户ID" prop="id">
      <el-input v-model="ruleForm.id" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="密码" prop="password">
      <el-input type="password" v-model="ruleForm.password" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm">登录</el-button>
      <el-button @click="register">注册</el-button>
    </el-form-item>
  </el-form>
</template>
<script>
export default {
  name: "Login",
  data() {
    return {
      ruleForm: {
        id:undefined,
        password:undefined
      },
      rules: {
        id:[{
          required: true,
          message: "不能为空",
          trigger: "change"
        }],
        password:[{
          required: true,
          message: "不能为空",
          trigger: "change"
        }]
      }
    };
  },
  methods: {
    submitForm() {
      if (this.ruleForm.id === undefined || this.ruleForm.id === ''){
        this.$message({
          message: 'id不可为空',
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

      this.axios({
        method:"post",
        url:"http://localhost:8081/user/login",
        data: {
          id : Number(this.ruleForm.id),
          password : this.ruleForm.password
        }
      }).then(repos => {
        if (repos.data !== null){
          sessionStorage.setItem("isLogin",JSON.stringify(repos.data))
          this.$router.push({path:'/main'})
          this.$message({
            message: '登录成功',
            type: 'success'
          });
        }else {
          this.$message({
            message: '用户名或密码错误',
            type: 'warning'
          });
        }
      }).catch(function (error){
        console.log(error)
      })
    },
    register() {
      this.$router.push({path:'/Register'})
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
