<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>

<%@ include file="../include/header.jsp"%>
<!DOCTYPE html>
<script src="/resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
		history.pushState(null, null, location.href);
		window.onpopstate = function(event) {
			history.go(1);
		};
		
		$(".btn-success").on("click", function() {
			if ("${id}" == "") {
				alert("로그인 해주세요.");
			}
			location.href = "/yshome/register";
		});
		
		if("${page.total > 4}") {
			$("#pp").css("width", "350px");
		} else {
			$("#pp").css("width", "200px");
		}
		
	});
</script>
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">LIST ALL PAGE</h3>
					<div style="width: 400; float: right;">
						<form action="listAll" name="frm" id="frm">
							<select name="searchType">
								<option value="" selected="selected"
									<c:out value="${page.searchType eq null ? 'selected' : ''}"/>>--선택하세요--</option>
								<option value="multi"
									<c:out value="${page.searchType eq 'multi' ? 'selected' : ''}"/>>제목+내용</option>
								<option value="title"
									<c:out value="${page.searchType eq 'title' ? 'selected' : ''}"/>>제목</option>
								<option value="content"
									<c:out value="${page.searchType eq 'content' ? 'selected' : ''}"/>>내용</option>
								<option value="writer"
									<c:out value="${page.searchType eq 'writer' ? 'selected' : ''}"/>>작성자</option>
							</select> <input type="text" name="keyWord" id="keyWord"
								placeholder="Search" value="${page.keyWord}">
							<button type="submit" id="btbt">Search</button>
							<!-- <div class="col-sm-6">
	    					<div class="input-group">
	      						<span class="input-group-btn">
								<button class="btn btn-default" type="button">Search</button>
	     						</span>
	      						<input type="text" class="form-control">
	    					</div>/input-group
						  </div>/.col-sm-6 -->
						</form>
					</div>
				</div>
				<div class="box-body">
					<table class="table table-bordered">
						<tr>
							<th style="width: 10px">BNO</th>
							<th>TITLE</th>
							<th>WRITER</th>
							<th>REGDATE</th>
							<th style="width: 40px">VIEWCNT</th>
						</tr>

						<c:forEach items="${list}" var="list">
							<tr>
								<td>${list.bno}</td>
								<td style="padding-left: <c:out value="${list.depth > 0 ? 20*list.depth : ''}"></c:out>px;"><div id="lt">
										<a href="detail?bno=${list.bno}&viewcnt=${list.viewcnt}">
										<c:if test="${list.depth > 0}">
										<img alt="comment" src="../resources/images/co.png" style="width: 15px; height: 17px; margin-right: 10px;">${list.title}
										</c:if>
										${list.title}</a>
									</div></td>
								<td>${list.writer}</td>
								<td>
									<%-- <fmt:parseDate value="${list.regdate}" var="dateFmt" pattern="yyyy-MM-dd"/> --%>
									<fmt:formatDate value="${list.regdate}"
										pattern="yyyy.MM.dd.HH:mm:ss" />
								</td>
								<td><span class="badge bg-ref">${list.viewcnt}</span></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div class="box-footer">
					<div style="width: 100px; float: left;">
						<button class="btn btn-success">Write</button>
					</div>
					<div id="pp" style="margin: 0 auto; width: 200px;">
						<select name="perPageNum" id="paperNum"
							onchange="location.href=this.value">
							<option>---선택하세요---</option>
							<option
								value="listAll?page=${page.page}&perPageNum=20&keyWord=${page.keyWord}&searchType=${page.searchType}">20개씩
								보기</option>
							<option
								value="listAll?page=${page.page}&perPageNum=30&keyWord=${page.keyWord}&searchType=${page.searchType}">30개씩
								보기</option>
							<option
								value="listAll?page=${page.page}&perPageNum=100&keyWord=${page.keyWord}&searchType=${page.searchType}">100개씩
								보기</option>
						</select>
						<c:if test="${!empty list}">
							<c:if test="${page.page > 1}">
								<a
									href="listAll?page=1&perPageNum=${page.perPageNum}&keyWord=${page.keyWord}&searchType=${page.searchType}"
									id="first">&lt;&lt;</a>
							</c:if>
							<c:if test="${page.page > 10}">
								<a
									href="listAll?page=${prev}&perPageNum=${page.perPageNum}&keyWord=${page.keyWord}&searchType=${page.searchType}"
									id="prev">&lt;</a>
							</c:if>
							<c:choose>
								<c:when test="${page.total % 10 == 0}">
									<c:forEach var="i" begin="${page.total-9}" end="${page.total}">
										<a
											href="listAll?page=${i}&perPageNum=${page.perPageNum}&keyWord=${page.keyWord}&searchType=${page.searchType}">${i}</a>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<c:forEach var="i" begin="${page.total-(page.total%10-1)}"
										end="${page.total}">
										<a
											href="listAll?page=${i}&perPageNum=${page.perPageNum}&keyWord=${page.keyWord}&searchType=${page.searchType}">${i}</a>
									</c:forEach>
								</c:otherwise>
							</c:choose>
							<c:if test="${prev1}">
								<a
									href="listAll?page=${next}&perPageNum=${page.perPageNum}&keyWord=${page.keyWord}&searchType=${page.searchType}"
									id="next">&gt;</a>
							</c:if>
							<c:if test="${prev1}">
								<a
									href="listAll?page=${lastpage}&perPageNum=${page.perPageNum}&keyWord=${page.keyWord}&searchType=${page.searchType}"
									id="last">&gt;&gt;</a>
							</c:if>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<%@ include file="../include/footer.jsp"%>