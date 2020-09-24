<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<script src="js/jquery-3.2.1.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<title>用户管理</title>
		<!--主要样式控制-->
		<link href="css/manage.css" rel="stylesheet">

		<style type="text/css">
			#totalCount{
				position: relative;
				left: 40px;
				top: 25px;
			}

			#tishikuang{
				position: absolute;
				top: 35%;
				left: 30%;
				z-index: 10;
				width: 250px;
			}
		</style>

		<script>

			$(function() {

				/*编辑用户_用户名校验*/
				$("#edituname").blur(function () {
					//获取username文本输入框的值
					var username = $(this).val();
					//发送ajax请求
					//期望服务器响应回的数据格式：{"userExsit":true,"msg":"此用户名太受欢迎,请更换一个"}
					//                         {"userExsit":false,"msg":"用户名可用"}
					$.ajax({
						url:"findUserServlet",
						type:"POST",
						//data:"username=jack&age=23",//请求参数
						data:{"uname":username},
						success:function (data) {//响应成功后的回调函数

							//判断userExsit键的值是否是true

							// alert(data);
							var span = $("#e_username");
							if(data.userExsit){
								//用户名存在
								span.css("color","red");
								span.html(data.msg);
							}else{
								//用户名不存在
								span.css("color","green");
								span.html(data.msg);
							}
						},
						error:function () {//响应失败后的回调函数
							alert("出错啦!")
						}
					})
				});

				/*增加用户_用户名校验*/
				$("#uname").blur(function () {
					//获取username文本输入框的值
					var username = $(this).val();
					//发送ajax请求
					//期望服务器响应回的数据格式：{"userExsit":true,"msg":"此用户名太受欢迎,请更换一个"}
					//                         {"userExsit":false,"msg":"用户名可用"}

					$.ajax({
						url:"findUserServlet",
						type:"POST",
						//data:"username=jack&age=23",//请求参数
						data:{"uname":username},
						success:function (data) {//响应成功后的回调函数

							//判断userExsit键的值是否是true

							// alert(data);
							var span = $("#s_username");
							if(data.userExsit){
								//用户名存在
								span.css("color","red");
								span.html(data.msg);
							}else{
								//用户名不存在
								span.css("color","green");
								span.html(data.msg);
							}
						},
						error:function () {//响应失败后的回调函数
							alert("出错啦!")
						}

					})

					/*$.get("../findUserServlet",{"uname":username},function (data) {
						//判断userExsit键的值是否是true

						// alert(data);
						var span = $("#s_username");
						if(data.userExsit){
							//用户名存在
							span.css("color","red");
							span.html(data.msg);
						}else{
							//用户名不存在
							span.css("color","green");
							span.html(data.msg);
						}
					});*/

				});


				/*封装模态框*/
				window.Modal = function () {
					var reg = new RegExp("\\[([^\\[\\]]*?)\\]", 'igm');
					var alr = $("#ycf-alert");
					var ahtml = alr.html();

					//关闭时恢复 modal html 原样，供下次调用时 replace 用
					//var _init = function () {
					//	alr.on("hidden.bs.modal", function (e) {
					//		$(this).html(ahtml);
					//	});
					//}();

					/* html 复原不在 _init() 里面做了，重复调用时会有问题，直接在 _alert/_confirm 里面做 */

					var _tip = function (options, sec) {
						alr.html(ahtml);    // 复原
						alr.find('.ok').hide();
						alr.find('.cancel').hide();
						alr.find('.modal-content').width(500);
						_dialog(options, sec);

						return {
							on: function (callback) {
							}
						};
					};

					var _alert = function (options) {
						alr.html(ahtml);  // 复原
						alr.find('.ok').removeClass('btn-success').addClass('btn-primary');
						alr.find('.cancel').hide();
						_dialog(options);

						return {
							on: function (callback) {
								if (callback && callback instanceof Function) {
									alr.find('.ok').click(function () { callback(true) });
								}
							}
						};
					};


					var _confirm = function (options) {
						alr.html(ahtml); // 复原
						alr.find('.ok').removeClass('btn-primary').addClass('btn-success');
						alr.find('.cancel').show();
						_dialog(options);

						return {
							on: function (callback) {
								if (callback && callback instanceof Function) {
									alr.find('.ok').click(function () { callback(true) });
									alr.find('.cancel').click(function () { return; });
								}
							}
						};
					};


					var _dialog = function (options) {
						var ops = {
							msg: "提示内容",
							title: "操作提示",
							btnok: "确定",
							btncl: "取消"
						};

						$.extend(ops, options);

						console.log(alr);

						var html = alr.html().replace(reg, function (node, key) {
							return {
								Title: ops.title,
								Message: ops.msg,
								BtnOk: ops.btnok,
								BtnCancel: ops.btncl
							}[key];
						});
						alr.html(html);
						alr.modal({
							width: 250,
							backdrop: 'static'
						});
					}
					return {
						tip: _tip,
						alert: _alert,
						confirm: _confirm
					}
				}();


				// 删除模态框的确定按钮的点击事件
				$("#deleteHaulBtn").click(function() {

					// ajax异步删除
					deleteHaulinfo();
				});

			});

		</script>
	</head>

	<body>
		<!-- Modal 增加用户-->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">添加用户</h4>
					</div>
                    <form action="/AddUserServlet" method="post">
					<div class="modal-body">

								<div class="form-group row">
									<div class="col-xs-8">
										<label for="uname">用户名：</label>
										<input type="text" class="form-control" id="uname" name="uname" autocomplete="off" placeholder="Name">
                                        <span id="s_username"></span><br>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-8">
										<label for="upassword">密码：</label>
										<input type="password" class="form-control" id="upassword" name="upassword" autocomplete="off" placeholder="Password">
									</div>
								</div>
								<div class="form-group row">
									<div class="col-xs-8">
										<label for="uphone">手机号：</label>
										<input type="text" class="form-control" id="uphone" name="uphone" autocomplete="off" placeholder="Mobile">
									</div>
								</div>
								<div class="form-group row select">
									<div class="col-xs-4">
										<label for="uvalid">是否启用：</label>
										<select id="uvalid" name="uvalid" class="form-control">
											<option value="1">启用</option>
											<option value="0" style="color: red">禁用</option>
										</select>
									</div>
								</div>

					</div>
					<div class="form-group modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal"> 取 消 </button>
						<button type="submit" onclick="" class="btn btn-primary"> 提 交 </button>
					</div>
                    </form>
				</div>
			</div>
		</div>

		<!-- Modal 编辑用户-->
		<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="editModalLabel2">编辑用户</h4>
					</div>
					<form action="/UpdateUserServlet" method="post">
						<div class="modal-body">

							<div class="form-group row">
								<div class="col-xs-8">
									<label for="edituname">用户名：</label>
									<input type="hidden" class="form-control" id="edituid" name="edituid">
									<input type="text" class="form-control" id="edituname" name="edituname" autocomplete="off" >
									<span id="e_username"></span><br>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-8">
									<label for="editupassword">密码：</label>
									<input type="password" class="form-control" id="editupassword" name="editupassword" autocomplete="off" >
								</div>
							</div>
							<div class="form-group row">
								<div class="col-xs-8">
									<label for="edituphone">手机号：</label>
									<input type="text" class="form-control" id="edituphone" name="edituphone" autocomplete="off">
								</div>
							</div>
							<div class="form-group row select">
								<div class="col-xs-4">
									<label for="edituvalid">是否启用：</label>
									<select id="edituvalid" name="edituvalid" class="form-control">
										<option value="1">启用</option>
										<option value="0" style="color: red">禁用</option>
									</select>
								</div>
							</div>

						</div>
						<div class="form-group modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal"> 取 消 </button>
							<button type="submit" onclick="" class="btn btn-primary"> 提 交 </button>
						</div>
					</form>
				</div>
			</div>
		</div>

		<!-- 模态框   信息删除确认 -->
		<div class="modal fade" id="delcfmOverhaul">
			<div class="modal-dialog">
				<div class="modal-content message_align">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
						<h4 class="modal-title">提示</h4>
					</div>
					<div class="modal-body">
						<!-- 隐藏需要删除的id -->
						<input type="hidden" id="deleteHaulId" />
						<p>您确认要删除该条信息吗？</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default"
								data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-primary"
								id="deleteHaulBtn">确认</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>



		<!-- system modal start -->
		<div id="com-alert" class="modal" style="z-index:9999;display: none;" >
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
						<h5 class="modal-title"><i class="fa fa-exclamation-circle"></i> [Title]</h5>
					</div>
					<div class="modal-body small">
						<p>[Message]</p>
					</div>
					<div class="modal-footer" >
						<button type="button"  class="btn btn-primary ok" data-dismiss="modal">[BtnOk]</button>
						<button type="button"  class="btn btn-default cancel" data-dismiss="modal">[BtnCancel]</button>
					</div>
				</div>
			</div>
		</div>
		<!-- system modal end -->



		<!--<ol class="breadcrumb">
		  <li><a href="#">Home</a></li>
		  <li><a href="#">Library</a></li>
		  <li class="active">Data</li>
		</ol>-->
		<div class="">
			<form class="form-inline">
			<div class="col-sm-12  col-md-12  head">
				<div class="search">

						<div class="form-group">
							<label class="sr-only" for="exampleInputName">Name</label>
							<input type="text" class="form-control" autocomplete="off" placeholder="请输入用户名" name="uname" id="exampleInputName">
						</div>
						<div class="form-group">
							<label class="sr-only" for="exampleInputMobile">Mobile</label>
							<input type="text" class="form-control" autocomplete="off" placeholder="请输入手机号" name="uphone" id="exampleInputMobile">
						</div>

						<!--选是否有效-->
						<div class="form-group">
							<select class="form-control" name="uvalid">
								<option>不选择</option>
								<option>有效</option>
								<option>无效</option>
							</select>
						</div>
						<div class="form-group">
							<button class="btn btn-primary"><span class="glyphicon glyphicon-search"></span></button>
						</div>
				</div>
				<div style="margin-top: 20px" class="operate">
					<button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-plus-sign"></i> 添加</button>
				</div>
				<hr />
			</div>


			<div class="tablearea">
				<c:choose>
					<c:when test="${empty page.data}">
						<h1>暂时没值</h1>
					</c:when>
					<c:otherwise>
						<table class="table table-bordered table-hover">
							<thead>
								<tr>

									<th>ID</th>
									<th>用户名</th>
									<th>密码</th>
									<th>手机号</th>
									<th>状态</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${page.data}" var="user">
									<tr>
										<td>${user.uid}</td>
										<td>${user.uname}</td>
										<td>${user.upassword}</td>
										<td>${user.uphone}</td>
										<td>
											<c:choose>
												<c:when test="${user.uvalid==0}">
													<span style="color: red;">禁用</span>
												</c:when>
												<c:otherwise>
													<span>启用</span>
												</c:otherwise>
											</c:choose>
										</td>
										<td class="td-manage">
											<a class="btn btn-success btn-xs" onclick="updateQueryOne(${user.uid})" data-toggle="modal" data-target="#editModal" >
												编辑
											</a>
											<a class="btn btn-danger btn-xs" href="javascript:void(0)"  onclick="showDeleteModal(this,${user.uid})" >
												删除
											</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:otherwise>
				</c:choose>
			</div>

					<%--    <div class="fenyeindex  col-sm-4  col-md-4 ">
                            <span>共有${page.totalCount}条记录 每页<select class="" name="pageSize">
                                        <option>9</option>
                                        <option>8</option>
                                        <option>7</option>
                                        <option>6</option>
                                        <option>5</option>
                                        <option>4</option>
                                        <option>3</option>
                                        <option>2</option>
                                        <option>1</option>
                                    </select>条记录</span>
                        </div>
