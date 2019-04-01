package exercise12;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class SuffixArrayClientTests extends TestCase {

    @Test
    public void testEmptyStrings() {
        SuffixArrayClient client = new SuffixArrayClient();

        Assert.assertEquals("", client.getLongestCommonSubstring("", ""));
    }

    public void testNoCommonSubstring() {
        SuffixArrayClient client = new SuffixArrayClient();

        Assert.assertEquals("", client.getLongestCommonSubstring("this is a long string", "bbbbccccddddd"));
    }

    public void testLongestSubstringAtStart() {
        SuffixArrayClient client = new SuffixArrayClient();

        Assert.assertEquals("a long string ", client.getLongestCommonSubstring("a long string ", "a long string which goes on"));
    }

    public void testLongestSubstringAtEnd() {
        SuffixArrayClient client = new SuffixArrayClient();

        Assert.assertEquals("string", client.getLongestCommonSubstring("a long string", "string"));
    }


    public void testLongestSubstringInMiddle() {
        SuffixArrayClient client = new SuffixArrayClient();

        Assert.assertEquals("long string", client.getLongestCommonSubstring("a long string in a long sentence", "long string"));
    }

}
