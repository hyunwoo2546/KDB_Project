/**
 * 
 */
 
 function fn_boardRegi(){
	var data = $("#frm").serialize();
	
	$.ajax({
		type : "POST",
		url : "/board/regi",
		data : data,
		success: function(data){
			if(data == "Y"){
				alert("글 등록이 완료되었습니다.");
				location.href = "/board/list";		
			}
		},
		error: function(data){
			alert("실패");
			console.log(data);
		}
	});
};