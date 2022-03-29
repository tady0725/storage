import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class read {
	static Set<Integer> readfile(String url) throws IOException {
		HashMap<String, String> dict1;
		dict1 = create_dic();
		Set<Integer> set_a = new HashSet<>();
		Set<Integer> set_b = new HashSet<>();
		Set<Integer> set_c = new HashSet<>();
		try (InputStreamReader isr2 = new InputStreamReader(new FileInputStream(url), "UTF-8");
				BufferedReader read2 = new BufferedReader(isr2);) {

			String line2;
			while ((line2 = read2.readLine()) != null) {
				Set<String> A;
				A = A_answer(line2);
				String wds = line2.replaceAll(" ", "");
				String wd = wds.substring(0, wds.length() - 1);
				int L = (wd.length());
				Set<String> B_answer = new HashSet<>();
				int start = 0, end = L, reset_index = L;

				// 第一筆匹配到
				String first = wd.substring(start, end);
				boolean status_first = dict1.containsKey(first);
				if (first.length() == reset_index && status_first == true) {
					int fl = first.length();
					String fp = Integer.toString(start);
					int endindex_f = start + fl - 1;
					String end_f = Integer.toString(endindex_f);
					String fn = fp + "," + end_f;
					B_answer.add(fn);
					continue;
				}

				while (true) {
					String s = wd.substring(start, end);
					boolean status = dict1.containsKey(s);
					if (status == true) {
						int get_l = s.length();
						String get_p = Integer.toString(start);
						int endindex_get = start + get_l - 1;
						String end_get = Integer.toString(endindex_get);
						String get_n = get_p + "," + end_get;
						B_answer.add(get_n);
						end = reset_index;
					}

					else {
						end -= 1;
						if (end == start + 1) {
							int l_ = s.length();
							String p_ = Integer.toString(start);
							int endindex_ = start + l_ - 1;
							String end_ = Integer.toString(endindex_);
							String _n = p_ + "," + end_;
							B_answer.add(_n);
							end = reset_index;
							if (start == L - 1) {
								break;
							}

						}

					}

				}
				Set<String> A_B;
				A_B = compare(A, B_answer);
				set_a.add(A.size());
				set_b.add(B_answer.size());
				set_c.add(A_B.size());

			}
		}

		return set_a;
	}

	static Set<String> A_answer(String sent) {
		String[] ws = sent.split(" ");
		Set<String> index = new HashSet<>();
		int pointer = 0;
		for (String w1 : ws) {
			int l = w1.length();
			String p = Integer.toString(pointer);
			int endindex = pointer + l - 1;
			String end = Integer.toString(endindex);
			String n = p + "," + end;
			index.add(n);
			pointer += l;
		}

		return index;

	}

	static Set<String> compare(Set<String> a, Set<String> b) {

		a.retainAll(b);
		return a;
	}

	// word dictionary
	static HashMap<String, String> create_dic() throws IOException {
		String ch = "";

		String file = "C:\\Users\\admin\\Downloads\\lexicon1_raw_nosil.txt";
		InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
		try (BufferedReader read = new BufferedReader(isr)) {
			String line;

			HashMap<String, String> dict = new HashMap<String, String>();
			while ((line = read.readLine()) != null) {
				line = line.replace("\n", "");
				String s[] = line.split(" ");
				// System.out.println(s[0] + s[1]);
				if (s.length > 1) {
					ch = s[0];
					dict.put(ch, ch);
				} else {
					continue;
				}
			}

			return dict;
		}

	}

}

class RunnableDemo implements Runnable {

	public void run() {
		String file = "D:\\DESKTOP\\NLP course\\work 1\\t1.txt";

	}

	public void start() {

		run();

	}
}

class RunnableDemo2 implements Runnable {

	public void run() {
		String file = "D:\\DESKTOP\\NLP course\\work 1\\t2.txt";

	}

	public void start() {

		run();

	}

}

class RunnableDemo3 implements Runnable {

	public void run() {
		String file = "D:\\DESKTOP\\NLP course\\work 1\\t3.txt";

	}

	public void start() {
		System.out.println("Starting ");
		run();

	}

}

class RunnableDemo4 implements Runnable {

	public void run() {
		String file = "D:\\DESKTOP\\NLP course\\work 1\\t4.txt";

	}

	public void start() {
		System.out.println("Starting ");
		run();

	}

}

public class multithread {

	public static void main(String args[]) throws IOException {

		RunnableDemo R1 = new RunnableDemo();
		R1.start();
		RunnableDemo2 R2 = new RunnableDemo2();
		R2.start();
		RunnableDemo3 R3 = new RunnableDemo3();
		R3.start();
		RunnableDemo4 R4 = new RunnableDemo4();
		R4.start();
		// Set<Integer> q;
		// q = read.readfile(file2);

		// HashMap<String, String> dict1;
		// dict1 = create_dic();

		// System.out.println(dict1);
	}

}
