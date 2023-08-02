package Practise;

import org.testng.annotations.Test;

public class JPpractise {

	@Test
	public void test1() {
		int n=5;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n-i;j++) {
				System.out.print("  ");
			}
			for(int j=0;j>=i;j++) {
				System.out.print((char)('A'+j));
			}
			System.out.println();
		}
	}
}
