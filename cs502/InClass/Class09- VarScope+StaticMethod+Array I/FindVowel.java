public class FindVowel {
	public static void main(String[] args) {
		int[] grade = new int[5];
		grade[0] = 100;
		grade[1] = 90;
		grade[2] = grade[0] / 2;

		for (int i=0; i<5; i++) {
			System.out.println(grade[i]);
		}


		char[] vowel = {'a', 'e', 'i', 'o', 'u'};
		char find = 'i';
		boolean found = false;
		for (int i=0; i<vowel.length; i++) {
			if (vowel[i] == find) {
			found = true;
			}
		}
		System.out.println(found);
	}
}		
