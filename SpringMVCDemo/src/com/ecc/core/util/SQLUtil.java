package com.ecc.core.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.ecc.core.bean.MetaDataBean;

/**
 * 
 * SQL工具类
 * 
 * 生成通用SQL
 * 
 * @author guoyl
 * 
 */
public class SQLUtil {

	/**
	 * 拼接SQL去除空值
	 * 
	 * @param obj
	 * @return
	 */
	public static Object checkNULL(Object obj) {
		if (obj == null) {
			return "";
		} else {
			return obj;
		}
	}

	/**
	 * 是否主键
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isPkValue(String pkValue, String value) {
		String[] pkvalues = pkValue.split(",", -2);
		boolean flag = false;
		for (int index = 0; index < pkvalues.length; index++) {
			if (pkvalues[index].trim().equals(value.trim())) {
				flag = true;
				break;
			} else
				continue;
		}
		return flag;
	}

	/**
	 * 生成insert sql语句
	 * 
	 * @param list
	 *            字段信息
	 * @param map
	 *            数据
	 * @return
	 */
	public static String createInsertSql(String tableName, String pkValue,
			List list, Map map) {
		MetaDataBean MetaDataBean = null;
		StringBuffer insertSql = new StringBuffer("insert into " + tableName
				+ "(");
		StringBuffer conditionSql = new StringBuffer(" values(");
		for (int index = 0; index < list.size(); index++) {
			MetaDataBean = (MetaDataBean) list.get(index);
			if (index == list.size() - 1) {

				if (MetaDataBean.getType() != 2) {
					if (map.get(MetaDataBean.getNameEn()) == null
							|| "".equals(map.get(MetaDataBean.getNameEn()))) {
						conditionSql.append(" ");
					} else {
						conditionSql.append("'"
								+ checkNULL(map.get(MetaDataBean.getNameEn()))
								+ "'");
						insertSql.append(MetaDataBean.getNameEn());
					}
				} else {

					if (map.get(MetaDataBean.getNameEn()) == null
							|| "".equals(map.get(MetaDataBean.getNameEn()))) {
						conditionSql.append(" ");
					} else {
						conditionSql.append(" "
								+ checkNULL(map.get(MetaDataBean.getNameEn()))
								+ "");
						insertSql.append(MetaDataBean.getNameEn());
					}

				}
			} else {

				if (MetaDataBean.getType() != 2) {
					if (map.get(MetaDataBean.getNameEn()) == null
							|| "".equals(map.get(MetaDataBean.getNameEn()))) {
						conditionSql.append(" ");
					} else {
						conditionSql.append(
								"'"
										+ checkNULL(map.get(MetaDataBean
												.getNameEn())) + "'").append(
								",");
						insertSql.append(MetaDataBean.getNameEn()).append(",");
					}
				} else {
					if (map.get(MetaDataBean.getNameEn()) == null
							|| "".equals(map.get(MetaDataBean.getNameEn()))) {
						conditionSql.append(" ");
					} else {
						conditionSql.append(
								" "
										+ checkNULL(map.get(MetaDataBean
												.getNameEn())) + " ").append(
								",");
						insertSql.append(MetaDataBean.getNameEn()).append(",");
					}
				}
			}
		}
		String insertS = insertSql.toString().trim();
		String conditionS = conditionSql.toString().trim();
		if (insertS.trim().lastIndexOf(",") == (insertS.trim().length() - 1)) {
			insertS = insertS.substring(0, insertS.length() - 1);
			insertS += ")";
		} else {
			insertS += ")";
		}

		if (conditionS.trim().lastIndexOf(",") == (conditionS.trim().length() - 1)) {
			conditionS = conditionS.substring(0, conditionS.length() - 1);
			conditionS += ")";
		} else {
			conditionS += ")";
		}

		return insertS + " " + conditionS;
	}

