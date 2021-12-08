package operation;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
/**
 * The List Test class calls the add, get, delete methods for ArrayList
 * and LinkedList to evaluate performance. The result is entered in the table.
 * @author Alsu
 */
public class ListTest {
    /**
     * Number of method calls
     */
    public long iter;
    /**
     * Results table
     */

    private String[][] resultsTable;
    /**
     * The beginning of the countdown
     */
    private long startTime;
    /**
     * The end of the countdown
     */
    private long endTime;

    /**
     * Constructor ListTest
     * @param iter Number of method calls
     */
    public ListTest(long iter) {
        this.iter = iter;
        long startTime = 0;
        long endTime = 0;
        resultsTable = new String[][]{
                {" ", "Add", "Get", "Delete", "Repetitions"},
                {"ArrayList", "", "", "", String.valueOf(iter)},
                {"LinkedList", "", "", "", String.valueOf(iter)}};
    }

    /**
     * Method calling add, delete, get methods
     * @throws Exception
     */
    public void startTest() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        resultsTable[1][1] = String.valueOf(testAdd(arrayList));
        resultsTable[2][1] = String.valueOf(testAdd(linkedList));
        resultsTable[1][2] = String.valueOf(testGet(arrayList));
        resultsTable[2][2] = String.valueOf(testGet(linkedList));
        resultsTable[1][3] = String.valueOf(testDelete(arrayList));
        resultsTable[2][3] = String.valueOf(testDelete(linkedList));
    }
    /**
     * Method calling the add function
     * @param list List
     */
    private long testAdd(List<Integer> list) {
        if (!list.isEmpty()) {
            list.clear();
        }
        startTime = System.currentTimeMillis();
        for (int i = 0; i < iter; i++) {
            list.add(i);
        }
        endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    /**
     * Method calling the get function
     * @param list List
     * @throws Exception If list is empty
     */
    private long testGet(List<Integer> list) throws Exception {
        if (list.isEmpty()) {
            throw new Exception("The list is empty!");
        }
        startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    /**
     * Method calling the remove function
     * @param list List
     * @throws Exception If list is empty
     */
    private long testDelete(List<Integer> list) throws Exception {
        if (list.isEmpty()) {
            throw new Exception("The list is empty!");
        }
        startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
        }
        endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
    /**
     * Return results table
     */
    public String[][] table() {
        return resultsTable;
    }
    /**
     * ListTest the hash code of this object.
     * @return Hash code in integer.
     */
    @Override
    public int hashCode() {
        return (int) (5 * Math.round(iter) + startTime);
    }

    /**
     * A method for comparing two objects. Is overridden.
     * @param obj The object to be compared with the current object.
     * @return True if they are equal, otherwise false.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        ListTest that = (ListTest) obj;
        return Double.compare(that.iter, iter) == 0;
    }

}
