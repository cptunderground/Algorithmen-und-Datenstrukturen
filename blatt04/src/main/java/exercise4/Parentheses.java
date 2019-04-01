package exercise4;

import java.util.Stack;


public class Parentheses {

  public static Stack<Character> gayStack = new Stack<>();
  public static char[] gayArray;

  static boolean checkParantheses(String s) {
    //Mithilfe des Internets, da Fragestellung unverständlich.
    gayArray = new char[s.length()];
    for (int i = 0; i < s.length(); i++) {
      gayArray[i] = s.charAt(i);
    }

    for (int i = 0; i < gayArray.length; i++) {
      if (gayArray[i] == '{' || gayArray[i] == '(' || gayArray[i] == '[') {
        gayStack.push(gayArray[i]);
      }
      if (gayArray[i] == '}' || gayArray[i] == ')' || gayArray[i] == ']') {
        if (gayStack.isEmpty()) {
          return false;
        } else if (!matching(gayStack.pop(), gayArray[i])) {
          return false;
        }
      }
    }

    if (gayStack.isEmpty()) {
      return true;
    } else {
      return false;
    }

    //throw new NotImplementedException("checkParantheses");

  }

  static boolean matching(char gayChar, char ultraGayChar) {
    if (gayChar == '(' && ultraGayChar == ')') {
      return true;
    } else if (gayChar == '{' && ultraGayChar == '}') {
      return true;
    } else if (gayChar == '[' && ultraGayChar == ']') {
      return true;
    } else {
      return false;
    }
  }

}