--%>

				<div class="row">
					<div id="totalCount" class="col-sm-2  col-md-2 ">
						<span>共有 ${page.totalPage} 页, ${page.totalCount} 条记录 </span>
					</div>
					<div class="col-sm-3  col-md-3  col-md-push-2">
						<nav  aria-label="Page navigation">
							<ul class="pagination" >
								<li>
									<a href="/UserListServlet?pageNum=1" aria-label="Previous">
										<span aria-hidden="true">&laquo;</span>
									</a>
								</li>
								<li>
									<a href="/UserListServlet?pageNum=${page.pageNum-1}" class="yema" class="layui-laypage-prev" data-page="5">上一页</a>
								</li>
								<li>
									<a href="/UserListServlet?pageNum=${page.pageNum+1}" class="yema" class="layui-laypage-prev" data-page="5">下一页</a>
								</li>
								<li>
									<a href="/UserListServlet?pageNum=${page.totalPage}" aria-label="Next">
										<span aria-hidden="true">&raquo;</span>
									</a>
								</li>
							</ul>
						</nav>
					</div>

				</div>


			</form>
		</div>

		<c:if test="${!empty msg}">
			<div id="tishikuang" class="alert alert-success alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<strong>${msg}</strong>
			</div>
			<%
				session.removeAttribute("msg");
			%>
		</c:if>

	</body>

