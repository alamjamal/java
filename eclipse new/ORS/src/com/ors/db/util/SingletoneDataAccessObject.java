package com.ors.db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.ors.util.UtilConstants;

public class SingletoneDataAccessObject {

	private static SingletoneDataAccessObject singletoneDataAccessObject;
	private Connection mCon;
	private static Properties mProps;
	static final Logger logger = Logger
			.getLogger(SingletoneDataAccessObject.class);

	/** A private Constructor prevents any other class from instantiating. */
	private SingletoneDataAccessObject() {

	}

	public static synchronized SingletoneDataAccessObject getSingletoneDataAccessObject() {

		if (singletoneDataAccessObject == null) {
			singletoneDataAccessObject = new SingletoneDataAccessObject();
		}
		return singletoneDataAccessObject;
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	/**
	 * @return the props
	 */
	public Properties getProperties() {
		return mProps;
	}

	/**
	 * @param props
	 *            application properties object
	 */
	public void setProperties(Properties aProps) {
		mProps = aProps;
	}

	public Connection getConnection() {
		try {
			Properties aProps = getProperties();
			Class.forName(aProps.getProperty(UtilConstants._DATABASE_DRIVER));
			mCon = DriverManager.getConnection(aProps
					.getProperty(UtilConstants._DATABASE_URL), aProps
					.getProperty(UtilConstants._DATABASE_USERNAME), aProps
					.getProperty(UtilConstants._DATABASE_PASSWORD));
		} catch (ClassNotFoundException e) {
			logger.info(e.getMessage());
		} catch (SQLException e) {
			logger.info(e.getMessage());
		}
		return mCon;
	}
}
