package com.lotbyte.def.method.inte;

public interface MySuperStr {
    /**
     * 简单的字符串判空
     * @param str
     * @return
     */
    static Boolean isEmpty(String str){
        if(null == str){
            return false;
        }
        if("".equals(str.trim())){
            return false;
        }
        return true;
    }


    /**
     * 获取一个随机字符串 字母+数字
     * @param numberFlag
     * @param length
     * @return
     */
    public static String createRandom(boolean numberFlag, int length) {
        String retStr = "";
        String strTable = numberFlag ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";
        int len = strTable.length();
        boolean bDone = true;
        do {
            retStr = "";
            int count = 0;
            for (int i = 0; i < length; i++) {
                double dblR = Math.random() * len;
                int intR = (int) Math.floor(dblR);
                char c = strTable.charAt(intR);
                if (('0' <= c) && (c <= '9')) {
                    count++;
                }
                retStr += strTable.charAt(intR);
            }
            if (count >= 2) {
                bDone = false;
            }
        } while (bDone);
        return retStr;
    }


}
