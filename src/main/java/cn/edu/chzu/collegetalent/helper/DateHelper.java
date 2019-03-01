package cn.edu.chzu.collegetalent.helper;

import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @auther: chzu
 * @date: Created in 2019/3/1 16:36
 * @description:
 */
public class DateHelper {

    public static Date toDate(String str){
        if(StringUtils.isEmpty(str)){
            return null;
        }
        return toDate(str,"yyyy-MM-dd");
    }

    public static Date toDate(String str, String pattern){
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            return simpleDateFormat.parse(str);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
