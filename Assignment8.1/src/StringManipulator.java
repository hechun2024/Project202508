/** 8.1_2 design a StringManipulator class
 * StringManipulator.java
 *
 * This class provides various string manipulation methods such as concatenation,
 * finding length, converting case, and checking for substrings.
 */
public class StringManipulator {

    // 拼接两个字符串
    public String concatenate(String str1, String str2) {
        return str1 + str2;
    }

    // 获取字符串长度
    public int findLength(String str) {
        return str.length();
    }

    // 转换为大写
    public String convertToUpperCase(String str) {
        return str.toUpperCase();
    }

    // 转换为小写
    public String convertToLowerCase(String str) {
        return str.toLowerCase();
    }

    // 判断是否包含子串
    public boolean containsSubstring(String str, String subStr) {
        return str.contains(subStr);
    }
}
