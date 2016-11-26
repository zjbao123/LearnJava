package IOclass;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/11/25 0025.
 */
public class IOtest {
    public static void main(String[] args) throws IOException {
        char[] c;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入：");
        String value = sc.nextLine();
        c= value.toCharArray();
        String input= "";
        for(int i =0; i<c.length;i++){

            if(c[i]==' '){
                input =input + "\n";

            }
            else{
                input += c[i];
            }
        }
        FileWriter wf = new FileWriter("src/IOclass/word.txt");
        wf.write(input);
        wf.close();

    }
}
