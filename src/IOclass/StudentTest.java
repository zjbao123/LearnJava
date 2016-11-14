package IOclass;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2016/11/14 0014.
 */


class Student implements Comparable<Student> {
    String sClass;
    String sName;
    Long sNo;
    String sCollege;

    public Student(String sCollege, String sClass, Long sNo, String sName) {
        this.sClass = sClass;
        this.sNo = sNo;
        this.sName = sName;
        this.sCollege = sCollege;
    }


    @Override
    public int compareTo(Student other) {
        if (other.sNo < this.sNo)
            return -1;
        else if (other.sNo == this.sNo)
            return 0;
        else
            return 1;


    }
}

public class StudentTest {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("src/IOclass/Java课名单.txt");
        BufferedReader bf = new BufferedReader(fr);
        String valueString = null;
        String[] elements;
        List<Student> students = new ArrayList<Student>();
        while ((valueString = bf.readLine()) != null) {
            elements = valueString.split("\t");
            students.add(new Student(elements[1], elements[2], Long.decode(elements[3].replace(" ", "")), elements[4]));
        }
        bf.close();
        Collections.sort(students);
        FileWriter fw = new FileWriter("src/IOclass/Java课名单-sort.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        for (Student student : students) {
            bw.write(student.sCollege + "\t" + student.sClass + "\t" + student.sNo + "\t" + student.sName + "\r\n");
        }
        bw.close();
        System.out.println("降序排序完成");

    }

}