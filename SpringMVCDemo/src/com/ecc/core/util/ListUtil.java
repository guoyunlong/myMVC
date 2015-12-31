package com.ecc.core.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.map.ListOrderedMap;

/**
 * 自定义LIST工具类
 * 
 * @author guoyl
 *
 */
public class ListUtil {

	public List format(List dataList,List filds){
		List returnDataList = new ArrayList();
		
		Iterator dataListIt = dataList.iterator();
		while(dataListIt.hasNext()){
			
		}
		
		
		return returnDataList;
	}
	public static List format(List dataList){
		List returnDataList = new ArrayList();
		
		Iterator dli = dataList.iterator();
		while(dli.hasNext()){
			Map map = (Map) dli.next();
			Set<Map.Entry<String, String>> allSet=map.entrySet();
			Iterator<Map.Entry<String, String>> iter=allSet.iterator();
			ListOrderedMap returnMap = new ListOrderedMap();
			while(iter.hasNext()){
				Map.Entry<String, String> me=iter.next();
				returnMap.put(me.getKey().toLowerCase(), me.getValue());
			}
			returnDataList.add(returnMap);
		}
		
		
		return returnDataList;
	}
	
}
