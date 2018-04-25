import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
public class AnalyzeHeight {
	public static void main(String[] args) {
		File heightFile = new File("Height.txt");
		File weightFile = new File("Weight.txt");
		ArrayList<String> heightList = new ArrayList<String>();
		ArrayList<String> weightList = new ArrayList<String>();
		ArrayList<String> comboList = new ArrayList<String>();
		float weightAvg = 0;
		
		heightList = readHeightFile(heightFile);
		weightList = readWeightFile(weightFile);
		
		comboList = sortByHeight(heightList, weightList);
		for (int i = 0; i < comboList.size(); i++) {
			System.out.println(comboList.get(i));
		}
		weightAvg = analyzeComboList(comboList);
		System.out.println("Weight Average: " + weightAvg);
	}

	public static ArrayList<String> readHeightFile(File bmiFile) {
		FileReader importFile = null;
		BufferedReader readFile = null;
		String line = null;
		ArrayList<String> bmiList = null;
		
		try {
			importFile = new FileReader(bmiFile);
			readFile = new BufferedReader(importFile);
			readFile.readLine();
			bmiList = new ArrayList<String>();
			while ((line = readFile.readLine()) != null) {
				if(line.equals("")) {
					line = line.replace("", "-1");
				}
				bmiList.add(line);
			}
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("The file could not be found.");
		}
		return bmiList;
	}

	public static ArrayList<String> readWeightFile(File tgFile) {
		FileReader importFile = null;
		BufferedReader readFile = null;
		String line = null;
		ArrayList<String> tgList = null;
		
		try {
			importFile = new FileReader(tgFile);
			readFile = new BufferedReader(importFile);
			readFile.readLine();
			tgList = new ArrayList<String>();
			while ((line = readFile.readLine()) != null) {
				if(line.equals("")) {
					line = line.replace("", "-1");
				}
				tgList.add(line);
			}
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("The file could not be found.");
		}
		return tgList;
	}
	
	public static ArrayList<String> sortByHeight(ArrayList<String> bmiList, ArrayList<String> tgList) {
		ArrayList<String> combo = null;
		float tmp = 0;
		DecimalFormat rnd = new DecimalFormat("0.00");
		
		combo = new ArrayList<String>();
		for (int l = 0; l < bmiList.size(); l++) {
			tmp = Float.parseFloat(bmiList.get(l));
			combo.add(rnd.format(tmp) + ", " + tgList.get(l));
		}
		Collections.sort(combo);
		return combo;
	}
	
	public static Float analyzeComboList(ArrayList<String> comboList) {
		String tmp = null;
		String sub = null;
		String sub2 = null;
		float sum = 0;
		float avg = 0;
		int j = 0;
		
		for (int i = 0; i < comboList.size(); i++) {
			tmp = comboList.get(i);
			sub = tmp.substring(0, 4);
			sub2 = tmp.substring(7, tmp.length());
			if (tmp.contains("-1")) {
				continue;
			}
			else if (Float.parseFloat(sub) >= 30f) {
				sum = Float.parseFloat(sub2) + sum;
				//System.out.println(tmp.indexOf("70.25"));
				j++;
			}
		}
		avg = sum / j;
		return avg;
	}

}
