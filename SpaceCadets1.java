import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


public class SpaceCadets1 {
	
	public static void main(String args[]) throws IOException {
		
		System.out.println("Enter the username of user:\n");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String email = br.readLine();
		
		URL url = new URL ("http://www.ecs.soton.ac.uk/people/" + email);
		BufferedReader br2 = new BufferedReader(new InputStreamReader(url.openStream()));
		
		String inputLine;
		while ((inputLine = br2.readLine()) != null) {
			if (inputLine.contains("<h2 class=\"uos-sia-title\" id=\"uos-sia-page-title\">")) {
				String[] split = inputLine.split("<h2 class=\"uos-sia-title\" id=\"uos-sia-page-title\">");
				String[] split2 = split[1].split("</h2>");
				String name = split2[0];
				if (!name.toLowerCase().contains("ecs people")) {
					System.out.println("\nThe given user's name is " + name);
				} else {
					System.out.println("\nUser not found");
				}
			}
		}
		
	}
	
}
