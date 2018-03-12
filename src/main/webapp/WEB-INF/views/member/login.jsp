<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<%@ include file="../include/header.jsp"%>
<script src="/resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".btn-info").on("click", function() {
			location.href = "/yshome/join_form";
		});
		
	});
</script>
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">LOGIN</h3>
				</div>
				<security:authorize access="isAnonymous()">
				<form action='<c:url value="/yshome/loginProcess"/>' method="post">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
					<div class="box-body">
						<div class="form-group">
							<label for="id">ID : </label> <input type="text" id="id"
								name="id" class="form-control" placeholder="ID" maxlength="10">
						</div>
						<div class="form-group">
							<label for="content">PASSWORD</label>
							<input type="password" id="pw" name="pw" class="form-control" placeholder="PASSWORD" maxlength="15">
						</div>
						<div class="form-group" style="width: 500px; height: 30px; margin: 0 auto 5px; color: red;">
							<span style="margin: 0 auto;">
								<c:if test="${param.error != null}">
									<p>아이디 또는 비밀번호가 잘못되었습니다.</p>
								</c:if>
							</span>
						</div>
						<div class="btbt" style="width: 100%;">
							<div style="margin: 0 auto; width: 604px;">
							<button type="submit" class="btn btn-primary" style="width: 300px">LOGIN</button>
							<button type="button" class="btn btn-info" style="width: 300px">JOIN</button>
							</div>
						</div>
					</div>
				</form>
				</security:authorize>
			</div>
		</div>
	</div>
</section>
<%@ include file="../include/footer.jsp"%>