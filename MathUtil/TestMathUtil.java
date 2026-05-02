public class TestMathUtil {
    public static void main(String[] args) {

        System.out.println("Normal test cases:");
        System.out.println("10 + 5 = " + MathUtils.add(10, 5));
        System.out.println("10 - 5 = " + MathUtils.subtract(10, 5));
        System.out.println("10 * 5 = " + MathUtils.multiply(10, 5));
        System.out.println("10 / 5 = " + MathUtils.divide(10, 5));

        System.out.println("\nEdge test cases:");
        System.out.println("0 + 0 = " + MathUtils.add(0, 0));
        System.out.println("5 - 10 = " + MathUtils.subtract(5, 10));
        System.out.println("-4 * 6 = " + MathUtils.multiply(-4, 6));
        System.out.println("10 / 0 = " + MathUtils.divide(10, 0));
        System.out.println("0 / 5 = " + MathUtils.divide(0, 5));
        System.out.println("0 / 0 = " + MathUtils.divide(0, 0));
    }
}