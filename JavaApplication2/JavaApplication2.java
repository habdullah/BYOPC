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
        if (p>3 || p<1){
        System.out.print("No of PC's can't be less then 1 or greater than 3.Exiting\n");
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
        

        for (int l = 1;l<s-1;l++){
            //minimum of the three
             assembly1[l] = Math.min(assembly1[l-1]+delay[l][0], Math.min(assembly2[l-1]+delay[l][1]+laneshift,assembly3[l-1]+delay[l][2]+laneshift));
            //path insert 
            if (assembly1[l] == assembly1[l-1]+delay[l][0]){
                fullpath1[l] = 1;
            }
            if (assembly1[l] == assembly2[l-1]+delay[l][1]){
                
                fullpath1[l] = 2;
            }
            if (assembly1[l] == assembly3[l-1]+delay[l][2]){
                
                fullpath1[l] = 3;
            }
            
            //minimum of the three
            if(p>1){
             assembly2[l] = Math.min(assembly2[l-1]+delay[l][1], Math.min(assembly1[l-1]+delay[l][0]+laneshift,assembly3[l-1]+delay[l][2]+laneshift));
            //path insert 
            if (assembly2[l] == assembly2[l-1]+delay[l][1]){
                fullpath2[l] = 2;
            }
            if (assembly2[l] == assembly1[l-1]+delay[l][0]+laneshift){
                fullpath2[l] = 1;
            }
            if (assembly2[l] == assembly3[l-1]+delay[l][2]+laneshift){
                fullpath2[l] = 3;
            }
            }
            
            if(p>2){
            //minimum of the three
             assembly3[l] = Math.min(assembly3[l-1]+delay[l][2], Math.min(assembly1[l-1]+delay[l][0]+laneshift,assembly2[l-1]+delay[l][1]+laneshift));
            //path insert 
            if (assembly3[l] == assembly3[l-1]+delay[l][2]){
                fullpath3[l] = 3;
            }
            if (assembly3[l] == assembly1[l-1]+delay[l][0]+laneshift){
                fullpath3[l] = 1;
            }
            if (assembly3[l] == assembly2[l-1]+delay[l][1]+laneshift){
                fullpath3[l] = 2;
            }
            }
        }
        
        int Fstar = Math.min(assembly1[s-1]+10, Math.min(assembly2[s-1]+10,assembly3[s-1]+10));
        int Lstar;
        if (Fstar == assembly1[s-1]+10){
                Lstar=1;
            }
            if (Fstar == assembly2[s-1]+10){
                Lstar=2;
            }
            if (Fstar == assembly3[s-1]+10){
                Lstar=3;
            }
        
        System.out.println("Optimal path for PC1:\n");
        System.out.println(Arrays.toString(fullpath1));
        
        System.out.println("\nOptimal path for PC2:\n");
        System.out.println(Arrays.toString(fullpath2));
        
        System.out.println("\nOptimal path for PC3:\n");
        System.out.println(Arrays.toString(fullpath3));
        
        
            
            
         
    }
    
}
