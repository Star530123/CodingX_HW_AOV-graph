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

		boolean cycleJudge = false;
		ArrayList<Subject> start = new ArrayList<Subject>();
		for (int i = 1; i < courseList.length; i++) {
			if (courseList[i].getParent() == null)
				start.add(courseList[i]);
		}

		if (start.size() == 0) {
			System.out.println("isCycle?  Yes");
			cycleJudge = true;
		}
		else {
			for (int i = 0; i < start.size(); i++) {
				Subject curSubject = start.get(i);
				if (curSubject.getParent() == null)
					cycleJudge = curSubject.isCycle(curSubject, courseList.length);
//				start.add(courseList[i]);
				if (cycleJudge == true) {
					System.out.println("isCycle?  Yes");
					break;
				}
			}
			if (cycleJudge == false)
				System.out.println("isCycle?  No");
		}

		if (cycleJudge == true)
			System.out.println("Invalid");
		else {
//		輸入修課順序
			System.out.println("輸入你的修課順序:");
			int[] courseRow = new int[courseNumber]; // 修課順序
			for (int i = 0; i < courseNumber; i++) {
				courseRow[i] = scanner.nextInt();
			}

//		判斷是否擋修
			boolean judge = true; // 判斷有沒有被擋修
			for (int i = 0; i < courseNumber; i++) {
				Subject key = courseList[courseRow[i]];
				if (key.getParent() == null) { // 沒有被擋修的課可以直接選
					key.setChosen(true);
					continue;
				}
				int parentSize = key.getParent().size();
				for (int j = 0; j < parentSize; j++) { // 看先修課有沒有都選過
					Subject parentKey = key.getParent().get(j);
					if (parentKey.isChosen() == false) {
						judge = false;
						break;
					}
					if (j == parentSize - 1)
						key.setChosen(true);
				}
				if (judge == false) {
					System.out.println("QQ");
					break;
				}
			}
			if (judge == true)
				System.out.println("XD");
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