</html>

<script type="text/javascript">
	/*<div class="alert alert-success" role="alert">...</div>*/

	function showDeleteModal(obj,id) {
		/*var $tds = $(obj).parent().parent().children();// 获取到所有列
		var delete_id = $($tds[0]).children("input").val();// 获取隐藏的ID*/

		$("#deleteHaulId").val(id);// 将模态框中隐藏的input的值ID设为需要删除的ID
		$("#delcfmOverhaul").modal({
			backdrop : 'static',
			keyboard : false
		});
	}

	function updateQueryOne(id) {
		$.ajax({
			url:"UpdateQueryOneServlet",
			type:"POST",
			//data:"username=jack&age=23",//请求参数
			data:{"uid":id},
			success:function (data) {//响应成功后的回调函数

				//判断userExsit键的值是否是true

				// alert(data);
				var edituid = $("#edituid");
				var edituname = $("#edituname");
				var editupassword = $("#editupassword");
				var edituphone = $("#edituphone");
				var edituvalid = $("#edituvalid");
				edituid.val(data.uid);
				edituname.val(data.uname);
				editupassword.val(data.upassword);
				edituphone.val(data.uphone);
				edituvalid.val(data.uvalid);

			},
			error:function () {//响应失败后的回调函数
				alert("出错啦!")
			}
		});
	}

	function deleteHaulinfo() {
		//alert("/DelUserServlet?uid="+$("#deleteHaulId").val());

		/*$.ajax({
			url:"/DelUserServlet",
			type:"POST",
			//data:"username=jack&age=23",//请求参数
			data:{"uid":$("#deleteHaulId").val()},
			success:function (data) {//响应成功后的回调函数
				showTip(data, 2000, function(){});
			},
			error:function () {//响应失败后的回调函数
				alert("出错啦!")
			}
		})*/

		window.location.href="/DelUserServlet?uid="+$("#deleteHaulId").val();

	}

	/**
	 * 显示提示消息（自动关闭）
	 * @param msg
	 * @param sec 显示时间（毫秒）
	 * @param callback 回调函数
	 */
	function showTip(msg, sec, callback){
		if(!sec) {
			sec = 1000;
		}
		Modal.tip({
			title:'提示',
			msg: msg
		}, sec);
		setTimeout(callback, sec);
	}

	/**
	 * 显示消息
	 * @param msg
	 */
	function showMsg(msg, callback){
		Modal.alert({
			title:'提示',
			msg: msg,
			btnok: '确定'
		}).on(function (e) {
			if(callback){
				callback();
			}
		});
	}

	/**
	 * 模态对话框
	 * @param msg
	 * @returns
	 */
	function showConfirm(msg,callback){
		//var res = false;
		Modal.confirm(
				{
					title:'提示',
					msg: msg,
				}).on( function (e) {
			callback();
			//res=true;
		});
		//return res;
	}


</script>