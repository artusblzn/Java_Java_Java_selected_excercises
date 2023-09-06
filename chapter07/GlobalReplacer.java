/**
 * EXERCISE 7.16 Challenge: The global replace function is a string-processing algorithm found in
 * every word processor. Write a method that takes three String arguments: a document, a target
 * string, and a replacement string. The method should replace every occurrence of the target string
 * in the document with the re- placement string. For example, if the document is “To be or not to
 * be, that is the question,” and the target string is “be,”, and the replacement string is “see,”
 * the result should be, “To see or not to see, that is the question.”
 */

package chapter07;

public class GlobalReplacer {
    public static String globalReplace(String document, String target, String replacement) {
        StringBuffer buffer = new StringBuffer();
        int afterKeywordPtr = 0;
        int keywordPtr = document.indexOf(target);

        while (keywordPtr != -1) {
            buffer.append(document.substring(afterKeywordPtr, keywordPtr));
            buffer.append(replacement);
            afterKeywordPtr = keywordPtr + target.length();
            keywordPtr = document.indexOf(target, afterKeywordPtr);
        }

        buffer.append(document.substring(afterKeywordPtr));

        return buffer.toString();
    }
}
