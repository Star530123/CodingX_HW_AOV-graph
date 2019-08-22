package course;

import java.util.ArrayList;
import java.util.Scanner;

public class course {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("輸入課程個數和修課路徑(edge):");
		int courseNumber = scanner.nextInt();
		int edgeNumber = scanner.nextInt();
		Subject[] courseList = new Subject[courseNumber + 1]; // 捨棄List的第一個位置
		System.out.println("輸入課程與課程擋修關係:");
		for (int i = 0; i < edgeNumber; i++) {
			int front = scanner.nextInt(); // 前面的課程
			int after = scanner.nextInt(); // 後面的課程
			addCourse(courseList, front, after);
		}
	}

	public static void addCourse(Subject[] courseList, int front, int after) {
		if (courseList[front] == null) 
			courseList[front] = new Subject(front);
		if (courseList[after] == null)
			courseList[after] = new Subject(after);
		courseList[front].addChild(courseList[after]);
		courseList[after].addParent(courseList[front]);
	}
}
