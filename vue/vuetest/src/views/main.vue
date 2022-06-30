<template>
	<el-row>
		<el-col :span="24">
			<div class="box">

				<el-form :model="creditFrom" :rules="rules" label-width="100px"
					style="margin-top: 20px;width: 460px;margin: 0 auto;">
					<h3 style="font-weight: 500;">还款计算</h3>

					<el-form-item label="贷款金额" prop="money">
						<el-input style="width: 360px;" placeholder="不超过3000万" v-model.number="creditFrom.money">
							<template slot="append">元</template>
						</el-input>
					</el-form-item>
					<el-form-item label="利率" prop="rate">
						<el-input style="width: 360px;" placeholder="请输入利率" v-model="creditFrom.rate">
							<el-select v-model="creditFrom.rateSelect" slot="prepend" style="width: 150px;"
								placeholder="请选择">
								<el-option label="日利率" value="1"></el-option>
								<el-option label="月利率" value="2"></el-option>
								<el-option label="年利率" value="3"></el-option>
							</el-select>
							<template slot="append">%</template>
						</el-input>
					</el-form-item>
					<el-form-item label="贷款期限" prop="allotted">
						<el-input style="width: 360px;" placeholder="请输入1-360个月的贷款期限"
							v-model.number="creditFrom.allotted">

							<template slot="append">个月 </template>
						</el-input>
					</el-form-item>
					<el-form-item label="还款方式" prop="repayment">
						<el-select style="width: 360px;" v-model="creditFrom.repayment" placeholder="请选择还款方式">
							<el-option label="按月计息、到期还本" value="1"></el-option>
							<el-option label="等额本息" value="2"></el-option>
							<el-option label="等额本金" value="3"></el-option>
							<el-option label="随借随还" value="4"></el-option>
						</el-select>
					</el-form-item>
					<el-form-item>
						<el-button @click="js()" type="primary" :disabled="btnDisabled">还款计算</el-button>
						<el-button>返回</el-button>
					</el-form-item>
				</el-form>

				<div class="jg" v-show="show" >
					总支付利息：<span>{{income}}</span> 累计还款金额：<span>{{rental}}</span>
				</div>

				<div class="cDZnmt"  v-show="show">
					<div class="header">
						<div>
							<h4>还款明细</h4>
							
							<p>当前计算结果仅供参考，具体的以签署的合同为准</p>
						</div>
						<button @click="qk()" type="button" class="ant-btn ant-btn-primary ant-btn-background-ghost"
							style="width: 100px;"><span>清 空</span></button>
					</div>
					  <el-table
					    :data="tableData"
					    stripe
					    style="width: 100%">
					    <el-table-column
						 fixed
						 prop="id"
						 align="center"
						 width="150"
					      label="期次">
					    </el-table-column>
					    <el-table-column
					      prop="interest"
					      label="偿还利息">
					    </el-table-column>
					    <el-table-column
					      prop="principal"
					      label="偿还本金">
					    </el-table-column>
					    <el-table-column
					      prop="needFor"
					      label="当前需供">
					    </el-table-column>
					    <el-table-column
					      prop="corpus"
					      label="剩余本金">
					    </el-table-column>
					  </el-table>
				</div>
			</div>
		</el-col>
	</el-row>
</template>

