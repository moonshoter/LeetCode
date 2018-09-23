package com.moonshot.leetcode

class Solution {
    fun isMatch(s: String, p: String): Boolean {
        if (s == null || p == null) {
            return false
        }

        return match(0, 0, s, p)

    }

    fun match(pos1_: Int, pos2_: Int, s: String, p: String): Boolean {
        var pos1 = pos1_
        var pos2 = pos2_
        if (pos2 >= p.length) {
            return pos1 >= s.length
        }

        if (pos2 + 1 < p.length && p[pos2 + 1] == '*') {
            //下一位是*
            while (pos1 < s.length) {

                if (s[pos1] == p[pos2] || p[pos2] == '.') {

                    if (match(pos1, pos2 + 2, s, p)) {
                        //如果后续匹配成功则成功匹配
                        return true
                    }

                } else {
                    //当前没匹配上
                    break
                }

                pos1++
            }
            //*号匹配零个字符
            return match(pos1, pos2 + 2, s, p)


        } else if (pos1 < s.length) {

            if (s[pos1] == p[pos2] || p[pos2] == '.') {
                //当前匹配上 匹配下一位
                return match(pos1 + 1, pos2 + 1, s, p)
            }

        }

        return false

    }
}