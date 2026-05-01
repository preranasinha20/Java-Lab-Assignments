// Main.java

import Vehicle.Employee.Ceo;

class Main{
	public static void main(String args[]){
			Ceo ceo = new Ceo();
			Developer dev = new Developer();
			
			dev.salary();
			dev.company();
			
			ceo.salary();
			ceo.company();
	}

}