package com.ecc.core.base;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.map.ListOrderedMap;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;

import com.ecc.core.bean.AjaxResponseBean;
import com.ecc.core.util.DBMetaUtil;
import com.ecc.core.util.SQLUtil;

/**
 * 完成基本的数据的增删改查
 * @author guoyl
 *
 */
public class BasicAction extends AbstractAction {
	private static final Logger log = Logger.getLogger(BasicAction.class);

	public BasicAction(){
		super();
	}
	
	@Override
	public AjaxResponseBean deleteRecodeById(Map map) {
		
		AjaxResponseBean responseBean = new AjaxResponseBean();
		ListOrderedMap returnMap = new ListOrderedMap();
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(this.getDataSource());
		List list = DBMetaUtil.getTableMetaData(this.getTableName(),
				this.getJdbcTemplate().getDataSource());
//				this.getDataSource());
		String deleteSql = SQLUtil.createDeleteSql(this.getTableName(), this.getPkValue(),list, map);
		log.info("delete sql==" + deleteSql);
		try {
			this.getJdbcTemplate().update(deleteSql);
			responseBean.setSuccess(true);
			returnMap.put("responseValue", "0");
			returnMap.put("responseDetail", "删除成功");
			responseBean.setResponseData(returnMap);
			return responseBean;
		} catch (DataAccessException e) {
			log.error("删除记录出错" + e);
			responseBean.setSuccess(false);
			returnMap.put("responseValue", "1");
			returnMap.put("responseDetail", "删除出错 ");
			responseBean.setResponseData(returnMap);
			return responseBean;
		}
	}


	@Override
	public AjaxResponseBean updateRecode(Map map) {

		AjaxResponseBean responseBean = new AjaxResponseBean();
		ListOrderedMap returnMap = new ListOrderedMap();
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(this.getDataSource());
		List list = DBMetaUtil.getTableMetaData(this.getTableName(),
				this.getJdbcTemplate().getDataSource());
//				this.getDataSource());
		String updateSql = SQLUtil.createUpdateSql(this.getTableName(), this.getPkValue(),list, map);
		log.info("update sql==" + updateSql);
		try {
			this.getJdbcTemplate().update(updateSql);
			responseBean.setSuccess(true);
			returnMap.put("responseValue", "0");
			returnMap.put("responseDetail", "更新成功");
			responseBean.setResponseData(returnMap);
			return responseBean;
		} catch (DataAccessException e) {
			log.error("更新记录出错" + e);
			responseBean.setSuccess(false);
			returnMap.put("responseValue", "1");
			returnMap.put("responseDetail", "更新出错 ");
			responseBean.setResponseData(returnMap);
			return responseBean;
		}
	}


	
	@Override
	public AjaxResponseBean loadRecodeById(Map map) {
		AjaxResponseBean responseBean = new AjaxResponseBean();
		ListOrderedMap returnMap = new ListOrderedMap();
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(this.getDataSource());
		List list = DBMetaUtil.getTableMetaData(this.getTableName(),
				this.getJdbcTemplate().getDataSource());
//				this.getDataSource());
		String selectSql = SQLUtil.createLoadByIdSql(this.getTableName(), this.getPkValue(),list, map);
		log.info("selectSql=" + selectSql);
		try {
			Map dataMap = (Map) this.getJdbcTemplate()
					.queryForMap(selectSql);
			Set<Map.Entry<String, String>> allSet=dataMap.entrySet();
			Iterator<Map.Entry<String, String>> iter=allSet.iterator();
			while(iter.hasNext()){
				Map.Entry<String, String> me=iter.next();
				returnMap.put(me.getKey().toLowerCase(), me.getValue());
			}
			responseBean.setSuccess(true);
			responseBean.setResponseData(returnMap);
			return responseBean;
		} catch (DataAccessException e) {
			log.error("查询记录出错" + e);
			responseBean.setSuccess(false);
			returnMap.put("responseValue", "1");
			returnMap.put("responseDetail", "查询出错 ");
			responseBean.setResponseData(returnMap);
			return responseBean;
		}
	}


	@Override
	public AjaxResponseBean insertRecode(Map map) {

		AjaxResponseBean responseBean = new AjaxResponseBean();
		ListOrderedMap returnMap = new ListOrderedMap();
		List list = DBMetaUtil.getTableMetaData(this.getTableName(),
				this.getJdbcTemplate().getDataSource());
		String selectSql = SQLUtil.createLoadByIdSql(this.getTableName(), this.getPkValue(),list, map);
		int count = this.getJdbcTemplate().queryForInt("select count(*) from ("
				+ selectSql + ")bccte");// 检查是否存在重复记录
		log.info("select sql==" + selectSql);
		if (count != 0) {
			responseBean.setSuccess(false);
			returnMap.put("responseValue", "-1");
			returnMap.put("responseDetail", "数据库存在相同记录");
			responseBean.setResponseData(returnMap);
			return responseBean;
		} else {
			String insertSql = SQLUtil.createInsertSql(this.getTableName(), this.getPkValue(),list, map);
			log.info("insert sql==" + insertSql);
			try {
				this.getJdbcTemplate().update(insertSql);
				responseBean.setSuccess(true);
				returnMap.put("responseValue", "0");
				returnMap.put("responseDetail", "插入成功");

				responseBean.setResponseData(returnMap);
				return responseBean;
			} catch (DataAccessException e) {
				log.error("插入数据出错 " + e);
				responseBean.setSuccess(false);
				returnMap.put("responseValue", "1");
				returnMap.put("responseDetail", "插入出错 ");

				responseBean.setResponseData(returnMap);
				return responseBean;
			}
		}
	}

	@Override
	public AjaxResponseBean batchDeleteRecode(Map map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AjaxResponseBean batchUpdateRecode(Map map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AjaxResponseBean batchInsertRecode(Map map) {
		// TODO Auto-generated method stub
		return null;
	}
}
