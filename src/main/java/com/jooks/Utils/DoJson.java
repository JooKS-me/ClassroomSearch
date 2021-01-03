package com.jooks.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DoJson {
    // 处理json字符串，返回空教室集合
    public static List<String> doJson(String strJson) {
        String pattern = "\"cd_id\":\"G\\d\\d\\d\"";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(strJson);
        List<String> list = new ArrayList<String>();

        while (m.find()) {
            String classroom = m.group().substring(9, 13);
            list.add(classroom);
        }

        return list;
    }
}
