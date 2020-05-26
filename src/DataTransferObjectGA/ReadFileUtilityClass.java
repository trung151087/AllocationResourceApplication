package DataTransferObjectGA;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//lớp tiện ích để đọc file và lấy các data theo từng tham số t,r,s,deadline... 
public class ReadFileUtilityClass {
	public static void main (String args[]) {
		getObjectFromFile("src/data/data.txt");
	}
    public static GAObjectData getObjectFromFile(String filePath) {
    	GAObjectData objResult = new GAObjectData();
    	try {
			String fileName = "src/data/data.txt";
			File file = new File(fileName);
			FileReader fr;
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			int countLine =0;
			int countLineForTask=0;
			int countLineForLEXP=0;
			int beginIndexForFloatMatrix=0;
			int finishIndexForFloatMatrix=0;
			while((line = br.readLine()) != null){
			    //process the line
			   // System.out.println(line);
			    if(countLine==0) {
			    	int[] temp = getParamIntArrayFromLine(line);
			    	objResult.t= temp[0];
			    	objResult.r = temp[1];
			    	objResult.s = temp[2];
			    	objResult.deadline =temp[3];
			    }
			    
			    if(countLine ==1) {
			    	objResult.duration =  getParamIntArrayFromLine(line);
			   	}
			    
			    if(countLine ==2) {
			    	objResult.edgeSum = getParamIntArrayFromLine(line)[0];
			    	beginIndexForFloatMatrix = objResult.edgeSum+3+objResult.t+1;
			    	finishIndexForFloatMatrix =objResult.edgeSum+3+objResult.t+1+objResult.r;
			    	objResult.adjB = new int[objResult.edgeSum+10];
			    	objResult.adjF = new int[objResult.edgeSum+10];
			    	objResult.TREQ = new int[objResult.t][objResult.s];
			    	objResult.LEXP = new float[objResult.r][objResult.s];
			    }
			    
			    if(countLine>=3&&countLine<=objResult.edgeSum+2) {
			    	System.out.println(countLine);
			    	objResult.adjB[countLine] = getParamIntArrayFromLine(line)[0];
			    	objResult.adjF[countLine] = getParamIntArrayFromLine(line)[1];
			    }
			    
			    if(countLine>=objResult.edgeSum+3&&countLine<=objResult.edgeSum+objResult.t) {
			    	System.out.println(countLine);
			    	int temp[] = getParamIntArrayFromLine(line);
			    	for(int i=0;i<temp.length;i++) {
			    		objResult.TREQ[countLineForTask][i]= temp[i];
			    	}
			    	countLineForTask++;
			    	
			    }
			    
//			    if(countLine>=beginIndexForFloatMatrix&&countLine<=finishIndexForFloatMatrix) {
//			    	float temp[] = getParamFloatArrayFromLine(line);
//			    	for(int i=0;i<temp.length;i++) {
//			    		objResult.LEXP[countLineForLEXP][i] = temp[i];
//			    	}
//			    	countLineForLEXP++;
//			    }
				countLine++;
			}
			System.out.println("Index:"+objResult.edgeSum +" \n "+objResult.adjB.length+"\n"
			+ objResult.adjF.length+ "\n "+objResult.TREQ.length+"  \n" +objResult.LEXP.length);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return objResult;
    }
    
    public static int[] getParamIntArrayFromLine(String line1) {
    	
    	String[] splited = line1.split(" ");
    	// System.out.println(splited.length);
    	int[] result = new int[splited.length];
    	for(int i=0;i<splited.length;i++) {
    		result[i] = Integer.parseInt(splited[i]);
    		// System.out.println(splited[i]);
    	}
    	return result;
    }
    public static float[] getParamFloatArrayFromLine(String line1) {
    	
    	String[] splited = line1.split(" ");
    	float[] result = new float[splited.length];
    	for(int i=0;i<splited.length;i++) {
    		result[i] = Float.parseFloat( splited[i]);
    	}
    	return result;
    }
}
