<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="${path}/resources/js/board.js"></script>
<script type="text/javascript">

	/* # 뷰 페이지 이동 */
	function fn_goView(seq){
		$("#seq").val(seq);
	
		var f = $("#frm");
		f.attr("action", "/board/view");
		f.attr("method", "POST");
		f.submit();
	};

	/*# 글 수정*/
	function fn_boardUpdate() {
		var seq = $("#seq").val();
		var subject = $("#subject").val();
		var name = $("#name").val();
		var content = $("#content").val();
		
		$.ajax({
			type : "POST",
			url : "/board/update",
			data : {seq : seq,
					subject : subject,
					name : name,
					content : content},
			success : function(data) {
				if(data=="Y") {
					alert("글 수정이 완료되었습니다.");
					fn_goView(seq);
				} else {
					alert("글 수정이 실패되었습니다.");
				}
			},
			error : function(data) {
				alert("실패");
				console.log(data);
			}
		});
	}
</script>
<title>Insert title here</title>
</head>
<body>
<form id="frm">
	<input type="hidden" value="${view.seq}" name="seq" id="seq">
	제목 : <input type="text" placeholder="제목" id="subject" name="subject" value="${view.subject}">
	작성자 : <input type="text" placeholder="작성자" id="name" name="name" readonly="readonly" value="${view.name}">
	<div>내용 : <input type="text" placeholder="내용" id="content" name="content" value="${view.content}"></div> 
	<button type="button" onclick="fn_boardUpdate();">등록</button>
</form>
</body>
</html>