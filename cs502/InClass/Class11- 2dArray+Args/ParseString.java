public class ParseString {
	public static void main (String[] args) {
		String s = "CS502";
		char[] strNum = new char[s.length()];
		int strNumIdx = 0;
		
		for (int i=0; i<s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				strNum[strNumIdx] = s.charAt(i);
				strNumIdx++;
			}
		}

		String strNewNum = new String(strNum);		// 502 + 2 empty spaces
		System.out.println("Parse string is: " + strNewNum.trim());	// Delete 2 empty spaces and use only 502
		int num = Integer.parseInt(strNewNum.trim()) + 2;
		System.out.println("CS" + num);
		// String newS = Integer.toString(num);		// Integer to String	
	}
}