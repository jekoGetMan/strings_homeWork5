package homeWork5;

import java.util.ArrayList;

public class Statement implements Comparable, Inter {

	public final static String DELIMITERS = "\u3030.!?,;:)}";
	public String symb;
	public ArrayList<Symbol> getSign;

	public Statement(ArrayList<String> sign) {
		this.getSign = new ArrayList<Symbol>();
		int cnt = 0;
		while (cnt < sign.size()){
			this.getSign.add(new Symbol(sign.get(cnt)));
			cnt++;
		}
		setText();
	}

	public int compareTo(Object obj) {
		Statement var = (Statement) obj;
		if (this.getSign.size() < var.getSign.size()) {
			return -1;
		} else if (this.getSign.size() > var.getSign.size()) {
			return 1;
		}
		return 0;
	}

	private void setText() {
		StringBuffer link = new StringBuffer();
		int index = 0;
		while(index < this.getSign.size()){
			if (index != 0 && this.getSign.get(index).dot == false) {
				link.append(" ");
			}
			link.append(this.getSign.get(index).someTxt);
			index++;
		}
		this.symb = link.toString();
	}

	public Statement(String wrd) {
		this.symb = wrd;
		this.getSign  = new ArrayList<Symbol>();
		String[] words = wrd.split("[ ] +");

		int indx = 0;
		while (indx < words.length){
			if (!words[indx].equals("")) {
				if (DELIMITERS.indexOf(words[indx].charAt(words[indx].length() - 1)) > -1) {
					this.getSign.add(new Symbol(words[indx].substring(0, words[indx].length() - 1)));
					this.getSign.add(new Symbol("" + words[indx].charAt(words[indx].length() - 1)));
				} else {
					this.getSign.add(new Symbol(words[indx]));
				}
			}
			indx++;
		}
		System.out.println("\n");
		System.out.println("\n");
	}

	@Override
	public String toString() {
		return symb.toString() + "\n";
	}
}
