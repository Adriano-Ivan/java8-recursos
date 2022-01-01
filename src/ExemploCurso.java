import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Curso {
	private String nome;
	private int alunos;

	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public int getAlunos() {
		return alunos;
	}
	@Override
	public String toString() {
		
		return "[Nome: "+nome+", Alunos: "+alunos+"]";
	}
}

public class ExemploCurso {

	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		//cursos.sort(Comparator.comparing(c->c.getAlunos()));
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
	
//		cursos.stream().filter(c->c.getAlunos()>=100)
//		.forEach(c->System.out.println(c.getNome)));
//		
		cursos.stream().filter(c->c.getAlunos()>=100)
		.map(Curso::getAlunos)
		.forEach(total -> System.out.println(total));
		
		int streamSum = cursos.stream()
				.filter(c->c.getAlunos()>=100)
				.mapToInt(Curso::getAlunos).sum();
		
		System.out.println("Total de alunos de cursos com mais de 100: "+streamSum);
		
		System.out.println("\nCursos:");
		cursos.forEach(c->System.out.println(c.getNome()));
	
		System.out.println("\nCursos com mais de 50:");
		cursos.stream().filter(curso->curso.getAlunos()>50)
		.forEach(curso->System.out.println(curso.getNome()));

		System.out.println("\nTransformando em nomes: ");
		
		Stream<String> cursosNomes = cursos.stream().map(Curso::getNome);
		
		cursosNomes.forEach(n->System.out.println(n));
		
		System.out.println("\nAPROVEITANDO METHOD REFERENCE");
	
		cursos.stream().filter(c->c.getAlunos()>50)
		.map(Curso::getAlunos)
		.forEach(n->System.out.println(n));
		
		// Mais testes
		System.out.println("\nMais testes:");
		Optional<Curso> cursoOpcional = cursos.stream()
				.filter(c->c.getAlunos() >= 100)
				.findAny();
		
		cursos.stream()
			.filter(c->c.getAlunos() >= 100)
			.findAny()
			.ifPresent(c-> System.out.println(c.getNome()));
		
		OptionalDouble media = cursos.stream()
				.filter(c->c.getAlunos()>=100)
				.mapToInt(Curso::getAlunos)
				.average();
		
		System.out.println("Média: "+media);
		List<Curso> resultadoStreamToList = cursos.stream()
		.filter(c->c.getAlunos()>=100)
		.collect(Collectors.toList());
		
		Map<String, Integer> mapCursos = cursos.stream()
		.filter(c->c.getAlunos()>=100)
		.collect(Collectors.toMap(
				c->c.getNome(),
				c->c.getAlunos()
				));
		
		System.out.println("Acesso a mapa por stream");
		cursos.stream()
		.filter(c->c.getAlunos()>=100)
		.collect(Collectors.toMap(
				c->c.getNome(),
				c->c.getAlunos()
				))
		.forEach((nome,alunos)->System.out.println(
				nome + " tem "+ alunos +" alunos"));
		
		System.out.println("Mapa Cursos");
		mapCursos.keySet().forEach(k->System.out.println(
				mapCursos.get(k)));
		
		//resultadoStreamToList.forEach(res->System.out.println(res));
		
//		Curso curso  = cursoOpcional.orElse(null);
//		System.out.println(curso.getNome());
//		
//		cursoOpcional.ifPresent(c-> System.out.println(c.getNome()));
	
		cursos.stream()
		.filter(c->c.getAlunos()>50)
		.findFirst()
		.ifPresent(c->System.out.println(c.getNome()));
		
		System.out.println("\nMédia de alunos:");
		
		OptionalDouble mediaDeTodosOsCursos=cursos.stream() 
		.mapToInt(Curso::getAlunos)
		.average();
		
		mediaDeTodosOsCursos.ifPresent(m->
		System.out.println("Média de todos os cursos: "+m));
		
		List<Curso> cursosMaisDeCinquenta = cursos.stream()
				.filter(c->c.getAlunos()>50)
				.collect(Collectors.toList());
		
		System.out.println(cursosMaisDeCinquenta);
	}
}
