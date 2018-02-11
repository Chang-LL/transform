package com.text.empty;

import java.util.Scanner;

public class TokenMgr implements Constants{
    private Scanner inFile;
    private char currentChar;
    private int currentColumnNumber;
    private int currentLineNumber;
    private int lineLength;
    private String inputLine;//一行输入
    private Token token;//一个单词符号
    private StringBuffer buffer;//单词符号映像
    public TokenMgr(Scanner inFile) {
        this.inFile = inFile;
        currentChar='\n';//触发读入
        currentColumnNumber = 0;
        currentLineNumber = 0;
        buffer=new StringBuffer();
    }

    public Token getNextToken() {
        //跳过空白
        while (Character.isWhitespace(currentChar))
            getNextChar();

        //生成返回给语法分析器的单词符号
        token=new Token();
        token.next=null;

        //存放单词符号开始位置
        token.beginLine=currentLineNumber;
        token.beginColumn =currentColumnNumber;

        //检测EOF
        if(currentChar==EOF)
        {
            token.image ="<EOF>";
            token.endLine =currentLineNumber;
            token.endColumn =currentColumnNumber;
            token.kind=EOF;
        }
        else //检测unsigned int
        if(Character.isDigit(currentChar))
        {
            buffer.setLength(0);//置长度为0
            do {
                //处理unsigned int
                //连接currentChar到buffer
                buffer.append(currentChar);
                //存储单词符号结束位置
                //调用getNextChar之前必须做的准备
                token.endLine =currentLineNumber;
                token.endColumn =currentColumnNumber;
                getNextChar();
            }while (Character.isDigit(currentChar));
            token.image = buffer.toString();
            token.kind =UNSIGNED;
        }
        else//处理单字符单词符号
        {
            switch (currentChar)
            {
                case '+':
                    token.kind =PLUS;
                    break;
                case '-':
                    token.kind =MINUS;
                    break;
                case '*':
                    token.kind =TIMES;
                    break;
                case '/':
                    token.kind =DIVIDE;
                    break;
                default:
                    token.kind =ERROR;
                    break;
            }
            //存储currentChar为token.image中的字符串
            token.image= Character.toString(currentChar);
            //存储单词符号结束位置
            token.endLine=currentLineNumber;
            token.endColumn=currentColumnNumber;
            getNextChar();//读取下一个符号
        }

        //单词符号的踪迹作为注释出现在输出文件
        System.out.printf(
                "kd=%3d bL=%3d bC=%3d eL=%3d eC=%3d im=%s%n",
                token.kind, token.beginLine, token.beginColumn, token.endLine,
                token.endColumn, token.image
                );
        return token;
    }

    private void getNextChar() {
        if(currentChar==EOF)
            return;
        if(currentChar=='\n')       //换行
        {
            if(inFile.hasNextLine())//有剩余行
            {
                inputLine = inFile.nextLine();//获取下一行
                inputLine=inputLine+"\n";//标记行结束
                currentColumnNumber = 0;
                currentLineNumber++;
            }
            else
            {
                currentChar = EOF;
                return;
            }
        }
        //从inputLine获取下一个字符
        currentChar =
                inputLine.charAt(currentColumnNumber++);
    }
}
