package service;

import datastr.MyLinkedList;
import model.Student;

public class MainService {

	public static void main(String[] args) {
		MyLinkedList<Character> symbols = new MyLinkedList<Character>();
		MyLinkedList<Student> students = new MyLinkedList<Student>();
		try {
			/*symbols.add('A');
			symbols.add('B');
			symbols.add('C');
			symbols.print();
			symbols.add('Z');
			symbols.print();
			symbols.add('X', 0); //X A B C Z
			symbols.print();
			symbols.add('U', 5); 
			symbols.print();
			symbols.add('Q', 2);
			symbols.print();
			symbols.remove(6);
			symbols.print();
			System.out.println(symbols.getByPosition(3));
			symbols.add('A');
			symbols.add('A', 3);
			symbols.print();
			System.out.println(symbols.searchElement('A'));
			symbols.makeEmpty();
			symbols.add('E');
			symbols.print();*/
			
			Student s1 = new Student("Janis", "Berzins");
			Student s2 = new Student("Baiba", "Jauka");
			Student s3 = new Student("Liga", "Nejauka");
			students.add(s1);
			students.add(s2);
			students.add(s3);
			students.print();
			students.add(new Student("Tests", "Tests"), 1); 
			students.print();
			students.remove(2);
			students.print();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