<script>
	import Vue from 'vue'
	export default {
		data() {

			var validatePass = (rule, value, callback) => {
				console.log(creditFrom.repayment);
				if (value == '4') {
					callback(new Error('该还款方式不支持还款计算，请重新选择'));
				} else {

					callback();
				}
			};
			return {
				show: false,
				btnDisabled: false,
				creditFrom: {
					money: undefined,
					rateSelect: "1",
					rate: undefined,
					allotted: undefined,
					repayment: undefined
				},
				tableData:[
					{
						interest:undefined,
						principal:undefined,
						needFor:undefined,
						corpus:undefined
					}
				],
				monthly:undefined,
				income:undefined,
				rental:undefined,
				rules: {
					money: [{
							required: true,
							message: "请填写贷款金额",
							trigger: "blur"
						},
						{
							pattern: /^[1-9]\d*$/,
							message: "请输入正整数",
							trigger: "blur"
						}, {
							type: "number",
							min: 1,
							max: 30000000,
							message: "不能超过3000万",
							trigger: "blur"

						}
					],
					rate: [{
							required: true,
							message: "请填写利率",
							trigger: "blur"

						},
						{
							pattern: /^(([^0][0-9]+|0)\.([0-9]{1,2})$)|^(([^0][0-9]+|0)$)|^(([1-9]+)\.([0-9]{1,2})$)|^(([1-9]+)$)/,
							message: "利率填写不正确",
							trigger: "blur"
						}
					],
					allotted: [{
							required: true,
							message: "请输入贷款期限",
							trigger: "blur"
						},
						{
							pattern: /^[1-9]\d*$/,
							message: "利率填写不正确",
							trigger: "blur"
						}, {
							type: "number",
							min: 1,
							max: 360,
							message: "请输入1-360个月的贷款期限3000万",
							trigger: "blur"

						}
					],
					repayment: [{
						required: true,
						message: "请填写贷款金额",
						trigger: "blur"
					}, {
						validator: (rule, value, callback) => {
							if (value == '4') {
								this.btnDisabled = true;
								callback(new Error('该还款方式不支持还款计算，请重新选择'));
							} else {
								this.btnDisabled = false;
								callback();
							}
						},
						trigger: "change"

					}]
				}
			}
		},
		methods: {
			
			js(){
				
				this.tableData = []
				this.income =0;
				this.rental = 0;
				
				var form = this.creditFrom;
				var rate = Number(form.rate)
				if(form.rateSelect === "1"){
					rate = rate * 30 * 0.01
				}else if(form.rateSelect === "2"){
					rate = rate * 0.01
				}else if(form.rateSelect === "3"){
					rate = rate / 12 * 0.01
				}
				if(form.repayment === "1" ){
					this.monthly = form.money * rate
					this.monthly = this.monthly.toFixed(2)
					this.income = this.monthly * form.allotted
					this.income = this.income.toFixed(2)
					this.rental = Number(this.income)  + form.money
					this.rental = this.rental.toFixed(2)
					for(var num = 1 ; num <= form.allotted;num++){
						
						if(num != form.allotted){
								
							this.tableData.push({
								id: num,
								interest:this.monthly,
								principal:"0.00",
								needFor:this.monthly,
								corpus: form.money.toFixed(2)
							})
						}else{
							
							this.tableData.push({
								id: num,
								interest:this.monthly,
								principal:form.money.toFixed(2),
								needFor: Number(this.monthly) + Number(form.money.toFixed(2)),
								corpus: "0.00"
							})
						}
					}
					this.show = true;
				}else if(form.repayment === "2"){
					var money = form.money 
					var xg =(money * rate *Math.pow((1+ rate ),form.allotted))/(Math.pow((1+ rate ),form.allotted)-1 )
					var countLx =0;
					var sum = 0;
					xg = Number(xg.toFixed(2))
					for(var num = 1 ; num <= form.allotted;num++){
						
						if(num != form.allotted){
							
							var lx =(money * (rate * 12)) / 360 * 30
							lx = Number(lx.toFixed(2));
							
							var bj = xg - lx;
							bj = Number(bj.toFixed(2));
							
							money = money - bj;
						}else{
							lx = lx-(money - bj)
							bj = money	
							money =0 
						}
						
						
						this.income = Number(this.income) + Number(lx) 
						this.tableData.push({
							id: num,
							interest:lx.toFixed(2),
							principal:bj.toFixed(2),
							needFor:xg.toFixed(2),
							corpus: money.toFixed(2)
						})
					}
					this.show = true;
					this.income = this.income.toFixed(2);
					this.rental = Number(form.money) + Number(this.income);
				}else if(form.repayment === "3"){
					var money = form.money;
					for(var num = 1 ; num <= form.allotted;num++){
						
						var lx = (money * (rate * 12)) / 360 * 30
						lx = Number(lx.toFixed(2))
						if(num === 1 ){
							
							var xg =Number((money/form.allotted).toFixed(2)) + (money)* rate
							xg = Number(xg.toFixed(2))
							var bj =  xg - lx;
							console.log(bj);
						}else{
							xg = bj + lx
							xg = Number(xg.toFixed(2))
							console.log(bj);
						}
						money = money - bj;
						this.income = Number(this.income) + Number(lx) 
						this.tableData.push({
							id: num,
							interest:lx.toFixed(2),
							principal:bj.toFixed(2),
							needFor:xg.toFixed(2),
							corpus: money.toFixed(2)
						})
					}
					this.show = true;
					this.income = this.income.toFixed(2);
					this.rental = Number(form.money) + Number(this.income);
				}
			},
			qk(){
				
				this.tableData = []
				this.income =0;
				this.rental = 0;
				this.show= false;
			}
		}
	}
</script>
<style>
	body {
		background-color: rgb(243 243 243);
	}

	.box {
		width: 1170px;
		background-color: #FFFFFF;
		margin: 0 auto;
		padding: 50px;
		margin-top: 80px;
	}

	.jg {
		width: 100%;
		display: block;
		text-align: center;
		margin-top: 40px;
		padding: 0px 0px 40px;
		border-bottom: 1px solid rgb(239, 239, 239);

	}

	.jg span {
		font-size: 40px;
		font-weight: bold;
		font-family: SourceHanSansCN-Bold, SourceHanSansCN, "PingFang SC", "Helvetica Neue", "Hiragino Sans GB", Helvetica, "Microsoft YaHei", Arial;
		color: rgb(50, 119, 255);
		margin-right: 30px;
	}

	.cDZnmt {
		padding: 40px 15px;
	}
	.cDZnmt .header {
	    display: flex;
	    -webkit-box-pack: justify;
	    justify-content: space-between;
	}
	.cDZnmt .header h4 {
	    font-size: 20px;
	    font-weight: 500;
	    color: rgb(51, 51, 51);
	    line-height: 20px;
	    margin-bottom: 12px;
	}
	.cDZnmt .header p {
	    font-size: 14px;
	    font-weight: 400;
	    color: rgb(153, 153, 153);
	    line-height: 16px;
	    margin-bottom: 20px;
	}
	.ant-btn-background-ghost.ant-btn-primary {
	    color: #3277ff;
	    border-color: #3277ff;
	    text-shadow: none;
	}
	.ant-btn {
	    line-height: 1.499;
		margin-top: 40px;
	    position: relative;
	    display: inline-block;
	    font-weight: 400;
	    white-space: nowrap;
	    text-align: center;
	    background-image: none;
	    -webkit-box-shadow: 0 2px 0 rgb(0 0 0 / 2%);
	    box-shadow: 0 2px 0 rgb(0 0 0 / 2%);
	    cursor: pointer;
	    -webkit-transition: all .3s cubic-bezier(.645,.045,.355,1);
	    transition: all .3s cubic-bezier(.645,.045,.355,1);
	    -webkit-user-select: none;
	    -moz-user-select: none;
	    -ms-user-select: none;
	    user-select: none;
	    -ms-touch-action: manipulation;
	    touch-action: manipulation;
	    height: 32px;
	    padding: 0 15px;
	    font-size: 14px;
	    border-radius: 4px;
	    color: rgba(0,0,0,.65);
	    background-color: #fff;
	    border: 1px solid #d9d9d9;
	}
</style>
