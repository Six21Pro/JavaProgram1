import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class SortedBarChart
{

    /**
     * Read a sequence of positive integers from a given input file,
     * and construct an array list out of them.
     * 
     * @param fileName: the input file name
     * @return an array list of values
     */
    public static ArrayList<Integer> readValues(String fileName) throws FileNotFoundException
    {
        File f = new File(fileName); //The file read is the file specified by user input in main
        Scanner a=new Scanner(f);
        //....
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (a.hasNextInt()){//While loop adds next int from file to the arraylist
            list.add(a.nextInt());}
        System.out.println("Original list values: "+list);
        System.out.println(" ");//just for a new line
        return list;//newly formed arraylist<> list is returned
    }

    /**
     * Return the largest element in the array list.
     * 
     * @param list: the input list
     * @return the largest element in list
     */
    public static int findMax(ArrayList<Integer> list)
    {
        int max=0;
        for (int i=0;i<list.size();i++){
            int find= list.get(i);//find represents the current arraylist value
            if (find>max){//if find is greater than max, find replaces max
                max=find;
            }
            //...
        }
        System.out.println("my max: "+max); //FOR TESTING
        System.out.println(" ");//just for a new line
        return max;//int max is returned
    }

    /**
     * Prints a chart of asterisks with list value, based on the input list.
     * 
     * @param list: the input list
     */
    public static void printBarChart(ArrayList<Integer> list)
    {
        for (int i=0;i<list.size();i++){
        int find= list.get(i);
        for (int j=0;j<find;j++){
            System.out.print("*");//for i isn't equal to list element, a * is printed
        }
        System.out.println("  ("+find+")");
        }
        System.out.println(" ");//just for a new line
    }

    /**
     * Prints the list value in one line
     * 
     * @param list the input list
     */
    public static void printArrayValues(ArrayList<Integer> list) //Could go without using this method but I left it in just to print
    //the converted bar values
    {
        System.out.println("Converted Bar Values: "+list);
    }

    /**
     * Convert the list valeus into corresponding bar values proportion to the largest element in the list.
     * Truncate the fraction part if the resulting bar value is not a whole number
     * 
     * @param list the input list
     */
    public static ArrayList<Integer>  convertBarValues(ArrayList<Integer> list,int max)//I added variable max to the method
    // originally the method just accepted list
    {

        ArrayList<Integer> newList = new ArrayList<Integer>();

        for (int i=0;i<list.size();i++){
            int toConvert= list.get(i);//toConvert is equal to and represents the current list element
            toConvert= toConvert * 30/max;//toConvert is multiplied by 30/ then divided by the max
            newList.add(toConvert);//to convert is added to newList
        }
        //System.out.println("Converted Bar Values: "+newList);// I could have used this instead of printArrayValues()
        return newList;
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println("Please enter input1.txt, input2.txt, input3.txt, or the name of another file");
        
        Scanner c=new Scanner(System.in);
        String userfile= c.nextLine();// scanner recieves input in the form of a string named userfile
        File f = new File(userfile);//the user's input functions as the name of the file to be read 
        Scanner a=new Scanner(f);
        System.out.println(" ");//just for a new line
        
        ArrayList<Integer> list=readValues(userfile);//readValues() executed
        //System.out.println(list); FOR TESTING
        
        int max=findMax(list);//findMax() executed
        
        ArrayList<Integer> newlist=convertBarValues(list, max);//convertBarValues() executed //new arraylist in main called newlist
        
        printArrayValues(newlist);//printArrayValues() executed
        
        printBarChart(newlist);//printBarChart() executed on the unsorted array list
        
        Collections.sort(newlist);//newlist is 
        System.out.println("sorted newlist: "+newlist);
        
        printBarChart(newlist);//printBarChart() executed again on the sorted arraylist
    } 
}

