package com.text.empty;

public interface Constants {
    //标识单词符号的整数
    public int EOF=0;
    public int UNSIGNED=1;
    public int PLUS=2;
    public int MINUS=3;
    public int TIMES=4;
    public int DIVIDE=5;
    public int ERROR=6;

    //tokenImage为每类单词符号提供字符串映像
    String[]tokenImage=
            {
                    "<EOF>",
                    "<UNSIGNED>",
                    "\"+\"",
                    "\"-\"",
                    "\"*\"",
                    "\"/\"",
                    "<ERROR"
            };
}
