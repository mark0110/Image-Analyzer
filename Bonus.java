import java.util.Scanner;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class Bonus {

	public static void main(String[] args) throws IOException{
	
	Scanner labelsTest = new Scanner(new File("labels.txt"));
	double correctPre=0, numPre=0;
	while(labelsTest.hasNext()){
		numPre++;
		if(prediction("numbers/"+labelsTest.next())==labelsTest.nextInt())
			correctPre++;
	}
	System.out.println("The accuracy is: "+((correctPre/numPre)*100)+"%");
	}
	
	public static int prediction(String fileTested) throws IOException{
		File file1 = new File("hidden-weights.txt");
		File file2 = new File("output-weights.txt");
		Scanner hiddenW = new Scanner(file1);
		Scanner hiddenO = new Scanner(file2);
		double[] weightW = new double[785];
		double[] weightO = new double[301];
		double[] hiddenResult = new double[300];
		double[] result = new double[10];
		
		BufferedImage img = ImageIO.read(new File(fileTested));
		double[] dummy = null;
		double[] input = img.getData().getPixels(0, 0, img.getWidth(),
		img.getHeight(), dummy);
		for(int i=0; i<input.length; i++){
			input[i]=input[i]/255;
		}
		
		for(int i=0; i<hiddenResult.length; i++){
			for(int k=0; k<weightW.length; k++){
				weightW[k]=hiddenW.nextDouble();
				
			}
			
			hiddenResult[i]=perceptron(input, weightW);
		}
		
		for(int i=0; i<result.length; i++){
			for(int k=0; k<weightO.length; k++){
				weightO[k]=hiddenO.nextDouble();
			}
			result[i]=perceptron(hiddenResult, weightO);
		}
		
		double max=result[0];
		int count=0;
		for(int i=0; i<result.length; i++){
			if(result[i]>max){
				max=result[i];
				count=i;
			}
				
		}
		return count;
		
		
	}
	
	public static double perceptronSigma(double[] X, double[] weight){
		double result=0;
		for(int i=0; i<X.length; i++){
			result=result+X[i]*weight[i];
		}
		result=result+weight[weight.length-1];
		return result;
	}
	
	public static double perceptron(double[] X, double[] weight){
		double result=0;
		result=1/(1+Math.pow(Math.E, perceptronSigma(X, weight)*-1));
		return result;
	}
	
}