	/**
	 * 生成update sql语句
	 * 
	 * @param list
	 *            字段信息
	 * @param map
	 *            数据
	 * @return
	 */
	public static String createUpdateSql(String tableName, String pkValue,
			List list, Map map) {
		MetaDataBean MetaDataBean = null;
		boolean isNumber = false;
		StringBuffer updateSql = new StringBuffer("update " + tableName
				+ " set ");
		StringBuffer conditionSql = new StringBuffer(" where ");
		String nameEn = "";
		for (int index = 0; index < list.size(); index++) {
			MetaDataBean = (MetaDataBean) list.get(index);
			nameEn = MetaDataBean.getNameEn();
			if (MetaDataBean.getType() != 2) {
				isNumber = false;
			} else {
				isNumber = true;
			}

			if (index == list.size() - 1) {
				if (SQLUtil.isPkValue(pkValue, nameEn)) {
					if (isNumber) {
						if (map.get(nameEn) == null
								|| "".equals(map.get(nameEn))) {
							conditionSql.append(" ");
						} else {
							conditionSql.append(
									" " + nameEn + "="
											+ checkNULL(map.get(nameEn)))
									.append(" and");
						}
					} else {
						conditionSql.append(
								" " + nameEn + "='"
										+ checkNULL(map.get(nameEn))).append(
								"' and");

					}
				} else {
					if (isNumber) {
						if (map.get(nameEn) == null
								|| "".equals(map.get(nameEn))) {
							conditionSql.append(" ");
						} else {
							updateSql.append(" " + nameEn + "="
									+ checkNULL(map.get(nameEn)));
						}
					} else {
						updateSql.append(
								" " + nameEn + "='"
										+ checkNULL(map.get(nameEn))).append(
								"' ");

					}
				}
			} else {
				if (SQLUtil.isPkValue(pkValue, nameEn)) {
					if (isNumber) {
						if (map.get(nameEn) == null
								|| "".equals(map.get(nameEn))) {
							conditionSql.append(" ");
						} else {
							conditionSql.append(
									" " + nameEn + "="
											+ checkNULL(map.get(nameEn)))
									.append(" and");
						}
					} else {
						conditionSql.append(
								" " + nameEn + "='"
										+ checkNULL(map.get(nameEn))).append(
								"' and");

					}
				} else {
					if (isNumber) {
						if (map.get(nameEn) == null
								|| "".equals(map.get(nameEn))) {
							conditionSql.append(" ");
						} else {
							updateSql.append(
									" " + nameEn + "="
											+ checkNULL(map.get(nameEn)))
									.append(",");
						}
					} else {
						updateSql.append(
								" " + nameEn + "='"
										+ checkNULL(map.get(nameEn))).append(
								"',");

					}
				}
			}

		}
		String updateSQL = updateSql.toString();
		if (updateSQL.endsWith(",")) {
			updateSQL = updateSQL.substring(0, updateSQL.length() - 1);
		}
		String condition = conditionSql.toString();
		condition = condition.substring(0, condition.lastIndexOf("and"));
		return updateSQL + " " + condition;
	}

	/**
	 * 生成删除sql
	 */
	public static String createDeleteSql(String tableName, String pkValue,
			List list, Map map) {
		StringBuffer deleteSql = new StringBuffer("delete from " + tableName
				+ " where ");
		for (int index = 0; index < list.size(); index++) {
			MetaDataBean MetaDataBean = (MetaDataBean) list.get(index);
			String nameEn = MetaDataBean.getNameEn();
			boolean isNumber;
			if (MetaDataBean.getType() != 2) {
				isNumber = false;
			} else {
				isNumber = true;
			}
			if (isPkValue(pkValue, nameEn)) {
				if (isNumber) {
					if (map.get(nameEn) == null || "".equals(map.get(nameEn))) {
						deleteSql.append(" ");
					} else {
						deleteSql
								.append(" " + nameEn + "="
										+ checkNULL(map.get(nameEn)).toString())
								.append(" and");
					}
				} else {
					deleteSql.append(
							" " + nameEn + "='"
									+ checkNULL(map.get(nameEn)).toString())
							.append("' and");
				}
			} else {
				continue;
			}
		}
		String condition = deleteSql.toString().substring(0,
				deleteSql.toString().length() - 3);
		return condition;
	}

	/**
	 * 生成select sql语句
	 * 
	 * @param list
	 *            字段信息
	 * @param map
	 *            数据
	 * @return
	 */
	public static String createLoadByIdSql(String tableName, String pkValue,
			List list, Map map) {
		MetaDataBean metaData = null;
		boolean isNumber = false;
		String nameEn = "";
		StringBuffer selectSql = new StringBuffer("select ");
		StringBuffer conditionSql = new StringBuffer(" where ");
		for (int index = 0; index < list.size(); index++) {
			metaData = (MetaDataBean) list.get(index);

			nameEn = metaData.getNameEn();
			if (metaData.getType() != 2) {
				isNumber = false;
			} else {
				isNumber = true;
			}
			if (index == list.size() - 1) {
				selectSql.append(nameEn);
				if (isPkValue(pkValue, nameEn)) {
					if (isNumber) {
						if (map.get(nameEn) == null
								|| "".equals(map.get(nameEn))) {
							conditionSql.append(" ");
						} else {
							conditionSql.append(
									" "
											+ nameEn
											+ "="
											+ checkNULL(map.get(nameEn))
													.toString()).append(" and");
						}
					} else {
						conditionSql
								.append(" " + nameEn + "='"
										+ checkNULL(map.get(nameEn)).toString())
								.append("' and");
					}
				}
			} else {
				selectSql.append(nameEn).append(",");
				if (isPkValue(pkValue, nameEn)) {
					if (isNumber) {
						if (map.get(nameEn) == null
								|| "".equals(map.get(nameEn))) {
							conditionSql.append(" ");
						} else {
							conditionSql.append(
									" "
											+ nameEn
											+ "="
											+ checkNULL(map.get(nameEn))
													.toString()).append(" and");
						}
					} else {
						conditionSql
								.append(" " + nameEn + "='"
										+ checkNULL(map.get(nameEn)).toString())
								.append("' and");
					}
				}
			}
		}
		selectSql.append(" from " + tableName);
		String condition = conditionSql.toString().substring(0,
				conditionSql.toString().length() - 3);
		return selectSql.toString() + " " + condition;
	}

