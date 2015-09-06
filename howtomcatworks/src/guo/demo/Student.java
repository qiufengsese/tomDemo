package guo.demo;
class Professor implements Cloneable{
	String name;
	int age;
	Professor(String name,int age) {
		this.name = name;
		this.age = age;
	}
	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return obj;
	}
}

public class Student implements Cloneable {
	String name;
	int age;
	Professor p;
	Student(String name,int age,Professor p) {
		this.name = name;
		this.age = age;
		this.p = p;
	}
	public Object clone() {
		Student obj  = null;
		try {
			obj = (Student)super.clone();
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		//obj.p =(Professor)p.clone();
		return obj;
	}
	
	public static void main(String[] args) {
		Professor p = new Professor("wangwu",55);
		Student s1 = new Student("zhangsan",18,p);
		Student s2 = (Student)s1.clone();
		s2.p.name = "lisi";
		s2.p.age = 30;
		System.out.println("name="+s1.p.name+","+"age="+s1.p.age);
		System.out.println("name="+s2.p.name+","+"age="+s2.p.age);
	}
}