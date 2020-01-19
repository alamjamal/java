package com.ors.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.ors.db.util.SingletoneDataAccessObject;

public class InitServlet extends HttpServlet {

	private static final long serialVersionUID = 7020529156071030106L;
	static final Logger logger = Logger.getLogger(InitServlet.class);
	SingletoneDataAccessObject dobject;

	public void init(ServletConfig sc) {
		ServletContext ctx = sc.getServletContext();
		InputStream fis = ctx.getResourceAsStream(sc
				.getInitParameter(UtilConstants._CONFIG));
		Properties props = new Properties();
		try {
			props.load(fis);
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
		dobject = SingletoneDataAccessObject.getSingletoneDataAccessObject();
		dobject.setProperties(props);
	}
}
