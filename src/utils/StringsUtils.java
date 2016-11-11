package utils;

import java.util.Set;

public class StringsUtils {

	/**
	 * 将Set转换成String，其中的元素
	 * @param set
	 * @return
	 */
	public static String convertSet2String(Set set){
		String result = "";
		
		if(set.isEmpty()){
			return result;
		}
		
		for(Object item:set){
			String str = (String)item;
			result += str + ",";
		}
		
		return result.substring(0, result.length()-1);
	}
}
