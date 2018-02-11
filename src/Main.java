
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


import com.empty.ArgsTokenMgr;
import com.empty.Parser;

public class Main {
    public static void main(String[]args)
    {
        String []a={"bccd"};
        ArgsTokenMgr tm=new ArgsTokenMgr(a);

        Parser parser=new Parser(tm);

        try {
            parser.parse();
        }
        catch (RuntimeException e)
        {
            System.err.println();
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }


}
