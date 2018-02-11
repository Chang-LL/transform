package com.expr.empty;
import java.util.*;

public class ArgsTokenMgr {
    private int index;
    String input;

    public ArgsTokenMgr(String[]args)
    {
        if(args.length>0)
            input=args[0];
        else
            input = "";
        index = 0;
        System.out.println("input = "+input);

    }
    public char getNextToken()
    {
        if(index<input.length())
            return input.charAt(index++);
        else
            return '#';
    }

}
