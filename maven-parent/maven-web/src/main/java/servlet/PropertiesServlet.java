package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import util.PropertyFileUtil;

import com.alibaba.druid.util.StringUtils;

public class PropertiesServlet extends HttpServlet{

	public PropertiesServlet(){
		super();
	}
	
	public void init(ServletConfig config){
		String profile = config.getInitParameter("profile");
		if(!StringUtils.isEmpty(profile)){
			PropertyFileUtil.init(profile);
		}else{
			PropertyFileUtil.init();
		}
		ServletContext context = config.getServletContext();
		context.setAttribute("prop", PropertyFileUtil.getKeyValue());
	}
	
}

