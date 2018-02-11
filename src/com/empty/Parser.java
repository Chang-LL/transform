package com.empty;

import java.util.*;

public class Parser
{
    private ArgsTokenMgr tm;
    private Stack<Character> stk;
    private char currentToken;

    public Parser(ArgsTokenMgr tm)
    {
        this.tm=tm;
        advance();
        stk=new Stack<Character>();
        stk.push('$');
        stk.push('$');
    }

    private void advance()
    {
        currentToken = tm.getNextToken();

    }

    private void consume(char expected)
    {
        if(currentToken == expected)
            advance();
        else
            throw new RuntimeException(
                    "Expecting \""+expected+"\""
            );
    }
    public void parse()
    {
        S();
        if(currentToken!='#')
            throw new RuntimeException(
                    "Expecting end of input"
            );
    }
    private void S()
    {
        consume('b');
        C();
        consume('d');
    }

    private void C() {
        switch (currentToken)
        {
            case 'C':
                consume('C');
                System.out.println('c');
                C();
                break;
            case 'd':
                ;
                break;
                default:
                    throw new RuntimeException(
                            "Expecting \"c\" or \"d\""
                    );
        }
    }


}
