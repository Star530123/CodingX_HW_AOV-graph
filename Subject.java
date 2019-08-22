package course;

import java.util.ArrayList;

public class Subject {
	private int number;
	private ArrayList<Subject> child;
	private ArrayList<Subject> parent;
	
	public Subject() {
		
	}
	public Subject(int number) {
		this.number = number;
		child = null;
		parent = null;
	}
	public void addChild(Subject child) {
		if(this.child == null)
			this.child = new ArrayList<Subject>();
		this.child.add(child);
	}
	public void addParent(Subject parent) {
		if(this.parent == null)
			this.parent = new ArrayList<Subject>();
		this.parent.add(parent);
	}
	public ArrayList<Subject> getChild() {
		return child;
	}
	
	public ArrayList<Subject> getParent(){
		return parent;
	}
	
	public int getCourse() {
		return number;
	}
	
	
	
//	public boolean isCycle(Subject[] courseList) {
//		ArrayList<Subject> start = new ArrayList<Subject>();
//		for(int i=0; i<courseList.length; i++) {
//			if(courseList[i].getParent() == null) 
//				start.add(courseList[i]);
//		}
//		for(int j=0; j<start.size();j++) {
//			ArrayList<Subject> childList = new ArrayList<Subject>();
//			
//		}
//		return true;
//	}
	
}
