package com.lotbyte.count;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lp
 * @Date 2019/3/25 16:07
 * @Version 1.0
 * 用户资产信息统计
 */
public class TestAccountInfo {


    public static void main(String[] args) {
        Map<String, Object> datas = new HashMap<String, Object>();
        datas.put("总金额", 10000.0);
        datas.put("可用金额", 80000.0);
        datas.put("冻结金额", 2000.0);
        datas.put("可提现金额", 8000.0);
        Map<String,Object> r01= countAccountInfoByUserId01(datas);
        System.out.println("java7代码结果:"+JSON.toJSONString(r01));
        System.out.println("----------------等价形式-----------");
        Map<String,Object> r02= countAccountInfoByUserId02(datas);
        System.out.println("java8代码结果:"+JSON.toJSONString(r02));
    }


    /**
     * 前台报表显示需要的json 测试数据:
     * {
     "data1":10000.0,   // 用户总资产
     "data2":[
     {
      "name":"总金额",
      "y":10000.0
      },
      {
      "name":"可用金额",
      "y":8000.0
      },
      {
      "name":"冻结金额",
      "y":2000.0
      },{
      "name":"可提现金额",
      "y":8000.0
      }
      ]
      }
     * Java 7 实现用户账户资产信息统计功能  结果通过map返回
     */
    public static Map<String, Object> countAccountInfoByUserId01(Map<String, Object> datas) {
        Map<String, Object> result = new HashMap<String, Object>();
        List<Map<String, Object>> data1 = new ArrayList<Map<String, Object>>();
        for (Map.Entry<String, Object> entry : datas.entrySet()) {
            if (entry.getKey().equals("总金额")) {
                result.put("data1", entry.getValue());
                continue;
            }
            Map<String, Object> temp = new HashMap<String, Object>();
            temp.put("name", entry.getKey());
            temp.put("y", entry.getValue());
            data1.add(temp);
        }
        result.put("data2", data1);
        return result;
    }


    public static Map<String, Object> countAccountInfoByUserId02(Map<String, Object> datas) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("data1",datas.entrySet().stream().filter((e) -> e.getKey().equals("总金额"))
                .findFirst().get().getValue());
        result.put("data2",datas.entrySet().stream().filter((e)->!(e.getKey().equals("总金额")))
                .map((e) -> new CountDto(e.getKey(), e.getValue())).collect(Collectors.toList()));
        return result;
    }


}
