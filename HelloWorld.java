import java.io.*;

public class HelloWorld {
	
	private void launch() {
		//personClassStuff();
		//simpleArray();
		//linkedList();
		//sortedLinkedList();
		//simpleMatrix();
		//screenInput();
		primeNumbers();
	}
	
	private void primeNumbers() {
		System.out.print("Please enter a number that you think might be a prime number\n");
		System.out.print("Enter x to quit\n");
		
		String str = System.console().readLine();
		
		while (!str.equals("x")) {
			while (str.length()==0) {
				System.out.print("Enter a potential prime\n");
				str = System.console().readLine();
			}
		
			try {
				int num = Integer.parseInt(str);
				int i=2;
				boolean notPrime=false;
		
				while (i<num) {
					notPrime = (num%i==0) ? true : false; // don't really need a ternary as default is false but just wanted to use one
					if (notPrime) break;
					i++;
				}
		
				if (notPrime)
					System.out.print(num + " is NOT a prime number");
				else
					System.out.print(num + " is a prime number");
			} 
			catch (NumberFormatException e) { 
			System.out.print("Not a number");
			}
			
			System.out.print("\nEnter another potential prime number or x to quit\n");
			str = System.console().readLine();
		}	
	}
	
	private void screenInput() {
		System.out.print("Please enter the number associated with your menu choice\n");
		System.out.print("For soup enter \t\t 1 \n");
		System.out.print("For sandwich enter \t 2 \n");
		System.out.print("For steak enter \t 3 \n");
		
		String str = System.console().readLine();
		while (str.length()==0) {
			System.out.print("Please enter one of valid options i.e. 1, 2 or 3\n");
			str = System.console().readLine();
		}
		int num = Integer.parseInt(str);
		
		switch (num) {
			case 1:
				System.out.print("Enjoy your soup");
				break;
			case 2:
				System.out.print("Enjoy your sandwich");
				break;
			case 3:
				System.out.print("Enjoy your steak");
				break;
			default:
				System.out.print(num + " is not a valid number");
		}
		
	}
	
	private void sortedLinkedList() {
		Node firstNode;
		Node lastNode;
		Node currentNode;
		
		int i=0;
		int[] nodeValues = {2,5,1,3,11,28,77,42,13};

		firstNode = new Node(nodeValues[i]);
		lastNode = firstNode;
		
		currentNode=firstNode;
		
		for (i=1; i<nodeValues.length; i++) {
			Node nextNode = new Node(nodeValues[i]);
			
			if (nextNode.getValue()<firstNode.getValue()) {
				nextNode.setNextNode(firstNode);
				firstNode.setPriorNode(nextNode); //for reversing
				firstNode=nextNode;
			} else {
				currentNode=firstNode;
				while (currentNode.getNextNode()!=null) {
					if (nextNode.getValue()<currentNode.getNextNode().getValue()) {
						nextNode.setNextNode(currentNode.getNextNode());
						currentNode.setNextNode(nextNode);
						nextNode.setPriorNode(currentNode); //for reversing
						nextNode.getNextNode().setPriorNode(nextNode); //for reversing
						break;
					} 
					currentNode=currentNode.getNextNode();
				}
				
				if (currentNode.getNextNode()==null) {
					currentNode.setNextNode(nextNode);
					nextNode.setPriorNode(currentNode); //for reversing
					lastNode=nextNode;
				}
			} 

		}
		
		//printing front to back
		currentNode = firstNode;
		while (currentNode!=null) {
			System.out.print(currentNode + "\t");
			currentNode = currentNode.getNextNode();
		}
		System.out.print(currentNode + "\n");
		
		//printing back to front
		currentNode = lastNode;
		while (currentNode!=null) {
			System.out.print(currentNode + "\t");
			currentNode=currentNode.getPriorNode();
		}
		
		System.out.print("\n" + "first node = " + firstNode + "\t" + " last node = " + lastNode + "\n");
	}
	
	private void simpleMatrix() {
		int[][] intMatrix = new int[3][3];
		int row;
		int column;
		
		for (row=0; row<3; row++) {
			for (column=0; column<3; column++) {
				intMatrix[row][column]=row+column;
			}
		}
		
		for (row=0; row<3; row++) {
			for (column=0; column<3; column++) {
				System.out.print(intMatrix[row][column] + "\t");
			}
			System.out.print("\n");
		}
	}
	
	private void linkedList() {
		int i=1;
		Node firstNode = new Node(i);
		Node currentNode = firstNode;
		
		for (i=2; i<=11; i++) {
			Node nextNode = new Node(i);
			currentNode.setNextNode(nextNode);
			currentNode = nextNode;
		}
		
		currentNode = firstNode;
		while (currentNode!=null) {
			System.out.print(currentNode + "\n");
			currentNode = currentNode.getNextNode();
		}

	}
	
	private void simpleArray() {
		Integer[] intArray = new Integer[10];
		for (int i=0; i<10;i++) {
			intArray[i] = i*3;
			System.out.print(intArray[i]+"\t");
		}
	}
	
	private void personClassStuff() {
		Person myPerson = new Person();
		System.out.print("first person\t" + myPerson + "\n");
		
		myPerson = new Person("Phil", "Moura", 49, "Loafer");
		System.out.print("second person\t" + myPerson + "\n");
		
		myPerson = new Student();
		System.out.print("first student\t" + myPerson + "\n");
		
		myPerson = new Student("Isabelle", "Moura", 45, "Student");
		System.out.print("second student\t" + myPerson + "\n");
		
		myPerson.setForename("Baby");
		System.out.print(myPerson.getName());
		
		Student myPerson1 = new Student("Betty", "Moura", 45, "Student");
		System.out.print("third student\t" + myPerson1 + "\n");
		myPerson1.setCourse("Computing");
		System.out.print("third student\t" + myPerson1 + "\n");
	}
	
	public static void main(String[] args) {
		HelloWorld script = new HelloWorld();
		script.launch();
	}
}