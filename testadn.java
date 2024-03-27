package coding_game_ADN;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class testadn {

	public boolean match(List<String> brinGauche, List<String> brinDroite) {
		String chaine1 = brinGauche.stream().collect(Collectors.joining());
		String chaine2 = brinDroite.stream().collect(Collectors.joining());

		if (chaine1.length() != chaine2.length()) {
			return false;
		}

		for (int i = 0; i < chaine1.length(); i++) {
			switch (chaine1.charAt(i)) {
			case 'A':
				if (chaine2.charAt(i) != 'T')
					return false;
				break;

			case 'T':
				if (chaine2.charAt(i) != 'A')
					return false;
				break;
			case 'G':
				if (chaine2.charAt(i) != 'C')
					return false;
				break;

			case 'C':
				if (chaine2.charAt(i) != 'G')
					return false;
				break;
			}
		}
		return true;
	}

	public List<List<Integer>> allCombinaisons(int nb, List<Integer> passed, int n) {

		// System.out.println("**********************_Iteration_*****************************");

		List<List<Integer>> res = new ArrayList<>();

		if (n == 0) {
			// System.out.println("singleton" + Collections.singletonList(passed));
			return Collections.singletonList(passed);
		}
		for (int i = 0; i < nb; i++) {
			if (passed.contains(i)) {
				continue;
			}
			List<Integer> passedNext = new ArrayList<>(passed);
			// System.out.println("passedNext init:" + passedNext);
			passedNext.add(i);
			// System.out.println("passedNext init add i:" + passedNext);
			res.addAll(allCombinaisons(nb, passedNext, n - 1));
			// System.out.println("res = " + res);
		}
		return res;
	}

	public static void main(String[] args) {
		List<Integer> passed = new ArrayList<>();
		testadn adn = new testadn();
		List<List<Integer>> combinaison = adn.allCombinaisons(2, passed, 2);
		System.out.println(combinaison);

		List<String> combinaisList = new ArrayList<>();
	}
}