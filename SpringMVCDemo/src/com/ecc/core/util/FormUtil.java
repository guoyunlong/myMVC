package com.ecc.core.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Form 工具类  处理Form数据转换
 * 
 * @author guoyl
 *
 */
public class FormUtil {
	/**
	 * 对从页面提交的form中作转换
	 * 
	 * @param map
	 * @return
	 */
	public static Map convertoMap(Map map) {
		Map returnMap = new HashMap();
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			returnMap.put(entry.getKey(),
					StrUtil.checkNULL(((String[]) entry.getValue())[0]));
		}
		return returnMap;
	}
}
