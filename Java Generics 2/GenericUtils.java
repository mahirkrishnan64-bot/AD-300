// GenericUtils.java
import jdk.jshell.SourceCodeAnalysis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GenericUtils {

    public static <T extends Comparable<? super T>> void sort(ArrayList<T> list) {
        Collections.sort(list);
    }

    public static void printCollection(Collection<?> collection) {
        for (Object item : collection) {
            System.out.println(item);
        }
    }

    public static double sumOfNumberList(List<? extends Number> numbers) {
        double sum = 0.0;
        for (Number n : numbers) {
            sum += n.doubleValue();
        }
        return sum;
    }
}