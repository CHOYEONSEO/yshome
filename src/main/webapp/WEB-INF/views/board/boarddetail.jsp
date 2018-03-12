<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp"%>

<script src="/resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".btn-warning").on("click", function() {
			$("#frm").attr("action", "/yshome/modify_form").submit();
		});

		$(".btn-danger").on("click", function() {
			if ($("#Cid").val() == "${listDetail.writer}") {
				$("#frm").attr("action", "/yshome/remove").submit();
				alert("글이 삭제 되었습니다.");
			}
		});

		$(".btn-primary").on("click", function() {
			$(location).attr("href", "/yshome/listAll");
		});
		
		$(".btn-success").on("click", function() {
			if ($("#Cid").val() == "") {
				alert("로그인해 주세요.");
				$(location).attr("href", "/yshome/login_form");
				return false;
			} 
			
			if ($("#Ctitle").val() == "") {
				alert("제목을 입력해 주세요.");
				return false;
			}
		});
		
		$("#nextclick").on("click", function() {
			$("#frm1").attr("action", "/yshome/detail").submit();
		});

		$("#prevclick").on("click", function() {
			$("#frm2").attr("action", "/yshome/detail").submit();
		});

		if ($("#next").val() == "") {
			$("#nextclick").hide();
			return false;
		}
		if ($("#prev").val() == "") {
			$("#prevclick").hide();
			return false;
		}
	});
</script>
<script>
	/* history.pushState(null, null, location.href); 
	 window.onpopstate = function(event) { 
	 history.go(1); 
	 } */
</script>
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">READ BOARD</h3>
				</div>
				<form action="/yshome/modify_form" method="post" name="frm" id="frm">
					<input type="hidden" id="bno" name="bno" value="${listDetail.bno}">
				</form>
				<div class="box-body">
					<div class="form-group">
						<label for="title">Title</label> <input type="text" id="title"
							name="title" class="form-control" value="${listDetail.title}"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="content">Content</label>
						<textarea class="form-control" rows="3" id="content"
							name="content" readonly="readonly">${listDetail.content}</textarea>
					</div>
					<div class="form-group">
						<label for="writer">Writer</label> <input type="text" id="writer"
							name="writer" class="form-control" value="${listDetail.writer}"
							readonly="readonly">
					</div>
				</div>
				<div class="box-body">
					<form action="/yshome/comment">
						<input type="hidden" name="bgroup" value="${listDetail.bgroup}">
						<input type="hidden" name="bseq" value="${listDetail.bno}">
						<input type="hidden" name="depth" value="${listDetail.depth + 1}">
						<div class="box-body">
							<div class="form-group">
								<label for="title">Title</label> <input type="text" id="Ctitle"
									name="title" class="form-control" placeholder="Enter Title">
							</div>
							<div class="form-group">
								<label for="content">Content</label>
								<textarea id="content" name="content" class="form-control"
									rows="3" placeholder="Enter ..."></textarea>
							</div>
							<div class="form-group">
								<label for="writer">Writer</label> <input type="text"
									id="writer" name="writer" class="form-control"
									placeholder="Enter writer" value="${id}" readonly="readonly">
									<hr>
								<button class="btn btn-success">Comment</button>
							</div>
						</div>
					</form>
				</div>
				<div class="box-footer">
				<c:if test="${id eq listDetail.writer}">
					<button type="submit" class="btn btn-warning">Modify</button>
					<button type="submit" class="btn btn-danger">Remove</button>
				</c:if>
					<button type="submit" class="btn btn-info" id="prevclick">Prev
						page</button>
					<button type="submit" class="btn btn-primary">List All</button>
					<button type="submit" class="btn btn-info" id="nextclick">Next
						page</button>
					<form action="/yshome/detail" name="frm1" id="frm1">
						<input type="hidden" name="bno" value="${listDetail.nextbno}"
							id="next"> <input type="hidden" name="viewcnt"
							value="${listDetail.nextviewcnt}">
					</form>
					<form action="/yshome/detail" name="frm2" id="frm2">
						<input type="hidden" name="bno" value="${listDetail.prevbno}"
							id="prev"> <input type="hidden" name="viewcnt"
							value="${listDetail.prevviewcnt}">
						<input type="hidden" value="${id}" id="Cid">
					</form>
				</div>
			</div>
		</div>
	</div>
</section>
<%@ include file="../include/footer.jsp"%>
<%-- <body>
${listDetail.nextbno}
${listDetail.prevbno}
				<form action="update_form" name="frmup">
					<input type="hidden" name="bno" value="${listDetail.bno}">
					<input type="hidden" name="writer" value="${listDetail.writer}">
					<input type="submit" value="수정">
				</form>
<form action="delete" name="frmdel">
	<input type="hidden" name="bno" value="${listDetail.bno}">
	<input type="submit" value="삭제">
</form>
<form action="detail" name="frmnext">
	<input type="submit" value="다음글" id="nextclick">
</form>
<form action="detail" name="frmprev">
	<input type="submit" value="이전글" id="prevclick">
</form>
</body> --%>
