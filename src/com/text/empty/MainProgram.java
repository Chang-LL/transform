package com.text.empty;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MainProgram {
    public static void main(String[]args)throws IOException
    {
        if(args.length!=1)
        {
            System.err.println("Wrong number cmd line args");
            System.exit(1);
        }
        //创建构成编译器的对象
        Scanner inFile=new Scanner(new File(args[0]));
        TokenMgr tm=new TokenMgr(inFile);
    }
}
