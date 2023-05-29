package BDDGenericMethods;

import java.util.Random;

public class JavaLibrary {
	public int random() {
		Random ran = new Random();
		int random=ran.nextInt(5000);
		return random;
}
}
