import java.util.*;

public class task_2 {
	//������� 2
	//��������� ������ ����� �� ������������ �������� ������, ������� �����,
	//������������ � ��������� ����� � ������� � ����������� �������� �����
	//� ����� ������

	static ArrayList<String> tl = new ArrayList<String>(); //list of lines
	
	static void procLine(String line)
	{
		StringTokenizer st = new StringTokenizer(line);
		int idx = 0;
		while(st.hasMoreElements())
		{
			String s = st.nextToken();
			if(Character.isUpperCase(s.charAt(idx)))
			{
				tl.add(s);
			}
		}
	}
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Insert your text line by line:");
		String text = "";
		while(sc.hasNextLine()){
			text = text + " " + sc.nextLine();
		}
		sc.close();
		procLine(text);
		System.out.println("---Full text---: ");
		for(String s : tl){
			System.out.println(s);
		}
		System.out.println("------end------\n");
	}
}
