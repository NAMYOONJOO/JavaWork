package com.command.write;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.FileDAO;
import com.lec.beans.WriteDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

public class UpdateCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;
		WriteDAO dao = new WriteDAO();
		FileDAO fileDao = new FileDAO();//첨부파일
		
		//---------------------------------------------------------------
		// 1. 업로드 파일(들)
		ServletContext context= request.getServletContext();
		String saveDirectory = context.getRealPath("upload");
		
		int maxPostSize = 5*1024*1024;//최대파일 5mb
		String encoding = "utf-8";
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		MultipartRequest multi = null;
		
		try {
			multi = new MultipartRequest(
					request, 
					saveDirectory,
					maxPostSize,
					encoding,
					policy);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		List<String> originalFileNames = new ArrayList<String>();
		List<String> fileSystemNames = new ArrayList<String>();
		
		Enumeration names = multi.getFileNames();//type = "file" 요소의 name 들 추출
		while(names.hasMoreElements()) {
			String name = (String)names.nextElement();
			String originalFileName = multi.getOriginalFileName(name);
			String fileSystemName = multi.getFilesystemName(name);
			System.out.println("첨부파일 : "+originalFileName + "->"+fileSystemName);
			
			if(originalFileName!=null&&fileSystemName!=null) {
				originalFileNames.add(originalFileName);
				fileSystemNames.add(fileSystemName);
			}
			
					
		}//end while
		
		
		
		//-----------------------------------------------------------------
		// 2. 삭제된 첨부파일(들)
		String [] delFiles = multi.getParameterValues("delfile");//복수개가 넘어온다. 
		if(delFiles!=null&&delFiles.length>0) { //삭제대상의 파일이 있다면
			int [] delFileUids = new int[delFiles.length];
			for (int i = 0; i < delFileUids.length; i++) {
				delFileUids[i] = Integer.parseInt(delFiles[i]);
			}
			
			try {
				fileDao.deleteByUid(delFileUids, request);
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//---------------------------------------------------------------
		// 3. 입력한값 받아오기 -->글수정
		  int uid = Integer.parseInt(multi.getParameter("uid"));
		  String subject = multi.getParameter("subject");
		  String content = multi.getParameter("content");
		  
		  try {
				cnt = dao.update(uid,subject,content);
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
		  
		  //-----------------------------------------------------------
		  //추가된 첨부파일(들)
		  
		  fileDao = new FileDAO();
		  try {
			  fileDao.insert(uid, originalFileNames, fileSystemNames);
		  }catch(SQLException e) {
			  e.printStackTrace();
		  }
		  
		  request.setAttribute("uid", uid);
		  request.setAttribute("update", cnt);
		
	}

}
