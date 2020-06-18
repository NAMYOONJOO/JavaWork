var depth = 1;
var parent = 0;

$(document).ready(function() {
	loadCate();

	$("select").change(function() {
		if($(this).val()>0){
			parent = $(this).val();
			depth = $("select").index(this) + 2;
		}else{
			parent = -$(this).val();
			depth = $("select").index(this) + 1;
		}
		loadCate();
	})

});

function loadCate() {
	$.ajax({
		url : "list.ajax",
		type : "post",
		cache : false,
		data : {
			depth : depth,
			parent : parent
		},
		success : function(data, status) {
			if (status == "success") {
				updateCate1(data)
			} else {
				alert("실패")
			}
		}
	});

}
function updateCate1(jsonObj) {
	result = "<option value='-"+parent+"'>--선택하세요--</option>";
	if (jsonObj.status == "OK") {
		var count = jsonObj.count;
		var i;
		var items = jsonObj.list; // 배열
		for (i = 0; i < count; i++) {
			result += "<option value=" + items[i].uid + ">" + items[i].name+ "</option>"
		}

		$("select:eq(" + (depth - 1) + ")").html(result);
		$("select:eq(" + (depth - 1) + ")").removeAttr('disabled');
		for (var i = depth; i <= 2; i++) {
			$("select:eq(" + i + ")").html("");
			$("select:eq(" + i + ")").attr("disabled", "disabled")
		}

	} else {
	}

}

/*
 * if (depth ==1) { $("select:eq(0)").html(result);
 * $("select:eq(0)").removeAttr('disabled'); $("select:eq(1)").html("");
 * $("select:eq(1)").attr("disabled","disabled") $("select:eq(2)").html("");
 * $("select:eq(2)").attr("disabled","disabled") } else if (depth == 2) {
 * $("select:eq(1)").html(result); $("select:eq(1)").removeAttr('disabled');
 * $("select:eq(2)").html(""); $("select:eq(2)").attr("disabled","disabled") }
 * else if (depth == 3) { $("select:eq(2)").html(result);
 * $("select:eq(2)").removeAttr('disabled'); }
 */