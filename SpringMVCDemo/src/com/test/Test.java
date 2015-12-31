package com.test;

public class Test {
	private static String replaceSpaceUnnecessary(String sql){
		
		if(sql.indexOf("  ")==-1){
			return sql;
		}else{
			return replaceSpaceUnnecessary(sql.replace("  ", " "));
		}
	}

	public static void main(String args[]){
		String sql = "select name from users where 1=1 group by name order by name  ";
		sql = replaceSpaceUnnecessary(sql);
		System.out.println(sql);

		String orderStr = sql.substring(sql.lastIndexOf("order by"), sql.length());
		String havingStr = sql.substring(sql.lastIndexOf("having"), sql.lastIndexOf("order by"));;
		String groupStr = sql.substring(sql.lastIndexOf("group by"), sql.lastIndexOf("having"));;
		String whereStr = sql.substring(sql.lastIndexOf("where"), sql.lastIndexOf("group by"));;
		String fromStr = sql.substring(sql.indexOf(" form "), sql.lastIndexOf("where "));;
		String selectStr = sql.substring(0,sql.indexOf(" form "));;

		System.out.println(orderStr);
		System.out.println(havingStr);
		System.out.println(groupStr);
		System.out.println(whereStr);
		System.out.println(fromStr);
		System.out.println(selectStr);
		
	}
}
