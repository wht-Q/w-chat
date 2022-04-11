package com.example.chat.sdk;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
public class Instructions {
    private static int counter=0;
    public static int getCounter() {
        return Instructions.counter;
    }
    public static  void setCounter(int counter) {
        Instructions.counter=counter;
    }
    public static  void setCounterPlus() {
        Instructions.counter--;
    }
    public static void main(String[] args) {
        List<String> instructions = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean flag =true;
        System.out.println("请输入您的指令集----注：输入false会停止输入，且最多能输入100条");
        int count =0;
        while (flag) {
            count++;
            String nextLine = scanner.nextLine();
            if ("false".equals(nextLine) || count >= 100) {
                flag = false;
            }
            //System.out.println(nextLine.matches("\\s*mov\\s[a-z]{1,10}\\s((-?[1-9][0-9]{0,3})|([1-9][0-9]{0,3}))\\s*"));
            if (      nextLine.matches("\\s*mov\\s[a-z]{1,10}\\s((-?[1-9][0-9]{0,4})|([1-9][0-9]{0,4}))\\s*")
                    || nextLine.matches("\\s*jnz\\s[a-z]{1,10}\\s((-?[1-9][0-9]{0,4})|([1-9][0-9]{0,4}))\\s*")
                    || nextLine.matches("\\s*inc\\s[a-z]{1,10}\\s*")
                    || nextLine.matches("\\s*dec\\s[a-z]{1,10}\\s*")
            ){
                instructions.add(nextLine);
                System.out.println(nextLine);
            }else if("false".equals(nextLine)){
                System.out.println("输入完成");
            }else {
                System.out.println("您输入的指令："+nextLine+"\t格式错误请重新输出");
            }
        }
        //开始计算
        ConcurrentHashMap<String,Integer> calculation = calculation(instructions);
        System.out.println(calculation.toString());
    }
    public static ConcurrentHashMap calculation(List<String> instructions){
        ConcurrentHashMap<String,Integer> mov = new ConcurrentHashMap<>();
        boolean flag =true;
        setCounter(instructions.size());
        while (flag){
            String instruction = instructions.get(Math.abs(instructions.size()-getCounter()));
            if ((instruction.indexOf("mov"))>-1){
                String[] split = instruction.trim().split(" ");
                mov.put(split[1],Integer.valueOf(split[2]));
                setCounterPlus();
            }else if ((instruction.indexOf("inc"))>-1){
                String[] split = instruction.trim().split(" ");
                Integer integer = mov.get(split[1]);
                mov.put(split[1],integer+1);
                setCounterPlus();
            } else if ((instruction.indexOf("dec"))>-1) {
                String[] split = instruction.trim().split(" ");
                Integer integer = mov.get(split[1]);
                mov.put(split[1],integer-1);
                setCounterPlus();
            }else if((instruction.indexOf("jnz"))>-1){
                String[] split = instruction.trim().split(" ");
                Integer integer = mov.get(split[1]);
                if (integer!=0){
                    int counter = getCounter();
                    setCounter(counter - Integer.valueOf(split[2]).intValue());
                }else {
                    setCounterPlus();
                }
            }
            if (getCounter()<=0){
                flag=false;
            }
        }
        return mov;
    }
}
