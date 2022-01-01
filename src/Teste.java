import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Teste {
	public static void main(
			String[] args) {

		List<String> palavras = new ArrayList<String>();
		palavras.add("Céu");
		palavras.add("Garrafa Azul");
		palavras.add("Cenário");
		
		palavras.sort(new ComparaPorTamanho());
		palavras.forEach(new Consumer<String>() {
			public void accept(String s) {
				System.out
						.println(s);
			}
		});
	}
}

class ComparaPorTamanho implements Comparator<String>{
	public int compare(String s1,String s2) {
		if(s1.length() > s2.length()){
			return -1;
		}
		if(s1.length() < s2.length()) {
			return 1;
		}
		return 0;
	}
}