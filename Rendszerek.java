import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class Rendszerek {

	public static void main(String[] args) throws FileNotFoundException {
		Random rand = new Random();
		File read = new File("Teszt1.tsp");
		Scanner reader = new Scanner(read);
		
		Map<Integer, Koordinatak> graf = new TreeMap<Integer, Koordinatak>();
		
		while (reader.hasNextLine()) {
			Integer key;
			int x, y;
			key = reader.nextInt();
			x = reader.nextInt();
			y = reader.nextInt();
			graf.put(key, new Koordinatak(x, y));
		}
		
		int PopulacioMeret = 10000;
		int n = graf.size();
		int e = 10;       //parologtatasi egyutthato
		int[] p = new int[n];
		
		for (int i = 0; i < n; i++) {
			p[i] = 10000;
		}
		
		int Legjobb = (Integer) null;
		Integer[] P = new Integer[n];
		Integer[] S = new Integer[n];
		boolean[] megNincs = new boolean[n];
		Integer[] C = new Integer[n];
		
		for (int i = 0; i < 10000; i++) {
			for (int j = 0; j < n; j++) {
				megNincs[j] = true;
			}
			
			for (int j = 0; j < n; j++) {
				P[j] = 0;
			}
			
			for (int j = 0; j < PopulacioMeret; j++) {
				for (int l = 0; l < n; l++) {
					S[l] = 0;
				}
				
				int k = 0;
				while (k < n) {
					int maxP = Collections.max(Arrays.asList(p));
					int index = 0;
					for (int l = 0; l < n; l++) {
						if (p[l] == maxP && megNincs[l]) {
							C[index] = l + 1;
							index++;
						}
					}
					
					if (index == 0) {
						for (int l = 0; l < n; l++) {
							S[l] = 0;
						}
					} else {
						int r = rand.nextInt(index);
						S[k] = C[r];
						megNincs[r] = false;
					}
				}
				
				// MegatarozMinoseg(S) -folyatani
			}
		}
	}

}
