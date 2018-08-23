import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.*;
import java.lang.Integer;

public class Input{
	public static void main(String[] args){
		int sum = 0;
		try{
			BufferedReader reader = new BufferedReader(new FileReader("numbers.txt"));
			Scanner scan = new Scanner(reader);
			
			while (scan.hasNextInt()){
				sum += scan.nextInt();
			}
		}catch(FileNotFoundException error){
			System.out.print(error);
		}
		
		try{
			PrintWriter writer = new PrintWriter(new FileWriter("Sum_result.txt"));
			writer.printf("The sum is: %d", sum);
			writer.close();
		}catch (IOException error){
			System.out.print("File not exist");
		}
	

	}
}
