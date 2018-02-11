package com.empty;

public class Parserexpr {
    private ArgsTokenMgr tm;
    private char currentToken;

    public Parserexpr(ArgsTokenMgr tm)
    {
        this.tm=tm;
        advance();
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
        expr();
        System.out.println();
    }

    private void expr() {
        switch (currentToken)
        {
            case '+':
                consume('+');
                expr();
                expr();
                System.out.print('+');
                break;
            case '-':
                consume('-');
                expr();
                expr();
                System.out.print('-');
                break;
            case '*':
                consume('*');
                expr();
                expr();
                System.out.print('*');
                break;
            case '/':
                consume('/');
                expr();
                expr();
                System.out.print('/');
                break;
            case 'b':
                consume('b');
                System.out.print('b');
                break;
            case 'c':
                consume('c');
                System.out.print('c');
                break;
            case 'd':
                consume('d');
                System.out.print('d');
                break;
            default:
                throw new RuntimeException(
                        "Expecting prefix expression");
        }

    }
}
