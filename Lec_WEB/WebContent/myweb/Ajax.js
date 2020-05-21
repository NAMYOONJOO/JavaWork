//kakao map
// var x = 126.244675;
// var y  = 37.533962;
// var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
//                 mapOption = { 
//                     center: new kakao.maps.LatLng(y, x), // 지도의 중심좌표
//                     level: 4 // 지도의 확대 레벨
//                 };
            
// var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// var imageSrc = 'https://www.galanni.com.au/wp-content/uploads/2017/08/cropped-G-LOGO-1.png', // 마커이미지의 주소입니다    
// 	imageSize = new kakao.maps.Size(64, 69), // 마커이미지의 크기입니다
// 	imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
		
// // 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
// var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
// 	markerPosition = new kakao.maps.LatLng(y, x); // 마커가 표시될 위치입니다

// // 마커를 생성합니다
// var marker = new kakao.maps.Marker({
// 	position: markerPosition, 
// 	image: markerImage // 마커이미지 설정 
// });

// // 마커가 지도 위에 표시되도록 설정합니다
// marker.setMap(map);  


			
//kakao local
$(document).ready(function(){
// $.ajax({
//     url: 'https://dapi.kakao.com/v2/local/search/address.json?query=인천',
//     headers: {Authorization: "KakaoAK ad5d4e40850394cbdf4da8bbdd046a92"},
//     type: 'GET'
// }).done(function(data) {
//     console.log(data);
// });
$("#btn_search").click(function(){

document.getElementById('map').style.display='block'
// var q = "서울시"; //검색 내용
var q= document.getElementById("location").value.trim();
	//ajax 시작
	//adress
	$.ajax({
		url : 'https://dapi.kakao.com/v2/local/search/address.json',
		headers : { 'Authorization': 'KakaoAK 96456f6d0e5f0db221b5025473bb3a0e'},	
		type: 'GET',
		data : { 'query' : q },
		success : function(data){
            //호출 성공하면 작성할 내용
            if(data.documents.length != 0 ){ // 값이 있으면
                parseJSON(data)
                
			}
		}, 
		error:function(request,status,error){
		    alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	}).done(function(data){console.log(data);});	



})
function parseJSON(jsonObj) {
	var x =  jsonObj.documents[0].x;
	var y = jsonObj.documents[0].y
	// alert(x)
	// alert(y)
	
	
	
	// var x = 126.244675;
	// var y  = 37.533962;
	// var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	// 				mapOption = { 
	// 					center: new kakao.maps.LatLng(y, x), // 지도의 중심좌표
	// 					level: 4 // 지도의 확대 레벨
	// 				};
				
	// var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

	// var imageSrc = 'https://www.galanni.com.au/wp-content/uploads/2017/08/cropped-G-LOGO-1.png', // 마커이미지의 주소입니다    
	// 	imageSize = new kakao.maps.Size(64, 69), // 마커이미지의 크기입니다
	// 	imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
			
	// // 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
	// var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
	// 	markerPosition = new kakao.maps.LatLng(y, x); // 마커가 표시될 위치입니다

	// // 마커를 생성합니다
	// var marker = new kakao.maps.Marker({
	// 	position: markerPosition, 
	// 	image: markerImage // 마커이미지 설정 
	// });

	// // 마커가 지도 위에 표시되도록 설정합니다
	// marker.setMap(map);  
	
	
	
	// 키워드로 장소검색
	$.ajax({
		url : 'https://dapi.kakao.com/v2/local/search/keyword.json',
		headers : { 'Authorization': 'KakaoAK 96456f6d0e5f0db221b5025473bb3a0e'},	
		type: 'GET',
		data : { 'query' : "스타벅스", "x":x,"y":y},
		success : function(data){
            //호출 성공하면 작성할 내용
			if(data.documents.length != 0 ){ // 값이 있으면
				// alert("성공?")
                parseJSON2(data) // 15개가 넘어온다

			}
		}, 
		error:function(request,status,error){
		    alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	}).done(function(data){console.log(data);});	

}

function parseJSON2(jsonObj) {
	
	

//place list

var documents = jsonObj.documents
		var table = ""

		var i;
	
		for (i = 0; i < documents.length; i++) {
			table += "<tr>";
			table += "<td><h2><i class='fas fa-map-marker-alt'> 골드커피 "+documents[i].place_name.split(" ")[1]+"</h2></td>"
			table += "<td><h3>"+documents[i].address_name+"</h3></td>"
			table += "<td><button>배달선택</button><br><div class='clear'></div><button>포장선택</button></td>"
			table += "</tr>";
			table += "<hr>";
		}
		$("#storelist").html(table);

		$('#resultlocation').text("매장검색결과 "+ documents.length+" 건")






//지도
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
    mapOption = { 
        center: new kakao.maps.LatLng(/*TODO*/jsonObj.documents[0].y, jsonObj.documents[0].x), // 지도의 중심좌표
        level: 5 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
 
// 마커를 표시할 위치와 title 객체 배열입니다 
var positions = [
    {
        latlng: new kakao.maps.LatLng(jsonObj.documents[0].y, jsonObj.documents[0].x)
    },
    {
        latlng: new kakao.maps.LatLng(jsonObj.documents[1].y, jsonObj.documents[1].x)
	},
	{
        latlng: new kakao.maps.LatLng(jsonObj.documents[2].y, jsonObj.documents[2].x)
	},
	{
        latlng: new kakao.maps.LatLng(jsonObj.documents[3].y, jsonObj.documents[3].x)
	},
	{
        latlng: new kakao.maps.LatLng(jsonObj.documents[4].y, jsonObj.documents[4].x)
	},
	{
        latlng: new kakao.maps.LatLng(jsonObj.documents[5].y, jsonObj.documents[5].x)
	},
	{
        latlng: new kakao.maps.LatLng(jsonObj.documents[6].y, jsonObj.documents[6].x)
	},
	{
        latlng: new kakao.maps.LatLng(jsonObj.documents[7].y, jsonObj.documents[7].x)
	},
	{
        latlng: new kakao.maps.LatLng(jsonObj.documents[8].y, jsonObj.documents[8].x)
	},
	{
        latlng: new kakao.maps.LatLng(jsonObj.documents[9].y, jsonObj.documents[9].x)
	},
	{
        latlng: new kakao.maps.LatLng(jsonObj.documents[10].y, jsonObj.documents[10].x)
	},
	{
        latlng: new kakao.maps.LatLng(jsonObj.documents[11].y, jsonObj.documents[11].x)
	},
	{
        latlng: new kakao.maps.LatLng(jsonObj.documents[12].y, jsonObj.documents[12].x)
	},
	{
        latlng: new kakao.maps.LatLng(jsonObj.documents[13].y, jsonObj.documents[13].x)
	},
	{
        latlng: new kakao.maps.LatLng(jsonObj.documents[14].y, jsonObj.documents[14].x)
    },
];

// 마커 이미지의 이미지 주소입니다
var imageSrc = "https://www.galanni.com.au/wp-content/uploads/2017/08/cropped-G-LOGO-1.png"; 
    
for (var i = 0; i < positions.length; i ++) {
    
    // 마커 이미지의 이미지 크기 입니다
    var imageSize = new kakao.maps.Size(24, 24); 
    
    // 마커 이미지를 생성합니다    
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
    
    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: positions[i].latlng, // 마커를 표시할 위치
        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
        image : markerImage // 마커 이미지 
    });
}


}


})
