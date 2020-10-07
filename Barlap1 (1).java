import java.util.*;
import java.io.*;

public class Barlap1 {

    /*
    *This program generates n sorted integers, prints array, and merges sorted ranges within the array.
  */


    PrintStream prt = System.out;


    int n, k, p, q, r;
    int[] arr;

    Barlap1() { //class constructor

          /*
        This constructor reads 5 integers n, k, p, q and r from any data file.
        n>20, p<=q<=r<=n and k >=10 and some explanation about the program.
        See constructor for count program at the end of 9/16 lecture
         */

        try {
            Scanner inf = new Scanner(System.in);

            prt.print("\t Project 1's program is designed to generate n random numbers, as well as " +
                    "\n\t sorted random ints with no range limitation. Merge includes newly generated random int" +
                    "\n\t Project 1 by: John Barlaan" +
                    "Date: 9/27/2010");
            n = inf.nextInt();
            k = inf.nextInt();
            p = inf.nextInt();
            q = inf.nextInt();
            r = inf.nextInt();

            //allocate space for array
            arr = new int[n]; 

            //output of input obtained from file
            prt.printf("\n\tn = %3d, k = %4d, p = %4d, q = %4d, r = %4d\n", n, k, p, q, r);

            //close file inf
            inf.close();
        } catch (Exception e) {
            prt.printf("\nError Handled. Read Exception: %s", e);
        }
    } //end constructor

    private void generate(int[] arr, int n) {
        /*
        This method generates n-m+1 random integers (no range limitation) and
        stores them in an array arr;
         */
        System.out.println("\n\ngenerate Method Called");
        int j;

        Random rd = new Random();
        for (j = 0; j < n; j++) {
            arr[j] = rd.nextInt(100); //stores a random INT in the array
        }




    } //end generate


    private void generatesorted(int arr[], int a, int b) {
    /*
    This method  generates n-m+1 sorted integer ( no range limitation) and
    stores them in array arr[m] thru arr[n], (m<=n);
    */
System.out.println("\n\ngeneratesorted Method Called");
        int j;

        Random rd = new Random();
        arr[a] = rd.nextInt(100); //set initial arr[0] with random integer up to 1000

        for (j = a + 1; j <= b; j++) { //to set every array position up to n with a random int up to 100 added on through each iteration.
            arr[j] = arr[j - 1] + rd.nextInt(100);

        }
    }



    private void merge(int arr[], int a,  int b, int c) {//p1.arr, p1.p, p1.q, p1.r
    /*
    This method merges sorted elements of array arr from a thru b and from
    b+1 thru c. See exercise-4 of 9/14 lecture notes.
     */
        // p1.merge(p1.p, p1.q, p1.r);
        System.out.println("\n\nmerge Method Called");
    int subarr1size =  b - a + 1;
    int subarr2size = c - b;


    //temp array
        int[] leftArr  = new int[subarr1size];
        int[] rightArr = new int[subarr2size];



        for (int i = 0; i < subarr1size; i++) {
            leftArr[i] = arr[a+i];
        }
        for (int x = 0; x < subarr2size; x++){
            rightArr[x] = arr[b+1+x];
        }

        //merging temp arrays
        //index of temp sub arrays
        int i = 0;
        int k = 0;

        //index merged subarr
        int j = a;

        while(i < subarr1size && k < subarr2size) {
            if (leftArr[i] <= rightArr[k]){
                arr[j] = leftArr[i];
                i++;
            }
            else {
                arr[j] = rightArr[k];
                k++;
            }
            j++;
        }

        //copy remaining elements of leftArr
        while (i <subarr1size) {
            arr[j] = leftArr[i];
            i++;
            j++;
        }

        //copy remaining elements of rightArr

        while(k < subarr2size) {
            arr[j] = rightArr[k];
            k++;
            j++;
        }


    } //end merge





    private void printarr(int arr[], int g) {
    /*
    This method prints elements of array arr with n integer elements
    Formatted k elements pr line
    */
        System.out.println("1st printarr Method Called");
        int j;

        prt.printf("\n\tArray elements are as follows:\n\t");
        for (j = 0; j < g; j++) {
            prt.printf(" %4d", arr[j]);
            if ((j + 1) % k == 0) {
                prt.printf("\n\t");
            }
        }
    }//end printarr

    private void printarr(int arr[], int a, int b){
        // print arr[a] through arr[b], formatted k elements  per line.
        System.out.println("2nd printarr Method Called");
       int j;
       prt.printf("\n\tArray elements are as follows:\n\t");
       for (j = a; j <= b; j++) {
           prt.printf(" %4d", arr[j]);

           if ((j+1)%k == 0) {
               prt.printf("\n\t");
           }
       }

    }


//main program

    public static void main(String args[]) throws Exception {
        //Create an instance of all sorts class
        Barlap1 p1 = new Barlap1();

        //generate n random no.'s and print them, formatted k  numbers per line;
         p1.generate(p1.arr,p1.n);
         p1.printarr(p1.arr, p1.n);

        System.out.println(" ");
        System.out.println(" ");

        //Generate n sorted random no'.s and print them, formatted k numbers per line.
        p1.generatesorted(p1.arr, 0, p1.n-1);
        p1.printarr(p1.arr, p1.n);

        System.out.println(" ");
        System.out.println(" ");

        //Generate sorted random numbers and store them in arr[p] thru arr[q]
        p1.generatesorted(p1.arr, p1.p, p1.q);
        p1.printarr(p1.arr, p1.p, p1.q);

        System.out.println(" ");
        System.out.println(" ");

        //Generate sorted random numbers and store them in arr[q+1] thru arr[r]
        p1.generatesorted(p1.arr,p1.q + 1, p1.r);
        p1.printarr(p1.arr, p1.q+1, p1.r);

        //Merge sorted elements arr[p] thru arr[q] and arr[q+1] thru arr[r]
        p1.merge(p1.arr, p1.p, p1.q, p1.r);
        p1.printarr(p1.arr,p1.n);
    } //end main




}

/* SAMPLE OUT PUT WITH VALUES 30 10 8 15 25
*

 Project 1's program is designed to generate n random numbers, as well as
         sorted random ints with no range limitation. Merge includes newly generated random int
         Project 1 by: John BarlaanDate: 9/27/2010
        n =  30, k =   10, p =    8, q =   15, r =   25


generate Method Called
1st printarr Method Called

        Array elements are as follows:
           97   13   70   31   38   13   79   83   14    9
           84   81   52   15   76   69   96   95   47   51
           87   76   16   62   52   84   53   62   73   59




generatesorted Method Called
1st printarr Method Called

        Array elements are as follows:
           77  110  131  191  257  269  342  344  419  475
          549  571  580  645  649  691  767  816  886  919
          998 1091 1105 1200 1295 1387 1456 1482 1577 1595




generatesorted Method Called
2nd printarr Method Called

        Array elements are as follows:
           83  132
          182  219  314  341  366  448



generatesorted Method Called
2nd printarr Method Called

        Array elements are as follows:
           52  135  216  284
          319  339  412  491  523  550

merge Method Called
1st printarr Method Called

        Array elements are as follows:
           77  110  131  191  257  269  342  344   52   83
          132  135  182  216  219  284  314  319  339  341
          366  412  448  491  523  550 1456 1482 1577 1595
*/
