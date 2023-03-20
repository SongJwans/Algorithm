package chap13_Sort;

import java.util.ArrayList;
import java.util.Collections;

public class InsertionSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        for (int i = 0; i < dataList.size() - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (dataList.get(j) < dataList.get(j - 1)) {
                    Collections.swap(dataList, j, j - 1);
                } else {
                    break;
                }
            }
        }

        return dataList;
    }
    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            testData.add((int) (Math.random() * 100));
        }
        InsertionSort insertionSort = new InsertionSort();
        System.out.println(insertionSort.sort(testData));
    }
}
