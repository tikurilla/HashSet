import java.util.*;

public class CustomHashSetTest {

    public static void main(final String... args) throws Exception {
        final Set<String> s = new HashSet<>();

        s.add("1");
        s.add("1");
        assertEquals("set size does not return 1 after adding same element twice", 1, s.size());
        assertTrue("set contains do not return true for the element that was added twice", s.contains("1"));

        s.remove("1");
        assertEquals("set size does not return 0 when all elements are removed from the set", 0, s.size());
        assertTrue("set isEmpty do not return true when the set size is 0", s.isEmpty());

        s.add("2");
        s.add("3");
        assertEquals("set size is not returning the correct size", 2, s.size());
        assertTrue("set contains is not working correctly", s.contains("2"));
        assertTrue("set contains is not working correctly", s.contains("3"));

        final Set<String> s2 = new HashSet<>();
        s2.add("1");

        s.addAll(s2);
        assertEquals("addAll is not working correctly", 3, s.size());

        final Set<String> s3 = new HashSet<>();
        s3.add("4");
        s3.add("5");
        s3.add("6");

        s.addAll(s3);
        assertEquals("addAll is not working correctly", 6, s.size());

        assertTrue("addAll is not working correctly", s.contains("1"));

        // contaisnAll testing
        final Set<String> s4 = new HashSet<>();
        s4.add("1");
        s4.add("2");
        s4.add("3");
        s4.add("4");
        s4.add("5");

        final Set<String> s5 = new HashSet<>();
        s5.add("1");
        s5.add("5");

        assertTrue("containsAll is not working correctly", s4.containsAll(s5));

        //
        final Collection<String> s6 = new ArrayList<>();
        s6.add("1");
        s6.add("1");
        s6.add("2");

        assertTrue("containsAll is not working correctly", s4.containsAll(s6));

        //
        final Collection<String> s7 = new ArrayList<>();
        s7.add("10");
        s7.add("1");
        s7.add("1");
        s7.add("2");

        assertFalse("containsAll is not working correctly", s4.containsAll(s7));

        final Collection<String> s8 = new ArrayList<>();
        assertFalse("containsAll is not working correctly", s4.containsAll(s8));
    }

    private static <T>void assertEquals(final String msg, final T expectedVal, final T actualVal) {
        if (!expectedVal.equals(actualVal)) {
            throw new RuntimeException(msg);
        }
    }

    private static void assertTrue(final String msg, final Boolean value) {
        assertEquals(msg, true, value);
    }

    private static void assertFalse(final String msg, final Boolean value) {
        assertEquals(msg, false, value);
    }

}