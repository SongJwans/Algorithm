package chap18_AdvancedSort;

import java.util.ArrayList;

public class MergeSort {



    public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> mergedList = new ArrayList<>();
        int leftPoint = 0;
        int rightPoint = 0;

        //CASE1: left/right 둘 다 있을 때
        while ((leftList.size() > leftPoint) && (rightList.size() > rightPoint)) {
            if (leftList.get(leftPoint) > rightList.get(rightPoint)) {
                mergedList.add(rightList.get(rightPoint));
                rightPoint+=1;
            } else {
                mergedList.add(leftList.get(leftPoint));
                leftPoint+=1;
            }
        }
        //CASE2: right 데이터가 없을 때
        while (leftList.size() > leftPoint) {
            mergedList.add(leftList.get(leftPoint));
            leftPoint+=1;
        }
        //CASE3: left 데이타가 없을 때
        while (rightList.size() > rightPoint) {
            mergedList.add(rightList.get(rightPoint));
            rightPoint+=1;
        }
        return mergedList;
    }
    public ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }
        int medium = dataList.size() / 2;

        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        //0부터 medium-1 인덱스 번호까지 해당 배열아이템을 서브배열에 저장
        leftArr = this.mergeSplitFunc(new ArrayList<>(dataList.subList(0, medium)));
        rightArr = this.mergeSplitFunc(new ArrayList<>(dataList.subList(medium, dataList.size())));

        return this.mergeFunc(leftArr, rightArr);

    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            testData.add((int) (Math.random() * 100));
        }
        MergeSort mergeSort = new MergeSort();
        System.out.println(mergeSort.mergeSplitFunc(testData));
    }
}
