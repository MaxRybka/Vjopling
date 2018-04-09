/**
 * @author Rybka Maxim,²ÏÇ-1
 * @file DataInput(Home Work 1)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class DataInput {

	public static Long getLong() throws IOException{
		String s = getString();
		Long value = Long.valueOf(s);
		return value;
	}
	
	public static char getChar() throws IOException{
		String s = getString();
		return s.charAt(0);
	}
	
	public static Integer getInt(){
		while(true) {
			String s = "";
			try {
				s = getString();
				Integer value = Integer.valueOf(s);
				return value;
			} catch (IOException e) {
				e.printStackTrace();
			} catch(NumberFormatException e) {
				System.out.println("Please , enter int!");
			}
		}
	}
	
	public static Double getDouble() {
		while(true) {
			String s = "";
			try {
				s = getString();
				Double value = Double.valueOf(s);
				return value;
			} catch (IOException e) {
				e.printStackTrace();
			} catch(NumberFormatException e) {
				System.out.println("Please , enter double!");
			}
		}
	}
	
	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s;
		try {
			s = br.readLine();
			return s;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Something goes wrong!";
	}
	
}