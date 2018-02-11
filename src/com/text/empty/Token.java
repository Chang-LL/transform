package com.text.empty;

public class Token {
    //标识单词符号类别的整数
    public int kind;
    //源程序中单词符号的位置
    public int beginLine,beginColumn,endLine,endColumn;
    //组成单词符号的字符串
    public String image;
    //链接到单词符号的下一个单词符号对象
    public Token next;
}
