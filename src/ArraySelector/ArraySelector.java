package ArraySelector;

import java.util.Arrays;

/**
 * Defines a library of selection methods on an array of integers.
 *
 * @author   Terrence Bamberg
 * @author   Dean Hendrix
 * @version  2/1/2023
 *
 */
public final class ArraySelector {
    private static long distCount;

    /**
     * Can't instantiate this class.
     */
    private ArraySelector() { }

    /**
     * Selects the minimum value from array a. This method
     * throws IllegalArgumentException if a is null or has zero
     * length. The array a is not changed by this method.
     * @param a an array of integers
     * @return the minimum value in the array
     */
    public static int min(int[] a) {
        if (a == null || a.length <= 0) {
            throw new IllegalArgumentException("Array cannot be null and must"
                    + " contain at least 1 element.");
        }
        return Arrays.stream(a)
                .min()
                .getAsInt();
    }

    /**
     * Selects the maximum value from array a. This method
     * throws IllegalArgumentException if a is null or has zero
     * length. The array a is not changed by this method.
     * @param a an array of integers
     * @return the maximum value in the array
     */
    public static int max(int[] a) {
        if (a == null || a.length <= 0) {
            throw new IllegalArgumentException("Array cannot be null and must"
                    + " contain at least 1 element.");
        }
        return Arrays.stream(a)
                .max()
                .getAsInt();
    }

    /**
     * Selects the kth minimum value from array a. This method
     * throws IllegalArgumentException if a is null, has zero length,
     * or if there is no kth minimum value (i.e., k < 1
     * or if k > the number of distinct values in the array).
     * The array a is not changed by this method.
     * @param a an array of integers
     * @param k position to search
     * @return the kth minimum element
     */
    public static int kmin(int[] a, int k) {
        if (a == null || a.length <= 0) {
            throw new IllegalArgumentException("Array cannot be null and must contain at least"
                    + " 1 element.");
        }
        // number of distinct elements in a.
        distCount = Arrays.stream(a)
                     .distinct()
                     .count();

        if (k < 1 || k > distCount) {
            throw new IllegalArgumentException("k cannot be less than 1 or greater than"
                    + " the number of distinct elements.");
        }
        // return the kth smallest value in stream as an int.
        return Arrays.stream(a)
                .distinct()
                .sorted()
                .skip(k-1)
                .limit(1)
                .min()
                .getAsInt();
    }

    /**
     * Selects the kth maximum value from array a. This method
     * throws IllegalArgumentException if a is null, has zero length,
     * or if there is no kth maximum value (i.e., k < 1
     * or if k > the number of distinct values in the array).
     * The array a is not changed by this method.
     * @param a an array of integers
     * @param k position to search
     * @return the kth maximum element
     */
    public static int kmax(int[] a, int k) {
        if (a == null || a.length <= 0)  {
            throw new IllegalArgumentException("Array cannot be null and must contain at least"
                    + " 1 element.");
        }
        // number of distinct elements in a.
        distCount = Arrays.stream(a)
                     .distinct()
                     .count();

        if (k < 1 || k > distCount) {
            throw new IllegalArgumentException("k cannot be less than 1 or greater than"
                    + " the number of distinct elements.");
        }
        // return the kth largest value in stream as an int.
        return Arrays.stream(a)
                .distinct()
                .sorted()
                .skip(distCount-k)
                .limit(1)
                .min()
                .getAsInt();
    }

    /**
     * Returns an array containing all the values in a in the
     * range [low..high]; that is, all the values that are greater
     * than or equal to low and less than or equal to high,
     * including duplicate values. The length of the returned array
     * is the same as the number of values in the range [low..high].
     * If there are no qualifying values, this method returns a
     * zero-length array. Note that low and high do not have
     * to be actual values in a. This method throws an
     * IllegalArgumentException if a is null or has zero length.
     * The array a is not changed by this method.
     * @param a an array of integers
     * @param low low range value
     * @param high high range value
     * @return an array of values in the range
     */
    public static int[] range(int[] a, int low, int high) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("Array cannot be null and must"
                    + " contain at least 1 element.");
        }
        // count of values in a filtered stream of a such that all elements are in range.
        // if 0, return an empty array.
        long rangeCount = Arrays.stream(a)
                           .filter(n -> n >= low && n <= high)
                           .count();

        if(rangeCount == 0) {
            return new int[] {};
        }
        // returns the stream as an array.
        return Arrays.stream(a)
                .filter(n -> n >= low && n <= high)
                .toArray();
    }


    /**
     * Returns the smallest value in a that is greater than or equal to
     * the given key. This method throws an IllegalArgumentException if
     * a is null or has zero length, or if there is no qualifying
     * value. Note that key does not have to be an actual value in a.
     * The array a is not changed by this method.
     * @param a an array of integers
     * @param key target value
     * @return ceiling value in array
     */
    public static int ceiling(int[] a, int key) {
        if (a == null || a.length <= 0) {
            throw new IllegalArgumentException("Array cannot be null and must have"
                    + " at least 1 element in it.");
        }
        // find max value in a to ensure there is at least one qualifying value.
        int maxValue = Arrays.stream(a)
                        .max()
                        .getAsInt();

        if (key > maxValue) {
            throw new IllegalArgumentException("The key is "
                    + "greater than any value in the array.");
        }
        // returns the min value as an int from a filtered stream such that each value in
        // the stream is >= key.
        return Arrays.stream(a)
                .filter(n -> n >= key)
                .min()
                .getAsInt();
    }


    /**
     * Returns the largest value in a that is less than or equal to
     * the given key. This method throws an IllegalArgumentException if
     * a is null or has zero length, or if there is no qualifying
     * value. Note that key does not have to be an actual value in a.
     * The array a is not changed by this method.
     * @param a an array of integers
     * @param key target value
     * @return floor value in array
     */
    public static int floor(int[] a, int key) {
        if (a == null || a.length <= 0) {
            throw new IllegalArgumentException("Array cannot be null and must"
                    + " contain at least 1 element.");
        }
        // find min value in a to ensure there is at least one qualifying value.
        int minValue = Arrays.stream(a)
                        .min()
                        .getAsInt();

        if (key < minValue) {
            throw new IllegalArgumentException("The key is "
                    + "less than any value in the array.");
        }
        // returns the max value as an int from a filtered stream such that each value in
        // the stream is <= key.
        return Arrays.stream(a)
                .filter(n -> n <= key)
                .max()
                .getAsInt();
    }

    static String toString(int[] a) {
        StringBuilder s = new StringBuilder();
        s.append("[");
        try {
            for (int i : a) {
                s.append(i + ", ");
            }
            s.delete(s.length() - 2, s.length());
        }
        catch (Exception ignored) {
        }
        finally {
            s.append("]");
        }
        return s.toString();
    }
}
