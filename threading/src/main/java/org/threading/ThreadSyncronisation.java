package org.threading;

/**
 * 
 * @author pramod.anarase
 *
 */
public class ThreadSyncronisation {

	/**
	 * Example - create two thread which will print odd and even numbver
	 * sequncially
	 */
  
    public boolean isOddPrinted;
	public static void main(String[] args) {

		Thread oddThraed = new Thread(new Runnable() {
			int oddnumber = 1;

			public void run() {
				/// print odd numaber 1,3,5
				while (oddnumber < 100) {
					printNumber("ODD", oddnumber);
					oddnumber += 2;
				}
			}

		});

		Thread evenThraed = new Thread(new Runnable() {
			int evenNumber = 2;

			public void run() {
				// print even number 2,4,6
				while (evenNumber < 100) {
					printNumber("EVEN", evenNumber);
					evenNumber += 2;
				}
			}
		});

		
		
		
		
		oddThraed.start();
		evenThraed.start();

	}
	
	
	public static void printNumber(String type,int number) {

		    
			System.out.println(type+ "=" + number);	
		
	}

}
