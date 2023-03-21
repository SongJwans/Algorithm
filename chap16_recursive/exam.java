package chap16_recursive;

public class exam {

    public int examFunc(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        } else {
            return examFunc(n - 1) + examFunc(n - 2) + examFunc(n - 3);
        }
    }

    public static void main(String[] args) {
        exam e = new exam();
        System.out.println(e.examFunc(5));
    }
}
