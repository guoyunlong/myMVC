package com.ecc.core.util;

import java.util.List;
import java.util.Map;

public class ConditionUtil {

	/**
	 * 将LIST条件集合转换成可拼接SQL的字符串
	 * 
	 * @param listCondition
	 * @return
	 */
	public static String toString(List listCondition) {
		boolean flag = true;// 为true条件拼接正确，为FALSE存在错误

		StringBuffer stringBuffer = new StringBuffer("");

		for (Object objCondition : listCondition) {
			// 判断mapCondition是否是Map对象
			if (!(objCondition instanceof Map)) {
				// mapCondition 不是MAP对象
				flag = false;
				break;
			}
			Map mapCondition = (Map) objCondition;

			if (mapCondition.get("conditionType") == null) {
				flag = false;
				break;
			}
			// 判断类型，返回如何拼接
			if (mapCondition.get("conditionType").toString().toUpperCase()
					.equals("equalTo".toUpperCase())) {

				stringBuffer.append(ConditionUtil.equalTo(mapCondition));
			} else if (mapCondition.get("conditionType").toString()
					.toUpperCase().equals("notEqualTo".toUpperCase())) {

				stringBuffer.append(ConditionUtil.notEqualTo(mapCondition));
			} else if (mapCondition.get("conditionType").toString()
					.toUpperCase().equals("greaterThan".toUpperCase())) {

				stringBuffer.append(ConditionUtil.greaterThan(mapCondition));
			} else if (mapCondition.get("conditionType").toString()
					.toUpperCase().equals("greaterThanOrEqualTo".toUpperCase())) {

				stringBuffer.append(ConditionUtil
						.greaterThanOrEqualTo(mapCondition));
			} else if (mapCondition.get("conditionType").toString()
					.toUpperCase().equals("lessThan".toUpperCase())) {

				stringBuffer.append(ConditionUtil.lessThan(mapCondition));
			} else if (mapCondition.get("conditionType").toString()
					.toUpperCase().equals("lessThanOrEqualTo".toUpperCase())) {

				stringBuffer.append(ConditionUtil
						.lessThanOrEqualTo(mapCondition));
			} else if (mapCondition.get("conditionType").toString()
					.toUpperCase().equals("isNull".toUpperCase())) {

				stringBuffer.append(ConditionUtil.isNull(mapCondition));
			} else if (mapCondition.get("conditionType").toString()
					.toUpperCase().equals("isNotNull".toUpperCase())) {

				stringBuffer.append(ConditionUtil.isNotNull(mapCondition));
			} else if (mapCondition.get("conditionType").toString()
					.toUpperCase().equals("like".toUpperCase())) {

				stringBuffer.append(ConditionUtil.like(mapCondition));
			} else if (mapCondition.get("conditionType").toString()
					.toUpperCase().equals("rightLike".toUpperCase())) {

				stringBuffer.append(ConditionUtil.rightLike(mapCondition));
			} else if (mapCondition.get("conditionType").toString()
					.toUpperCase().equals("leftLike".toUpperCase())) {

				stringBuffer.append(ConditionUtil.leftLike(mapCondition));
			} else if (mapCondition.get("conditionType").toString()
					.toUpperCase().equals("notLike".toUpperCase())) {

				stringBuffer.append(ConditionUtil.notLike(mapCondition));
			} else if (mapCondition.get("conditionType").toString()
					.toUpperCase().equals("notRightLike".toUpperCase())) {

				stringBuffer.append(ConditionUtil.notRightLike(mapCondition));
			} else if (mapCondition.get("conditionType").toString()
					.toUpperCase().equals("notLeftLike".toUpperCase())) {

				stringBuffer.append(ConditionUtil.notLeftLike(mapCondition));
			} else if (mapCondition.get("conditionType").toString()
					.toUpperCase().equals("in".toUpperCase())) {

				stringBuffer.append(ConditionUtil.in(mapCondition));
			} else if (mapCondition.get("conditionType").toString()
					.toUpperCase().equals("notIn".toUpperCase())) {

				stringBuffer.append(ConditionUtil.notIn(mapCondition));
			} else if (mapCondition.get("conditionType").toString()
					.toUpperCase().equals("between".toUpperCase())) {

				stringBuffer.append(ConditionUtil.between(mapCondition));
			} else if (mapCondition.get("conditionType").toString()
					.toUpperCase().equals("notBetween".toUpperCase())) {

				stringBuffer.append(ConditionUtil.notBetween(mapCondition));
			} else {
				flag = false;
				break;
			}
			stringBuffer.append(" and ");
		}

		if(listCondition.isEmpty()){
			flag = false;
		}
		
		if (flag) {
			String returnString = String.valueOf(stringBuffer);
			return returnString.substring(0, returnString.lastIndexOf(" and "))
					.toUpperCase();
		} else {
			return "";
		}
	}

	/**
	 * 拼接列名的字符串
	 * 
	 * @param mapCondition
	 * @return
	 */
	@SuppressWarnings("unused")
	private static String toColumnString(Map mapCondition) {

		if (mapCondition.get("tableAlias") == null
				|| "".equals(mapCondition.get("tableAlias"))) {
			return mapCondition.get("columnName").toString();
		} else {
			return mapCondition.get("tableAlias") + "."
					+ mapCondition.get("columnName").toString();
		}

	}

