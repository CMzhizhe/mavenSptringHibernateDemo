package com.art.msh.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;

public class StringUtils {
	/**
	 * 判断输入的内容是否为空
	 * @param value
	 * @return
	 */
	public static boolean isEmptyOrNull(String value){
		if(value==null||value.trim().equals("")){
			return true;
		}
		return false;
	}
	
	 // 将字Clob转成String类型  
    public static String ClobToString(Clob sc) throws SQLException, IOException {  
        String reString = "";  
        Reader is = sc.getCharacterStream();// 得到流  
        BufferedReader br = new BufferedReader(is);  
        String s = br.readLine();  
        StringBuffer sb = new StringBuffer();  
        while (s != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING  
            sb.append(s);  
            s = br.readLine();  
        }  
        reString = sb.toString();  
        return reString;  
    }  
}
