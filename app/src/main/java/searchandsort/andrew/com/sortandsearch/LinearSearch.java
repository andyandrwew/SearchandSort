package searchandsort.andrew.com.sortandsearch;

/**
 * Created by andrew on 7/26/2017.
 */

import java.util.Iterator;
import java.util.List;

public class LinearSearch
{
    // This function returns index of element x in arr[]
    public static int search(int[] list, int x)
    {
        int position = -1;

        for (int i = 0; i < list.length; i++)
        {
            ++position;
            if (list[i] == x)
                return position;
        }

        // return -1 if the element is not found
        return -1;
    }
}

