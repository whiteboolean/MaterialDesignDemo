package com.white.www.materialdesigndemo.paixu;

/**
 * Author: White
 * Time:2018/8/4 19:24
 * Description:插入排序算法
 * 直接插入排序
 * 二分法插入排序
 * 希尔排序
 */

public class InsertSort {

    //[9,3,2,6,10,44,83,28,5,1,0,36]


    public static void main(String[] args) {
        int a[] = {49,56,45,11,25,48,6,23,23,4,8,9,546,154,12,1,0,2,-1};
        //直接插入

        for (int i =1;i<a.length;i++){
            int temp = a[i];//新遍历的值,等待插入到前面的有序数组
            int j ;
            for (j=i-1;j>=0;j--){
                //将大于temp的数往后面移一步
                if (a[j]>temp){
                    a[j+1] = a[j];
                }else {
                    break;
                }
            }
            a[j+1] = temp;
        }

        System.out.println("排序后:");
        for (int anA : a) {
            System.out.println(anA);
        }
    }
}
