<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>
<script>
$(document).ready(function() {
	$(".btn-primary").on("click", function() {
		$(location).attr("href", "/yshome/listAll");
	});
	
	$(".btn-warning").on("click", function() {
		$("#frm").attr("action", "/yshome/modify").submit();
	});
	
});
</script>
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">Modify BOARD</h3>
				</div>
				<form action="/yshome/modify" method="post" name="frm" id="frm">
					<label for="bno">No.</label> <input type="text" id="bno" name="bno"
						value="${listDetail.bno}" readonly="readonly">
					<div class="box-body">
						<div class="form-group">
							<label for="title">Title</label> <input type="text" id="title"
								name="title" class="form-control">
						</div>
						<div class="form-group">
							<label for="content">Content</label>
							<textarea class="form-control" rows="3" id="content"
								name="content"></textarea>
						</div>
						<div class="form-group">
							<label for="writer">Writer</label> <input type="text" id="writer"
								name="writer" class="form-control" value="${listDetail.writer }" readonly="readonly">
						</div>
					</div>
				</form>
				<div class="box-footer">
					<button type="submit" class="btn btn-warning">Ok</button>
					<button type="submit" class="btn btn-primary">List All</button>
				</div>
			</div>
		</div>
	</div>
</section>

<%@ include file="../include/footer.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>