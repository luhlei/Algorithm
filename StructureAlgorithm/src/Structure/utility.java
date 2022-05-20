package Structure;

import static Structure.digui.less;

public class utility {
    public static void change(Comparable[] a, int i, int j) {//按值转递
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j)
                break;
            change(a, i, j);
        }
        change(a, lo, j);
        return j;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            if (less(a[i + 1], a[i]))
                return false;
        }
        return true;
    }

    public static void recursion(Comparable a, int lo, int hi) {
        if (hi <= lo) return;
    }

    //快速排序
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
    }
}

