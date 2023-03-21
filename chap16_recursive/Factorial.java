package chap16_recursive;

import java.util.ArrayList;

public class Factorial {
    public int factorialFunc(int n) {
        if (n > 1) {
            return n * factorialFunc(n - 1);
        } else {
            return 1;
        }
    }

    public int factorialFunc2(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorialFunc2(n - 1);
        }
    }

    public int factorialFunc3(int num) {
        if (num <= 1) {
            return num;
        } else {
            return num * factorialFunc3(num - 1);
        }
    }

    public int factorialFunc4(ArrayList<Integer> dataList) {
        if (dataList.size() <= 0) {
            return 0;
        }
        return dataList.get(0) + factorialFunc4(new ArrayList<Integer>(dataList.subList(1, dataList.size())));
    }

    public static void main(String[] args) {
        Factorial f = new Factorial();
        System.out.println(f.factorialFunc(5));
    }
}