	/**
	 * 格式化分页处理
	 * 
	 * @param start
	 * @param limit
	 * @param sqlBase
	 * @return
	 */
	public static String toPage(int start, int limit, String sql) {
		StringBuffer sb = new StringBuffer("SELECT * FROM ( ");
		sb.append("SELECT T.*, ROWNUM RN FROM ( ");
		sb.append(sql);
		sb.append(" ) T WHERE ROWNUM <= ");
		sb.append(start + limit);
		sb.append(" ) T WHERE T.RN > ");
		sb.append(start);
		return sb.toString();
	}

	/**
	 * 格式化统计SQL
	 * 
	 * @param sqlBase
	 * @return
	 */
	public static String toCount(String sqlBase) {
		StringBuffer sb = new StringBuffer("SELECT COUNT(*) FROM ( ");
		sb.append(sqlBase);
		sb.append(" ) ");
		return sb.toString();
	}

	/**
	 * 创建查询SQL
	 * 
	 * @param listCondition
	 * @param sqlBase
	 * @return
	 */
	public static String createSelectSql(List listCondition, String sqlBase) {
		Map map = SQLUtil.resolveSelectSql(sqlBase);

		String conditionStr = ConditionUtil.toString(listCondition);

		StringBuffer stringBuffer = new StringBuffer("");
		stringBuffer.append(map.get("selectStr"));
		stringBuffer.append(map.get("fromStr"));
		if (map.get("whereStr") == null || "".equals(map.get("whereStr"))) {

			if (!(conditionStr == null || "".equals(conditionStr))) {
				stringBuffer.append(" where ");
			}
		} else {
			stringBuffer.append(map.get("whereStr"));
			if (!(conditionStr == null || "".equals(conditionStr))) {
				stringBuffer.append(" and ");
			}
		}
		stringBuffer.append(conditionStr);
		stringBuffer.append(map.get("groupStr"));
		stringBuffer.append(map.get("havingStr"));
		stringBuffer.append(map.get("orderStr"));

		return String.valueOf(stringBuffer).toLowerCase();
		
	}

	/**
	 * 分解SQL
	 * 
	 * @param sqlBase
	 * @return
	 */
	private static Map resolveSelectSql(String sqlBase) {

		Map<String, String> map = new HashMap<String, String>();

		if (sqlBase == null || sqlBase.trim().equals("")) {
			// sqlBase is null;
			return map;
		}

		String selectStr = "";
		String fromStr = "";
		String whereStr = "";
		String groupStr = "";
		String havingStr = "";
		String orderStr = "";

		int indexOfSelect = -1;
		int indexOfFrom = -1;
		int indexOfWhere = -1;
		int indexOfOrder = -1;
		int indexOfGroup = -1;
		int indexOfHaving = -1;

		// 格式化SQ1将存在两个以上的空格全部替换成一个
		sqlBase = SQLUtil.replaceSpaceUnnecessary(sqlBase);

		// 截取order by语句
		indexOfOrder = sqlBase.lastIndexOf(" order by ");
		if (indexOfOrder == -1) {
			indexOfOrder = sqlBase.length();
		}
		orderStr = sqlBase.substring(indexOfOrder, sqlBase.length());

		indexOfHaving = sqlBase.lastIndexOf(" having ");
		if (indexOfHaving == -1) {
			indexOfHaving = indexOfOrder;
		}
		havingStr = sqlBase.substring(indexOfHaving, indexOfOrder);

		indexOfGroup = sqlBase.lastIndexOf(" group by ");
		if (indexOfGroup == -1) {
			indexOfGroup = indexOfHaving;
		}
		groupStr = sqlBase.substring(indexOfGroup, indexOfHaving);

		indexOfWhere = sqlBase.lastIndexOf(" where ");
		if (indexOfWhere == -1) {
			indexOfWhere = indexOfGroup;
		}
		whereStr = sqlBase.substring(indexOfWhere, indexOfGroup);

		indexOfFrom = sqlBase.indexOf(" from ");
		if (indexOfFrom == -1) {
			// from table error
			return map;
		}
		fromStr = sqlBase.substring(indexOfFrom, indexOfWhere);

		selectStr = sqlBase.substring(0, indexOfFrom);
		indexOfSelect = selectStr.indexOf("select");

		if (indexOfSelect == -1) {
			// select column error
			return map;
		} else if (!selectStr.substring(0, indexOfSelect).trim().isEmpty()) {
			// select column error
			return map;
		}

		map.put("selectStr", selectStr);
		map.put("fromStr", fromStr);
		map.put("whereStr", whereStr);
		map.put("groupStr", groupStr);
		map.put("havingStr", havingStr);
		map.put("orderStr", orderStr);

		return map;
	}

	/**
	 * 
	 * 替换多余的空格 递归
	 * 
	 * @param sql
	 * @return
	 */
	@SuppressWarnings("unused")
	private static String replaceSpaceUnnecessary(String sql) {

		if (sql.indexOf("  ") == -1) {
			return sql;
		} else {
			return replaceSpaceUnnecessary(sql.replace("  ", " "));
		}
	}

}
