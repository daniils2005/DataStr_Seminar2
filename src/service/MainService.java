package service;

import datastr.MyLinkedList;

public class MainService {

	public static void main(String[] args) {
		MyLinkedList<Character> symbols = new MyLinkedList<Character>();
		
		try {
			symbols.add('A');
			symbols.add('B');
			symbols.add('C');
			symbols.print();
			System.out.println();
			symbols.add('Z');
			symbols.print();
			System.out.println();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
