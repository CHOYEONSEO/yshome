<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<%@ include file="../include/header.jsp"%>
<script src="/resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var RegexName = /^[가-힣a-zA-Z]{2,13}$/; //이름 유효성 검사 2~13자 사이
		var RegexId = /^[a-z0-9]{4,10}$/; //아이디 유효성 검사 4~10자 사이
		var RegexPw = /^[a-zA-Z0-9]{5,10}$/; //비밀번호  유효성 검사 5~10자 사이
		var RegexEmail = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i; //이메일 요휴성검사
		var RegexTel = /^[0-9_-]{9,11}$/; //전화번호 유효성 검사 
		var RegexAddr = /^[가-힣a-zA-Z0-9_-]{5,20}$/; //주소 유효성 검사

		$("#name").blur(function() {
			if (!RegexName.test($.trim($("#name").val()))) {
				$("#urename").html("한글 또는 영문으로 입력해주세요.").css("color", "red");
				$("#name").val("");
				return false;
			} else {
				$("#urename").html("").css("color", "blue");
			}
		});
		
 		$("#id").blur(function() {
			if (!RegexId.test($.trim($("#id").val()))) {
				$("#ureid").html("영문 또는 숫자만 입력해주세요.").css("color", "red");
				$("#id").val("");
				return false;
			} else {
				$.ajax({
					type:"POST",
					url:"/yshome/idCheck",
					dataType:"json",
					data:"id=" + $("#id").val(),
					success:function(data) {
						if (data > 0) {
							$("#ureid").html("중복된 아이디 입니다.").css("color", "red");
							$("#hid").val("0");
						} else {
							$("#ureid").html("사용 가능한 아이디 입니다.").css("color", "#9dcfff");
							$("#hid").val("1");
						}
					},
					error:function() {
						alert("시스템 에러");
					}
				});
				$("#ureid").html("");
			}
		});
 		
		$("#pw").blur(function() {
			if (!RegexPw.test($.trim($("#pw").val()))) {
				$("#urepw").html("영문과 숫자만 입력해주세요.").css("color", "red");
				$("#pw").val("");
				return false;
			} else {
				$("#urepw").html("");
			}
		});
		
		$("#pw1").blur(function() {
			if (!RegexPw.test($.trim($("#pw1").val()))) {
				$("#urepw1").html("영문과 숫자만 입력해주세요.").css("color", "red");
				$("#pw1").val("");
				return false;
			} else {
				$("#urepw1").html("");
			}
		});
		
		$("#addr").blur(function() {
			if (!RegexAddr.test($.trim($("#addr").val()))) {
				$("#ureaddr").html("주소를 다시 입력해주세요.").css("color", "red");
				$("#addr").val("");
				return false;
			} else {
				$("#ureaddr").html("");
			}
		});
		
		$("#email").blur(function() {
			if (!RegexEmail.test($.trim($("#email").val()))) {
				$("#ureemail").html("다시 입력해주세요.").css("color", "red");
				$("#email").val("");
				return false;
			} else {
				$("#ureemail").html("");
			}
		});
		
		$(".btn-primary").click(function() {
			if ($("#name").val() == "") {
				$("#name").focus();
				alert("이름을 입력해 주세요.");
				return false;
			}
			
			if ($("#id").val() == "1") {
				$("#id").focus();
				alert("아이디를 입력해 주세요.");
				return false;
			}
			
			if ($("#hid").val() != "1") {
				$("#id").focus();
				alert("중복된 아이디 입니다.");
				return false;
			}
			
			if ($("#pw").val() == "") {
				$("#pw").focus();
				alert("비밀번호를 입력해 주세요.");
				return false;
			}
			
			if ($("#pw1").val() == "") {
				$("#pw1").focus();
				alert("비밀번호 확인을 입력해 주세요.");
				return false;
			}
			
			if ($("#addr").val() == "") {
				$("#addr").focus();
				alert("주소를 입력해주세요.");
				return false;
			}
			
			alert("회원가입되었습니다. 로그인해주세요.");
		});

		$(".btn-danger").on("click", function() {
			location.href = "/yshome/login_form";
		});
	});
</script>
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">JOIN</h3>
				</div>
				<form action="join" method="post" name="frm" id="frm">
					<div class="box-body">
						<div class="form-group">
							<label for="uname">* NAME : </label>
							<label id="urename"></label>
							<input type="text" id="name" name="name" class="form-control" 
							placeholder="NAME" maxlength="13">
						</div>

						<div class="form-group">
							<label for="uid">* ID : </label> 
							<label id="ureid"></label>
							<input type="text" id="id" name="id" class="form-control" 
							placeholder="ID" maxlength="10">
							<input type="hidden" id="hid">
						</div>

						<div class="form-group">
							<label for="upw">* PASSWORD : </label>
							<label id="urepw"></label>
							<input type="password" id="pw" name="pw" class="form-control" 
							placeholder="PASSWORD" maxlength="15">
						</div>

						<div class="form-group">
							<label for="upw1">* RE PASSWORD : </label>
							<label id="urepw1"></label>
							<input type="password" id="pw1" name="pw1" class="form-control" 
							placeholder="RE PASSWORD" maxlength="15">
						</div>

						<div class="form-group">
							<label for="unick">NICK NAME : </label> 
							<input type="text" id="nick" name="nick" class="form-control" 
							placeholder="NICK NAME" maxlength="15">
						</div>

						<div class="form-group">
							<label for="uaddr">* ADDRESS : </label>
							<label id="ureaddr"></label>
							<input type="text" id="addr" name="addr" class="form-control" 
							placeholder="ADDRESS" maxlength="30">
						</div>

						<div class="form-group">
							<label for="uemail">EMAIL : </label>
							<label id="ureemail"></label>
							<input type="text" id="email" name="email" class="form-control" 
							placeholder="EMAIL" maxlength="20">
						</div>

						<div class="form-group">
							<label for="ubirth">BIRTH</label> <input type="date" id="birth"
								name="birth">
						</div>

						<div class="btbt" style="width: 100%;">
							<div style="margin: 0 auto; width: 604px;">
								<button type="submit" class="btn btn-primary"
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