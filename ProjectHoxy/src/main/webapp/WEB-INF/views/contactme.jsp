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
	href="${pageContext.request.contextPath }/CSS/Contectme.css" />

<link
	href="https://fonts.googleapis.com/css2?family=Noto+Serif+KR:wght@200;300&display=swap"
	rel="stylesheet">
<!-- font-family: 'Noto Serif KR', serif; -->


<!-- fonta -->
<script src="https://kit.fontawesome.com/a076d05399.js"></script>

<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath }/JS/yj.js"></script>


<title>남윤주_Nam Yoon Joo</title>
</head>
<body id="bg3">
	<div id="side_bar_purple">
		<div class="side_btn side_btn_p ff_Noto" id="nav_box1">INTRODUCE</div>
		<div class="side_btn side_btn_p ff_Noto" id="nav_box2">SKILL</div>
		<div class="side_btn side_btn_p ff_Noto" id="nav_box3">PROJECT</div>
		<div class="side_btn side_btn_p ff_Noto" id="nav_box4">EXPERIENCE</div>
		<div class="side_btn side_btn_p ff_Noto" id="nav_box5">EDUCATION</div>
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
	<div class="mid_80 row">
		<img class="col-md-3 mg50_bt" src="https://i.imgur.com/978FkMN.png">
		<div class="col-md-12 row">


			<div class="col-md-8 row">
				<h1 class="contactme_name  mg25_bt fw_bold">남 윤 주</h1>
				<h1 class="contactme_eng_name  mg25_bt fw_bold">
					<br> ( Nam Yoon Joo )
				</h1>
				<div class="col-md-12"></div>
				<div class="col-md-1 tAlign_r">
					<i class="fas fa-phone-alt mg25_bt"></i><br> <i
						class="fas fa-envelope-open-text mg25_bt"></i><br> <i
						class="fab fa-github mg25_bt"></i><br> <i class=""></i><br>
				</div>
				<div class="col-md-11">
					<h1 class="mg25_bt">010 8915 2865</h1>
					<h1 class="mg25_bt">bhd4445@naver.com</h1>
					<h1 class="mg25_bt">
						<a href="https://github.com/Yoonjoo0528">https://github.com/Yoonjoo0528</a>
					</h1>
					<h1 class="">
						<a href="https://github.com/NAMYOONJOO">https://github.com/NAMYOONJOO</a>
					</h1>

				</div>
				<div class="col-md-12">
					<h1 class="gray_box">휴대전화 또는 이메일로 연락 부탁드립니다.</h1>
				</div>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-3">
				<img id="img9" src="https://i.imgur.com/t0A9kHH.jpg">
			</div>
		</div>
	</div>

	<!--  -->
	<div class="mid_80">
		<div class="row">
			<h1 class=" contact_title col-md-3">INTRODUCE</h1>
			<div class="contact_content col-md-9">
				<h1>안녕하세요. 웹 개발자 남 윤 주 입니다.</h1>
				<h1>저는 대학교 4학년 때 '열화상 카메라를 이용한 야간 물체추적 감시 시스템'을 주제로 1년간 팀 프로젝트를
					한 경험이 있습니다. 프로젝트는 기존 고정된 감시카메라의 제한점을 보완해 특정 온도 이상의 물체를 감지 및 추적을
					목적으로 설계하였으며 밤낮 가리지 않는 야간감시로 범죄예방을 하고 오늘날 코로나 19 감염 유행상황에서 실시간 영상을
					통해 사람의 체온과 움직임 감시해야 하는 상황에서 적은 인력으로 효율적으로 사용하기 위해 제작했습니다. 팀 내에서 저는
					MFC 윈도우 프로그래밍을 통해 사용자가 PC에서 실시간으로 영상을 감시할 수 있는 GUI를 제작이라는 역할을 맡았으며
					윈도우 소켓통신을 통한 실시간 영상 수신, Opencv를 사용한 영상처리와 검출된 객체 추적을 위한 카메라 모듈로 명령
					송신기능 등을 구현할 수 있었습니다. 시스템의 GUI 제작을 하며 중요하게 생각한 점은 사용자의 불편을 줄이는 것이였으며
					프로그램을 보완하기 위해제작한 프로그램을 실제 상황에서 사용해는 과정을 통해 감시영상에 온도정보와 프레임이 함께 표시되면
					사용자가 영상감시에 방해요소가 된다는 점을 알게 되었습니다. 온도정보가 함께 출력되는 화면과 온전한 화면 두가지를 동시에
					제공하고 GUI를 통해 객체검출시간, 온도정보를 기록하는 기능을 추가함으로서 사용자가 느낄 수 있는 불편함을 줄여
					프로젝트의 완성도를 높일 수 있었습니다. 이런 과정에서 개발자로서 ‘사용자의 편의’를 우선시 하게되는 계기가 되었습니다.
					편의성을 높이기위한 방법을 생각하던중 저는 모두에게 친숙한 ‘웹’이라 분야에 관심을 갖게되었으며 다양한 많은 기능으로
					전세계사람들에게 유용한 정보, 지식을 전달할뿐아니라 편리한 기능으로 폭넓게 삶의 질을 높여주는 점에서 웹 개발에 큰
					매력을 느꼈으며 편의를 위해 사용자의 관점에서 생각할 수있는 웹 개발자를 꿈꾸게 되었습니다.</h1>
			</div>
		</div>
		<div class="row">
			<h1 class="contact_title col-md-3">SKILL</h1>
			<div class="contact_content col-md-9 row">
				<div class="skill_box col-md-3">
					<h2 class="fw_bold">Back-end</h2>
					<h1>Java</h1>
					<h1>Spring</h1>
					<h1>C++</h1>

				</div>
				<div class="skill_box col-md-3">
					<h2 class="fw_bold">Database</h2>
					<h1>Oracle</h1>

				</div>
				<div class="skill_box col-md-3">
					<h2 class="fw_bold">Front-end</h2>
					<h1>HTML/CSS</h1>
					<h1>javascript</h1>
					<h1>jQuery</h1>

				</div>
				<div class="skill_box col-md-3">
					<h2 class="fw_bold">Web Server</h2>
					<h1>Apache Tomcat</h1>



				</div>
			</div>
		</div>

		<div class="row">
			<h1 class="contact_title col-md-3">PROJECT</h1>
			<div class="contact_content col-md-9 row">
				<div class="ed_content col-md-12">
					<h1>2020.03 ~ 2020.08</h1>
					<h2>코리아 IT 아카데미</h2>
					<h3>과정명 : Java 프레임웍기반 풀스택 양성 (국비과정)</h3>
					<h3>교육내용 : JAVA 프로그래밍 / Oracle 및 JDBC / 웹 프론트 엔드 / JSP 기반 웹
						프로그래밍 / Spring Framework</h3>
				</div>
				<div class="ed_content col-md-12">
					<h1>2020.03 ~ 2020.08</h1>
					<h2>코리아 IT 아카데미</h2>
					<h3>과정명 : Java 프레임웍기반 풀스택 양성 (국비과정)</h3>
					<h3>교육내용 : JAVA 프로그래밍 / Oracle 및 JDBC / 웹 프론트 엔드 / JSP 기반 웹
						프로그래밍 / Spring Framework</h3>
				</div>
			</div>
		</div>
		<div class="row">
			<h1 class="contact_title col-md-3">EXPERIENCE</h1>
			<div class="contact_content col-md-9 row"></div>
		</div>
		<div class="row">
			<h1 class="contact_title col-md-3">EDUCATION</h1>
			<div class="contact_content col-md-9 row">
				<div class="ed_content col-md-12">
					<h1>2020.03 ~ 2020.08</h1>
					<h2>코리아 IT 아카데미</h2>
					<h3>과정명 : Java 프레임웍기반 풀스택 양성 (국비과정)</h3>
					<h3>교육내용 : JAVA 프로그래밍 / Oracle 및 JDBC / 웹 프론트 엔드 / JSP 기반 웹
						프로그래밍 / Spring Framework</h3>
				</div>
				<div class="ed_content col-md-12">
					<h1>2016.03 ~ 2020.02</h1>
					<h2>공주대학교</h2>
					<h3>정보통신공학부 전파공학전공</h3>
				</div>
				<div class="ed_content col-md-12">
					<h1>2013.03 ~ 2016.02</h1>
					<h2>계산여자고등학교</h2>
					<h3>자연계 졸업</h3>
				</div>
			</div>
		</div>
		<div id="latest_update" class="mid_80">Latest Updated 2020.10.20
		</div>
</body>
</html>














