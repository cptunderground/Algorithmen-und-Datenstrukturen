package exercise12;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class TrieSTTests extends TestCase {


    String[] keys = {"the", "sea", "by", "she", "seashells", "sells"};
    int[] values = {1, 2, 3, 4, 5, 6};

    public TrieST setupTrie() {
        TrieST trie = new TrieST();

        for (int i = 0; i < 6; ++i) {
            trie.put(keys[i], values[i]);
        }
        return trie;
    }

    @Test
    public void testPutGet() {

        TrieST trie = setupTrie();

        for (int i = 0; i < 6; ++i) {
            Assert.assertEquals(values[i], trie.get(keys[i]));
        }
    }


    @Test
    public void testFindMinimalKeyWithPrefix() {
        TrieST trie = setupTrie();

        Assert.assertEquals("by", trie.findMinimalKeyWithPrefix(""));

        Assert.assertEquals("by", trie.findMinimalKeyWithPrefix("b"));

        Assert.assertEquals("by", trie.findMinimalKeyWithPrefix("by"));

        Assert.assertEquals("sea", trie.findMinimalKeyWithPrefix("s"));

        Assert.assertEquals("she", trie.findMinimalKeyWithPrefix("sh"));

        Assert.assertEquals("seashells", trie.findMinimalKeyWithPrefix("seash"));

        Assert.assertEquals(null, trie.findMinimalKeyWithPrefix("prefixdoesnotexist"));
    }
}
