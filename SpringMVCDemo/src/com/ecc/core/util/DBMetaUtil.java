package com.ecc.core.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.ecc.core.bean.MetaDataBean;

/**
 * 元数据处理封装
 * 
 * @author guoyl
 * 
 */
public class DBMetaUtil {
	
	private static final Logger log = Logger.getLogger(DBMetaUtil.class);

	/**
	 * 取得表结构
	 */
	public static List<MetaDataBean> getTableMetaData(String tableName, DataSource ds) {
		List<MetaDataBean> list = new ArrayList<MetaDataBean>();
		Connection conn = null;
		try {
			conn = ds.getConnection();
			PreparedStatement prepareStatement = conn
					.prepareStatement("select * from " + tableName
							+ " where 1=2");

			ResultSet rs = prepareStatement.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			for (int i = 1; i <= metaData.getColumnCount(); ++i) {
				String columnName = metaData.getColumnName(i).toLowerCase();
				int type = metaData.getColumnType(i);
				MetaDataBean metaColumn = new MetaDataBean();
				metaColumn.setNameEn(columnName);
				metaColumn.setType(type);
				list.add(metaColumn);
			}
			prepareStatement.close();
			return list;
		} catch (SQLException e) {

			log.error("查询数据库表结构出错" + e);
			return null;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				log.error("关闭数据库连接出错");
			}
		}
	}
	
	
	
}
