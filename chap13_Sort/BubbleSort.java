package chap13_Sort;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        for (int i = 0; i < dataList.size() - 1; i++) {
            //스왑이 일어난다면 true 일어나지않으면 정렬이 필요없으므로 바로 빠져 나간다.
            boolean swap = false;

            for (int j = 0; j < dataList.size() - 1 - i; j++) {
                if (dataList.get(j) > dataList.get(j + 1)) {
                    Collections.swap(dataList, j, j + 1);
                    swap = true;
                }
            }
            if (swap == false) {
                break;
            }
        }
        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            testData.add((int) (Math.random() * 100));
        }
        BubbleSort b = new BubbleSort();
        System.out.println(b.sort(testData));
    }

}
