import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercises {
	
	public static void main(String[] args) {
//		System.out.println(russianMultiplication(57,86));
//		System.out.println(capitalizeFirstLetterWords("Hello, my fellow students"));
////		fibonacci();
//		try (Scanner scanner = new Scanner(System.in)) {
//			System.out.println("Por favor indique a idade de uma pessoa em segundos:");
//			Long age = null;
//			while (true) {
//				String stored = scanner.nextLine();
//				try {
//					age = Long.parseLong(stored);
//					planetaryAge2(age);
//					break;
//				} catch (NumberFormatException e) {
//					System.out.println("Por favor escolha uma opção válida!");
//				}
//			}
//		}
//		long init = System.nanoTime();
//		palyndromeString("Socorram-me, subi no onibus em Marrocos");
//		long end =System.nanoTime();
//		System.out.printf("%.3f ms", (double) (end-init)/1000);
//		System.out.println();
//		
//		init = System.nanoTime();
//		palyndromeString2("Socorram-me, subi no onibus em Marrocos");
//		end =System.nanoTime();
//		System.out.printf("%.3f ms", (double) (end-init)/1000);
//		System.out.println();
//		isItASunday();
//		fizzBuzz(45,40);
		System.out.println("apples".compareTo("banana"));
		System.out.println("banana".compareTo("pears"));
		System.out.println("a".compareTo("b"));
		System.out.println("a".compareTo("c"));
	}
	
	//
	////
	//////EXERCISE 1
	////
	//
	public static void exercise(){
		Integer[] array = {6,-1,14,7,3,21,-5};
		//THE HARD WAY
		Integer min = null;
		Integer max = null;

		for(int i = 0; i < array.length; i++){
			if(i == 0){
				min = array[i];
				max = array[i];
			}else{
				if(array[i] < min){
					min = array[i];
				}else if(array[i] > max){
					max = array[i];
				}
			}
		}
		//END HARD WAY
		//EASY WAY
		Arrays.sort(array);
		min = array[0];
		max = array[array.length - 1];

		//CURIOSITY
		Arrays.sort(array, Collections.reverseOrder());
		//END EASY WAY
	}
	

	//
	////
	//////EXERCISE 2
	////
	//
	public static int factorial(int num){
		//problem here, int takes values up to a certain point (32-bit), and that point gets reached at about 12!
		//use big integer class
		int fact = num;
		if(num != 0){
			for(int i = num-1; i > 0; i--){
				fact = fact * i;
			}
		}
		else{
			fact = 1;
		}
		return fact;
	}

	public static int fact2(int num){
		if(num == 1 || num == 0){
			return 1;
		}else{
			return num*fact2(--num);
		}
	}
	
	
	/**
	 * This is the answer to number one, how to do Russian Multiplication.
	 * Separate 2 numbers into two columns, and add 'lines' by doubling number 1 and halving number 2 (up to the floor value).
	 * If a line contains an even number 2, erase that line.
	 * Stop once number 2 is 1, and then add all of the number 1 from all none erased lines.
	 * This works recursively, once number 2 is 1 simply return out the value of number 1, besides that, if number 2 is 
	 * even simply calculate the next line without caring for the current line's number 1, other wise simply add number 1 to 
	 * result of next line.
	 * @param number1 first number, the ones to be added
	 * @param number2 second number, where we keep track whether to delete the line and when to stop
	 * @return final result
	 */
	public static int russianMultiplication(int number1, int number2){
		if(number2==1){
			return number1;
		}
		if(Math.floorMod(number2, 2)==1){
			return number1 + russianMultiplication(number1*2,(int) Math.floor(number2/2));
		}else{
			return russianMultiplication(number1*2,(int) Math.floor(number2/2));
		}
	}
	
	public static String capitalizeFirstLetterWords(String text){
		if(!text.isEmpty()){
			String[] words = text.split("\\s+");
			for (int i = 0; i < words.length; i++) {
				words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
			}
			return String.join(" ", words);
		}else{
			return "You chose an empty string, please try again";
		}
	}
	
	public static void fibonacci(){
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Por favor indique quantos números da sequência de Fibonacci quer:");
			Integer length = null;
			while (true) {
				String stored = scanner.nextLine();
				try {
					length = Integer.parseInt(stored);
					break;
				} catch (NumberFormatException e) {
					System.out.println("Por favor escolha uma opção válida!");
				}
			}
			if(length!=0){
				ArrayList<Integer> fibonacciNumbers = new ArrayList<>();
				int sum = 0;
				for (int i = 0; i < length; i++) {
					if (i > 1) {
						fibonacciNumbers.add(fibonacciNumbers.get(i - 2) + fibonacciNumbers.get(i - 1));
					} else {
						fibonacciNumbers.add(i);
					}
					sum += fibonacciNumbers.get(i);
				}
				System.out.println("Os números são: " + fibonacciNumbers.stream().map(Object::toString).collect(Collectors.joining(", ")));
				System.out.println(String.format("A média é: %.2f", (double)sum/length));
			}
			else{
				System.out.println("Não há sequências com 0 elementos.");
			}
		}
	}
	public static final LinkedHashMap<String,Double> sideralPeriodPerPlanet = new LinkedHashMap<>();
	static{
		sideralPeriodPerPlanet.put("Mercúrio", 0.241);
		sideralPeriodPerPlanet.put("Vénus", 0.615);
		sideralPeriodPerPlanet.put("Terra", 1.000);
		sideralPeriodPerPlanet.put("Marte", 1.881);
		sideralPeriodPerPlanet.put("Júpiter", 11.86);
		sideralPeriodPerPlanet.put("Saturno", 29.46);
		sideralPeriodPerPlanet.put("Urano", 84.81);
		sideralPeriodPerPlanet.put("Neptuno", 164.8);
	}

	
	public static void planetaryAge(Long earthAgeInSeconds){
		Long earthYearInSeconds = (long) (365*24*60*60);
		double earthAgeInYears = (double) (earthAgeInSeconds/earthYearInSeconds);
		for(String planetName: sideralPeriodPerPlanet.keySet()){
			System.out.println(String.format("A pessoa teria %.3f ano(s) no planeta %s", (double) (earthAgeInYears/sideralPeriodPerPlanet.get(planetName)), planetName));
		}
	}
	
	public static void planetaryAge2(Long earthAgeInSeconds){
		Long earthYearInSeconds = (long) (365*24*60*60);
		double earthAgeInYears = (double) (earthAgeInSeconds/earthYearInSeconds);
		for(Planet p: Planet.values()){
			System.out.println(String.format("A pessoa teria %.3f ano(s) no planeta %s", (double) (earthAgeInYears/p.sideralPeriod()), p.Name()));
		}
	}
	
	public static void palyndromeString(String text){
		String text2 = text.replaceAll("\\W","").toLowerCase();
		int length = text2.length();
		String firstHalf = text2.substring(0, Math.floorDiv(length, 2));
		String secondHalf = null;
		if(length % 2 ==1){
			secondHalf = text2.substring(Math.floorDiv(length, 2)+1);
		}else{
			secondHalf = text2.substring(Math.floorDiv(length, 2));
		}
		String invertedSecondHalf = new StringBuilder(secondHalf).reverse().toString();
		if(firstHalf.equals(invertedSecondHalf)){
			System.out.println("Sim, o texto inserido é um palíndromo");
		}else{
			System.out.println("Não, o texto não é um palíndromo");
		}
	}
	
	public static void palyndromeString2(String text){
		String text2 = text.replaceAll("\\W","").toLowerCase();
		int length = text2.length();
		for(int i = 0; i < length/2; i++){
			if(text2.charAt(i) != text2.charAt(length - i - 1)){
				System.out.println("Não, o texto não é um palíndromo");
				break;
			}
		}
		System.out.println("Sim, o texto inserido é um palíndromo");
	}
	
	public static void isItASunday(){
		DayOfWeek d = LocalDate.parse("2017-01-10").getDayOfWeek();
		if(d.equals(DayOfWeek.SUNDAY)){
			System.out.println("O dia que indicou é um Domingo.");
		}else{
			System.out.println(String.format("O dia que indicou não é Domingo. O próximo Domingo é em %s",LocalDate.parse("2017-01-10").with(TemporalAdjusters.next(DayOfWeek.SUNDAY))));	
		}
	}
	
	public static void fizzBuzz(int x, int y){
		if ((x % 3 != 0) && (x % 5 != 0)) {
			System.out.println(x);
		} else if ((x % 3 == 0) && (x % 5 != 0)) {
			System.out.println("Fizz");
		} else if ((x % 3 != 0) && (x % 5 == 0)) {
			System.out.println("Buzz");
		} else {
			System.out.println("FizzBuzz");
		}
		if (x != y) {
			if (x < y) {
				fizzBuzz(x + 1, y);
			} else if (x > y) {
				fizzBuzz(x - 1, y);
			}
		}
	}
	
	public static void fizzBuzz2(int x, int y){
		if(x % 15 == 0){
			System.out.println("FizzBuzz");
		}else if(x % 3 == 0){
			System.out.println("Fizz");
		}else if(x % 5 ==0){
			System.out.println("Buzz");
		}else{
			System.out.println(x);
		}
		if (x != y) {
			if (x < y) {
				fizzBuzz(x + 1, y);
			} else if (x > y) {
				fizzBuzz(x - 1, y);
			}
		}
	}
}

enum Planet{
	MERCURY("Mercúrio", 0.241),
	VENUS("Vénus", 0.615),
	EARTH("Terra", 1.000), 
	MARS("Marte", 1.881), 
	JUPITER("Júpiter", 11.86), 
	SATURN("Saturno", 29.46), 
	URANUS("Urano", 84.81), 
	NEPTUNE("Neptuno", 164.8);
	
	private final String name;
	private final double sideralPeriod;
	
	Planet(String name, double sideralPeriod){
		this.name = name;
		this.sideralPeriod = sideralPeriod;
	}
	
	public String Name(){
		return name;
	}
	
	public double sideralPeriod(){
		return sideralPeriod;
	}
}
