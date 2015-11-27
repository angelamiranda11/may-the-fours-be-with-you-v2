package game.utility;

import java.io.*;
import java.util.*;

import game.before.wordsBean;

public class FileManipulation {

	static String n;
	static int l;
	static int count;
	
	static wordsBean bean = new wordsBean();

	public static void dictionary(String source, String dest, String four,
			String csv) throws IOException {
		try {

			File fin = new File(source);
			FileInputStream fis = new FileInputStream(fin);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			FileWriter fstream = new FileWriter(dest, true);
			BufferedWriter out = new BufferedWriter(fstream);

			String aLine = null;

			while ((aLine = in.readLine()) != null) {
				// Process each line and add output to Dest.txt file
				if (aLine.length() == 4) {
					out.write(aLine + "\n");
				}
			}
			in.close();
			out.close();

			// fourletters.txt to fourletterscsv.csv
			File fin2 = new File(dest);
			FileInputStream fis2 = new FileInputStream(fin2);
			BufferedReader in2 = new BufferedReader(new InputStreamReader(fis2));

			FileWriter fstream2 = new FileWriter(four, true);
			BufferedWriter out2 = new BufferedWriter(fstream2);

			while ((n = in2.readLine()) != null) {
				l = n.length();
				out2.write(alphabetical() + "\n");

			}

			in2.close();
			out2.close();

		} catch (FileNotFoundException fnf) {
			System.out.println("File not found: " + fnf.getMessage());
		}
	}

	public static void PrintOutput(String dest, String four) throws IOException {
		try {
			BufferedReader dFile = new BufferedReader(new FileReader(dest));
			BufferedReader jFile = new BufferedReader(new FileReader(four));

			String csv = "D://fourletterscsv.csv";
			FileWriter fstream = new FileWriter(csv, true);
			BufferedWriter out = new BufferedWriter(fstream);

			ArrayList<String> jWordList = new ArrayList<String>();
			ArrayList<String> dWordList = new ArrayList<String>();

			HashSet<String> dWordListNoDuplicates = new HashSet<>();

			long startTime = System.currentTimeMillis();
			
			while (dFile.ready()) {
				String word = dFile.readLine();
				dWordList.add(word);
			}
			dFile.close();

			while (jFile.ready()) {

				String word = jFile.readLine();
				if (!dWordListNoDuplicates.contains(word)) {
					jWordList.add(word);
					dWordListNoDuplicates.add(word);
				}
			}
			jFile.close();

			Collections.sort(dWordList);
			Collections.sort(jWordList);

			String[] dArray = dWordList.toArray(new String[dWordList.size()]);
			String[] jArray = jWordList.toArray(new String[jWordList.size()]);

			dArray = canonArray(dArray);
			jArray = canonArray(jArray);

			for (int i = 0; i < jWordList.size(); i++) {
				String jWord = jArray[i];
				
				out.write(jWordList.get(i) + ",");
				
				for (int c = 0; c < dWordList.size(); c++) {
					String dWord = dArray[c];
					if (jWord.equals(dWord)) {
						out.write(dWordList.get(c) + ",");
					}

				}
				out.write("\n");

			}
			out.close();
			long endTime = System.currentTimeMillis();
			long ms = endTime - startTime;
			System.out
					.println("Elapsed time in seconds: " + ms / 1000.0 + "\n");
		} catch (FileNotFoundException fnf) {
			System.out.println("File not found: " + fnf.getMessage());
		}
	}

	public static String alphabetical() {
		StringBuilder builder = new StringBuilder();
		char b[] = new char[l];
		for (int i = 0; i < l; i++) {
			b[i] = n.charAt(i);
		}
		char temp;
		for (int j = 0; j < l - 1; j++) {
			for (int k = 0; k < l - 1 - j; k++) {
				if (b[k] > b[k + 1]) {
					temp = b[k];
					b[k] = b[k + 1];
					b[k + 1] = temp;
				}
			}
		}

		for (int m = 0; m < l; m++) {
			builder.append(b[m]);
		}
		String str = builder.toString();
		return str;
	}

	private static String toCanonical(String word) {
		char[] charArray = word.toCharArray();
		Arrays.sort(charArray);
		String charNewString = new String(charArray);
		return charNewString;
	}

	private static String[] canonArray(String[] Arr) {
		String[] newArr = new String[Arr.length];
		for (int i = 0; i < Arr.length; i++) {
			String temp = toCanonical(Arr[i]);
			newArr[i] = temp;

		}
		return newArr;
	}

	//gets random line at csv file, split the words then store in array
	public static String[] randomLine(String csv) throws IOException {
		String fileName = csv;
		File file = new File(fileName);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		List<String> lines = new ArrayList<String>();
		String line = reader.readLine();
		
		while(line !=null){
			lines.add(line);
			line = reader.readLine();
		}
		reader.close();
		
		Random rand = new Random();
		String randomString = lines.get(rand.nextInt(lines.size()));

		String[] tempLineArray = randomString.split(",");
		
	
		return tempLineArray;
	}
	
	public static String indexZeroWord(String[] tempLineArray){ //gets index[0] of the array 
		String indexZero = tempLineArray[0];
		
		return indexZero;
	}
	
	public static List<String> shuffleLetters(String[] splitLetter){
		List<String> shuffle = Arrays.asList(splitLetter);
		Collections.shuffle(shuffle);
		return shuffle;
	}
	
	public static boolean StringMatching(String[] arrayWord, String answer){
		for(int i=1; i<arrayWord.length; i++){
			int patternLength = answer.length();
			int arrayWordLength = arrayWord[i].length();
			int y;
			//String Matching (returns the index)
			for (int x=0; x<=arrayWordLength-patternLength; x++ ){
				
				for (y=0; y<patternLength; y++){
					if(arrayWord[i].charAt(x+y) != answer.charAt(y)){
						break;
					}
				}
				
				if (y==patternLength){
					System.out.println(answer + " is equal to " + arrayWord[i]);
					return true;
				}
				else{
					System.out.println(answer + " is NOT equal to " + arrayWord[i]);
					
				}
				
			}
			
		}
		return false;
	}
	
	
	public static void prepareGameFile(String filePath) {
		try {
			File file = new File(filePath);
			if(!file.isDirectory()) {
				if(file.exists()) {
					new RandomAccessFile(file, "rw").setLength(0);
					System.out.printf("prepareFile - Contents of file at %s deleted succesfully.%n", filePath);
				}
				else {
					throw new FileNotFoundException();
				}
			}
			else {
				System.err.printf("prepareFile - Path %s does not point to a normal file.", filePath);
			}
		} catch (FileNotFoundException e) {
			System.err.printf("prepareFile - File at path %s is not found.%n", filePath);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.printf("prepareFile - Contents of file at path %s is not deleted successfully.%n", filePath);
			e.printStackTrace();
		}
	}
}