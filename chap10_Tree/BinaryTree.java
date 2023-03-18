package chap10_Tree;

public class BinaryTree {
    Node head = null;

    public class Node {
        Node left;
        Node right;
        int value;

        public Node(int data) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public boolean insertNode(int data) {
        //CASE1: 노드가 하나도 없을 때
        if (this.head == null) {
            this.head = new Node(data);

        } else {
            //CASE2: 노드가 하나 이상 들어가 있을 때
            Node findNode = this.head;
            while (true) {
                //CASE2-1: 현재 노드의 왼쪽에 노드가 들어가야 할 때
                if (data < findNode.value) {
                    if (findNode.left != null) {
                        findNode = findNode.left;
                    } else {
                        findNode.left = new Node(data);
                        break;
                    }
                    //CASE2-2: 현재 노드의 오른쪽에 노드가 들어가야 할 때
                } else {
                    if (findNode.right != null) {
                        findNode = findNode.right;
                    } else {
                        findNode.right = new Node(data);
                        break;
                    }
                }
            }
        }
        return true;
    }

    public Node search(int data) {
        //CASE1 : 노드가 하나도 없을 때
        if (this.head == null) {
            return null;
            //CASE2: 노드가 하나 이상 있을 때
        } else {
            Node findNode = this.head;
            while (findNode != null) {
                if (findNode.value == data) {
                    return findNode;
                } else if (data < findNode.value) {
                    findNode = findNode.left;
                } else {
                    findNode = findNode.right;
                }
            }
            return null;
        }
    }

    public boolean delete(int value) {
        boolean searched = false;

        Node currParentNode = this.head;     // 부모 노드

        Node currNode = this.head; //현재 노드


        //코너 케이스 1: 노드가 leaf 노드일 때
        if (this.head == null) {
            return false;


            //코너 케이스 2: 노드가 단지 하나만 있고, 해당 노드가 삭제할 노드일 때
        } else {
            if (this.head.value == value && this.head.left == null && this.head.right == null) {
                this.head = null;
                return true;
            }
        }
        while (currNode != null) {
            if (currNode.value == value) {
                searched = true;
                break;
            } else if (value < currNode.value) {
                currParentNode = currNode;
                currNode = currNode.left;
            }
        }
        if (searched == false) {
            return false;
        }
        return false;
    }
    //currNode 에는 해당 데이터를 가지고 있는 Node ,currParentNode는 currNode의 부모 노드


    public static void main(String[] args) {
        BinaryTree myTree = new BinaryTree();
        myTree.insertNode(2);
        myTree.insertNode(3);
        myTree.insertNode(4);
        myTree.insertNode(6);


    }
}
