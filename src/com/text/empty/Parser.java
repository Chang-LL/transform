package com.text.empty;

public class Parser implements Constants {
    private TokenMgr tm;
    private Token currentToken;
    private Token previousToken;
    public Parser(TokenMgr tm)
    {
        this.tm=tm;
        currentToken = tm.getNextToken();
        previousToken=null;

    }
    public void parse()
    {
        S();//进行语法分析
        if(currentToken.kind!=EOF)//检测垃圾输入
            throw genEx("Expecting <EOF>");
    }

    private void S() {
        int p;
        p=expr();
        System.out.println(p);
    }

    private int expr() {
        int p,q;
        Token t;
        switch (currentToken.kind)
        {
            case PLUS:
                consume(PLUS);
                p=expr();
                q=expr();
                return p+q;
            case MINUS:
                consume(MINUS);
                p=expr();
                q=expr();
                return p-q;
            case TIMES:
                consume(TIMES);
                p=expr();
                q=expr();
                return p*q;
            case DIVIDE:
                consume(DIVIDE);
                p=expr();
                q=expr();
                return p/q;
            case UNSIGNED:
                t=currentToken;          //存储到t
                consume(UNSIGNED);       //消耗单词符号
                p= Integer.parseInt(t.image);//现在使用t
                return p;
            default:
                throw genEx("Expecting operator or" +
                        tokenImage[UNSIGNED]);
        }
    }

    private RuntimeException genEx(String errorMessage) {
        return new RuntimeException("Encountered \"" +
                currentToken.image+"\" on line " +
                currentToken.beginLine+" column " +
                currentToken.beginColumn+
                System.getProperty("line.separator")
            +errorMessage);
    }

    //前移currentToken到下一个符号
    private void advance()
    {
        previousToken=currentToken;
        //如果下一个单词符号在单词符号列表上 前移到该单词符号
        if(currentToken.next!=null)
            currentToken= currentToken.next;
        //否则 从单词符号管理器获取下一个单词符号
        //存放到单词符号列表上
        else
            currentToken=currentToken.next
                    =tm.getNextToken();
    }
    //getToken(i) 返回第i个单词符号 不在单词符号流中前移
    //getToken(0) 返回previousToken
    //getToken(1) 返回currentToken
    //getToken(2) 返回下一个单词符号 等等
    //
    private Token getToken(int i)
    {
        if(i<=0)
            return previousToken;
        Token t=currentToken;
        for(int j=1;j<i;j++)
        {
            if(t.next!=null)
                t=t.next;
            //否则 从单词符号管理器获取下一个单词符号
            //存放到单词符号列表上
            else
                t=t.next=tm.getNextToken();
        }
        return t;

    }

    //如果当前单词符号的类别匹配期望的类别
    //那么前移到下一个单词字符
    //否则抛出一个例外
    //
    private void consume(int expected)
    {
        if(currentToken.kind==expected)
            advance();
        else
            throw genEx("Expecting "+tokenImage[expected]);
    }
}
