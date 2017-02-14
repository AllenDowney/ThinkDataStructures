import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class StopWords {
	private static final Set<String> STOPWORDS = new HashSet<>();
	private static boolean populated = false;

	public static Set<String> getStopWords() throws IOException {
		if (!populated) {
			populateSet();
			populated = true;
		}
		return STOPWORDS;
	}

	private static void populateSet() throws IOException {
		String slash = File.separator;
		String filename = System.getProperty("user.dir") + slash +
				"resources" + slash + "stopwords.txt";

		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + filename);
			return;
		}

		String line = br.readLine();
		while (line != null) {
			STOPWORDS.add(line);
			line = br.readLine();
		}
		br.close();
	}

	public static void main(String[] args) throws IOException {
		getStopWords();

        if (STOPWORDS.size() == 173) {
			System.out.println("Successfully loaded stop words");
		}
	}
}
