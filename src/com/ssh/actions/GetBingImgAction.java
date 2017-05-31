package com.ssh.actions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Result;

public class GetBingImgAction implements ServletResponseAware{

	
	private HttpServletResponse response;
	
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response=arg0;
		
	}

	public void GetImgUrl() throws IOException
	{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		try {
			URL url=new URL("http://cn.bing.com/HPImageArchive.aspx?format=js&idx=0&n=1&mkt=zh-CN");
			
			InputStreamReader in=new InputStreamReader(url.openStream(),"UTF-8");
			
			BufferedReader buffin=new BufferedReader(in);
			
			String html;
			
			html=buffin.readLine();
//			System.out.println(html);
			
			
			String imgurl=html.split("\"url\":\"/")[1].split("\"")[0];
//			System.out.println(imgurl);
			String realimgurl="http://cn.bing.com/"+imgurl;
			
			in.close();
			buffin.close();
			
			out.print(realimgurl);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
