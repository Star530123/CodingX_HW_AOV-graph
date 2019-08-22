package course;

import java.util.ArrayList;
import java.util.Scanner;

public class course {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("��J�ҵ{�ӼƩM�׽Ҹ��|(edge):");
		int courseNumber = scanner.nextInt();
		int edgeNumber = scanner.nextInt();
		Subject[] courseList = new Subject[courseNumber + 1]; // �˱�List���Ĥ@�Ӧ�m
		System.out.println("��J�ҵ{�P�ҵ{�׭����Y:");
		for (int i = 0; i < edgeNumber; i++) {
			int front = scanner.nextInt(); // �e�����ҵ{
			int after = scanner.nextInt(); // �᭱���ҵ{
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
