package leetCode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 212. Word Search II
 * Solved
 * Hard
 * Topics
 * Companies
 * Hint
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 * Example 2:
 *
 *
 * Input: board = [["a","b"],["c","d"]], words = ["abcb"]
 * Output: []
 *
 *
 * Constraints:
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] is a lowercase English letter.
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] consists of lowercase English letters.
 * All the strings of words are unique.
 */
public class WordSearchII {

    private static int COLS;
    private static int ROWS;
    private Trie currTrie;

    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for(String word : words) {
            root.addWord(word);
        }

        ROWS = board.length;
        COLS = board[0].length;
        HashSet<String> res = new HashSet<>();
        HashSet<String> visit = new HashSet<>();

        for(int i = 0;i<ROWS;i++) {
            for(int j=0;j<COLS;j++) {
                dfs(i, j, root, "", res, visit, board, root);
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(int r, int c, Trie node, String word, HashSet<String> res,
                     HashSet<String> visit, char[][] board, Trie root) {

        if (
                r < 0 ||
                        c < 0 ||
                        r == ROWS ||
                        c == COLS ||
                        !node.children.containsKey(board[r][c]) ||
                        node.children.get(board[r][c]).refs < 1 ||
                        visit.contains(r + "-" + c)
        ) {
            return;
        }

        visit.add(r+"-"+c);
        node = node.children.get(board[r][c]);
        word += board[r][c];
        if(node.isWord) {
            node.isWord = false;
            res.add(word);
            root.removeWord(word);
        }

        dfs(r+1, c, node, word, res, visit, board, root);
        dfs(r-1, c, node, word, res, visit, board, root);
        dfs(r, c+1, node, word, res, visit, board, root);
        dfs(r, c-1, node, word, res, visit, board, root);
        visit.remove(r+"-"+c);
    }

    class Trie {
        public HashMap<Character, Trie> children;
        public boolean isWord;
        public int refs = 0;

        public Trie() {
            children = new HashMap<>();
        }

        public void addWord(String word) {
            currTrie = this;
            currTrie.refs += 1;
            for(char c: word.toCharArray()) {
                if(!currTrie.children.containsKey(c))
                    currTrie.children.put(c, new Trie());
                currTrie = currTrie.children.get(c);
                currTrie.refs += 1;
            }
            currTrie.isWord = true;
        }

        public void removeWord(String word) {
            currTrie = this;
            currTrie.refs -= 1;
            for(char c : word.toCharArray()) {
                if(currTrie.children.containsKey(c)) {
                    currTrie = currTrie.children.get(c);
                    currTrie.refs -= 1;
                }
            }
        }

    }
}
