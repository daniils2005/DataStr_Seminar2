package datastr;

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
	
	public void print() throws Exception {
		if(isEmpty()) {
			throw new Exception("Sarakstā nav elementu, līdz ar to neko nevar izprintēt");
		}
		
		MyNode<Ttype> currentNode = firstNode;
		
		while(currentNode != null) {
			System.out.print(currentNode.getElement() + " ");
			currentNode = currentNode.getNextNode();
		}
	}
}
