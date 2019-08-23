package course;

import java.util.ArrayList;

public class Subject {
	private int number;
	private ArrayList<Subject> child;
	private ArrayList<Subject> parent;
	private boolean chosen;

	public Subject() {

	}

	public Subject(int number) {
		this.number = number;
		child = null;
		parent = null;
		chosen = false;
	}

	public boolean isChosen() {
		return chosen;
	}

	public void setChosen(boolean chosen) {
		this.chosen = chosen;
	}

	public void addChild(Subject child) {
		if (this.child == null)
			this.child = new ArrayList<Subject>();
		this.child.add(child);
	}

	public void addParent(Subject parent) {
		if (this.parent == null)
			this.parent = new ArrayList<Subject>();
		this.parent.add(parent);
	}

	public ArrayList<Subject> getChild() {
		return child;
	}

	public ArrayList<Subject> getParent() {
		return parent;
	}

	public int getCourse() {
		return number;
	}

	public boolean isCycle(Subject curSubject,int n) { // courseList第一個位置不用
//		ArrayList<Subject> start = new ArrayList<Subject>();
//		for (int i = 1; i <= courseList.length; i++) {
//			if (courseList[i].getParent() == null)
//				start.add(courseList[i]);
//		}

//		for (int i = 0; i < start.size(); i++) { // 從每個起點開始
		int[] count = new int[n]; // 計算經過幾次
//		Subject curSubject = start.get(i);
		boolean judge = countNumber(curSubject, count);
		if (judge == true)
			return true;
//		}
		return false;
	}

	public boolean countNumber(Subject curSubject, int[] count) {
//		System.out.println("current: " + curSubject.getCourse());
		ArrayList<Subject> children = curSubject.getChild();
		if (children == null) { // 沒有cycle
			return false;
		}

		int[] originalCount = new int[count.length];
		for (int i = 0; i < count.length; i++) {
			originalCount[i] = count[i];
		}
		
		int n = children.size();
//		System.out.println("children size:" + n);	
		int i = 0;
		while (i < n) {
//			System.out.println("i: " + i);
//			count[number] += 1;
			count[curSubject.getCourse()] +=1;
			if (count[curSubject.getCourse()] == 2) { // 有cycle
//				System.out.println("NONON");
				return true;
			}
			boolean judge = countNumber(children.get(i), count);
//			System.out.println("Boolean: " + judge);
			if(judge == true)
				return true;
			for (int j = 0; j < count.length; j++) {
				count[j] = originalCount[j];
			}
			i++;
		}
//		System.out.println("HI");
		return false;
	}

}
