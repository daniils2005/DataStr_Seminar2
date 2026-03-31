package datastr;

public class MyNode<Ttype> {
	private Ttype element;
	private MyNode<Ttype> nextNode = null;
	private MyNode<Ttype> previousNode = null;
	
	public Ttype getElement() {
		return element;
	}
	
	public MyNode<Ttype> getNextNode() {
		return nextNode;
	}
	
	public MyNode<Ttype> getPreviousNode() {
		return previousNode;
	}

	public void setElement(Ttype element) {
		if(element != null) {
			this.element = element;
		} else {
			this.element = (Ttype) new Object();
		}
	}

	// nav jāveic not null pārbaudes, jo var būt gadījumi, ka ir null vērtība pirmajā vai pēdējā node
	public void setNextNode(MyNode<Ttype> nextNode) {
		this.nextNode = nextNode;
	}

	public void setPreviousNode(MyNode<Ttype> previousNode) {
		this.previousNode = previousNode;
	}
	
	//bez argumenta konstruktors nav vajadzīgs, jo vienmēr lietotājam būs jānorāda sākuma elements
	public MyNode(Ttype element) {
		setElement(element);
	}
	
	public String toString() {
		return "" + element;
	}
	
}
