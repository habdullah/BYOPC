/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;
import java.util.*; 
/**
 *
 * @author hammad
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print("Enter No of PCs\n");
        Scanner scan = new Scanner(System.in);
        int p = scan.nextInt();
        if (p<1){
        System.out.print("No of PC's can't be less then 1.Exiting\n");
        return;
        }
        System.out.print("Enter No of stations\n");
        int s = scan.nextInt();
        
        int[] assembly1= new int[s];
        int[] assembly2= new int[s];
        int[] assembly3= new int[s];
        
        int[][] delay = new int[s][3];
        int[] fullpath1 = new int[s];
        int[] fullpath2 = new int[s];
        int[] fullpath3 = new int[s];
        int laneshift = 5; //5second lane shift time
        Random generator = new Random();  
        //now populate the delay array
        for (int j = 0; j<delay[0].length; j++){
            for (int i = 0; i<delay.length; i++){
                delay[i][j]= generator.nextInt(20) + 1;
            }
        }
        
        System.out.print("Delay array populated\n"); 
        //  int x = Math.min(delay[0][0], Math.min(delay[0][1], delay[0][2]));
        switch(p){
            case (1):
                assembly1[0] = 2 + delay[0][0];//2 is time to enter belt
                 System.out.println(p+" computers in 3 queue");
                break;
            case (2):
                assembly1[0] = 2 + delay[0][0];//2 is time to enter belt
                assembly2[0] = 2 + delay[0][1];//2 is time to enter belt
                System.out.println(p+" computers in 3 queue");
                break;
            case (3):
                assembly1[0] = 2 + delay[0][0];//2 is time to enter belt
                assembly2[0] = 2 + delay[0][1];//2 is time to enter belt
                assembly3[0] = 2 + delay[0][2];//2 is time to enter belt
                System.out.println(p+" computers in 3 queue");
                break;
            default:
                System.out.print("switch defaulting");
                break;
        }
        if f1[j-1] + a1,j <= f2[j-1] + t2,j-1 + a1,j
        then f1[j] ←- f1[j-1]+a1,j
        l1[j] ←- 1
        else f1[j] ←- f2[j-1] + t2,j-1 + a1,j
        l1[j] ←- 2

        for (int l = 1;l<s-1;l++){
        if (assembly1[l-1]+delay[0][l]<=assembly2[l-1]+delay[1][l]){
            assembly1[l] = assembly1[l-1]+delay[0][l];
            final
        }
        }
    }
    
}
