import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Datas {

	public static void main(String[] args) {
		LocalDate hoje = LocalDate.now();
		
		
		LocalDate ind = LocalDate.of(1822, Month.SEPTEMBER,
				22);
		
		int anos = hoje.getYear() - ind.getYear();
		
		System.out.println(hoje);
		
		System.out.println(anos);
		
		// Period - pega o período entre um start e um end
		Period periodo = Period.between(ind,hoje);
		
		System.out.println(periodo);
		
		System.out.println(periodo.getYears());
		
		LocalDate plusInd = ind.plusYears(10);
		
		System.out.println(plusInd);
		
		DateTimeFormatter formatador = DateTimeFormatter
				.ofPattern("dd/MM/yyyy");
		
		String indPlusFormatado = plusInd.format(formatador);
		System.out.println(indPlusFormatado);
		
		//  LocalDateTime
		DateTimeFormatter formatadorDateTime = DateTimeFormatter
				.ofPattern("dd/MM/yyyy hh:mm:ss");
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora.format(formatadorDateTime));
	
		System.out.println(agora.toLocalDate());
		
		// LocalTime
		LocalTime intervalo = LocalTime.of(20,16);
		System.out.println(intervalo);
		
		// ZonedDateTime
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println(zdt);
		
		
		// Um pouco mais de prática
		LocalDate future = LocalDate.of(2099,Month.JANUARY,25);
		System.out.println(future.format(formatador));
		
		Period periodTodayFuture = Period.between(LocalDate.now(), future);
		System.out.println(periodTodayFuture.getYears());
	
		// Duration
		System.out.println(Duration.ofHours(23).getSeconds());
	
		
		// Hoje
		LocalDate today = LocalDate.now();
		DateTimeFormatter dtf = DateTimeFormatter
				.ofPattern("dd/MM/yyyy");
		System.out.println(today.format(dtf));
	
	}
}


