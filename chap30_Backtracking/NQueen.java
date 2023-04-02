package chap30_Backtracking;

import java.util.ArrayList;

public class NQueen {
    public boolean isAvailable(ArrayList<Integer> candidate, Integer currentCol) {
        Integer currentRow = candidate.size();
        //Promissing
        for (int i = 0; i < currentRow; i++) {
            if ((candidate.get(i) == currentCol) || (Math.abs(candidate.get(i) - currentCol) == currentRow - i)) {
                return false;
            }
        }

        return true;
    }

    // 행 별로 체크를 할거이기 때문에 체크해야 할 row를  currentRow
    // 여태 체크해온 정보를  currentCandidate에 저장
    public void dfsFunc(Integer N, Integer currentRow, ArrayList<Integer> currentCandidate) {

        if (currentRow == N) {
            System.out.println(currentCandidate);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (this.isAvailable(currentCandidate, i) == true) {
                currentCandidate.add(i);
                this.dfsFunc(N, currentRow + 1, currentCandidate);
                currentCandidate.remove(currentCandidate.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        NQueen n = new NQueen();
        n.dfsFunc(4, 0, new ArrayList<Integer>());
    }
}
