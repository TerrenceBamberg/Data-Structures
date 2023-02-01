package ArraySelector;

import static org.junit.jupiter.api.Assertions.*;

class ArraySelectorTest {

    int[] a1 = {2, 8, 7, 8, 9, 9, 6, 6, 4, 3};
    int[] a2 = {Integer.MIN_VALUE, 25, 1, 7, 3};
    int[] a3 = {8, 8, 8, 8, 8};
    int[] a4 = {-2, -8, -8, -7, -3, -3, -4};
    int[] a5 = {-2, 8, 3, -3, -4, Integer.MAX_VALUE};
    int[] a6 = {};
    int[] a7 = null;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void min() {
        assertEquals(2, ArraySelector.min(a1), "Error in min(a1): ");
        assertEquals(-2147483648, ArraySelector.min(a2), "Error in min(a2): ");
        assertEquals(8, ArraySelector.min(a3), "Error in min(a3): ");
        assertEquals(-8, ArraySelector.min(a4), "Error in min(a4): ");
        assertEquals(-4, ArraySelector.min(a5), "Error in min(a5): ");
        assertThrows(IllegalArgumentException.class, () -> ArraySelector.min(a6),
                "Error in min(a6): ");
        assertThrows(IllegalArgumentException.class, () -> ArraySelector.min(a7),
                "Error in min(a7): ");
    }


    @org.junit.jupiter.api.Test
    void max() {
        assertEquals(9, ArraySelector.max(a1), "Error in max(a1): ");
        assertEquals(25, ArraySelector.max(a2), "Error in max(a2): ");
        assertEquals(8, ArraySelector.max(a3), "Error in max(a3): ");
        assertEquals(-2, ArraySelector.max(a4), "Error in max(a4): ");
        assertEquals(2147483647, ArraySelector.max(a5), "Error in max(a5): ");
        assertThrows(IllegalArgumentException.class, () -> ArraySelector.max(a6),
                "Error in max(a6): ");
        assertThrows(IllegalArgumentException.class, () -> ArraySelector.max(a7),
                "Error in max(a7): ");
    }

    @org.junit.jupiter.api.Test
    void kmin() {
        assertEquals(3, ArraySelector.kmin(a1, 2), "Error in kmin(a1): ");
        assertEquals(25, ArraySelector.kmin(a2, 5), "Error in kmin(a2): ");
        assertEquals(-4, ArraySelector.kmin(a4, 3), "Error in kmin(a4): ");
        assertEquals(2147483647, ArraySelector.kmin(a5, 6), "Error in kmin(a5): ");
        assertThrows(IllegalArgumentException.class, () -> ArraySelector.kmin(a6, 6),
                "Error in kmin(a6): ");
        assertThrows(IllegalArgumentException.class, () -> ArraySelector.kmin(a7, 7),
                "Error in kmin(a7): ");
        assertThrows(IllegalArgumentException.class, () -> ArraySelector.kmin(a3, 2),
                "Error in kmin(a3): ");
    }

    @org.junit.jupiter.api.Test
    void kmax() {
        assertEquals(8, ArraySelector.kmax(a1, 2), "Error in kmax(a1): ");
        assertEquals(1, ArraySelector.kmax(a2, 4), "Error in kmax(a2): ");
        assertEquals(-4, ArraySelector.kmax(a4, 3), "Error in kmax(a4): ");
        assertEquals(-4, ArraySelector.kmax(a5, 6), "Error in kmax(a5): ");
        assertThrows(IllegalArgumentException.class, () -> ArraySelector.kmax(a6, 6),
                "Error in kmax(a6): ");
        assertThrows(IllegalArgumentException.class, () -> ArraySelector.kmax(a7, 7),
                "Error in kmax(a7): ");
        assertThrows(IllegalArgumentException.class, () -> ArraySelector.kmax(a3, 2),
                "Error in kmax(a3): ");
    }

    @org.junit.jupiter.api.Test
    void range() {
        assertEquals("[]", ArraySelector.toString(ArraySelector.range(a1, 1, 1)),
                "Error in range(a1): ");
        assertEquals("[1, 3]", ArraySelector.toString(ArraySelector.range(a2, -2, 3)),
                "Error in range(a2): ");
        assertEquals("[8, 8, 8, 8, 8]", ArraySelector.toString(ArraySelector.range(a3, 8, 8)),
                "Error in range(a3): ");
        assertEquals("[-2, -8, -8, -7, -3, -3, -4]",
                ArraySelector.toString(ArraySelector.range(a4, Integer.MIN_VALUE, 8)),
                "Error in range(a4): ");
        assertEquals("[-2, 8, 3, -3]", ArraySelector.toString(ArraySelector.range(a5, -3, 19)),
                "Error in range(a5): ");
        assertThrows(IllegalArgumentException.class, () -> ArraySelector.range(a6, 6, 12),
                "Error in range(a6): ");
        assertThrows(IllegalArgumentException.class, () -> ArraySelector.range(a7, 2, 10),
                "Error in range(a7): ");
    }

    @org.junit.jupiter.api.Test
    void ceiling() {
        assertEquals(2, ArraySelector.ceiling(a1, 2), "Error in ceiling(a1): ");
        assertEquals(7, ArraySelector.ceiling(a2, 4), "Error in ceiling(a2): ");
        assertEquals(8, ArraySelector.ceiling(a3, 5), "Error in ceiling(a3): ");
        assertEquals(-8, ArraySelector.ceiling(a4, Integer.MIN_VALUE), "Error in ceiling(a4): ");
        assertEquals(3, ArraySelector.ceiling(a5, 0), "Error in ceiling(a5): ");
        assertThrows(IllegalArgumentException.class, () -> ArraySelector.ceiling(a6, 6),
                "Error in ceiling(a6): ");
        assertThrows(IllegalArgumentException.class, () -> ArraySelector.ceiling(a7, 7),
                "Error in ceiling(a7): ");
        assertThrows(IllegalArgumentException.class, () -> ArraySelector.ceiling(a3, 100),
                "Error in ceiling(a3): ");
    }

    @org.junit.jupiter.api.Test
    void floor() {
        assertEquals(2, ArraySelector.floor(a1, 2), "Error in floor(a1): ");
        assertEquals(3, ArraySelector.floor(a2, 4), "Error in floor(a2): ");
        assertEquals(8, ArraySelector.floor(a3, 8), "Error in floor(a3): ");
        assertEquals(-7, ArraySelector.floor(a4, -5), "Error in floor(a4): ");
        assertEquals(2147483647, ArraySelector.floor(a5, Integer.MAX_VALUE), "Error in floor(a5): ");
        assertThrows(IllegalArgumentException.class, () -> ArraySelector.floor(a6, 6),
                "Error in floor(a6): ");
        assertThrows(IllegalArgumentException.class, () -> ArraySelector.floor(a7, 7),
                "Error in floor(a7): ");
        assertThrows(IllegalArgumentException.class, () -> ArraySelector.floor(a3, 1),
                "Error in floor(a3): ");
    }
}