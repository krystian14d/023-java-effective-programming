package useListsInsteadOfArrays;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

//that will not work:
//class Chooser {
//
//    private final Object[] choiceArray;
//
//    Chooser(Collection choices) {
//        this.choiceArray = choices.toArray();
//    }
//
//    public Object choose(){
//        Random rnd = ThreadLocalRandom.current();
//        return choiceArray[rnd.nextInt(choiceArray.length)];
//    }
//}

class Chooser<T> {
    private final List<T> choiceList;

    Chooser(Collection<T> choices) {
        this.choiceList = new ArrayList<>(choices);
    }

    public Object choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }
}
