package com.calculator;

import java.math.BigDecimal;

/**
 * Created by iamxr on 18/9/14.
 */

class ArithUtil{
    private static final int DEF_DIV_SCALE=10;

    private ArithUtil(){}
    //相加
    public static double add(double d1,double d2){
        BigDecimal b1=new BigDecimal(Double.toString(d1));
        BigDecimal b2=new BigDecimal(Double.toString(d2));
        return b1.add(b2).doubleValue();

    }
    //相减
    public static double sub(double d1,double d2){
        BigDecimal b1=new BigDecimal(Double.toString(d1));
        BigDecimal b2=new BigDecimal(Double.toString(d2));
        return b1.subtract(b2).doubleValue();

    }
    //相乘
    public static double mul(double d1,double d2){
        BigDecimal b1=new BigDecimal(Double.toString(d1));
        BigDecimal b2=new BigDecimal(Double.toString(d2));
        return b1.multiply(b2).doubleValue();

    }
    //相除
    public static double div(double d1,double d2){

        return div(d1,d2,DEF_DIV_SCALE);

    }

    public static double div(double d1,double d2,int scale){
        if(scale<0){
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1=new BigDecimal(Double.toString(d1));
        BigDecimal b2=new BigDecimal(Double.toString(d2));
        return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}

public class calculator {

    public static double Calculator(String A,String B,String HOW){
        double Result = 0;
        double a = 0;
        double b = 0;
        try{
             a = Double.parseDouble(A);
             b = Double.parseDouble(B);
        }catch(Exception e){}
        switch (HOW){
            case "÷":
                try{
                   Result = ArithUtil.div(a,b);
                }catch(Exception e){
                    Result = ArithUtil.div(a,b,10);
                }
                break;
            case "×":
                Result = ArithUtil.mul(a,b);
                break;
            case "－":
                    Result = ArithUtil.sub(a,b);
                break;
            case "+":
                Result = ArithUtil.add(a,b);
                break;
        }
        return Result;
    }

}
