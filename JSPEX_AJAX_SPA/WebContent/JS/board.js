var page = 1  // 현재 페이지 
var pageRows = 10   // 한 페이지에 보여지는 게시글 개수

$(document).ready(function(){
	// 게시판 목록 1페이지 로딩
	loadPage(page);
	
});

// page 번째 페이지 로딩
function loadPage(page){
	
	$.ajax({
		url : "list.ajax?page=" + page + "&pageRows=" + pageRows
		, type : "GET"
		, cache : false
		, success : function(data, status){
			if(status == "success"){
				//alert("AJAX 성공: 받아쮸~");
				updateList(data);
			}			
		}
	});
} // end loadPage()

// 
function updateList(jsonObj){
	result = ""; 
	
	if(jsonObj.status == "OK"){
		
		var count = jsonObj.count;
		
		// 전역변수 업데이트!
		window.page = jsonObj.page;
		window.pageRows = jsonObj.pagerows;
		
		var i;
		var items = jsonObj.data;   // 배열
		for(i = 0; i < count; i++){
			result += "<tr>\n";
			result += "<td>" + "</td>\n";
			result += "<td>" + items[i].uid + "</td>\n";
			result += "<td>" + items[i].subject + "</td>\n";
			result += "<td>" + items[i].name + "</td>\n";
			result += "<td>" + items[i].viewcnt + "</td>\n";
			result += "<td>" + items[i].regdate + "</td>\n";			
			result += "</tr>\n";
		} // end for
		$("#list tbody").html(result);  // 테이블 업데이트!
		
		// 페이지 정보 업데이트
		$("#pageinfo").text(jsonObj.page + "/" + jsonObj.totalpage + "페이지, " + jsonObj.totalcnt + "개의 글");
		
		
		
		return true;
	} else {
		alert(jsonObj.message);
		return false;
	}
	return false;
}




































