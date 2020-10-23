<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- 부트스트랩 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">



<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/CSS/reset.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/CSS/Hoxy2.css" />


<link
	href="https://fonts.googleapis.com/css2?family=Fredoka+One&family=Noto+Serif+KR:wght@200;300&display=swap"
	rel="stylesheet">

<!-- font-family: 'Noto Serif KR', serif; -->


<!-- fonta -->
<script src="https://kit.fontawesome.com/a076d05399.js"></script>

<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath }/JS/yj.js"></script>


<title>남윤주_Nam Yoon Joo</title>
</head>
<body>
	<div id="side_bar">
		<div class="side_btn ff_Noto" id="nav_box1">기획의도</div>
		<div class="side_btn ff_Noto" id="nav_box2">Project</div>
		<div class="side_btn ff_Noto" id="nav_box3">개발환경/사용기술</div>
		<div class="side_btn ff_Noto" id="nav_box4">소개</div>
		<div class="side_btn ff_Noto" id="nav_box5">제작문서</div>
		<div class="side_btn ff_Noto" id="nav_box6">발표영상</div>
		<div class="side_btn ff_Noto" id="nav_box8">GitHub</div>
	</div>
	<div class="mid_80">
		<nav id="main_nav">
			<ul>
				<li class="inline fw_bold "
					onclick="location.href='http://www.runzhu.shop/ProjectHoxy/contactme'">Contact
					me</li>
				<li class="inline fw_bold"
					onclick="location.href='http://www.runzhu.shop/ProjectHoxy/'">Project</li>
			</ul>
		</nav>
	</div>
	<div class="mid_80">
		<div class="row">
			<div class="col-md-6" id="main1">
				<div class="mg_t100"></div>
				<h1 class="ff_Noto fs_xxlarge mg25_bt fw_bold">원스톱 인테리어 플랫폼 너네집</h1>
				<h1 class="ff_Noto mg25_bt fs_xlarge fw_bold">One-stop interior
					platform</h1>
				<!--<h1 class="ff_Noto mg_t50 mg10_bt">간편한 입사지원과 기업정보공유를 통해</h1>-->
				<h1 class="ff_Noto mg_t50 mg25_bt">SNS적인 인테리어 정보공유서비스, 쇼핑서비스, 시공서비스를 온라인으로 제공함으로써 인테리어의 모든 고민을 한 번에 해결해 줍니다.</h1>
				<button class="yellow_border_btn"
					onclick="window.open('https://youtu.be/jAuwcbxZ_68', 'TEAM5 발표영상');">발표영상 바로보기</button>

			</div>
			<div class="col-md-6" id="main2">
				<div id="img1"></div>
			</div>

		</div>
	</div>
	<div class="mid_80 fs_xlarge" id="nav_position_1">
		<h1 class="ff_Noto fw_bold tt">기획의도</h1>
	</div>
	<div class="yello_box">
		<div class="mid_80">
			<h1 class="ff_Noto fw_bold fs_medium">
				&nbsp;&nbsp;저는 20살부터 4년 동안 자취한 적이 있습니다. 대학생이라는 신분으로 홀로 적은 자금으로 생활했기
				때문에 업체에 인테리어 시공을 맡기기보다 셀프 도배 방법을 찾아보고 직접 가구를 주문해 조립하며 집을 꾸몄던 소소한 경험이
				떠올랐고 오늘날 2000년대 이후 미혼율, 이혼율이 높아져 1인 가구의 비중이 높아지는 시대에 평소 어려움을 느꼈던
				인테리어라는 분야에 변화가 필요하다고 생각하게 되었습니다. 그래서 혼자 생활했을 당시 자주 이용했던 ‘오늘의 집’이라는
				인테리어 정보서비스 페이지를 떠올리게 되었고 벤치 마킹해 ‘인테리어 원스톱 플랫폼 페이지’를 주제로 Servlet과 연계한 MVC Model 2 기반 웹 애플리케이션을 설계하게
				되었습니다. <br> <br>&nbsp;&nbsp;프로젝트는 홈페이지에 회원운영서비스를 도입해 회원간
				SNS 적인 소통방식으로 인테리어 정보를 공유하고, 쇼핑 서비스를 제공함으로써 누구나 쉽게 인테리어라는 주제에 관심을 둘
				수 있도록 했습니다. 또한, 인테리어 시공정보제공, 예약서비스를 온라인으로 제공함으로써 인테리어 모든 고민을 한 곳에서
				해결할 수 있도록 프로젝트를 기획하게 되었습니다.
			</h1>
		</div>
	</div>
	<div class="mid_80 fs_xlarge lineh_40 row" id="nav_position_2">
		<h1 class="ff_Noto fw_bold tt mg50_bt">Project</h1>
		<div class="col-md-12"></div>
		<div class="col-md-6">
			<h1 class="ff_Noto fw_bold fs_medium">프로젝트명 : 원스톱 인테리어 플랫폼 ('너네
				집')</h1>
			<h1 class="ff_Noto fw_bold fs_medium">팀명 : TEAM5</h1>
			<h1 class="ff_Noto fw_bold fs_medium">기간 : 2020.05.25 ~
				2020.06.15</h1>

		</div>
		<div class="col-md-6">
			<h1 class="ff_Noto fw_bold fs_medium">팀원</h1>
			<h1 class="ff_Noto fw_bold fs_medium">남윤주 (팀장) : 프로젝트 총괄, 스토어 구현</h1>
			<h1 class="ff_Noto fw_bold fs_medium">김우경 : 스토어, 상품 구현</h1>
			<h1 class="ff_Noto fw_bold fs_medium">정종훈 : 구매프로세스</h1>
			<h1 class="ff_Noto fw_bold fs_medium">박빈나 : 커뮤니티 구현</h1>
			<h1 class="ff_Noto fw_bold fs_medium">이성준 : 회원관리 구현</h1>


		</div>
	</div>
	<div class="mid_80 fs_xlarge" id="nav_position_3">
		<h1 class="ff_Noto fw_bold tt">개발환경 & 사용기술</h1>
		<img id="img8" src="https://i.imgur.com/vtDJjvE.png">
	</div>
	<div class="bg_yellow" id="nav_position_4">
		<div class="mid_80 fs_xlarge">
			<h1 class="ff_Noto fw_bold mg50_bt tt">소개</h1>
			<div class="row">
				<img id="img3" class="col-md-6 mg70_bt"
					src="https://i.imgur.com/DBl4uXa.png">
				<div class="col-md-6 mg70_bt">
					<h1 class="ff_Fredoka fc_blue fs_xxlarge mg25_bt fw_bold mg_t50">USER</h1>
					<h1 class="ff_Noto fs_xxlarge mg25_bt fw_bold">회원시스템</h1>
					<h1 class="ff_Noto mg25_bt fs_large fw_normal lineh_40">
						회원 유형을 개인, 기업, 관리자로 나누어 맞춤형 기능을 제공합니다. 기업은 체계적인 공고 관리와 실시간 지원 현황
						열람이 가능하며 개인회원은 다양한 공고, 기업 정보와 간편한 이력서, 지원관리를 접할 수 있습니다. <br>
						관리자는 공지사항 등록을 통해 회원에게 정보전달을 하고 지원현황 통계 옵션 관리가 가능합니다.
					</h1>
				</div>



				<div class="col-md-6 mg70_bt">
					<h1 class="ff_Fredoka fc_blue fs_xxlarge mg25_bt fw_bold">COMMUNITY</h1>
					<h1 class="ff_Noto fs_xxlarge mg25_bt fw_bold">내가 찾던 지역별 채용공고</h1>
					<h1 class="ff_Noto mg25_bt fs_large fw_normal lineh_40">
						기업은 공고 정보입력, 마감날짜 지정을 통해 공고 등록을 하고 자유롭게 정보 수정이 가능합니다. <br>개인회원은
						공고 키워드 검색기능을 통해 원하는 공고리스트를 찾을 수 있으며 상세페이지를 통해 기업이 올린 공고 정보를 얻을 수
						있습니다.
					</h1>
				</div>
				<img id="img4" class="col-md-6 mg70_bt"
					src="https://i.imgur.com/yOQsxzx.png">





				<!--  -->


				<div class="col-md-6 mg70_bt">
					<h1 class="ff_Fredoka fc_blue fs_xxlarge mg25_bt fw_bold">STORE</h1>
					<h1 class="ff_Noto fs_xxlarge mg25_bt fw_bold">간편한 입사지원</h1>
					<h1 class="ff_Noto mg25_bt fs_large fw_normal lineh_40">
						개인회원은 로그인 후 공고, 이력서 선택후 즉시지원을 통해 클릭 한번으로 간편한 입사지원을 할 수 있습니다. 개인은
						자신의 지원 내역을 통해 자신의 지원 현황을 확인 할 수 있으며 기업은 개인회원의 지원 내역을 통해 개인이 지원한
						분야와 제출 이력서를 열람할 수 있습니다. <br>공고 상세페이지에서 지원 통계를 차트로 표현해 사용자는
						지원현황을 가시적으로 쉽게 파악할 수 있습니다.
					</h1>
				</div>
				<img id="img6" class="col-md-6 mg70_bt"
					src="https://i.imgur.com/GM5zWIO.png">
				<!--  -->
				<img id="img7" class="col-md-5 mg70_bt"
					src="https://i.imgur.com/7xymvgU.png">



				<!--  -->
				<div class="col-md-7 mg70_bt">
					<h1 class="ff_Fredoka fc_blue fs_xxlarge mg25_bt fw_bold mg_l30">INTERIOR
					</h1>
					<h1 class="ff_Noto fs_xxlarge mg25_bt fw_bold mg_l30">온라인 인테리어
						시공</h1>
					<h1 class="ff_Noto mg25_bt fs_large fw_normal lineh_40 mg_l30">
						개인회원은 BLIND BOARD의 기업후기, 면접후기, 정보공유 메뉴를 통해 자신에게 필요한 취업 정보를 얻을 수 있고
						직접 익명으로 글을 씀으로써 자유롭게 회원들과 정보공유를 할 수 있습니다. 또한 키워드 검색을 통해 원하는 정보를 직접
						찾을 수 있는 검색기능을 제공합니다.</h1>
				</div>
			</div>
		</div>
	</div>
	<div class="mid_80 fs_xlarge " id="nav_position_5">
		<h1 class="ff_Noto fw_bold tt">제작문서</h1>
		<div class="card mg_t50">
			<i class="fas fa-project-diagram"></i>
			<h1 class="fw_bold ff_Noto">FlowChart</h1>
			<button onclick="window.open('flowChart2', 'FlowChart'); ">자세히
				보기</button>
		</div>
		<div class=" card mg_t50">
			<i class="fas fa-sitemap"></i>
			<h1 class="fw_bold ff_Noto">SiteMap</h1>
			<button onclick="window.open('siteMap2', 'SiteMap'); ">자세히 보기</button>
		</div>
		<div class=" card mg_t50">
			<i class="fas fa-database"></i>
			<h1 class="fw_bold ff_Noto">DataBase</h1>
			<button onclick="window.open('dataBase2', 'DataBase'); ">자세히
				보기</button>
		</div>
	</div>
	<div class="row mid_80" id="nav_position_6">
		<div class=" fs_xlarge col-md-12">
			<h1 class="ff_Noto fw_bold mg25_bt tt">발표영상</h1>
			<div class=" mg_t100">

				<iframe width="100%" height="500"
					src="https://www.youtube.com/embed/jAuwcbxZ_68" frameborder="0"
					allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
					allowfullscreen></iframe>
			</div>
		</div>

	</div>

	<div class="mid_80 fs_xlarge git_card" id="nav_position_8">
		<h1 class="ff_Noto fw_bold tt">GitHub</h1>
		<div id="img2"></div>
		<input class="ff_Noto mg70_bt" id="git_url1" type="text"
			value="https://github.com/Yoonjoo0528/Team5"> <input
			id="git_url2" type="button" value="Click"
			onclick="window.open('https://github.com/Yoonjoo0528/Team5');">
	</div>
	<footer>
		<button class="white_btn" onclick="location.href='contactme'">Contact
			me</button>
	</footer>
</body>
</html>














