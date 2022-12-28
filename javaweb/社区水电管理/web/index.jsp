<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path=request.getContextPath(); %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>登录</title>

	<link href="<%=path%>/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>

<body style="background-color: #dfd8e8;">
<form id="item" action="/login">
	<div class="container">
		<div class="row">
			<aside class="col-sm-4" style="margin: auto">
				<div class="card" style="margin-top: 80px;">
					<article class="card-body">
						<a href="/toRegistered" class="float-right btn btn-outline-primary">注册</a>
						<h4 class="card-title mb-4 mt-1">登录</h4>
						<form>
							<p style="color: red;text-align: center">${msg}</p>
							<div class="form-group">
								<label>用户名</label>
								<input  name="username" class="form-control" type="text" id="user_num" required>
							</div> <!-- form-group// -->

							<div class="form-group">
								<label>密码</label>
								<input name="password" class="form-control" type="password" id="user_password" required>
							</div> <!-- form-group// -->

							<div class="form-group">
								<div class="checkbox">
									<label> <input type="checkbox"> 记住密码 </label>
								</div> <!-- checkbox .// -->
							</div> <!-- form-group// -->

							<div class="form-group">
								<button type="submit" class="btn btn-primary btn-block"> 登录  </button>
							</div> <!-- form-group// -->
						</form>
					</article>
				</div>
			</aside>
		</div>
	</div>
</form>

</body>
</html>