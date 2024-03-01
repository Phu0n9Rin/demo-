/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Q1 {
    //Change the name of input and output file based on practical paper
    String inputFile = "input.txt";
    String outputFile = "output.txt";

    //--VARIABLES - @STUDENT: DECLARE YOUR VARIABLES HERE:
	    String str[];
    ArrayList<Shape> list = new ArrayList<>();
    String result = "";



	//--FIXED PART - DO NOT EDIT ANY THINGS HERE--
	//--START FIXED PART--------------------------    
    String fi, fo;
    
    /**
     * Set input and output file for automatic rating
     * @param args path of input file and path of output file
     */
    public void setFile (String[] args){
        fi = args.length>=2? args[0]: inputFile;
        fo = args.length>=2? args[1]: outputFile;
    }
    
    /**
     * Reads data from input file
     */
    public void read(){
        try (Scanner sc  = new Scanner(new File(fi))){
    //--END FIXED PART----------------------------

            //INPUT - @STUDENT: ADD YOUR CODE FOR INPUT HERE:
            int n = Integer.parseInt(sc.nextLine());//n=3
            str = new String[n];
            for (int i = 0; i < n; i++) {
                str[i] = sc.nextLine();
            }


	//--FIXED PART - DO NOT EDIT ANY THINGS HERE--
	//--START FIXED PART--------------------------    
            sc.close();
        }catch(FileNotFoundException ex){
            System.out.println("Input Exception # " + ex);
        }
    }
    //--END FIXED PART----------------------------
    
    //ALGORITHM - @STUDENT: ADD YOUROWN METHODS HERE (IF NEED):
    

    
	//--FIXED PART - DO NOT EDIT ANY THINGS HERE--
	//--START FIXED PART--------------------------    
    /**
     * Main algorithm
     */
    public void solve(){
    //--END FIXED PART----------------------------

        //ALGORITHM - @STUDENT: ADD YOUR CODE FOR OUTPUT HERE:
               for (String s : str) {
            String w[] = s.trim().split("\\s+");
            if (w[0].equalsIgnoreCase("r")) {
                Rectangle r = new Rectangle(w[1], w[2], Double.parseDouble(w[3]), Double.parseDouble(w[4]));
                list.add(r);
                result += r.entryData() + "\n";

            } else if (w[0].equalsIgnoreCase("clear")) {
                list.clear();
                result += "------\n";
                result += "* Remove all\n";
            } else if (w[0].equalsIgnoreCase("print")) {
                result += "---Print---\n";
                if (list.isEmpty()) {
                    result += "Empty\n";
                } else {
                    for (Shape shape : list) {
                        result += shape.printData() + "\n";
                    }
                }
            }            else if (w[0].equalsIgnoreCase("c")) {
                Circle c = new Circle(w[1], w[2], Double.parseDouble(w[3]));
                list.add(c);
                result += c.entryData() + "\n";
        } else if (w[0].equalsIgnoreCase("GetRectangle")) {
                result += "---GetRectangle---\n";
                int count = 0;
                    for (Shape rectangle : list) {
                        if(rectangle instanceof Rectangle){
                            result += rectangle.printData()+"\n";
                            count+=1;
                        }
                        }                        if(count==0){
                            result+="Empty\n";
                    }                
            }
            else if (w[0].equalsIgnoreCase("GetCircle")) {
                result += "---GetCircle---\n";
                int count = 0;
                    for (Shape circle : list) {
                        if(circle instanceof Circle){
                            result += circle.printData()+"\n";
                            count+=1;
                        }                           
                        }                       if(count==0){
                           result+="Empty\n";

                    }
                
            }else if(w[0].equalsIgnoreCase("Sort")){
                result += "---Sort---\n";
                if (list.isEmpty()) {
                    result += "Empty\n";
                } else {
            Comparator<Shape> cm = new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                if (o1.getArea()> o2.getArea()) {
                    return 1;
                } else if (o1.getArea() < o2.getArea()) {
                    return -1;

                } else {
                    return 0;
                }
            }
        };
//         list.sort(cm);
            list.sort((o1,o2)-> Double.compare(o1.getArea(), o2.getArea()));
                    for (Shape shape : list) {
                        result += shape.printData() + "\n";
                    }
                }

            }else if (w[0].equalsIgnoreCase("GetMaxArea")) {
                result += "---GetMaxArea---\n";
                if (list.isEmpty()) {
                    result += "Empty\n";
                } else {
        double maxArea = list.get(0).getArea();
        for (Shape shape : list) {
            if (shape.getArea() > maxArea) {
                maxArea = shape.getArea();
            }
        }
        for (Shape shape : list) {
            if (shape.getArea() == maxArea) {
                result+=shape.printData()+"\n";
            }
        }
    }
            
            
                }
            } 

        


	//--FIXED PART - DO NOT EDIT ANY THINGS HERE--
	//--START FIXED PART-------------------------- 
    }
    
    /**
     * Write result into output file
     */
    public void printResult(){
	    try{
            FileWriter fw = new FileWriter(fo);
	//--END FIXED PART----------------------------
                
        	//OUTPUT - @STUDENT: ADD YOUR CODE FOR OUTPUT HERE:
            fw.write(result);



	//--FIXED PART - DO NOT EDIT ANY THINGS HERE--
	//--START FIXED PART-------------------------- 
            fw.flush();
            fw.close();
        }catch (IOException ex){
            System.out.println("Output Exception # " + ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Q1 q = new Q1();
        q.setFile(args);
        q.read();
        q.solve();
        q.printResult();
    }
	//--END FIXED PART----------------------------    
}
