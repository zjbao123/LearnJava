package Java常用类的使用;

import java.lang.String;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

//1.使用ArrayList和HashMap这两个容器存储300万个Student对象，这300万个Student对象中学号分别为s1,s2,s3直至s3000000，学生名字也可以为学号或者为空字符串或者随机字符串均可。要求：
//a)在ArrayList这个容器中查找学号名字为s1, s100, s5000, s50000, s3000000学生的信息，输出该信息，并分别给出查找时间。
//b)在HashMap这个容器中查找学号名字为s1,s100,s5000,s50000, s3000000学生的信息，输出该信息，并分别给出查找时间；
//c)比较上述结果并讨论为什么会是这样的结果？
public class Solution {
    public static void main(String[] args) {
        ArrayList<Student> students1 = new ArrayList<Student>(3000000);
        HashMap<Integer, Student> students2 = new HashMap<Integer, Student>();

        for (int i = 0; i <= 3000001; i++) {
            Student a = new Student("s" + i, i);
            students1.add(a);
            students2.put(i, a);
        }
        long t1 = Calendar.getInstance().getTimeInMillis();
        System.out.println(students1.get(1).getsName());
        System.out.println(students1.get(100).getsName());
        System.out.println(students1.get(5000).getsName());
        System.out.println(students1.get(50000).getsName());
        System.out.println(students1.get(3000000).getsName());
        long t2 = Calendar.getInstance().getTimeInMillis();
        System.out.println(t2 - t1);
        long t3 = Calendar.getInstance().getTimeInMillis();
        System.out.println(students2.get(1).getsName());
        System.out.println(students2.get(100).getsName());
        System.out.println(students2.get(5000).getsName());
        System.out.println(students2.get(50000).getsName());
        System.out.println(students2.get(3000000).getsName());
        long t4 = Calendar.getInstance().getTimeInMillis();
        System.out.println(t4 - t3);

    }
}

class Student {
    private String sName;
    private int sNo;

    public Student(String sName, int sNo) {
        this.sName = sName;
        this.sNo = sNo;

    }

    public Student() {
    }

    public void print() {
        System.out.println("学生姓名为：" + sName + "学号为：" + sNo);
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getsNo() {
        return sNo;
    }

    public void setsNo(int sNo) {
        this.sNo = sNo;
    }
}



