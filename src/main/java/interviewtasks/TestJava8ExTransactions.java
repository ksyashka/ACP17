package interviewtasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestJava8ExTransactions {

    private static class Transaction {

        public static final int SIMPLE = 1;
        public static final int ADVANCED = 2;

        private String value;
        private int type;
        private int id;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static void main(String[] args) {


        List transactions = new ArrayList<>();

     /*   List simpleTransactions = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getType() == Transaction.SIMPLE) {
                simpleTransactions.add(t);
            }
        }
        Collections.sort(simpleTransactions, new Comparator() {
            public int compare(Transaction t1, Transaction t2) {
                return t2.getValue().compareTo(t1.getValue());
            }
        });
        List transactionIds = new ArrayList<>();
        for (Transaction t : simpleTransactions) {
            transactionIds.add(t.getId());
        }

        // DO STREAM PROCESSING INSTEAD OF THE CODE ABOVE
*/
    }
}
