package swingdemo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class swingTest extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 * 
	 * @throws IOException
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					swingTest frame = new swingTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public swingTest() {
		JTextArea textArea = new JTextArea();

		
		String valueString;
		String[] elements;
		List<Student> students = new ArrayList<Student>();
		try {
			FileReader fr = new FileReader("Java课名单.txt");
			BufferedReader br = new BufferedReader(fr);
			while ((valueString = br.readLine()) != null) {
				elements = valueString.split("\t");
				students.add(new Student(elements[1], elements[2], elements[3],
						elements[4]));
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e);

		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		List<String> snameStrings = new ArrayList<String>();

		for (Student student : students) {
			snameStrings.add(student.getsName());
		}
		String[] s = new String[snameStrings.size()];
		s = (String[]) snameStrings.toArray(s);
		JComboBox comboBoxSname = new JComboBox(s);
		comboBoxSname.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				textArea.setText("");
				textArea.append(students.get(comboBoxSname.getSelectedIndex())
						.toString());
				
			}
		});
		
		comboBoxSname.setBorder(BorderFactory.createTitledBorder("选择一个学生："));
		contentPane.add(comboBoxSname, BorderLayout.NORTH);

		JButton btnNewButton = new JButton("保存至文件");
		contentPane.add(btnNewButton, BorderLayout.SOUTH);

		textArea.setBorder(BorderFactory.createTitledBorder("该学生信息为："));
		textArea.setBackground(Color.WHITE);
		textArea.append(students.get(comboBoxSname.getSelectedIndex())
				.toString());
		contentPane.add(textArea, BorderLayout.CENTER);
		
		
		final Object[] columnNames = {"专业", "班级", "学号","姓名", "java"};
		final Object[][] rowData = new Object[60][5];
		for (Student student : students) {
			rowData[students.indexOf(student)]=student.array();
		}
		System.out.println(rowData);
		JTable table = new JTable(rowData,columnNames);
		
		JScrollPane pane1 = new JScrollPane (table);
		table.setPreferredScrollableViewportSize(new Dimension(600, 100)); 
		contentPane.add(pane1,BorderLayout.EAST);
	}

}

class Student {
	String sClass;
	String sName;
	String sNo;
	String sCollege;

	public Student(String sCollege, String sClass, String sNo, String sName) {
		this.sClass = sClass;
		this.sCollege = sCollege;
		this.sName = sName;
		this.sNo = sNo;
	}

	public String getsName() {
		return sName;
	}

	public String getsClass() {
		return sClass;
	}
	public String getsCollege() {
		return sCollege;
	}
	public String getsNo() {
		return sNo;
	}
	@Override
	public String toString() {
		return ("专业为\t" + sCollege + "\n" + "班级为\t" + sClass + "\n" + "学号为\t"
				+ sNo + "\n" + "姓名为\t" + sName + "\n");
	}
	public Object[] array(){
		Object[] a = new Object[5];
		a[0] = getsCollege();
		a[1] = getsClass();
		a[2] = getsNo();
		a[3] = getsName();
		a[4] = null;
		return a;
		
	}
}
