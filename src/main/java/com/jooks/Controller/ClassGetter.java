package com.jooks.Controller;

import com.jooks.Utils.DoJson;
import com.jooks.Utils.GetJson;
import com.jooks.entity.TimeSet;

import java.util.List;

public class ClassGetter {
    public static void main(String[] args) {
        // 以查询18周周五第1节课为例
        TimeSet timeSet = new TimeSet(18, 5, 1);
        String cookies = "JSESSIONID=30A450C577B84881985DB1207DD37E37";
        Integer totalPage = null;
        List<String> classrooms = DoJson.doJson(GetJson.getJson(timeSet, cookies));
        for (String str : classrooms) {
            System.out.println(str);
        }
    }
}
