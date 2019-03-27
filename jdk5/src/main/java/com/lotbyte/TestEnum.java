package com.lotbyte;

/**
 * @author lp
 * @Date 2019/3/21 16:47
 * @Version 1.0
 */
public class TestEnum {
    public static void main(String[] args) {
        test02();
    }

    public static void test01() {
        /* ColorEntity colorEntity=new ColorEntity();
        colorEntity.setId(1);
        colorEntity.setType(1);//1代表神马？？？*/

/*        ColorEntity colorEntity = new ColorEntity();
        colorEntity.setId(1);
        // 不是每个程序员都能够做到的 大量离散的常量写在当前类中也不易于后期维护
        colorEntity.setType(ColorEntity.BLACK);*/


        // 使用枚举给颜色类型赋值
        ColorEntity colorEntity = new ColorEntity();
        colorEntity.setId(1);
        // 通过枚举执行画笔颜色值 代码清晰 简单！！！
        colorEntity.setType(ColorEnum_2.BLACK.getType());
    }

    /**
     * 颜色枚举类遍历
     */
    public static void test02(){
        for(ColorEnum_1 colorEnum:ColorEnum_1.values()){
            System.out.println(colorEnum.name() +","+ colorEnum.ordinal());
        }

        ColorEnum_1 colorEnum = ColorEnum_1.BLACK;
        switch (colorEnum){
            case RED:
                System.out.println("红色画笔");
                break;
            case BLACK:
                System.out.println("黑色画笔");
                break;
            case BLUE:
                System.out.println("蓝色画笔");
                break;
            default:
                System.out.println("默认颜色");
                break;
        }


        //compareTo(E o) 比较两个枚举类顺序 返回顺序差值
        switch (colorEnum.compareTo(ColorEnum_1.WHITE)) {
            case -1:
                System.out.println("Black 在 White 顺序前");
                break;
            case 1:
                System.out.println("Black 在 White 顺序后");
                break;
            default:
                System.out.println("Black 与 White 在同一位置");
                break;
        }

        //getDeclaringClass()   枚举类相对应class 名称
        System.out.println("getDeclaringClass(): " + colorEnum.getDeclaringClass().getName());

        //name() 和  toString()
        System.out.println("name(): " + colorEnum.name());
        System.out.println("toString(): " + colorEnum.toString());

        //ordinal()， 返回值是从 0 开始
        System.out.println("ordinal(): " + colorEnum.ordinal());

    }
}
