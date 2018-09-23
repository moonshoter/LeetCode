package com.moonshot.leetcode;

public class LeetCode10 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        return match(0, 0, s, p);

    }

    public boolean match(int pos1, int pos2, String s, String p) {
        if (pos2 >= p.length()) {
            //patten使用完毕
            return pos1 >= s.length();
        }

        if (pos2 + 1 < p.length() && p.charAt(pos2 + 1) == '*') {
            //下一位是* 当前不一定需要匹配上
            for (; pos1 < s.length(); pos1++) {

                if (s.charAt(pos1) == p.charAt(pos2) || p.charAt(pos2) == '.') {
                    if (match(pos1, pos2 + 2, s, p)) {
                        return true;
                    }
                } else {
                    //当前位没匹配上
                    break;
                }
            }

            //*号匹配零个字符
            return match(pos1, pos2 + 2, s, p);

        } else if (pos1 < s.length()) {
            //下一位非* 当前需要匹配上
            if (p.charAt(pos2) == '.' || s.charAt(pos1) == p.charAt(pos2)) {
                //当前位置匹配上 匹配下一个位置
                return match(pos1 + 1, pos2 + 1, s, p);

            }
            return false;

        }

        return false;

    }
}
