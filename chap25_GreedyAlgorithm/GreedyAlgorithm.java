package chap25_GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class GreedyAlgorithm {
    // [][0] -> 무게 [][1] -> 가치
    // 무게 제한이 k인 배낭에 최대 가치를 가지도록 물건을 넣는 문제
    public void knapsackFunc(Integer[][] oList, double capacity) {
        double totalValue = 0.0;
        double fraction = 0.0;

        Arrays.sort(oList, new Comparator<>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                //무게 당 가치로 나눈다.
                return (o2[1] / o2[0]) - (o1[1] / o1[0]);
            }
        });
        for (int i = 0; i < oList.length; i++) {
            // [][0] -> 무게로 비교
            // 물건을 쪼개지 않아도 될 때
            if (capacity - (double) oList[i][0] > 0) {
                capacity -= (double) oList[i][0];
                // 무게당 가치를 토대로 가치를 추가
                totalValue += (double) oList[i][1];
                System.out.println("무게:" + oList[i][0] + ", 가치:" + oList[i][1]);
            }// 무게를 쪼개야 할 때
            else {
                fraction = capacity / (double) oList[i][0];
                totalValue += (double) oList[i][1] * fraction;
                System.out.println("무게:" + oList[i][0] + ", 가치:" + oList[i][1]
                        + ", 비율:" + fraction);
                break;
            }
        }
        System.out.println("총 담을 수 있는 가치 " + totalValue);
    }

    public static void main(String[] args) {
        GreedyAlgorithm greedyAlgorithm = new GreedyAlgorithm();
        Integer[][] objectList = {{10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5}};
        greedyAlgorithm.knapsackFunc(objectList, 30.0);
    }
}
