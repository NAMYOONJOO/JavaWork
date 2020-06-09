package com.command.write;

import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.FileDAO;
import com.lec.beans.FileDTO;
import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class ViewCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		WriteDAO dao = new WriteDAO();
		WriteDTO [] arr = null;
		
		// 첨부파일
		FileDAO fileDao = new FileDAO();
		FileDTO [] fileArr = null;
		
		int uid = Integer.parseInt(request.getParameter("uid"));  // 매개변수 검증 필요

		try {
			arr = dao.readyByUid(uid);  // 읽기 + 조회수 증가
			request.setAttribute("list", arr);
		} catch (SQLException e) { // 만약 ConnectionPool 을 사용한다면 여기서 NamingException 도 catch 해야 한다  
			e.printStackTrace();
		}
		

		// 첨부파일 읽어 들이기
		
		try {
			if(arr != null && arr.length == 1) {
				fileArr = fileDao.selectFilesByWrUid(uid);  // 첨부파일 읽어오기
				
				// 이미지 파일 여부 세팅
				String realPath = "";
				String saveFolder = "upload";
				ServletContext context = request.getServletContext();
				realPath = context.getRealPath(saveFolder);

				for(FileDTO fileDto : fileArr) {
					String downloadedFilePath = realPath + File.separator + fileDto.getFile();
					BufferedImage imgData = ImageIO.read(new File(downloadedFilePath));
					if(imgData != null) {   
						fileDto.setImage(true);  // 이미지 다!
					}
				}
				
				
				request.setAttribute("file", fileArr);
			}	
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	} // end execute()

}  // end Command




















