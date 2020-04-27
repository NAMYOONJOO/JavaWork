package com.lec.java.crawl06;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;

import javax.imageio.ImageIO;

/* 웹에서 이미지와 같은 바이너리 형태 리소스 다운로드 받기
 * 
 * 방법1 : URL의 openStream() → InputStream 
 * 방법2 : HttpURLConnection의 getInputStream() → InputStream
 * 방법3 : ImageIO 객체 사용 : 이미지객체
 * 
 *  <프로젝트에 download 폴더 만들고 진행하세요> 
 * 
 * 예제에 사용한 미디어 출처
 *  https://www.w3schools.com/html/html5_video.asp
 *  https://www.w3schools.com/html/html5_audio.asp
 *  https://www.w3schools.com/howto/howto_css_fullscreen_video.asp
 *  
 * 예제에 사용한 이미지 출처
 * 	https://www.w3schools.com/css/css_image_gallery.asp
 * 
 * 예제에 사용한 데이터 출처
 *   공공데이터 포털 - 파일데이터
 *   https://www.data.go.kr/search/index.do?index=DATA&query=&currentPage=1&countPerPage=10&sortType=VIEW_COUNT
 */
public class Crawl06Main {

	public static final String FILEPATH = "download";

	public static void main(String[] args) throws IOException {
		System.out.println("웹 리소스 다운로드");

		Crawl06Main app = new Crawl06Main();

		String[] movUrls = { "https://www.w3schools.com/html/movie.mp4", // 영상
				"https://www.w3schools.com/howto/rain.mp4", "https://www.w3schools.com/html/mov_bbb.mp4",
				"https://www.w3schools.com/html/horse.ogg" // 음성

		};

		// 데이터. URL 에 파일명이 없는 형태
		String[] dataUrls = {
				"https://www.data.go.kr/dataset/fileDownload.do?atchFileId=FILE_000000001524257&fileDetailSn=1&publicDataDetailPk=uddi:af2e59b7-9f3a-4624-94ae-9ac9d785b62b", // https://www.data.go.kr/dataset/15007122/fileData.do
																																												// 건강검진정보
				"https://www.data.go.kr/dataset/fileDownload.do?atchFileId=FILE_000000001562989&fileDetailSn=1&publicDataDetailPk=uddi:e9317e2f-fb83-43c8-914e-85ac6cca6736_201909101530", // https://www.data.go.kr/dataset/3038489/fileData.do
																																															// 교통사고통계
				"https://www.data.go.kr/dataset/fileDownload.do?atchFileId=FILE_000000001585803&fileDetailSn=1&publicDataDetailPk=uddi:7a68a482-4e3f-4cf8-851a-d4857fa2bff7" // https://www.data.go.kr/dataset/3041272/fileData.do
																																												// 전국산업단지현황통계
		};

		// 이미지, jpg
		String[] imgUrls = { "https://www.w3schools.com/css/img_5terre.jpg",
				"https://www.w3schools.com/css/img_forest.jpg", "https://www.w3schools.com/css/img_lights.jpg",
				"https://www.w3schools.com/css/img_mountains.jpg" };

//		System.out.println();
//		for(int i = 0; i < movUrls.length; i++) app.download1(movUrls[i]);
//		
//		System.out.println();
//		
//		System.out.println();
//		for(int i = 0; i < dataUrls.length; i++) app.download2(dataUrls[i]);
//		

		for (int i = 0; i < imgUrls.length; i++)
			app.download3(imgUrls[i]);
		System.out.println("\n프로그램 종료");
	} // end main()

	// 방법1
	// URL 의 openStream()
	// 단순히 byte 스트림으로만 입력 가능
	// 파일 이름, 타입등 의 정보는 알수 없다.
	public void download1(String srcUrl) throws IOException {

		URL url = null;
		InputStream in = null;
		OutputStream out = null;
		BufferedOutputStream bout = null;
		BufferedInputStream bin = null;
		String dstFile = null; // 저장할 파일 이름

		url = new URL(srcUrl);
		in = url.openStream(); // URL -> InputStream****** 핵심

		dstFile = fileNameFromURL(url);

		out = new FileOutputStream(FILEPATH + File.separator + dstFile); // 저장할 파일 경로

		bin = new BufferedInputStream(in);
		bout = new BufferedOutputStream(out);

		while (true) {
			int data = bin.read();
			if (data == -1)
				break;
			bout.write(data);
		}

		bin.close();
		bout.close();

		System.out.println("다운로드: " + srcUrl + " → " + dstFile);

	} // end download1
		// 방법2
		// HttpURLConnection 객체 사용
		// HttpURLConnection 의 getInputStream()
		// 장점: 파일사이즈, 타입, 이름 등을 미리 알수 있다.

	public void download2(String srcUrl) throws IOException {

		URL url = null;
		HttpURLConnection conn = null;
		InputStream in = null;
		BufferedInputStream bin = null;
		FileOutputStream out = null;
		BufferedOutputStream bout = null;
		String dstFile = null;

		url = new URL(srcUrl);
		conn = (HttpURLConnection) url.openConnection();
		int contentLength = conn.getContentLength(); // 파일사이즈를 알 수 있다.
		String contentType = conn.getContentType();// 파일종류 MIME-TYPE확인 가능
		// https://developer.mozilla.org/ko/docs/Web/HTTP/Basics_of_HTTP/MIME_types

		// 다운로드 받는 파일 이름 확인 가능
		String raw = conn.getHeaderField("Content-Disposition");
		// header에 담겨있다
		// contentdisposition값

		if (raw != null && raw.indexOf("=") != -1) {
			String fileName = raw.split("=")[1].trim();
			dstFile = URLDecoder.decode(fileName, "UTF-8");
		}

		in = conn.getInputStream(); /// InputStream <-HttpURLConnection
		bin = new BufferedInputStream(in);
		out = new FileOutputStream(FILEPATH + File.separator + dstFile);
		bout = new BufferedOutputStream(out);

		// contentLength 를 알기때문에 한번에 버퍼에 담을 수 있다.
		byte[] buf = new byte[contentLength]; // 다운받을 파일 크기만큼의 버퍼 준비
		int byteImg;
		while ((byteImg = bin.read(buf)) != -1) {
			bout.write(buf, 0, byteImg);
		}

		bin.close();
		bout.close();

		System.out.println("다운로드: " + srcUrl + "\n\t → " + dstFile);
		System.out.println("\t" + contentLength + " bytes  " + contentType);

	}

	// 방법3
	// ImageIO 객체 사용
	public void download3(String srcUrl) throws IOException {

		String dstFile = null;
		URL url = new URL(srcUrl);

		dstFile = fileNameFromURL(url);

		BufferedImage imgData = ImageIO.read(url);
		File file = new File(FILEPATH + File.separator + dstFile);
		ImageIO.write(imgData, "jpg", file);

		System.out.println("다운로드 :" + srcUrl + "->" + dstFile);
		System.out.println(imgData.getWidth() + "x" + imgData.getHeight());
	}

	// url 에서 파일명 추출
	public String fileNameFromURL(URL url) {
		return url.getPath().substring(url.getPath().lastIndexOf('/') + 1);
	}

} // end class
