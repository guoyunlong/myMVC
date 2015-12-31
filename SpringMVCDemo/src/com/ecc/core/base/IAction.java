package com.ecc.core.base;

import java.util.Map;

import com.ecc.core.bean.AjaxResponseBean;

/**
 * 普通操作封状接口 
 * @author guoyl
 *
 */
public interface IAction {
	
	/**
	 * 增加
	 * 
	 * @param map
	 * @return  0 成功
	 * 			1 失败
	 * 			-1 数据重复
	 */
	AjaxResponseBean insertRecode(Map map);
	/**
	 * 修改 
	 * @param map
	 * @return 0 成功
	 * 		   1 失败
	 * 		   -2 数据过期
	 */
	AjaxResponseBean updateRecode(Map map);
	/**
	 * 按ID取值 
	 * 
	 * @param map
	 * @return  0 成功 
	 * 			1 失败
	 */
	AjaxResponseBean loadRecodeById(Map map);
	/**
	 * 删除
	 * 
	 * @param map
	 * @return 0 成功
	 * 		   1 失败
	 * 		   -2 数据过期
	 */
	AjaxResponseBean deleteRecodeById(Map map);
	/**
	 * 多条删除
	 * 
	 * @param map
	 * @return
	 */
	AjaxResponseBean batchDeleteRecode(Map map);
	/**
	 * 多条修改
	 * 
	 * @param map
	 * @return
	 */
	AjaxResponseBean batchUpdateRecode(Map map);
	/**
	 * 多条新增
	 * 
	 * @param map
	 * @return
	 */
	AjaxResponseBean batchInsertRecode(Map map);
	
}
