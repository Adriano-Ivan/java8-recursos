import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		palavras.add("Batman Begins");
		palavras.add("Batman The Dark Knight");
		palavras.add("Alepo");
		palavras.add("Águia");
		palavras.add("Agulha");

		/*
		palavras.sort((String s1, String s2)-> {
			return Integer.compare(s1.length(), s2.length());
//		        int r = Integer.compare(s1.length(), s2.length());
//		        if(r==1) return -1;
//		        if(r==-1) return 1;
//		        return 0;
		    }
		);*/

		//palavras.sort(Comparator.comparing(s->s.length()));
		palavras.sort((s1,s2)->s1.compareTo(s2));
		//Consumer<String> impressor = s -> System.out.println(s);
		
//		palavras.forEach(System.out::println);
		palavras.forEach(s->System.out.println(s));
		
		//new Thread(()->System.err.println("Executando um Runnable")).start();
	}
}
