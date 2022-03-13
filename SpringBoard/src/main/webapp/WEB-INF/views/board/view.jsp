<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	/*# 글 삭제*/
	function fn_boardDelete(seq) {
		$.ajax({
			type : "POST",
			url : "/board/delete",
			data : {seq : seq},
			success : function(data) {
				if(data == "Y") {
					alert("글 삭제가 완료되었습니다.");
					location.href = "/board/list";
				}
			},
			error : function(data) {
				alert("실패");
				console.log(data);
			}
		});
	}
	
	/*# 수정 뷰 이동*/
	function fn_goUpdateView(seq) {
		$("#seq").val(seq);
		
		var f = $("#frm");
		f.attr("action", "/board/goUpdateView");
		f.attr("method", "POST");
		f.submit();
	};
</script>
<title>Insert title here</title>
</head>
<body>

	<form id="frm">
		<input type="hidden" value="" name="seq" id="seq">
		<div>제목 : ${view.subject} 조회수 : ${view.readCount}</div>
		<div>작성자 : ${view.name}</div>
		<div>내용 : ${view.content} </div>
		<button type="button" onclick='location.href="/board/list"'>목록</button>
		<button type="button" onclick='fn_goUpdateView(${view.seq})'>수정</button>
		<button type="button" onclick='fn_boardDelete(${view.seq})'>삭제</button>
	</form>
	
</body>
</html>