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
	href="${pageContext.request.contextPath }/CSS/Hoxy.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/CSS/nav.css" />


<link
	href="https://fonts.googleapis.com/css2?family=Noto+Serif+KR:wght@200;300&display=swap"
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
		<div class="side_btn ff_Noto" id="nav_box7">시연영상</div>
		<div class="side_btn ff_Noto" id="nav_box8">GitHub</div>
	</div>
	
	<div class="main_nav_div nav_bg2">
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
				<h1 class="ff_Noto fs_xxlarge mg25_bt fw_bold">취업 리크루팅 플랫폼 NEXT</h1>
				<h1 class="ff_Noto mg25_bt fs_xlarge fw_bold">Recruiting
					Platform</h1>
				<!--<h1 class="ff_Noto mg_t50 mg10_bt">간편한 입사지원과 기업정보공유를 통해</h1>-->
				<h1 class="ff_Noto mg_t50 mg25_bt">취업의 모든 고민을 한번에 해결하세요</h1>
				<!--<button class="yellow_border_btn"
					onclick="window.open('http://www.runzhu.shop', 'NEXT');">SITE
					VIEW</button>-->
				<button class="yellow_border_btn"
					onclick="window.open('http://www.runzhu.shop', 'NEXT');">SITE VIEW</button>
				<div class="mg10_bt"></div>
				<a href="https://www.youtube.com/watch?v=hq-WDDuPS-E&feature=emb_title">발표영상 바로보기</a><a> / </a>
				<a href="https://www.youtube.com/watch?v=a77TM839-xQ&feature=emb_title">시연영상 바로보기</a>
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
			<h1 class="ff_Noto fw_bold fs_medium">&nbsp;&nbsp;프로젝트는
				SpringFramework 기반 MVC모델의 웹페이지 개발을 목표로 일반회원 기업회원을 나눠 맞춤형 리크루팅 기능을
				제공하며 손쉬운 이력서, 지원 관리를 통해 누구나 쉽게 취업에 관심을 갖고 참여를 할 수 있도록 했습니다. 또한 기업에
				대한 익명 면접 후기, 취업 후기, 정보공유 서비스를 온라인으로 제공함으로써 취업 모든 고민을 한 곳에서 해결할 수 있도록
				프로젝트를 기획하게 되었습니다.</h1>
		</div>
	</div>
	<div class="mid_80 fs_xlarge lineh_40 row" id="nav_position_2">
		<h1 class="ff_Noto fw_bold tt mg50_bt">Project</h1>
		<div class="col-md-12"></div>
		<div class="col-md-6">
			<h1 class="ff_Noto fw_bold fs_medium">프로젝트명 : 리크루팅 취업 플랫폼
				('NEXT')</h1>
			<h1 class="ff_Noto fw_bold fs_medium">팀명 : Hoxy</h1>
			<h1 class="ff_Noto fw_bold fs_medium">기간 : 2020.07.14 ~
				2020.08.05</h1>

		</div>
		<div class="col-md-6">
			<h1 class="ff_Noto fw_bold fs_medium">팀원</h1>
			<h1 class="ff_Noto fw_bold fs_medium">남윤주 (팀장) : 프로젝트 총괄, 원클릭
				입사지원 구현, 데이터설계</h1>
			<h1 class="ff_Noto fw_bold fs_medium">윤지우 : 맞춤형 회원 시스템 구현, 개발환경
				구축</h1>
			<h1 class="ff_Noto fw_bold fs_medium">장수영 : 체계적인 이력서 관리, Git협업
				관리, 개발환경 구축</h1>
			<h1 class="ff_Noto fw_bold fs_medium">김진영 : 100% 익명성 보장 기업 리뷰 구현
			</h1>
			<h1 class="ff_Noto fw_bold fs_medium">김우경 : 지역별 채용공고 구현</h1>

		</div>
	</div>
	<div class="mid_80 fs_xlarge" id="nav_position_3">
		<h1 class="ff_Noto fw_bold tt">개발환경 & 사용기술</h1>
		<img id="img8" src="https://i.imgur.com/cZZjuAV.png">
	</div>
	<div class="bg_yellow" id="nav_position_4">
		<div class="mid_80 fs_xlarge">
			<h1 class="ff_Noto fw_bold mg50_bt tt">소개</h1>
			<div class="row">
				<img id="img3" class="col-md-6 mg70_bt"
					src="https://i.imgur.com/kzQlAtU.png">
				<div class="col-md-6 mg70_bt">
					<h1 class="ff_Noto fs_xxlarge mg25_bt fw_bold mg_t50">맞춤형 회원
						시스템</h1>
					<h1 class="ff_Noto mg25_bt fs_large fw_normal lineh_40">
						회원 유형을 개인, 기업, 관리자로 나누어 맞춤형 기능을 제공합니다. 기업은 체계적인 공고 관리와 실시간 지원 현황
						열람이 가능하며 개인회원은 다양한 공고, 기업 정보와 간편한 이력서, 지원관리를 접할 수 있습니다. <br>
						관리자는 공지사항 등록을 통해 회원에게 정보전달을 하고 지원현황 통계 옵션 관리가 가능합니다.
					</h1>
				</div>



				<div class="col-md-6 mg70_bt">
					<h1 class="ff_Noto fs_xxlarge mg25_bt fw_bold">내가 찾던 지역별 채용공고</h1>
					<h1 class="ff_Noto mg25_bt fs_large fw_normal lineh_40">
						기업은 공고 정보입력, 마감날짜 지정을 통해 공고 등록을 하고 자유롭게 정보 수정이 가능합니다. <br>개인회원은
						공고 키워드 검색기능을 통해 원하는 공고리스트를 찾을 수 있으며 상세페이지를 통해 기업이 올린 공고 정보를 얻을 수
						있습니다.
					</h1>
				</div>
				<img id="img4" class="col-md-6 mg70_bt"
					src="https://i.imgur.com/q3oFSxz.png">





				<!--  -->
				<img id="img5" class="col-md-6 mg70_bt"
					src="https://i.imgur.com/mV2QkK2.png">


				<div class="col-md-6 mg70_bt">
					<h1 class="ff_Noto fs_xxlarge mg25_bt fw_bold mg_l30 mg_t50">체계적인
						이력서 관리</h1>

					<h1 class="ff_Noto mg25_bt fs_large fw_normal lineh_40 mg_l30">
						NEXT 개인회원은 여러개의 이력서를 등록할 수 있으며 등록, 수정, 삭제 통해 체계적으로 맞춤형 이력서 관리가
						가능합니다.</h1>
				</div>

				<div class="col-md-6 mg70_bt">
					<h1 class="ff_Noto fs_xxlarge mg25_bt fw_bold">간편한 입사지원</h1>
					<h1 class="ff_Noto mg25_bt fs_large fw_normal lineh_40">
						개인회원은 로그인 후 공고, 이력서 선택후 즉시지원을 통해 클릭 한번으로 간편한 입사지원을 할 수 있습니다. 개인은
						자신의 지원 내역을 통해 자신의 지원 현황을 확인 할 수 있으며 기업은 개인회원의 지원 내역을 통해 개인이 지원한
						분야와 제출 이력서를 열람할 수 있습니다. <br>공고 상세페이지에서 지원 통계를 차트로 표현해 사용자는
						지원현황을 가시적으로 쉽게 파악할 수 있습니다.
					</h1>
				</div>
				<img id="img6" class="col-md-6 mg70_bt"
					src="https://i.imgur.com/aMBQ2AT.png"> <img id="img7"
					class="col-md-5 mg70_bt" src="https://i.imgur.com/GCES6TA.png">



				<!--  -->
				<div class="col-md-7 mg70_bt">
					<h1 class="ff_Noto fs_xxlarge mg25_bt fw_bold mg_l30">100% 익명성
						보장 기업 리뷰</h1>
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
			<button onclick="window.open('flowChart', 'FlowChart'); ">자세히
				보기</button>
		</div>
		<div class=" card mg_t50">
			<i class="fas fa-sitemap"></i>
			<h1 class="fw_bold ff_Noto">SiteMap</h1>
			<button onclick="window.open('siteMap', 'SiteMap'); ">자세히 보기</button>
		</div>
		<div class=" card mg_t50">
			<i class="fas fa-database"></i>
			<h1 class="fw_bold ff_Noto">DataBase</h1>
			<button onclick="window.open('dataBase', 'DataBase'); ">자세히
				보기</button>
		</div>
	</div>
	<div class="row mid_80" id="nav_position_6">
		<div class=" fs_xlarge col-md-6">
			<h1 class="ff_Noto fw_bold mg25_bt tt">발표영상</h1>
			<div class=" mg_t100">
				<iframe width="100%" height="300"
					src="https://www.youtube.com/embed/hq-WDDuPS-E" frameborder="0"
					allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
					allowfullscreen></iframe>
			</div>
		</div>
		<div class=" fs_xlarge col-md-6" id="nav_position_7">
			<h1 class="ff_Noto fw_bold mg25_bt tt">시연영상</h1>
			<div class=" mg_t100">
				<iframe width="100%" height="300"
					src="https://www.youtube.com/embed/a77TM839-xQ" frameborder="0"
					allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
					allowfullscreen></iframe>
			</div>
		</div>
	</div>

	<div class="mid_80 fs_xlarge git_card" id="nav_position_8">
		<h1 class="ff_Noto fw_bold tt">GitHub</h1>
		<div id="img2"></div>
		<input class="ff_Noto mg70_bt" id="git_url1" type="text"
			value="https://github.com/preandero/ProjectHoxy.git"> <input
			id="git_url2" type="button" value="Click"
			onclick="window.open('https://github.com/preandero/ProjectHoxy.git');">
	</div>
	<footer>
		<button class="white_btn" onclick="location.href='contactme'">Contact
			me</button>
	</footer>
</body>
</html>














