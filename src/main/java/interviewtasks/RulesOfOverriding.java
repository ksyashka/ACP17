package interviewtasks;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class RulesOfOverriding {

    class A {

        protected List findNames(String key) throws Exception {
            return null;
        }

    }

    // give advices for
    class B extends A {
        @Override
        public LinkedList findNames(String key) throws IOException{
            return null;
        }
        //can extend access modifier (to public), may return children of the List, may not throw exc or throw children of Exception, can change String agrument name



    }

}