	private static String valueFormat(Map mapCondition) {

		Object obj = mapCondition.get("columnValue");

		if (obj instanceof String) {
			StringBuffer stringBuffer = new StringBuffer("");
			String[] strs = obj.toString().split(",");
			for (int i = 0; i < strs.length; i++) {
				stringBuffer.append("'");
				stringBuffer.append(obj);
				stringBuffer.append("'");
				if (i != strs.length - 1) {
					stringBuffer.append(",");
				}
			}
			return String.valueOf(stringBuffer);
		}
		return obj.toString();
	}

	/**
	 * 相等
	 * 
	 * @param mapCondition
	 * @return
	 */
	private static String equalTo(Map mapCondition) {

		return toColumnString(mapCondition) + " = "
				+ ConditionUtil.valueFormat(mapCondition);

	}

	/**
	 * 不相等
	 * 
	 * @param mapCondition
	 * @return
	 */
	private static String notEqualTo(Map mapCondition) {

		return toColumnString(mapCondition) + " <> "
				+ ConditionUtil.valueFormat(mapCondition);

	}

	/**
	 * 大于
	 * 
	 * @param mapCondition
	 * @return
	 */
	private static String greaterThan(Map mapCondition) {

		return toColumnString(mapCondition) + " > "
				+ ConditionUtil.valueFormat(mapCondition);

	}

	/**
	 * 大于等于
	 * 
	 * @param mapCondition
	 * @return
	 */
	private static String greaterThanOrEqualTo(Map mapCondition) {

		return toColumnString(mapCondition) + " >= "
				+ ConditionUtil.valueFormat(mapCondition);

	}

	/**
	 * 小于
	 * 
	 * @param mapCondition
	 * @return
	 */
	private static String lessThan(Map mapCondition) {

		return toColumnString(mapCondition) + " < "
				+ ConditionUtil.valueFormat(mapCondition);

	}

	/**
	 * 小于等于
	 * 
	 * @param mapCondition
	 * @return
	 */
	private static String lessThanOrEqualTo(Map mapCondition) {

		return toColumnString(mapCondition) + " <= "
				+ ConditionUtil.valueFormat(mapCondition);

	}

	/**
	 * 为空
	 * 
	 * @param mapCondition
	 * @return
	 */
	private static String isNull(Map mapCondition) {
		return toColumnString(mapCondition) + " is null ";
	}

	/**
	 * 不为空
	 * 
	 * @param mapCondition
	 * @return
	 */
	private static String isNotNull(Map mapCondition) {
		return toColumnString(mapCondition) + " is not null ";
	}

	/**
	 * 模糊查询 全匹配
	 * 
	 * @param mapCondition
	 * @return
	 */
	private static String like(Map mapCondition) {
		return toColumnString(mapCondition) + " like '%"
				+ ConditionUtil.valueFormat(mapCondition) + "%' ";
	}

	/**
	 * 模糊查询 右匹配
	 * 
	 * @param mapCondition
	 * @return
	 */
	private static String rightLike(Map mapCondition) {
		return toColumnString(mapCondition) + " like '"
				+ ConditionUtil.valueFormat(mapCondition) + "%' ";
	}

	/**
	 * 模糊查询 左匹配
	 * 
	 * @param mapCondition
	 * @return
	 */
	private static String leftLike(Map mapCondition) {
		return toColumnString(mapCondition) + " like '%"
				+ ConditionUtil.valueFormat(mapCondition) + "' ";
	}

	/**
	 * 模糊查询取反 全匹配
	 * 
	 * @param mapCondition
	 * @return
	 */
	private static String notLike(Map mapCondition) {
		return toColumnString(mapCondition) + " not like '%"
				+ ConditionUtil.valueFormat(mapCondition) + "%' ";
	}

	/**
	 * 模糊查询取反 右匹配
	 * 
	 * @param mapCondition
	 * @return
	 */
	private static String notRightLike(Map mapCondition) {
		return toColumnString(mapCondition) + " not like '"
				+ ConditionUtil.valueFormat(mapCondition) + "%' ";
	}

	/**
	 * 模糊查询取反 左匹配
	 * 
	 * @param mapCondition
	 * @return
	 */
	private static String notLeftLike(Map mapCondition) {
		return toColumnString(mapCondition) + " not like '%"
				+ ConditionUtil.valueFormat(mapCondition) + "' ";
	}

	/**
	 * 包含
	 * 
	 * @param mapCondition
	 * @return
	 */
	private static String in(Map mapCondition) {
		return toColumnString(mapCondition) + " in ("
				+ ConditionUtil.valueFormat(mapCondition) + ") ";
	}

	/**
	 * 不包含
	 * 
	 * @param mapCondition
	 * @return
	 */
	private static String notIn(Map mapCondition) {
		return toColumnString(mapCondition) + " not in ("
				+ ConditionUtil.valueFormat(mapCondition) + ") ";
	}

	/**
	 * 在两个值之间
	 * 
	 * @param mapCondition
	 * @return
	 */
	private static String between(Map mapCondition) {
		String[] values = ConditionUtil.valueFormat(mapCondition).toString()
				.split(",");
		return toColumnString(mapCondition) + " between " + values[0] + " and "
				+ values[1];
	}

	/**
	 * 不在两个值之间
	 * 
	 * @param mapCondition
	 * @return
	 */
	private static String notBetween(Map mapCondition) {
		String[] values = ConditionUtil.valueFormat(mapCondition).toString()
				.split(",");
		return toColumnString(mapCondition) + " not between " + values[0]
				+ " and " + values[1];
	}

}
