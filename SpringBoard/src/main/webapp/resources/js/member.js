/**
 * 
 */
 
 function fn_login() {
	var id = $("#id").val();
	
	$.ajax({
		type : "POST",
		url : {id : id, password : password},
		success : function(data) {
			if(data == "Y") {
				location.href = "board/list";
			} else {
				alert("아이디 또는 비밀번호가 일치하지 않습니다.");
			}
		},
		error : function(data) {
			alert("아이디 또는 비밀번호가 일치하지 않습니다.");
		}
	});
	
};