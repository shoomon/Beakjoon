import java.io.*;
import java.util.StringTokenizer;

public class Code10828 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String s;
        int[] stack = new int[10000];
        int top = -1, N;
        try{
            N = Integer.parseInt(br.readLine());

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                s = st.nextToken();

//                System.out.println("Command" + i + ": " + s);
                if(s.equals("push")){
                    top = push(stack, top, Integer.parseInt(st.nextToken()));
                }else if(s.equals("pop")){
                    top = pop(stack, top);
                }else if(s.equals("size")){
                    size(top);
                }else if(s.equals("empty")){
                    empty(top);
                }else if(s.equals("top")){
                    top(stack, top);
                }
//                System.out.println(", Current top: " + top);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                br.close();
                bw.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    static int push(int[] stack, int top, int x){
        if(top+1 != stack.length){
            stack[top+1] = x;
        }
        return top+1;
    }

    static int pop(int[] stack, int top){
        if(top == -1){
            System.out.println(-1);
            return -1;
        }else {
            System.out.println(stack[top]);
        }
        return top-1;
    }
    static void size(int top){
        System.out.println(top+1);
    }
    static void empty(int top){
        if(top == -1){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
    static void top(int[] stack, int top){
        if(top == -1){
            System.out.println(-1);
        }else{
            System.out.println(stack[top]);
        }
    }
}
