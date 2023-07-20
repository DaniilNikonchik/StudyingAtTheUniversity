import java.util.*;
/* вариант 16
 * содержимое стандартного входного потока скопировать в выходной, преобразуя строки входного файла следующим образом:
 * каждая входная строка состоит из слов, разделенных одним или несколькими пробелами.
 * Переставить в ней слова, состоящие только из букв так, чтобы они были упорядочены по алфавиту.
 * При этом другие слова должны оставаться на месте, количество пробелов должно оставаться таким же, как и в исходной строке. 
 */

class Word_ implements Comparable<Word_> {
	String str;
	int oldBegPos, oldEndPos;
	
	public Word_ (String str, int oldBegPos) {
		this.str = str;
		this.oldBegPos = oldBegPos;
		this.oldEndPos = oldBegPos + str.length() - 1;
	}
	
	public Word_(Word_ w) {
		str = w.str;
		oldBegPos = w.oldBegPos;
		oldEndPos = w.oldEndPos;
	}
	public int compareTo (Word_ w) {
		return str.compareTo(w.str);
	}
	
	public static boolean isMyWord (String str) {
		for (int i = 0; i < str.length(); i++)
			if (Character.isLetter(str.charAt(i)) == false)
				return false;
		return true;
	}
}

public class task_16 {
	
	static ArrayList<String> text = new ArrayList<String>();
	
	static String processLine (String line) {
		StringBuilder res = new StringBuilder(line);
		
		ArrayList<Word_> list = new ArrayList<Word_>();
		ArrayList<Word_> sortlist = new ArrayList<Word_>();
		
		StringTokenizer sttok = new StringTokenizer(line);
		int endPos = 0;
		
		while (sttok.hasMoreElements()) {
			
			String word = sttok.nextToken();
			endPos = line.indexOf(word, endPos);
			
			if ( Word_.isMyWord(word) ) {
				Word_ w = new Word_(word, endPos);
				list.add(w);
				sortlist.add(w);
			}
			endPos += word.length();
		}
		
		Collections.sort(sortlist);
		for (int i = sortlist.size() - 1; i >= 0; --i) {
			res.replace(list.get(i).oldBegPos, list.get(i).oldEndPos + 1, sortlist.get(i).str);
		}
		return res.toString();
	}
	
	public static void main(String[] args) {
		
		System.out.println("Enter text or Ctrl+Z:");
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String line = in.nextLine();
			text.add(processLine(line));
		}
		in.close();
		System.out.println("\nText:");
		if ( text.size() == 0 )
			System.err.println("....");
		for (String line: text)
			System.out.println(line);
		System.out.println("The end.");
		
	}

}
