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

	public List<List<Integer>> allCombinaisons(int nbFragment, List<Integer> passed, int nRestant) {

		List<List<Integer>> combinaison = new ArrayList<>();
		if (nRestant == 0)
			return Collections.singletonList(passed);

		// System.out.println("**********************_Iteration_*****************************");
		for (int i = 0; i < nbFragment; i++) {
			if (passed.contains(i)) {
				continue;
			}

			List<Integer> nextPassed = new ArrayList<>(passed);
			nextPassed.add(i);
			combinaison.addAll(allCombinaisons(nbFragment, nextPassed, nRestant - 1));
		}
		return combinaison;
	}

	public static void main(String[] args) {

		List<Integer> passed = new ArrayList<>();
		testadn adn = new testadn();
		List<List<Integer>> combinaisonList = adn.allCombinaisons(4, passed, 4);
		// System.out.println(combinaisonList);
		// System.out.println("1st:" + combinaisonList.get(0));

		List<Integer> combinaison = new ArrayList<>();

		List<String> Source = new ArrayList<>();
		Source.add("AT");
		Source.add("G");
		Source.add("CC");
		Source.add("TAG");
		// System.out.println("Source=" + Source.size());

		for (int j = 0; j < combinaisonList.size(); j++) {

			combinaison = combinaisonList.get(j);

			for (int i = 1; i < Source.size() - 1; i++) {

				List<String> brinGauche = new ArrayList<>();
				List<String> brinDroite = new ArrayList<>();

				for (int i0 = 0; i0 < i; i0++) {
					brinGauche.add(Source.get(combinaison.get(i0)));
				}

				for (int i1 = i; i1 < Source.size(); i1++) {
					brinDroite.add(Source.get(combinaison.get(i1)));
				}
				// System.out.println("brinGauche=" + brinGauche);
				// System.out.println("brinDroite=" + brinDroite);

				boolean resultat = adn.match(brinGauche, brinDroite);

				if (resultat) {
					/*
					 * System.out.println("Source: " + Source); System.out.println("brinGauche=" +
					 * brinGauche); System.out.println("brinDroite=" + brinDroite);
					 */
					// System.out.println("combinaison:" + combinaison);

					String res1 = String.join(" ", brinGauche);
					String res2 = String.join(" ", brinDroite);

					res1 = res1.concat("#").concat(res2);
					System.out.println(res1);
					// System.out.println("");

					j = combinaisonList.size();

					break;
				}

			}

		}
	}
}