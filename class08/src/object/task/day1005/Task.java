package object.task.day1005;

import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        //作业一
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个数字：");
        int number = scanner.nextInt();

        //解法一：
//        task1(number);
//        解法二
//        task1_2(number,1);

        //作业2
        //解法1
       /* for (int i = 2; i < 1000; i++) {
            task2(i);
        }*/
        //解法2
//        for (int i = 2; i < 100; i++) {
//            System.out.print(i+"=");
//            getPrimeFactor(i);
//            System.out.println();
//        }
        
        //作业3
        //解法一
//        task3(number);

        //解法二
        task3_1(number);


    }

   /* 题目1：给一个不多于5位的正整数。要求：

    一、逆序打印出各位数字。

    二、 求它是几位数。*/

    public static void task1(int n) {
        int length = 1;
        System.out.print("这个数的逆向输出为：");
        while (n / 10 > 0) {
            length++;
            System.out.print(n % 10);
            n /= 10;
        }
        System.out.print(n);
        System.out.println(",这个数的长度为" + length);
    }

    public static void task1_2(int n, int length) {
        if (n / 10 == 0) {
            System.out.print(n + "，这个数的长度为" + length);
            return;
        }
        System.out.print(n % 10);
        task1_2(n / 10, length + 1);
    }


    /*题目描述

        题目2：将2-1000以内的所有正整数进行质因数分解。

        例如：输入90,打印出90=2*3*3*5。*/

    /*2.程序分析：对n进行分解质因数，应先找到一个----最小的质数k--，然后按下述步骤完成：
            (1)如果这个质数恰等于n，则说明分解质因数的过程已经结束，打印出即可。
            (2)如果n <> k，但n能被k整除，则应打印出k的值，并用n除以k的商,作为新的正整数你n,重复执行第一步。
            (3)如果n不能被k整除，则用k+1作为k的值,重复执行第一步。*/
    private static void task2(int n) {
        System.out.print(n + " = ");
        for (int k = 2; k <= n / 2; k++) {
            if (n % k == 0) {
                System.out.print(k + "*");
                n = n / k;   //用递归把n重新定值
                k--; //这步很重要，让for循环重新执行
            }
        }
        System.out.print(n);    //把最后一个质因数输出
        System.out.println();
    }

    private static void task2_1(int number) {
        for (int i = 2; i <= number; i++) {
            if (number == i) {
                System.out.print(i);
                return;
            }
            if (number % i == 0) {
                System.out.print(i + "*");
                task2_1(number / i);
                break;
            }
        }
    }





    /*题目描述

     题目3：从键盘输入一个整数（1~20） ，则以该数字为矩阵的大小，把1,2,3…n*n 的数字按照顺时针螺旋的形式填入其中。

     例如： 输入数字2，则程序输出：

             1 2

             4 3

     输入数字3，则程序输出：

             1 2 3

             8 9 4

             7 6 5

     输入数字4， 则程序输出：

             1  2  3  4

             12 13 14 5

             11 16 15 6

             10  9 8  7
 */
    //画图图解
    public static void task3(int num) {
        int arr[][] = new int[num][num];
        //最小行数和列数
        int minX = 0, minY = 0;
        //最大行数和列数
        int maxX = num - 1, maxY = num - 1;
        int index = 1;
        while (minX <= maxX) {
            //最小行排数
            for (int x = minY; x <= maxY; x++) {
                arr[minX][x] = index;
                index++;
            }
            minY++;
            //最大列排数
            for (int y = minY; y <= maxY; y++) {
                arr[y][maxX] = index;
                index++;
            }
            maxX--;
            //最大行排数
            for (int x = maxX; x >= minX; x--) {
                arr[maxY][x] = index;
                index++;
            }
            maxY--;
            //最小列排数
            for (int y = maxY; y >= minY; y--) {
                arr[y][minX] = index;
                index++;
            }
            minX++;
        }

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print(String.format("%4d", arr[i][j]));

            }
            System.out.println();
        }
    }

    public static void task3_1(int num) {
        int arr[][] = new int[num][num];
        //计数器
        int count = num * num;
        //方向
        int k = 1;//1向右,2向下,3向左,4向上
        int i = 0, j = 0;
        for (int index = 1; index <= count; index++) {
            if (k == 1) {
                //向右 i不变，j++
                if (j < num && arr[i][j] == 0) {
                    arr[i][j] = index;
                    j++;
                } else {
                    k = 2;
                    i++;
                    j--;
                    index--;
                }
            } else if (k == 2) {
                //向下 j不变，i++
                if (i < num && arr[i][j] == 0) {
                    arr[i][j] = index;
                    i++;
                } else {
                    k = 3;
                    i--;
                    j--;
                    index--;
                }
            } else if (k == 3) {
                //向左 i不变，j--
                if (j >= 0 && arr[i][j] == 0) {
                    arr[i][j] = index;
                    j--;
                } else {
                    k = 4;
                    i--;
                    j++;
                    index--;
                }
            } else if (k == 4) {
                //向上j不变，i--
                if (i >= 0 && arr[i][j] == 0) {
                    arr[i][j] = index;
                    i--;
                } else {
                    k = 1;
                    i++;
                    j++;
                    index--;
                }
            }
        }
        //输出矩阵
        for (int l = 0; l < num; l++) {
            for (int m = 0; m < num; m++) {
                System.out.print(String.format("%4d", arr[l][m]));

            }
            System.out.println();
        }
    }
}
