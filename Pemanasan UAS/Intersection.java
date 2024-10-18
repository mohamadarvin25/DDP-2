import java.util.LinkedList;

public class Intersection<E> {
    public static <E> LinkedList<E> intersection(LinkedList<E> fstSet, LinkedList<E> sndSet) {

        // lengkapi
        LinkedList<E> intersection = new LinkedList<E>();
        for(int i = 0; i< fstSet.size(); i++){
            for (int j = 0; j < sndSet.size(); j++){
                if (fstSet.get(i) == sndSet.get(j)){
                    intersection.add(fstSet.get(i));
                    break;
                }
            }
        }
        return intersection;
    }
}
