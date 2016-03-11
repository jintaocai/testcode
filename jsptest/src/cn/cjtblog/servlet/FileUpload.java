package cn.cjtblog.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FileUpload
 */
@MultipartConfig(location="/", fileSizeThreshold=1024*102,
maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
@WebServlet(urlPatterns={"/fileUpload"},loadOnStartup=1)
public class FileUpload extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String fileName=request.getParameter("username")+new Date().getTime()+".jpg";

		try{
			Part part=request.getPart("imageFile");
			part.write(fileName);
		}
		catch(Exception e){
			response.setContentType("application/json;charset=utf-8");
			response.setStatus(HttpServletResponse. SC_BAD_REQUEST);
			String s="{\"result\":\"failure\"}";
			response.getWriter().print(s);
		}
		response.setContentType("application/json;charset=utf-8");
		
		String s="{\"result\":\"success\"}";
		response.getWriter().print(s);
	}

}
