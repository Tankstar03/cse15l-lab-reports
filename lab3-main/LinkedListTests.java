import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class LinkedListTests {

    
    @Test
    public void testPrepend() {
        LinkedList tester = new LinkedList();
        tester.prepend(10);
        tester.prepend(5);
        assertEquals(5, tester.root.value);
    }

    @Test
    public void testAppend() {
        LinkedList tester = new LinkedList();
        tester.append(10);
        tester.append(20);
        tester.append(30);
        assertEquals(30, tester.root.next.next.value);
    }

    @Test
    public void testFirst() {
        LinkedList tester = new LinkedList();
        tester.append(10);
        tester.append(20);
        tester.append(30);
        assertEquals(10, tester.first());
    }

    @Test
    public void testLast() {
        LinkedList tester = new LinkedList();
        tester.append(10);
        tester.prepend(5);
        tester.append(20);
        tester.prepend(2);
        assertEquals(20, tester.last());
    }

    @Test
    public void testToString() {
        LinkedList tester = new LinkedList();
        tester.append(10);
        tester.prepend(5);
        tester.append(20);
        tester.prepend(2);
        assertEquals("2 5 10 20 ", tester.toString());
    }

    @Test
    public void testLength() {
        LinkedList tester = new LinkedList();
        tester.append(10);
        tester.prepend(5);
        tester.append(20);
        tester.prepend(2);
        assertEquals(4, tester.length());
    }
}