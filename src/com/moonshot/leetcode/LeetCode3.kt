package com.moonshot.leetcode

fun lengthOfLongestSubstring(s: String): Int {

    var flags = BooleanArray(128)
    var charPos = IntArray(128)
    var start = 0
    var result = 0

    for (i in s.indices) {

        var ch = s[i].toInt()
        if (flags[ch]) {
            //有重复字符 更新 起始索引
            var preCharPos = charPos[ch];
            for (j in start..preCharPos) {
                flags[s[j].toInt()] = false
            }
            //从重复字符的下一个重新开始
            start = preCharPos + 1
        }
        charPos[ch] = i
        flags[ch] = true

        if (i - start + 1 > result) {
            result = i - start + 1
        }

    }

    return result
}