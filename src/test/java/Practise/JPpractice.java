package Practise;

import java.util.Iterator;

import org.testng.annotations.Test;

public class JPpractice {

	@Test
	public void test1() {
		
		int n=5;
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
			System.out.print((char)('a'+j)+" " );
		}
			System.out.println();
		}
	}
	
	@Test
	public void test2() {
		int n=5;
		int k=0;
		for(int i=0;i<n;i++) {
			
			for(int j=0;j<=i;j++) {
				
				System.out.print((char)('a'+k)+" ");
				k++;
			}
			System.out.println();
		}
	}
	@Test
	public void test3() {
		int n=5;
				for(int i=0;i<n;i++) {
			
			for(int j=0;j<=i;j++) {
				
				System.out.print((char)('a'+i+j));
				}
			System.out.println();
		}
	}
	
	@Test
	public void test4() {
		int n=5;
		int k=0;
				for(int i=0;i<n;i++) {
			
			for(int j=0;j<=i;j++) {
				System.out.print(k%10+" ");
				k++;
}
			System.out.println();
}
				}
	
	@Test
	public void test5() {
		int n=5;
		int k=1;
				for(int i=0;i<n;i++) {
			
			for(int j=0;j<=i;j++) {
				
					
				System.out.print(k%10+" ");
				k++;
				if(k==10) {
					k++;
				}
}
			System.out.println();
}
	}
	@Test
	public void test6() {
		int n=5;
		int k=0;
				for(int i=0;i<n;i++) {
			
			for(int j=0;j<=i;j++) {
				
					
				System.out.print(k%5+1+" ");
				k++;
//				if(k>5) {
//					k=0;
//					k++;
//				}
}
			System.out.println();
}
	}
	
	@Test
	public void test7() {
		int n=5;
		int k=0;
		for (int i = 0; i < n ; i++) {
			for(int j=0;j<=i;j++) {
				System.out.print(k++%6+" ");
			}
			System.out.println();
		}
	}
	@Test
	public void test8() {
		int n=5;
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	@Test
	public void test9() {
		int n=5;
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				if(i%2==0)
				System.out.print(0+" ");
				else
					System.out.print(1+" ");
			}
			System.out.println();
		}
	}
	@Test
	public void test10() {
		int n=5;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	
	@Test
	public void test11() {
		int n=5;
		for(int i=n;i>=1;i--) {
			for(int j=1;j<=i;j++)
			{
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	@Test
	public void test12() {
		int n=5;
		for(int i=0;i<n;i++) {
			for(int j=i;j>=0;j--) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
}