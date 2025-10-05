// 8.2_task1

public class PalindromeChecker {
    public boolean isPalindrome(String str) {
        if (str == null) return false;   // null 不是回文

        // 1️⃣ 去掉非字母数字字符（不是 A–Z、a–z 或 0–9 的任何字符，^表示取反：不是）
        String clean = str.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        // 2️⃣ 反转字符串，StringBuilder 是 Java 中一个可变字符串类（mutable string class）
        String reversed = new StringBuilder(clean).reverse().toString();

        // 3️⃣ 比较正反是否相同
        return clean.equals(reversed);
    }
}
