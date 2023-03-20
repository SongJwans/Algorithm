package chap13_Sort;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {
    ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        //SelectionSort는 인덱스 처음부터 가장 작은 값을 채워나가기 때문에
        //최소값을 저장할 변수 필요
        int lowest;
        for (int i = 0; i < dataList.size() - 1; i++) {
            lowest = i;
            for (int j = i + 1; j < dataList.size() - 1; j++) {
                if (dataList.get(lowest) > dataList.get(j)) {
                    lowest = j;
                }
            }
            Collections.swap(dataList, lowest, i);
        }
        return dataList;
    }
    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            testData.add((int) (Math.random() * 100));
        }
        SelectionSort s = new SelectionSort();
        System.out.println(s.sort(testData));
    }
}
