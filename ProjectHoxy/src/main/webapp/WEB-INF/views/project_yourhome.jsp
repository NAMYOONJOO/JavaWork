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
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/CSS/nav.css" />


<link
	href="https://fonts.googleapis.com/css2?family=Fredoka+One&family=Noto+Serif+KR:wght@200;300&display=swap"
	rel="stylesheet">

<!-- font-family: 'Noto Serif KR', serif; -->


<!-- fonta -->
<script src="https://kit.fontawesome.com/a076d05399.js"></script>

<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath }/JS/yj.js"></script>
<script src="${pageContext.request.contextPath }/JS/nav.js"></script>


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
	
	<div class="main_nav_div nav_bg3">
		<div class="mid_80header">
			<nav id="main_nav_purple">
				<ul>
					<li class="inline fw_bold "
						onclick="location.href='http://www.runzhu.shop/yoonjoo'">
						That's me</li>
					<li class="inline fw_bold" id="nav_project"
						>Project</li>
				</ul>
			</nav>

		</div>
	</div>
	
	<div class="sub_nav">

		<nav>
			<ul>
				<li class="inline"><a href="http://www.runzhu.shop/yoonjoo/project_next">리크루팅 취업 플랫폼 'NEXT'</a></li>
				<li class="inline"> / </li>
				<li class="inline"><a href="http://www.runzhu.shop/yoonjoo/project_yourhome">원스톱 인테리어 플랫폼 '너네 집'</a></li>
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
				<h1 class="ff_Noto mg_t50 mg25_bt">SNS적인 인테리어 정보공유서비스, 쇼핑서비스,
					시공서비스를 온라인으로 제공함으로써 인테리어의 모든 고민을 한 번에 해결하세요.</h1>
				<button class="yellow_border_btn"
					onclick="window.open('https://youtu.be/jAuwcbxZ_68', 'TEAM5 발표영상');">발표영상
					바로보기</button>

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
				인테리어 정보서비스 페이지를 떠올리게 되었고 벤치 마킹해 ‘인테리어 원스톱 플랫폼 페이지’를 주제로 Servlet과 연계한
				MVC Model 2 기반 웹 애플리케이션을 설계하게 되었습니다. <br> <br>&nbsp;&nbsp;프로젝트는
				홈페이지에 회원운영서비스를 도입해 회원간 SNS 적인 소통방식으로 인테리어 정보를 공유하고, 쇼핑 서비스를 제공함으로써
				누구나 쉽게 인테리어라는 주제에 관심을 둘 수 있도록 했습니다. 또한, 인테리어 시공정보제공, 예약서비스를 온라인으로
				제공함으로써 인테리어 모든 고민을 한 곳에서 해결할 수 있도록 프로젝트를 기획하게 되었습니다.
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
			<h1 class="ff_Noto fw_bold fs_medium">남윤주 (팀장) : 프로젝트 총괄, 데이터설계,</h1>
			<h1 class="ff_Noto fw_bold fs_medium">스토어 상품, 문의 프로세스 구현</h1>
			<h1 class="ff_Noto fw_bold fs_medium">김우경 : 스토어구매 프로세스 구현</h1>
			<h1 class="ff_Noto fw_bold fs_medium">정종훈 : 인테리어 시공상담 예약 프로세스 구현</h1>
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
					<h1 class="ff_Noto mg25_bt fs_large fw_normal lineh_40">
						다음 Map API를 활용한 주소입력, 유효성 검사 후 회원가입, Session을 제어를 통한 로그인, 로그아웃
						구현으로 회원에게 구매, 커뮤니티, 시공예약 등 다양한 서비스를 제공하며 회원 정보 수정, 탈퇴가 가능합니다. <br>또한,
						관리자 모드를 통해 pagination을 구현한 모든 회원 목록 열람이 가능합니다.
					</h1>
				</div>



				<div class="col-md-6 mg70_bt">
					<h1 class="ff_Fredoka fc_blue fs_xxlarge mg25_bt fw_bold">COMMUNITY</h1>
					<h1 class="ff_Noto mg25_bt fs_large fw_normal lineh_40">
						회원에게 인테리어 관련 정보 질문 기능을 제공하며 자신이 작성한 게시물을 수정, 삭제를 할 수 있고 카카오 공유하기
						API를 사용해 유용한 게시물을 카카오톡을 통해 공유하는 기능을 구현했습니다.<br>회원에게 게시물에 대한
						댓글 기능을 제공해 SNS적인 커뮤니티를 구현했으며 유해한 게시물에 대한 신고 기능을 통해 관리자가 원활하게 게시글
						관리를 할 수 있도록 합니다.
					</h1>
				</div>
				<img id="img4" class="col-md-6 mg70_bt"
					src="https://i.imgur.com/yOQsxzx.png">





				<!--  -->


				<div class="col-md-6 mg70_bt">
					<h1 class="ff_Fredoka fc_blue fs_xxlarge mg25_bt fw_bold">STORE</h1>
					<h1 class="ff_Noto mg25_bt fs_large fw_normal lineh_40">
						네이버 데이터 랩 쇼핑검색 API를 이용해 상품데이터를 JDBC를 이용한 데이터 프로세싱 과정을 통해 구현했으며
						관리자에게 상품 가격수정, 상품 삭제 기능과 상품 관련 이미지 첨부(파일첨부) 기능을 통해 상품관리 로직을 제공합니다.
						<br>상품에 대한 문의 프로세스를 구현하여 문의, 답변과정을 통해 일반회원과 관리자가 소통 할 수 있도록
						합니다. <br>다음 Map API를 이용한 주소입력과 I am Port 결제 API를 사용해 상품 구매
						기능을 제공하며 구매 이력 조회, 구매 취소기능을 제공합니다.
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
					<h1 class="ff_Noto mg25_bt fs_large fw_normal lineh_40 mg_l30">
						시공업체 데이터를 AJAX를 통해 화면에 띄우며 지역과 카테고리 별로 검색할 수 있습니다. 회원에게 시공 상담 기능을
						제공함으로써 온라인으로 인테리어 고민을 해결 할 수 있습니다.</h1>
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
			<button onclick="window.open('siteMap2', 'SiteMap'); ">자세히
				보기</button>
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














