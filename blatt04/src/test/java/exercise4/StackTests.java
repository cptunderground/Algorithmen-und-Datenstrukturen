package exercise4;

import org.junit.Assert;
import org.junit.Test;

public class StackTests {

  @Test
  public void testEmptyStackHasSizeZero() {
    Stack<String> stack = new Stack<String>();
    Assert.assertTrue(stack.size() == 0);
  }

  @Test
  public void testPushPopLeadsToEmptyStack() {
    Stack<String> stack = new Stack<String>();
    stack.push("e");
    stack.pop();
    Assert.assertTrue(stack.isEmpty());
  }

  @Test
  public void testPushIncreasesSizeByOne() {
    Stack<String> s = new Stack<String>();
    int oldSize = s.size();
    s.push("a");
    int newSize = s.size();
    Assert.assertEquals(oldSize + 1, newSize);
  }

  @Test
  public void testPopDecreasesSizeByOne() {
    Stack<String> s = new Stack<String>();
    s.push("a");
    int oldSize = s.size();
    s.pop();
    int newSize = s.size();
    Assert.assertEquals(oldSize - 1, newSize);
  }

  @Test
  public void testPopTakesAwayTopElement() {
    Stack<String> stack = new Stack<String>();
    stack.push("first");
    stack.push("second");
    Assert.assertEquals("second", stack.top());
    String poppedElement = stack.pop();
    Assert.assertEquals("second", poppedElement);
    Assert.assertEquals("first", stack.top());
  }
}
