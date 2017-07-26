package searchandsort.andrew.com.sortandsearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public String data = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                run();
            }
        });
    }












    public void run()
    {
        RunGUI runGUI;
        /*
        ((TextView) findViewById(R.id.output)).append(((TextView)findViewById(R.id.arrSize)).getText() + "\n");
        ((TextView) findViewById(R.id.output)).append(((TextView)findViewById(R.id.searchInt)).getText() + "\n");
        ((TextView) findViewById(R.id.output)).append(((TextView)findViewById(R.id.min)).getText() + "\n");
        ((TextView) findViewById(R.id.output)).append(((TextView)findViewById(R.id.max)).getText() + "\n");
        */

        int array = Integer.parseInt(((TextView)findViewById(R.id.arrSize)).getText().toString());
        int search = Integer.parseInt((String) ((TextView)findViewById(R.id.arrSize)).getText().toString());
        int min = Integer.parseInt((String) ((TextView)findViewById(R.id.arrSize)).getText().toString());
        int max = Integer.parseInt((String) ((TextView)findViewById(R.id.arrSize)).getText().toString());

        runGUI = new RunGUI(array, search, min, max);
    }











    class RunGUI {
        int arraySizes = 0;
        int searchNum = 0;
        int minRange = 0;
        int maxRange = 0;

        public RunGUI(int arrSize, int num2Search, int lowBound,
                      int hiBound) {

            // modify number of entries to sort and search through below
            arraySizes = arrSize;
            searchNum = num2Search;
            minRange = lowBound;
            maxRange = hiBound;

            long timeOfAction = 0;
            long timeOfSort = 0;
            long timeB4 = 0;
            long timeAfter = 0;

            int position = -1;
            int[] list = new int[arraySizes];
            int[] list1 = list;
            int[] list2 = list;
            int[] list3 = list;
            int[] list4 = list;

            ((TextView)findViewById(R.id.output)).setMovementMethod(new ScrollingMovementMethod());

            Random r = new Random();

            ((TextView) findViewById(R.id.output)).append("\nBuilding data...\n");

            for (int i = 0; i < list.length; i++) {
                list[i] = r.nextInt((maxRange - minRange) + 1) + minRange;
                list1[i] = list[i];
                list2[i] = list[i];
                list3[i] = list[i];
                list4[i] = list[i];
            }


            ((TextView) findViewById(R.id.output)).append("\nInsertion Sort....\n");


            timeB4 = System.currentTimeMillis();
            InsertionSort.sort(list2);
            timeAfter = System.currentTimeMillis();
            timeOfAction = timeAfter - timeB4;
            ((TextView) findViewById(R.id.output)).append("Insertion Sort took: " + timeOfAction + "ms\n");


            ((TextView) findViewById(R.id.output)).append("\nSelection Sort....\n");
            ((TextView) findViewById(R.id.output)).append("\nSelection Sort....\n");

            timeB4 = System.currentTimeMillis();
            SelectionSort.sort(list);
            timeAfter = System.currentTimeMillis();
            timeOfAction = timeAfter - timeB4;
            ((TextView) findViewById(R.id.output)).append("Selection Sort took: " + timeOfAction + "ms\n");

            ((TextView) findViewById(R.id.output)).append("\nMerge Sort....\n");

            timeB4 = System.currentTimeMillis();
            MergeSort.sort(list1);
            timeAfter = System.currentTimeMillis();
            timeOfAction = timeAfter - timeB4;
            ((TextView) findViewById(R.id.output)).append("Merge Sort took: " + timeOfAction + "ms\n");

            ((TextView) findViewById(R.id.output)).append("\nLinear Search....\n");

            timeB4 = System.currentTimeMillis();
            position = LinearSearch.search(list3, searchNum);
            timeAfter = System.currentTimeMillis();
            ((TextView) findViewById(R.id.output)).append("Found at position " + position + "\n");

            timeOfAction = timeAfter - timeB4;
            ((TextView) findViewById(R.id.output)).append("Linear search took: " + timeOfAction + "ms\n");

            ((TextView) findViewById(R.id.output)).append("\nArrays.Binary Search....\n");

            timeB4 = System.currentTimeMillis();
            Arrays.sort(list3);
            timeAfter = System.currentTimeMillis();
            timeOfSort = timeAfter - timeB4;
            timeB4 = System.currentTimeMillis();
            position = Arrays.binarySearch(list3, searchNum);
            timeAfter = System.currentTimeMillis();
            if (position < 0) {
                position = -1;
            }
            ((TextView) findViewById(R.id.output)).append("Found at position " + position + "\n");

            timeOfAction = timeAfter - timeB4;
            ((TextView) findViewById(R.id.output)).append("Binary search took: " + timeOfAction + "ms" + "\n+ " + timeOfSort
                    + "ms for Arrays.sort() to prepare data for search.\nTotal time of binary: "
                    + (timeOfSort + timeOfAction) + "ms\n");


            if (minRange > -185_000) {
                ((TextView) findViewById(R.id.output)).append("\nBinary Search....\n");


                timeB4 = System.currentTimeMillis();
                Arrays.sort(list4);
                timeAfter = System.currentTimeMillis();
                timeOfSort = timeAfter - timeB4;
                timeB4 = System.currentTimeMillis();
                position = BinarySearch.binarySearch(list4, 0, list4.length, searchNum);
                timeAfter = System.currentTimeMillis();
                if (position < 0) {
                    position = -1;
                }
                ((TextView) findViewById(R.id.output)).append("Found at position " + position);

                timeOfAction = timeAfter - timeB4;
                ((TextView) findViewById(R.id.output)).append("Binary search took: " + timeOfAction + "ms" + "\n+ " + timeOfSort
                        + "ms for Arrays.sort() to prepare data for search.\nTotal time of binary: "
                        + (timeOfSort + timeOfAction) + "ms");

            } else {
                ((TextView) findViewById(R.id.output)).append("\n\nThe Binary Search method did not work with this range.");
            }


        }

    }


}

