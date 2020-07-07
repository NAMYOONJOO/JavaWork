package com.jar.validator;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

/*
 * Maven 빌드시 : 손상된 jar 파일 확인 (corrupted jar check)
 * 
 * 손상된 jar 파일의 경우 다운로드 시도.
 * 
 * 다운로드 받은 후 해당 Maven 프로젝트들은 update 해주세요.
 * 
 */
public class JarValidator {

	private static final String URL_MAVEN2 = "https://repo1.maven.org/maven2";
	
	private static Path repositoryPath = null;
	
	public static void main(String[] args) throws IOException{
		// 사용자 폴더 밑의 repository 경로
		repositoryPath = Paths.get(System.getProperty("user.home"), ".m2", "repository");
		
		//System.out.println(repositoryPath);
		
		// repository 경로 존재 여부 확인
		if(Files.exists(repositoryPath)) {
			
			JarValidator jv = new JarValidator();
			
			List<Path> jarFiles = jv.getFiles(repositoryPath, ".jar");
			System.out.println("발견된 전체 jar 파일들 : " + jarFiles.size() + " 개");
			
			jv.openJars(jarFiles);
			
		} else {
			// repository 경로가 없으면
			System.out.println("Repository path " + repositoryPath + " 경로가 없습니다");
		}
		
	} // end main()

	/**
	 * 주어진 경로에서 부터 시작하여 모든 이하 디렉토리들을 검색하여, 주어진 확장자에 일치하는 파일들의 목록 만들기.
	 * @param filePath      : File의 절대경로
	 * @param fileExtension : 검색할 파일의 확장자 
	 * @return  디렉토리 내에 있는 모든 파일들의 List 
	 */
	private List<Path> getFiles(Path filePath, String fileExtension) throws IOException{
		return Files.walk(filePath)  // filePath 부터 시작하여 이하 모든 파일들 검색
			.filter(p -> p.toString().endsWith(fileExtension)) // 그중에서 특정 확장자 가진것만 골라내서
			.collect(Collectors.toList());  // List로 모음.
	} // end getFiles()
	
	
	
	private List<String> openJars(List<Path> jarFiles){
		
		int [] badJars = {0};   // 손상된 jar 파일 개수.  굳이 배열인 이유는 local inner 에서 사용하기 위해.
		
		// 각각의 jar 파일에 대해 아래 수행
		jarFiles.forEach(path -> {
			String absPath = path.toAbsolutePath().toString();  // jar 파일 절대 경로
			
			try (
				JarFile file = new JarFile(path.toFile());  // jar 파일 open 시도!
					){				
				
			} catch(IOException e) {  // ★ jar파일 open 실패하면 IOException 발생
				String errMsg = "손상 jar 발견: " + absPath + " --exception:" + e.toString();
				System.out.println(errMsg);
				badJars[0]++;   // 손상된 jar 파일 개수 증가
				// 다운로드 시도
				String downloadUrl = URL_MAVEN2 + absPath.substring(repositoryPath.toString().length()).replaceAll("\\\\", "/");
				System.out.println(downloadUrl);
				
				
				
			} 
			
		});
		
		System.out.println("손상된 jar 파일 개수 = " + badJars[0]);
		
		return null;
		
	} // end openJars()
	
	/**
	 * 특정 url 의 파일 다운로드
	 * @param srcUrl : 다운로드 받을 파일의 url
	 * @param dstFile : 다운받아 저장할 파일 경로
	 * @throws IOException
	 */
	public void download(String srcUrl, String dstFile) throws IOException{
		URL url = null;
		HttpURLConnection conn = null;
		InputStream in = null;
		BufferedInputStream bin = null;
		FileOutputStream out = null;
		BufferedOutputStream bout = null;
		
		try {
			System.out.println("다운로드 시도..:" + srcUrl + "\n\t → " + dstFile);
			
			url = new URL(srcUrl);
			conn = (HttpURLConnection) url.openConnection();
			int contentLength = conn.getContentLength();  // 파일 크기
			String contentType = conn.getContentType();   // 파일 종류 MIME-Type
			
			// 다운로드 받는 파일 이름 확인 가능
			String raw = conn.getHeaderField("Content-Disposition");  // attachment; filename=abc.jpg 
			
			
			
		} finally {
			if(bout != null) bout.close();
			if(bin != null) bin.close();
		}
		
		
	}
	
	
	
	
}






















