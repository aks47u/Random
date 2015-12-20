import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class SavingExample {
	public static void main(String[] args) {
		sample(3);
	}

	private static void sample(int limit) {
		ArrayList<String> output = new ArrayList<String>();

		for (int i = 0; i <= limit; i++) {
			for (int j = 0; j <= limit; j++) {
				output.add(i + " * " + j + " = " + (i * j));
			}
			
			try {
				saveFile("sample_" + i + "_timesTables.txt", output);
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			
			output.clear();
		}
	}

	private static void saveFile(String file, ArrayList<String> alist)
			throws FileNotFoundException, IOException {
		System.out.println("Saving file:\t" + file);
		File aFile = new File(file);
		Writer output = null;

		try {
			output = new BufferedWriter(new FileWriter(aFile));

			for (int i = 0; i < alist.size(); i++) {
				output.write(alist.get(i) + "\n");
			}
		} finally {
			if (output != null) {
				output.close();
			}
		}

		System.out.println("Saved file:\t" + file);
	}
}
