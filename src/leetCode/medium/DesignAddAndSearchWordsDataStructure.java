package leetCode.medium;

/**
 * 211. Design Add and Search Words Data Structure
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 *
 * Implement the WordDictionary class:
 *
 * WordDictionary() Initializes the object.
 * void addWord(word) Adds word to the data structure, it can be matched later.
 * bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 *
 *
 * Example:
 *
 * Input
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * Output
 * [null,null,null,null,false,true,true,true]
 *
 * Explanation
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *
 *
 * Constraints:
 *
 * 1 <= word.length <= 25
 * word in addWord consists of lowercase English letters.
 * word in search consist of '.' or lowercase English letters.
 * There will be at most 2 dots in word for search queries.
 * At most 104 calls will be made to addWord and search.
 */
public class DesignAddAndSearchWordsDataStructure {

    class WordDictionary {

        public class Node {
            char val;
            boolean isWord;
            Node [] children;

            public Node(char val) {
                this.val = val;
                isWord = false;
                children = new Node[26];
            }
        }

        Node root;

        public WordDictionary() {
            root = new Node('\0');
        }

        public void addWord(String word) {
            Node curr = root;

            for(char c : word.toCharArray()) {
                if(curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new Node(c);
                }
                curr = curr.children[c - 'a'];
            }
            curr.isWord = true;
        }

        // TC O(m^2)
        public boolean search(String word) {
            return searchHelper(word, root, 0);
        }

        private boolean searchHelper(String word, Node curr, int index) {
            for(int i = index; i<word.length();i++) {
                char c = word.charAt(i);

                if(c == '.') {
                    for(Node temp: curr.children) {
                        if(temp != null && searchHelper(word, temp, i + 1))
                            return true;
                    }
                    return false;
                }

                if(curr.children[c - 'a'] == null)
                    return false;

                curr = curr.children[c - 'a'];
            }
            return curr.isWord;
        }
    }
}
