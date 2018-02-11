package com.expr.empty;
/*
* void S():{}                                    选择集合
* {
*   "b"C()"d"                                    {"b"}
* }
*
* void C():{}
* {
*   "c" {System.out.println('c');}C()            {"c"}
*   |
*   {}                                           {"d"}
* }
*
*
*
*
*
*
*/


import com.expr.empty.ArgsTokenMgr;
import com.expr.empty.Parser;
import com.expr.empty.ParserExpr;

public class Main {
    public static void main(String[]args)
    {
        String []a={"+/bcd"};
        ArgsTokenMgr tm=new ArgsTokenMgr(a);

        Parser parser=new Parser(tm);

        ParserExpr parser1=new ParserExpr(tm);

        try {
            //parser.parse();
            parser1.parse();
        }
        catch (RuntimeException e)
        {
            System.err.println();
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
