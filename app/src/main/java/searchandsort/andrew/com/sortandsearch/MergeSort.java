package searchandsort.andrew.com.sortandsearch;

/**
 * Created by andrew on 7/26/2017.
 */
/* Java program for Merge Sort */
public class MergeSort
{
    static int count = 0;

    private static void merge(int[] first, int[] second, int[] a)
    {
        int iFirst = 0; // Next element to consider in the first array
        int iSecond = 0; // Next element to consider in the second array
        int j = 0; // Next open position in a
        // As long as neither iFirst nor iSecond is past the end, move
        // the smaller element into a
        while (iFirst < first.length && iSecond < second.length)
        {
            if (first[iFirst] < second[iSecond])
            {
                a[j] = first[iFirst];
                iFirst++;
            } else
            {
                a[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }

        // Note that only one of the two loops below copies entries
        // Copy any remaining entries of the first array
        while (iFirst < first.length)
        {
            a[j] = first[iFirst];
            iFirst++;
            j++;
            count++;
        }
        // Copy any remaining entries of the second half
        while (iSecond < second.length)
        {
            a[j] = second[iSecond];
            iSecond++;
            j++;
            count++;
        }
    }

    public static void sort(int[] list)
    {
        int r = list.length;
        if (list.length <= 1)
        {
            return;
        }
        int[] left = new int[(r / 2)];
        int[] right = new int[r - r / 2];
        for (int i = 0; i < left.length; i++)
        {
            left[i] = list[i];
        }
        for (int i = 0; i < right.length; i++)
        {
            right[i] = list[left.length + i];
        }

        sort(left);
        sort(right);
        merge(left, right, list);
    }
}
