package datastr;

import java.util.ArrayList;

public class MyLinkedList<Ttype> {
	private MyNode<Ttype> firstNode = null;
	private MyNode<Ttype> lastNode = null;
	private int howManyElements = 0;
	
	public int getHowManyElements() {
		return howManyElements;
	}
	
	//bezargumenta konstruktors būs no Object klases
	//bet argumenta nevajag taisīt
	
	public boolean isEmpty() {
		return (howManyElements == 0);
	}
	
	public boolean isFull() {
		try {
			new MyNode<Character>('A');//mēģinu RAM atmiņā rezervēt vietu
			return false;
		} catch(OutOfMemoryError e) {
			return true;
		}
	}
	
	public void add(Ttype element) throws Exception {
		if(isFull()) {
			throw new Exception("Saraksts ir pilns un nav iespējams pievienot elementu");
		}
		if(element == null) {
			throw new Exception("Padotais elements nav norādīts");
		}
		
		//ja būs pievienots pirmais bloks
		if(isEmpty()) {
			MyNode<Ttype> newNode = new MyNode<Ttype>(element);
			lastNode = newNode;
			firstNode = newNode;
			howManyElements++;
		} else { //ja jau ir vismaz viens bloks iekš saraksta
			MyNode<Ttype> newNode = new MyNode<Ttype>(element);
			lastNode.setNextNode(newNode);
			newNode.setPreviousNode(lastNode);
			lastNode = newNode;
			howManyElements++;
		}
	}
	
	//izveidot add funckiju, kura padod elementu un pozīciju, kura ielikt
	//veikt nepieciesamas parbaudes
	//ja velas pieveinot 0 pozicija
	//ja velas pievienot beigas
	//ja velas pievienot pa vidu
	
	public void add(Ttype element, int position) throws Exception {
		if(isFull()) {
			throw new Exception("Saraksts ir pilns un nav iespējams pievienot elementu");
		}
		if(element == null) {
			throw new Exception("Padotais elements nav norādīts");
		}
		if(position < 0) {
			throw new Exception("Pozīcija var būt tikai pozitīva");
		}
		if(position > howManyElements) {
			throw new Exception("Pozīcija nevar būt lielāka par esošo elementu skaitu");
		}
		
		
		if(position == 0) {
			MyNode<Ttype> newNode = new MyNode<Ttype>(element);
			newNode.setNextNode(firstNode);
			firstNode.setPreviousNode(newNode);
			firstNode = newNode;
			howManyElements++;
		} else if(position == howManyElements) {
			add(element);
		} else {
			MyNode<Ttype> newNode = new MyNode<Ttype>(element);
			MyNode<Ttype> currentNode = firstNode;
			
			for(int i = 1; i <= position-1; i++) {
				currentNode = currentNode.getNextNode();
			}
			
			MyNode<Ttype> leftNode = currentNode;
			MyNode<Ttype> rightNode = leftNode.getNextNode();
			
			leftNode.setNextNode(newNode);
			newNode.setPreviousNode(leftNode);
			
			rightNode.setPreviousNode(newNode);
			newNode.setNextNode(rightNode);
			
			howManyElements++;
		}
	}
	
	public void remove(int position) throws Exception {
		if(isEmpty()) {
			throw new Exception("Saraksts ir tukšs");
		}
		if(position < 0 || position > howManyElements - 1) {
			throw new Exception("Pozīcija neeksistē");
		}
		
		MyNode<Ttype> currentNode = firstNode;
		if(position == 0) {
			firstNode = firstNode.getNextNode();
			firstNode.getPreviousNode().setNextNode(null);
			firstNode.setPreviousNode(null);
		} else if(position == howManyElements - 1) {
			lastNode = lastNode.getPreviousNode();
			lastNode.getNextNode().setPreviousNode(null);
			lastNode.setNextNode(null);
		} else {
			for(int i = 0; i < position; i++) {
				currentNode = currentNode.getNextNode();
			}
			currentNode.getPreviousNode().setNextNode(currentNode.getNextNode());
			currentNode.getNextNode().setPreviousNode(currentNode.getPreviousNode());
			currentNode.setNextNode(null);
			currentNode.setPreviousNode(null);
		}
		howManyElements--;
	}
	
	public Ttype getByPosition(int position) throws Exception {
		if(position < 0 || position > howManyElements - 1) {
			throw new Exception("Pozīcija neeksistē");
		}
		if(position == 0) {
			return firstNode.getElement();
		} else if(position == howManyElements - 1) {
			return lastNode.getElement();
		}
		MyNode<Ttype> currentNode = firstNode;
		for(int i = 0; i < position; i++) {
			currentNode = currentNode.getNextNode();
		}
		return currentNode.getElement();
	}
	
	public ArrayList<Integer> searchElement(Ttype element) throws Exception {
		if(isEmpty()) {
			throw new Exception("Saraksts ir tukšs");
		}
		if(element == null) {
			throw new Exception("Padotais elements nav norādīts");
		}
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		MyNode<Ttype> lastNode = firstNode;
		for(int i = 0; i < howManyElements; i++) {
			if(lastNode.getElement().equals(element)) {
				indexes.add(i);
			}
			lastNode = lastNode.getNextNode();
		}
		return indexes;
	}

	
	public void print() throws Exception {
		if(isEmpty()) {
			throw new Exception("Sarakstā nav elementu, līdz ar to neko nevar izprintēt");
		}
		
		MyNode<Ttype> currentNode = firstNode;
		
		while(currentNode != null) {
			System.out.print(currentNode.getElement() + " ");
			currentNode = currentNode.getNextNode();
		}
		System.out.print("\n");
	}
	
	public void makeEmpty() {
		firstNode = null;
		lastNode = null;
		howManyElements = 0;
		System.gc();
	}
}
