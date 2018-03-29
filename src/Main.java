
public class Main {
	public static void main(String[] args) {
		Employee a[] = new Employee[4];
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		for(int i = 0; i < a.length; i++) {
			
			System.out.print("Employee name: ");
			String name = input.next();
			
			System.out.print("Employee age: ");
			//int age = Integer.parseInt(input.nextLine());
			int age = input.nextInt();
			
			System.out.print("Employee salary: ");
			//long salary = Long.parseLong(input.nextLine());
			long salary = input.nextLong();
			
			if(salary < 1)
				a[i] = new Employee(name, age);
			else
				a[i] = new Employee(name, age, salary);
		
		}
		
		input.close();
		
		displayInfos(a);
		otEvnelKevesebb(a);
		double atlagNyugdijig = nyugdijigAtlagEv(a);
		System.out.println("\n\nÁtlag nyugdíjig: " + atlagNyugdijig);
		atlagnalTobbVanHatra(a, atlagNyugdijig);
		
		System.out.println("\n\nNövekvő: ");
		for(int i = 0; i < a.length; i++) {
			
			int minIndex = i;
			
			
			for(int j = i+1; j < a.length; j++)
				if(a[minIndex].getRemainingYearsUntilPansion() > a[j].getRemainingYearsUntilPansion())
					minIndex = j;
			
			
			/*Employee tmp = a[i];
			a[i] = a[minIndex];
			a[minIndex] = tmp;*/
			
			Employee tmp = new Employee(a[i].getEmployeeName(), a[i].getAge(), a[i].getSalary() );
			a[i] = new Employee(a[minIndex].getEmployeeName(), a[minIndex].getAge(), a[minIndex].getSalary());
			a[minIndex] = new Employee(tmp.getEmployeeName(), tmp.getAge(), tmp.getSalary());
		}
		
		displayInfos(a);
		
		
		System.out.println("\n\nCsökkenő: ");
		for(int i = 0; i < a.length; i++) {
			
			int maxIndex = i;
			
			
			for(int j = i+1; j < a.length; j++)
				if(a[maxIndex].getRemainingYearsUntilPansion() < a[j].getRemainingYearsUntilPansion())
					maxIndex = j;
			
			
			/*Employee tmp = a[i];
			a[i] = a[maxIndex];
			a[maxIndex] = tmp;*/
			
			Employee tmp = new Employee(a[i].getEmployeeName(), a[i].getAge(), a[i].getSalary() );
			a[i] = new Employee(a[maxIndex].getEmployeeName(), a[maxIndex].getAge(), a[maxIndex].getSalary());
			a[maxIndex] = new Employee(tmp.getEmployeeName(), tmp.getAge(), tmp.getSalary());
		}
		
		displayInfos(a);
		
		
	}
	
	public static void displayInfos(Employee[] a) {
		System.out.println("\n\nDISPLAY INFOS: ");
		for(Employee x : a) {
			System.out.println(x.toString());
		}
	}
	
	public static void otEvnelKevesebb(Employee[] a) {
		System.out.println("\n\nOT EVNEL KEVESEBB: ");
		for(Employee x : a) {
			if((x.getPensionRemainingAge() - x.getAge()) < 5)
				System.out.println(x.toString());
		}
	}
	
	public static double nyugdijigAtlagEv(Employee[] a) {
		int sum = 0;
		for(Employee x : a) {
			sum += (x.getPensionRemainingAge() - x.getAge());		
		}
		
		return sum/a.length;
	}
	public static void atlagnalTobbVanHatra(Employee[] a, double atlag) {
		System.out.println("\n\nATLAGNAL TOBB: ");
		for(Employee x : a) {
			if(x.getRemainingYearsUntilPansion() > atlag)
				System.out.println(x.toString());
		}
	}
}
