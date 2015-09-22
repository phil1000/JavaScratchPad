public class Node {

	private Node nextNode;
	private Node priorNode;
	private int value;
	
	public Node(int value) {
		this.value=value;
	}
	
	public int getValue() {return value;}
	public Node getNextNode() {return nextNode;}
	public void setNextNode(Node nextNode) {this.nextNode=nextNode;}
	public Node getPriorNode() {return priorNode;}
	public void setPriorNode(Node priorNode) {this.priorNode=priorNode;}
	public String toString() {return Integer.toString(this.value);}
}