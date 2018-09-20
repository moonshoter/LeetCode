package com.moonshot.leetcode;

public class LeetCode3 {


    public static void main(String[] args) {

        System.out.println("result " + lengthOfLongestSubstring("abba"));

    }

    public static int lengthOfLongestSubstring(String s) {

        boolean[] flags = new boolean[128];
        int[] charPos = new int[128];
        int start = 0;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (flags[ch]) {
                //有重复字符 更新 起始索引
                int preCharPos = charPos[ch];
                for (int j = start; j < preCharPos; j++) {
                    flags[s.charAt(j)] = false; //
                }
                //从重复字符的下一个重新开始
                start = preCharPos + 1;

            }
            charPos[ch] = i;
            flags[ch] = true;

            if (i - start + 1 > result) {
                result = i - start + 1;
            }

        }

        return result;
    }
}
