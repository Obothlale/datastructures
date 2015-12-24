package co.za.obothlale.kganane.stack.use_singularlinkedlist;

import co.za.obothlale.kganane.exceptions.SingularLinkedListOutOfBounds;
import co.za.obothlale.kganane.stacks.use_singularlinkedlist.Stack;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Obothlale on 2015-05-30.
 *
 */
public class TestStack {

    private Stack<Integer> stack;

    @Before
    public void setup(){
        stack = new Stack<Integer>();
    }

    @Test
    public void testPush(){
        for(int i = 0; i < 5;i++){
            stack.push(i);
        }
        Assert.assertEquals("4 3 2 1 0",stack.print());
    }

    @Test
    public void testPop(){
        for(int i = 0; i < 5;i++){
            stack.push(i);
        }
        Assert.assertEquals(new Integer(4),stack.pop());
        Assert.assertEquals("3 2 1 0",stack.print());

        Assert.assertEquals(new Integer(3),stack.pop());
        Assert.assertEquals("2 1 0",stack.print());

        Assert.assertEquals(new Integer(2),stack.pop());
        Assert.assertEquals("1 0",stack.print());

        Assert.assertEquals(new Integer(1),stack.pop());
        Assert.assertEquals("0",stack.print());

        Assert.assertEquals(new Integer(0),stack.pop());
        Assert.assertEquals("",stack.print());

        Assert.assertNull(stack.pop());
    }
    @Test
    public void testPeekFrontQueue() {
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        Assert.assertEquals(new Integer(4),stack.peek());
    }

    @Test
    public void testPeekBackQueue() {
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        Assert.assertEquals(new Integer(0),stack.peekBottom());
    }

    @Test
    public void testPeekAtIndex() {
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        try {
            Assert.assertEquals(new Integer(2),stack.peekAtIndex(2));
        } catch (SingularLinkedListOutOfBounds singularLinkedListOutOfBounds) {
            singularLinkedListOutOfBounds.printStackTrace();
        }
        try {
            Assert.assertEquals(new Integer(2),stack.peekAtIndex(5));
        } catch (SingularLinkedListOutOfBounds singularLinkedListOutOfBounds) {
            Assert.assertEquals("SingularLinkedListOutOfBounds queried index(5) > current max index(4)", singularLinkedListOutOfBounds.getMessage());
        }
        try {
            Assert.assertEquals(new Integer(2),stack.peekAtIndex(-1));
        } catch (SingularLinkedListOutOfBounds singularLinkedListOutOfBounds) {
            Assert.assertEquals("SingularLinkedListOutOfBounds queried index(-1) < min index(0)",singularLinkedListOutOfBounds.getMessage());
        }
    }

    @Test
    public void testIsEmpty() {
        Assert.assertTrue(stack.isEmpty());
    }

}
