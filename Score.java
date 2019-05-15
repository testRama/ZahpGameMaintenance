
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Score
{
	public static int score;
	public static long time;
	public static long startTime;
	public static long stopTime;
	public static DecimalFormat df = new DecimalFormat("#.00");
	private static final String FilenameS1 = "/Users/Rama/Documents/workspace/ZahpGame/TextFile : Pics/S1HighScore.txt";
	private static final String FilenameS2 = "/Users/Rama/Documents/workspace/ZahpGame/TextFile : Pics/S2HighScore.txt";
	private static Scanner inputFile;
	private String scoreText = "Score: ";
	private String arial = "arial";

	public int drawScore(Graphics graphics)
	{
		String a = Integer.toString(score);

		graphics.setColor(Color.BLACK);
		graphics.setFont(new Font(arial, Font.PLAIN, 20));
		graphics.drawString(scoreText, 1290, 740);

		graphics.setColor(Color.BLACK);
		graphics.setFont(new Font(arial, Font.PLAIN, 33));
		graphics.drawString(a, 1360, 740);
		return 0;
	}
	
	public String drawTime(Graphics graphics)
	{	
		long t2 = System.currentTimeMillis();
		long ts = getStartTime();
		String currTime = (df.format((double)(t2-ts)/1000));
		
		graphics.setColor(Color.BLACK);
		graphics.setFont(new Font(arial, Font.PLAIN, 33));
		graphics.drawString(scoreText, 1200, 740);

		graphics.setColor(Color.BLACK);
		graphics.setFont(new Font(arial, Font.PLAIN, 33));
		graphics.drawString(currTime, 1300, 740);
		return currTime;
	}
	
	public static void setStartTime(long startTimeSw){
		startTime = startTimeSw;
	}

	public static void setStopTime(long stopTimeSw){
		stopTime = stopTimeSw;
	}
	public static long getStopTime(){
		return stopTime;
	}
	public static long getStartTime(){
		return startTime;
	}
	
	public static String getTime(){
		
		long start =getStartTime();
		
		long stop = getStopTime();
	
		String currTime = ((df.format((double)(stop-start))));//1000
		return (currTime);
	}

	public static int getScore(){
		return score;
	}
	
	public static void writeToFileS1(String playerName, String difficulty, int score){
		String info;
		info = playerName + "," + difficulty + "," + score +"\n";
		
		try {
			FileWriter writeTo;
			writeTo = new FileWriter(FilenameS1, true);
			writeTo.append(info);
			writeTo.close();
		} catch (IOException e) {
			System.out.println("File not found for S1");
			e.printStackTrace();
		}
		
	}
	
	public static void writeToFileS2(String playerName, String difficulty,String score ){
		String info;
		info = playerName + "," + difficulty + "," + score + "," +"\n";

		try {
			FileWriter writeTo;
			writeTo = new FileWriter(FilenameS2, true);
			writeTo.append(info);
			writeTo.close();
		} catch (IOException e) {
			System.out.println("File not found for S2");
			e.printStackTrace();
		}
		
	}
	public static String[][] getFromFileS2(){ // Need storting 
		String info2D[][]=null;
		String sortedHighScore[][]=null;
		ArrayList <String>info2 = new ArrayList<String>();
	
		
		String[] arrFileS2 = null;
		String Line1;
	
		try {
			File readFromS1 = new File(FilenameS2);
			inputFile = new Scanner(readFromS1); 
			
			while (inputFile.hasNextLine()) {
				Line1 = inputFile.nextLine(); 
				arrFileS2 = Line1.split(","); 
				info2.add(arrFileS2[0]);
				info2.add(arrFileS2[1]);
				info2.add(arrFileS2[2]);
			}
			
			int size = (info2.size()/3);
			info2D=new String[size][3];
			int counter=0;
			for(int j=0;j<size;j++){
				info2D[j][0]=info2.get(counter);
				counter++;
				info2D[j][1]=info2.get(counter);
				counter++;
				info2D[j][2]=info2.get(counter);
				counter++;
			}
			
			sort(info2D,0,size);
			int size2 =0;
			
			if(size<10){
				size2=size;
			}
			if(size>10){
				size2=10;
			}
			sortedHighScore = new String[size2][3];
			
			for(int i=0; i<size2;i++){
				sortedHighScore[i][0]=info2D[i][0];
				sortedHighScore[i][1]=info2D[i][1];
				sortedHighScore[i][2]=info2D[i][2];
			}
			inputFile.close();
		}
		
		catch (IOException e) {
			
		}
		
		return sortedHighScore;
		
	}
	
	public static String[][] getFromFileS1(){ // Need storting 
		String info2D[][]=null;
		String sortedHighScore[][]=null;
		ArrayList <String>info = new ArrayList<String>();
		
		String[] arrFileS1 = null;
		String Line1;
	
		try {
			File readFromS1 = new File(FilenameS1);
			inputFile = new Scanner(readFromS1); 
			
			while (inputFile.hasNextLine()) {
				Line1 = inputFile.nextLine(); 
				arrFileS1 = Line1.split(","); 
				info.add(arrFileS1[0]);
				info.add(arrFileS1[1]);
				info.add(arrFileS1[2]);
			}
			
	
			int size = (info.size()/3);
			info2D=new String[size][3];
			int counter=0;
			for(int j=0;j<size;j++){
				info2D[j][0]=info.get(counter);
				counter++;
				info2D[j][1]=info.get(counter);
				counter++;
				info2D[j][2]=info.get(counter);
				counter++;
			}
			sort(info2D,0,size);
			int size2 =0;
			
			if(size<10){
				size2=size;
			}
			if(size>10){
				size2=10;
			}
			sortedHighScore = new String[size2][3];
			
			for(int i=0; i<size2;i++){
				sortedHighScore[i][0]=info2D[i][0];
				sortedHighScore[i][1]=info2D[i][1];
				sortedHighScore[i][2]=info2D[i][2];
			}
			inputFile.close();
		}
		
		catch (IOException e) {
			
		}
		
		return sortedHighScore;
		
	}
	
	private static void sort(String [][] info, int k, int h) {
		 int n = h; 
	        for (int i = 0; i < n-1; i++){ 
	            for (int j = 0; j < n-i-1; j++){
	                if (Integer.parseInt(info[j][2])< Integer.parseInt(info[j+1][2])) 
	                { 
		                  swap(info, (j+1), j);
	                }
	            }
	        }
	}

	private static void swap(String[][] arr, int i, int j) { // the rows
		String temp[][]=new String[1][3];
		
		temp[0][0]= arr[i][0];
		temp[0][1]= arr[i][1];
		temp[0][2]= arr[i][2];
		
		arr[i][0]= arr[j][0];
		arr[i][1]= arr[j][1];
		arr[i][2]= arr[j][2];
		
		arr[j][0]= temp[0][0];
		arr[j][1]= temp[0][1];
		arr[j][2]= temp[0][2];

	}
	
}