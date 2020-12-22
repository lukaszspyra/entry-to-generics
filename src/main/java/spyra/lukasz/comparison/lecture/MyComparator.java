package spyra.lukasz.comparison.lecture;

public class MyComparator {

    public static void main(String[] args) {
        System.out.println("ints " + compare(0, 1));
        System.out.println("Integers " + compare(Integer.valueOf(0), Integer.valueOf(1)));
        System.out.println(compare("Strings " + "A", "a"));

    }

    private static String compare(int a, int b) {
        if (a > b) {
            return "higher";
        }
        if (a < b) {
            return "lower";
        }
        return "equal";
    }

    private static String compare(Integer a, Integer b) {
        if (a.compareTo(b) > 0) {
            return "higher";
        }
        if (a.compareTo(b) < 0) {
            return "lower";
        }
        return "equal";
    }

    private static String compare(String a, String b) {
        if (a.compareTo(b) > 0) {
            return "higher";
        }
        if (a.compareTo(b) < 0) {
            return "lower";
        }
        return "equal";
    }

}
