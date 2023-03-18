package chap11_Heap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MyHeap {
    //배열의 크기가 정해지지 않아서 ArrayList 사용

    public ArrayList<Integer> heapArray = null;

    public MyHeap(Integer data) {
        heapArray = new ArrayList<>();

        heapArray.add(null);
        heapArray.add(data);
    }

    public boolean insert(Integer data) {
        Integer inserted_idx, parent_idx;

        if (heapArray == null) {
            heapArray = new ArrayList<>();

            heapArray.add(null);
            heapArray.add(data);
            return true;
        }
        this.heapArray.add(data);
        inserted_idx = this.heapArray.size() - 1;
        // 조건이 처음 들어갈 때 와 아닐때가 있어서 move_up 메소드를 추가하여 작성
        while (this.move_up(inserted_idx)) {
            parent_idx = inserted_idx / 2;
            Collections.swap(this.heapArray, inserted_idx, parent_idx);
            inserted_idx = parent_idx;
        }
        return true;
    }

    public boolean move_up(Integer inserted_idx) {
        // 삽입된 값이 루트 노드일 경우
        if (inserted_idx <= 1) {
            return false;
        }
        Integer parant_idx = inserted_idx / 2;
        if (this.heapArray.get(inserted_idx) > this.heapArray.get(parant_idx)) {
            return true;
        } else {
            return false;
        }
    }

    public Integer pop() {
        Integer return_data, popped_idx, left_child_popped_idx, right_child_popped_idx;


        if (this.heapArray == null) {
            return null;
        } else {
            return_data = this.heapArray.get(1);
            this.heapArray.set(1, this.heapArray.get(this.heapArray.size() - 1));
            this.heapArray.remove(this.heapArray.size() - 1);
            popped_idx = 1;
            while (this.move_down(popped_idx)) {
                left_child_popped_idx = popped_idx * 2;
                right_child_popped_idx = popped_idx * 2 + 1;

                //CASE2: 왼쪽 노드만 있을 때
                if (right_child_popped_idx >= this.heapArray.size()) {
                    if (this.heapArray.get(left_child_popped_idx) > this.heapArray.get(popped_idx)) {
                        Collections.swap(heapArray, popped_idx, left_child_popped_idx);
                        popped_idx = left_child_popped_idx;
                    }
                }//CASE3: 자식 노드가 둘다 있을 때
                else {
                    if (this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)) {
                        if (this.heapArray.get(left_child_popped_idx) > this.heapArray.get(popped_idx)) {
                            Collections.swap(heapArray, popped_idx, left_child_popped_idx);
                            popped_idx = left_child_popped_idx;
                        }
                    } else {
                        if (this.heapArray.get(right_child_popped_idx) > this.heapArray.get(popped_idx)) {
                            Collections.swap(heapArray, popped_idx, right_child_popped_idx);
                            popped_idx = right_child_popped_idx;
                        }
                    }
                }
            }
            return return_data;
        }
    }

    public boolean move_down(Integer popped_idx) {
        Integer left_child_popped_idx, right_child_popped_idx;

        left_child_popped_idx = popped_idx * 2;
        right_child_popped_idx = popped_idx * 2 + 1;

        //CASE1: 자식 노드가 하나도 없을 때
        if (left_child_popped_idx >= this.heapArray.size()) {
            //swap을 할 수 없다?
            return false;
        } //CASE2: 왼쪽 노드만 있을 때
        else if (right_child_popped_idx >= this.heapArray.size()) {
            if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                return true;
            } else {
                return false;
            }

        } //CASE3: 자식 노드가 둘다 있을 때
        else {
            // 자식 노드 중 큰 값을 비교하기 위해서 큰값을 찾는다.
            if (this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)) {
                if (this.heapArray.get(left_child_popped_idx) > this.heapArray.get(popped_idx)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (this.heapArray.get(right_child_popped_idx) > this.heapArray.get(popped_idx)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public static void main(String[] args) {

        MyHeap myHeap = new MyHeap(15);

        myHeap.insert(10);
        myHeap.insert(8);
        myHeap.insert(5);
        myHeap.insert(4);
        myHeap.insert(20);
        System.out.println(myHeap.heapArray);

        myHeap.pop();
        System.out.println(myHeap.heapArray);

    }
}
