package com.lotbyte.count;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lp
 * @Date 2019/3/25 17:11
 * @Version 1.0
 */
public class TestInvestInfo {
    public static void main(String[] args) {

        /**
         {
           // 六个月月份值
           "data1":
             [
             "2018-10",
             "2018-11",
             "2018-12",
             "2019-01",
             "2019-02",
             "2019-03"
             ],
           // 六个月 每个月投资金额汇总
           "data2":[800,1000,1000, 1500, 1000, 2000],
           //  六个月 每个月收益汇总
            "data3":[200,250, 258, 300, 350, 460]
         }
         */
        List<Map<String, Object>> datas = new ArrayList<Map<String, Object>>();
        Map<String, Object> m01 = new HashMap<String, Object>();
        m01.put("month", "2018-10");
        m01.put("investTotal", 800);
        m01.put("incomeTotal", 200);
        Map<String, Object> m02 = new HashMap<String, Object>();
        m02.put("month", "2018-11");
        m02.put("investTotal", 1000);
        m02.put("incomeTotal", 250);
        Map<String, Object> m03 = new HashMap<String, Object>();
        m03.put("month", "2018-12");
        m03.put("investTotal", 1000);
        m03.put("incomeTotal", 100);
        Map<String, Object> m04 = new HashMap<String, Object>();
        m04.put("month", "2019-01");
        m04.put("investTotal", 1500);
        m04.put("incomeTotal", 300);
        Map<String, Object> m05 = new HashMap<String, Object>();
        m05.put("month", "2019-02");
        m05.put("investTotal", 1000);
        m05.put("incomeTotal", 350);
        Map<String, Object> m06 = new HashMap<String, Object>();
        m06.put("month", "2019-03");
        m06.put("investTotal", 2000);
        m03.put("incomeTotal", 460);
        datas = Arrays.asList(m01, m02, m03,m04,m05,m06);
       System.out.println("java7代码结果:"+JSON.toJSONString(countInvestIncomeInfoByUserId01(datas)));
        System.out.println("----------等价形式--------");
        /* System.out.println(JSON.toJSONString(countInvestIncomeInfoByUserId02(datas)));*/
        System.out.println("java8代码结果:"+JSON.toJSONString(countInvestIncomeInfoByUserId03(datas)));
    }


    public static Map<String, Object> countInvestIncomeInfoByUserId01(List<Map<String, Object>> datas) {
        Map<String, Object> result = new HashMap<String, Object>();
        List<Object> months = new ArrayList<Object>();
        List<Object> investList = new ArrayList<Object>();
        List<Object> incomeList = new ArrayList<Object>();
        for (Map<String, Object> map : datas) {
            months.add(map.get("month"));
            investList.add(map.get("investTotal"));
            incomeList.add(map.get("incomeTotal"));
        }
        result.put("data1", months);
        result.put("data2", investList);
        result.put("data3", incomeList);
        return result;
    }

    public static Map<String, Object> countInvestIncomeInfoByUserId02(List<Map<String, Object>> datas) {
        Map<String, Object> result = new HashMap<String, Object>();
        List<Object> months = new ArrayList<Object>();
        List<Object> investList = new ArrayList<Object>();
        List<Object> incomeList = new ArrayList<Object>();
        datas.stream().forEach((m) -> {
            months.add(m.entrySet().stream().
                    filter((e) -> e.getKey().equals("month")).map((e) -> e.getValue()).findFirst().get());
            investList.add(m.entrySet().stream().
                    filter((e) -> e.getKey().equals("investTotal")).map((e) -> e.getValue()).findFirst().get());
            incomeList.add(m.entrySet().stream().
                    filter((e) -> e.getKey().equals("incomeTotal")).map((e) -> e.getValue()).findFirst().get());
        });
        result.put("data1", months);
        result.put("data2", investList);
        result.put("data3", incomeList);
        return result;
    }

    public static Map<String, Object> countInvestIncomeInfoByUserId03(List<Map<String, Object>> datas) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("data1",datas.stream().map((m) -> m.get("month")).collect(Collectors.toList()));
        result.put("data2",datas.stream().map((m) -> m.get("investTotal")).collect(Collectors.toList()));
        result.put("data3",datas.stream().map((m) -> m.get("month")).collect(Collectors.toList()));
        return result;
    }
}
