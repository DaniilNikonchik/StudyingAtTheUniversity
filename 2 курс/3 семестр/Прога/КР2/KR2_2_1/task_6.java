import java.util.*;

public class task_6 {
	
	public static boolean check(String userNameString) {
		for (int i = 0; i < userNameString.length(); i++)
			if (Character.isDigit(userNameString.charAt(i)) == false)
					return false;
			return true;
	}
	
	
	public static void main (String args[]) {
		
		System.out.println("������� ������. ��� ��������� ����� ��� Ctrl + z");
		Scanner in = new Scanner(System.in);
		ArrayList<String> List = new ArrayList<String>(); 
		
		
		while (in.hasNextLine()) {
			
			String str = in.nextLine();
			StringTokenizer strtok = new StringTokenizer(str);
			
			while (strtok.hasMoreTokens()) {
				String word = strtok.nextToken();
				if (check(word) == true) List.add(word);
			}	
		}
		
		if (List.isEmpty() == true) System.out.println("��� ����, ��������� �� ����!");
		else {
		for (String i: List)
			System.out.println(i);
		}
		
		
		in.close();
		System.exit(0);
		
	}

}