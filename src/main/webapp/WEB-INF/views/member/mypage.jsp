<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<%@ include file="../include/header.jsp"%>
<script src="/resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script>
	$(document).ready(function() {
		$(".btn-primary").on("click", function() {
			$(".btn-warning").show();
		});
		
		$(".btn-danger").on("click", function() {
			location.href = "/yshome/listAll";
		});
		
		$(".btn-info").on("click", function() {
			$("#frm").attr("action", "/yshome/mypageEdit").submit();
		});
		
		$(".btn-warning").on("click", function() {
			alert("탈퇴되었습니다.");
			$("#frm").attr("action", "/yshome/delete").submit();
		});
		
		if("${msg}" != "") {
			alert("비밀번호를 다시 입력해주세요.");
		}
		if ("${succ}" == "1") {
			$("input[name='addr']").attr("readonly", false);
			$("input[name='email']").attr("readonly", false);
			$("input[name='birth']").attr("readonly", false);
			$(".btn-primary").hide();
		} else {
			$(".btn-info").hide();
		}
	});
</script>
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">JOIN</h3>
					<c:if test="${!empty succ}">
					<button type="button" class="btn btn-warning" style="width: 100px; float: right;">Withdrawal</button>
					</c:if>
				</div>
				<form action="mypageEdit_form" method="post" name="frm" id="frm">
					<div class="box-body">
						<div class="form-group">
							<label for="uname">* NAME : </label>
							<label id="urename"></label>
							<input type="text" id="name" name="name" class="form-control" 
							placeholder="NAME" maxlength="13" value="${mlist.name}" readonly="readonly">
						</div>

						<div class="form-group">
							<label for="uid">* ID : </label> 
							<label id="ureid"></label>
							<input type="text" id="id" name="id" class="form-control" 
							placeholder="ID" maxlength="10" value="${mlist.id}" readonly="readonly">
							<input type="hidden" id="hid">
						</div>

						<div class="form-group">
							<label for="upw">* PASSWORD : </label>
							<label id="urepw"></label>
							<input type="password" id="pw" name="pw" class="form-control" 
							placeholder="PASSWORD" maxlength="15" value="${mlist.pw}">
						</div>

<!-- 						<div class="form-group">
							<label for="upw1">* RE PASSWORD : </label>
							<label id="urepw1"></label>
							<input type="password" id="pw1" name="pw1" class="form-control" 
							placeholder="RE PASSWORD" maxlength="15">
						</div> -->

						<div class="form-group">
							<label for="unick">NICK NAME : </label> 
							<input type="text" id="nick" name="nick" class="form-control" 
							placeholder="NICK NAME" maxlength="15" value="${mlist.nick}" readonly="readonly">
						</div>

						<div class="form-group">
							<label for="uaddr">* ADDRESS : </label>
							<label id="ureaddr"></label>
							<input type="text" id="addr" name="addr" class="form-control" 
							placeholder="ADDRESS" maxlength="30" value="${mlist.addr}" readonly="readonly">
						</div>

						<div class="form-group">
							<label for="uemail">EMAIL : </label>
							<label id="ureemail"></label>
							<input type="text" id="email" name="email" class="form-control" 
							placeholder="EMAIL" maxlength="20" value="${mlist.email}" readonly="readonly">
						</div>

						<div class="form-group">
							<label for="ubirth">BIRTH</label> <input type="date" id="birth"
								name="birth" value="${mlist.birth}" readonly="readonly">
						</div>

						<div class="btbt" style="width: 100%;">
							<div style="margin: 0 auto; width: 604px;">
								<button type="submit" class="btn btn-primary"
									style="width: 300px">Edit</button>
								<button type="button" class="btn btn-info"
									style="width: 300px">OK</button>
								<button type="button" class="btn btn-danger"
									style="width: 300px">Back</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</section>
<%@ include file="../include/footer.jsp"%>