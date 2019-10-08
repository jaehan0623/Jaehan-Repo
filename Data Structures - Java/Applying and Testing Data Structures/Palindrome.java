
public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> result = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            result.addLast(word.charAt(i));
        }
        return result;
    }
    public boolean isPalindrome(String word) {
        if (word == null) {
            return false;
        }
        Deque<Character> charList = wordToDeque(word);
        if (charList.size() < 2) {
            return true;
        } else if (charList.removeFirst() != charList.removeLast()) {
            return false;
        } else {
            return isPalindrome(dequeToWord(charList));
        }
    }
    private String dequeToWord(Deque<Character> deque) {
        String answer = "";
        int size = deque.size();
        for (int i = 0; i < size; i++) {
            answer += deque.removeFirst();
        }
        return answer;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word == null) {
            return false;
        }
        Deque<Character> charList = wordToDeque(word);
        if (charList.size() < 2) {
            return true;
        } else if (!cc.equalChars(charList.removeFirst(), charList.removeLast())) {
            return false;
        } else {
            return isPalindrome(dequeToWord(charList), cc);
        }
    }
}
