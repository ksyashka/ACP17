package interviewtasks;

import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CalculateSumOfTree {


    private static class TNode {
        public int value;
        public List<TNode> subNodes;

        public TNode(int value) {
            this.value = value;
        }

        public TNode(int value, TNode... arrSubNodes) {
            this.value = value;
            this.subNodes = Arrays.asList(arrSubNodes);
        }

        @Override
        public String toString() {
            return "TNode value=" + value;
        }
    }

    public static int sumAllNodes(TNode root) {
        if (root == null) return 0;
        if (root.subNodes == null) return root.value;

        int result = root.value;
        for (TNode sub : root.subNodes) {
            result += sumAllNodes(sub);
        }

        return result;

    }

    public static TNode findBiggestNode(TNode root) {
        if (root == null) return null;
        if (root.subNodes == null) return root;

        List<TNode> elems = new ArrayList<>();

        for (TNode sub : root.subNodes) {
            elems.add (findBiggestNode(sub));
        }
        TNode biggest = root;
        for (TNode el:elems) {
            if (biggest.value<el.value) biggest = el;
        }

        return biggest;
    }

    public static int countAllNodes(TNode root) {
        if (root == null) return 0;
        if (root.subNodes == null) return 1;

        int result = 1;

        for (TNode sub : root.subNodes) {
            result += countAllNodes(sub);
        }

        return result;
    }


    public static void printAllNodes(TNode root) {
        System.out.println(root);
        if (root.subNodes != null)
            for (TNode sub : root.subNodes)
                printAllNodes(sub);
    }

    /*
    *
    *   10
    *       5
    *           2
    *           2
    *       5
    *           2
    *           2
    *       5
    *           2
    *
    *
    *  sum =
    *
    * */
    public static void main(String[] args) {

        TNode level21 = new TNode(555, new TNode(2), new TNode(2));

        TNode level22 = new TNode(250987, new TNode(2), new TNode(2000));

        TNode level23 = new TNode(87, new TNode(105));

        TNode level11 = new TNode(10, level21, level22, level23);

        System.out.println(sumAllNodes(level11));
        System.out.println(countAllNodes(level11));
        printAllNodes(level11);
        System.out.println(findBiggestNode(level11));

    }

}