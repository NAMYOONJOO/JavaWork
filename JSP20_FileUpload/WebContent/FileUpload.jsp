<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%-- cos 라이브러리 --%>
    <%@ page import="com.oreilly.servlet.MultipartRequest" %>
    <%@ page import="com.oreilly.servlet.multipart.FileRenamePolicy" %>
    <%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
    
    
    <%-- parameter 값들, file 값들 추출 --%>
    <%@ page import="java.util.Enumeration" %>
    
    <%-- File 객체 --%>
    <%@ page import="java.io.File" %>
    
    <%--이미지 파일 다루기 --%>
    <%@ page import = "java.awt.image.BufferedImage" %>
    <%@ page import = "javax.imageio.ImageIO" %>
    
    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>파일 업로드 결과</title>
</head>
<body>

<form action="FileCheck.jsp" method="post" name="fileCheck"> 
<%
//MultipartRequest 객체 생성 준비 
//String saveDirectory = "C:\\tomcat\\upload";

//파일 저장경로
//서버에서(서블릿) 어디에 어느폴더에서 서블릿으로 변환되는지 알아내기
ServletContext context =this.getServletContext();
//서블릿안의 upload 폴더의 물리적인 경로 얻어오기
String saveDirectory = context.getRealPath("upload");


System.out.println("업로드 경로 : "+saveDirectory);
//POST 받기 최대 사이즈 (최대 크기) 5M byte = ?
	int maxPostSize = 5*1024*1024;
	String encoding = "utf-8"; //인코딩
	
	FileRenamePolicy policy = new DefaultFileRenamePolicy();//업로딩 파일 이름 중복에 대한 rename 정책
	
	MultipartRequest multi = null;
	
	try{
		
		//jsp 파일에서 예외를 반드시 catch 할 필요는 없지만..
		
		//MultipartRequest 생성 단계에서 이미 파일은 저장됨
		multi =new MultipartRequest(
				request,// JSP 내부객체 request
				saveDirectory,//업로드된 파일 저장 경로
				maxPostSize,// 최대 파일 크기(post 크기)
				encoding,
				policy//중복이름의 파일 rename 객체 
				
				);
		
		Enumeration names = null;
		
		//1. Parameter name 들 추출
		names = multi.getParameterNames(); //일반 form parameter name 들 추출

		while(names.hasMoreElements()){
			String name = (String)names.nextElement(); //name
			String value = multi.getParameter(name);//value
			out.println(name+":"+value+"<br>");
		}
		out.println("<hr>");
		
		//2.File들 추출
		names = multi.getFileNames(); //type = "file"요소 name 들 추출
		
		while(names.hasMoreElements()){
			String name = (String)names.nextElement();
			out.println("input name : "+name+"<br>");
			
			// 위 name 의 업로드  원본 파일 명을 가져온다. 
			String originalFileName = multi.getOriginalFileName(name);
			out.println("원본파일 이름 : "+originalFileName+"<br>");//요것이 DB 에 저장되어있어야 한다.
			out.println("<input type =  'hidden' name = 'originalFileName'  value = '"+originalFileName+"'>");
			
			// 서버 시스템에 '저장된 파일명'을 가져온다. 
			String fileSystemName = multi.getFilesystemName(name);
			out.println("파일시스템 이름 : "+fileSystemName+"<br>");//요것이 DB 에 저장되어있어야 한다.
			out.println("<input type =  'hidden' name = 'fileSystemName'  value = '"+fileSystemName+"'>");
			
			
			//업로딩된 파일의 타일 : MINE 타입 (ex : image/png ...);
			String fileType = multi.getContentType(name);
			out.println("파일타입 : "+ fileType +"<br>");
			
			// 문자열 '파일이름' 이 name 에 들어온 상태
			// 문자열 파일이름을 통해 실제 파일 정보를 -> FILE  객체로 가져오기
			File file = multi.getFile(name);
			
			if(file != null){
				long fileSize = file.length();// 파일 크기 (byte)
				out.println("파일 크기 : "+fileSize+"byte<br>");
				//이미지 파일 다루기 
				BufferedImage bi = ImageIO.read(file);
				if(bi != null){ //이미지가 아니면 null return (이미지 판별 용으로 쓴다. )
					int width = bi.getWidth();
					int height = bi.getHeight();
					out.println("이미지파일 WxH : "+width+"x"+height+"<br>");
					
				}else{
					out.println("이미지가 아닙니다. <br>");
				}
			}
			out.println("<hr>");
			
		}
		
		
		//2. File 들 추출
		
	}catch(Exception e){
		e.printStackTrace();
		out.print("파일 처리 예외발생<br>");
	}
 
%>
<input type = "submit" value = "업로드 파일 확인"/><br>
</form>


</body>
</html>














