package 数据结构.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BrecketChecker {
    private String input;  //储存带检测的字符串

    //构造方法，接受待检查的字符串
    public BrecketChecker(String in){
        this.input = in;
    }

    //检查分隔符匹配方法
    public void check(){
        int steLength = input.length();
        StackChar stackChar = new StackChar(steLength);

        for(int i=0;i<steLength;i++){
            char ch =input.charAt(i);  //一次获取串中的单个字符
            switch(ch){
                case '{' :
                case '[' :
                case '(' :
                    //如果为左分隔符，压入栈
                    stackChar.push(ch);
                    break;
                case '}' :
                case ']' :
                case ')' :
                    //如果为右分隔符，与栈顶元素进行匹配
                    if(!stackChar.isEmpty()){
                        char chx = stackChar.pop();

                        if((ch== '{' && chx != '}')||
                                (ch == '(' && chx != ')')||
                                (ch == '[' && chx != ']')
                        ){
                            System.out.println("匹配出错！字符："+ch+",下标："+i);
                        }
                    }else{
                        System.out.println("匹配出错！字符："+ch+",下标："+i);
                    }

                default :
                    break;
            }

        }
        if(!stackChar.isEmpty()){
            //匹配结束时如果栈中还有元素，证明右分隔符缺失
            System.out.println("有括号没有关闭！");
        }else{
            System.out.println("匹配成功！");
        }
    }


    public static void main(String[] args) {

        System.out.println("输入需要检测的字符串：");
        String str = "a{b(c[d]e)f}";
        BrecketChecker checker = new BrecketChecker(str);
        checker.check();
    }

//    public static String getString() {
//        String str = "";
//        try {
//            InputStreamReader reader = new InputStreamReader(System.in);
//            BufferedReader bReader = new BufferedReader(reader);
//            str = bReader.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return str;
//    }
}
