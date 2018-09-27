import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.ArrayList;
public class Olympian {
	private String name;
	private String sport;
	private int numMedals;
	private String event;


	public Olympian(String n, String s, String e, int num)
	{
		name = n;
		sport = s;
		event = e;
		numMedals = num;
	}
	public String toString()
	{
		return name + "\t\t"+sport+ "\t\t" + event + "\t\t" + numMedals;
	}
	public static void main(String[] args)
	{
		int quit;

		System.out.println("Welcome to P3: Olympians! My name is Marquis Lockhart.");

		ArrayList<Olympian> Olympian = new ArrayList<Olympian>();
		String name, sport, event;
		int medals;
		for(;;)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter a name:");
			name = sc.nextLine();
			System.out.println("Please enter a sport:");
			sport = sc.nextLine();
			System.out.println("Please enter an event:");
			event = sc.nextLine();
			for(;;){
				System.out.println("How many medals were won:");
				medals = sc.nextInt();
				if(medals < 11 && medals > -1) break;
				System.out.printf("Invalid medal amount.\n");
			}
			Olympian temp = new Olympian(name, sport, event, medals);
			Olympian.add(temp);
			System.out.println("Would you like to continue?");
			System.out.println(" 1.Yes\n 2.No\n");
			quit=sc.nextInt();
			if(quit==2) break;
		}
		System.out.println("The results are complete. Have a great day!");
		int tot =computeMedals(Olympian);
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File("results.txt"));
			pw.println("Name:\t\tSport:\t\tEvent:\t\tMedals:");
			for(Olympian Summary: Olympian)
			{
				pw.println(Summary);
			}
			pw.println("========================================\nResults:");
			pw.println(tot);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally
		{
			pw.close();
		}

	}
	public int getMedals(){
		return numMedals;
	}
	public static int computeMedals(ArrayList<Olympian> numMedals) {
		int total=0;
		for(Olympian Medals: numMedals)
			total+=Medals.getMedals();
		return total;
	}
}


