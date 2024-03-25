package test;

public class Helloword {

	public int sommeNombres(int num1, int num2) {
		return num1 - num2;
	}

	public boolean compare(char a, char b) {
		if ((a == 'T' && b == 'A') || (b == 'T' && a == 'A'))
			return true;

		if ((a == 'C' && b == 'G') || (b == 'C' && a == 'G'))
			return true;
		return false;
	}

	public static void main(String[] args) {

		char a = 'C', b = 'G', extract_char;
		String chaineEntre = new String("ATGCCTAG"), chaine1 = "", chaine2 = "";
		System.out.println("######## " + chaineEntre);

		System.out.println("§§§§§§§§§§§§§§ >>>>>>>>>" + chaineEntre.substring(0, 1));

		Helloword hello = new Helloword();

		// System.out.println("Hello word en java= " + hello.sommeNombres(2, 6));
		// System.out.println("Hello word en java= " + hello.compare(b, a));
		System.out.println("##############>>>>" + chaineEntre.length());

		for (int i = 0; i < chaineEntre.length(); i++) {

			System.out.println("################ Boucle  1 ################");
			extract_char = chaineEntre.charAt(i);
			System.out.println("7>>>>>>  " + extract_char);

			for (int j = 0; j < chaineEntre.length(); j++) {

				System.out.println("######## Boucle  2 ########");
				System.out.println("777  j=" + j + " " + chaineEntre);
				System.out.println("777777777  " + chaineEntre.charAt(j));
				System.out.println("RESULT :" + hello.compare(extract_char, chaineEntre.charAt(j)));

				if (hello.compare(extract_char, chaineEntre.charAt(j))) {
					System.out.println("DEBUG 0");
					chaine1 = chaine1 + extract_char;
					chaine2 = chaine2 + chaineEntre.charAt(j);
					if (j < 7) {
						System.out.println("chaine 1,2:" + chaine1 + " " + chaine2);
						System.out.println("DEBUG 1 >>>>>" + chaineEntre);

						System.out.println(">>>> " + chaineEntre.charAt(i + 1));
						System.out.println(">>>> " + chaineEntre.substring(0, i));

						/*
						 * if ((i < chaineEntre.length() - 1) | (j < chaineEntre.length() - 1)) {
						 * chaineEntre = chaineEntre.substring(0, i) + 'X' + chaineEntre.charAt(i + 1);
						 * chaineEntre = chaineEntre.substring(0, j) + 'X' + chaineEntre.charAt(j + 1);
						 * }
						 */
						System.out.println("DEBUG 2");

					} else {

						chaineEntre = chaineEntre.substring(0, j) + 'X';
						chaineEntre = chaineEntre.substring(0, i) + 'X';
					}

					System.out.println("----------->" + chaineEntre);
				}
			}
		}
		// chaineEntre = chaine1 + '#' + chaine2;
		// System.out.println("######## " + chaineEntre);

	}
}
