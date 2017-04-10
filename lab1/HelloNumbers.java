public class HelloNumbers {
	public static void main(String[] args) {
		int x = 0;
		int i = 0;
		while (i < 10) {
			System.out.println(x);
			i = i + 1;
			x = x + i;
		}

		//x = "horse";
	}
}

/*
1. Before Java variables can be used, they must be declared.
2. Java variables must have a specific type.
3. Java variable types can never change.
4. Types are verified before the code even runs!!!
*/