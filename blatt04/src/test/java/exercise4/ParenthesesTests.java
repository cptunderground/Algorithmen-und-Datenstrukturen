package exercise4;

import org.junit.Assert;
import org.junit.Test;

public class ParenthesesTests {

  @Test
  public void testEmptyString() {
    System.out.println(Parentheses.checkParantheses(""));
    Assert.assertTrue(Parentheses.checkParantheses(""));
  }

  @Test
  public void testOpenClosingParentheses() {
    Assert.assertTrue(Parentheses.checkParantheses("()"));
    Assert.assertTrue(Parentheses.checkParantheses("[]"));
    Assert.assertTrue(Parentheses.checkParantheses("{}"));
  }

  @Test
  public void testComplexExpression() {
    Assert.assertTrue(Parentheses.checkParantheses("[()]{}{[()()]()}"));
  }

  @Test
  public void testWrongClosing() {
    Assert.assertFalse(Parentheses.checkParantheses("[}"));
  }

  @Test
  public void testMissingClosing() {
    Assert.assertFalse(Parentheses.checkParantheses("([]"));
    Assert.assertFalse(Parentheses.checkParantheses("["));
    Assert.assertFalse(Parentheses.checkParantheses("[((())"));
  }

  @Test
  public void testMissingOpening() {
    Assert.assertEquals(Parentheses.checkParantheses("[]))"), false);
    Assert.assertEquals(Parentheses.checkParantheses("}"), false);
  }
}
