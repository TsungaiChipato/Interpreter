public class Set<E extends Comparable<E>>implements SetInterface<E>{
    private ListInterface<E> list;
    private int size;
    Set(){
        init();
    }

    public SetInterface<E> init(){
        list = new List<E>();
        return this;
    }

    public boolean isFull() {
      if(list.isEmpty()){
        return true;
      }
      return false;
    }

    public boolean contains(E d){
      if(list.find(d)){
        return true;
      }
      return false;
    }

    public int size(){
      return list.size();
    }

    public void pushIdentifier(E d) {
      list.insert(d);
      size++;
    }

    public SetInterface<E> popIdentifier(E d) {
      if(list.find(d)){
        list.remove();
        size--;
      }
      // throw exception
      return this;
    }

    public boolean goToLastElement() {
      if(list.goToLast()){
        return true;
      }
      return false;
    }

    public boolean goToFirstElement(){
      if(list.goToFirst()){
        return true;
      }
      return false;
    }

    public boolean goToNextElement(){
      if(list.goToNext()){
        return true;
      }
      return false;
    }



    public SetInterface<E> union(SetInterface<E> set) {
      // SetInterface<E> result = new Set<E>();
      // result = set.copy();
      SetInterface<E> result = set.copy();
      this.list.goToFirst();
      if (!result.contains(this.list.retrieve())){
           result.insert(this.list.retrieve());
      }

      while(this.list.goToNext()){
        if (!result.contains(this.list.retrieve())){
             result.insert(this.list.retrieve());
          }
      }

      return result;

    }

    public SetInterface<E> difference(SetInterface<E> set) {
      SetInterface<E> tempSet = new Set<E>();
      return tempSet;
    }

    public SetInterface<E> intersection(SetInterface<E> set) {
      SetInterface<E> tempSet = new Set<E>();
      return tempSet;
    }

    public SetInterface<E> symdiff(SetInterface<E> set) {
      SetInterface<E> tempSet1 = new Set<E>();
      SetInterface<E> tempSet2 = new Set<E>();
      tempSet1 = this.union(set);
      tempSet2 = this.intersection(set);
      return tempSet1.difference(tempSet2);
    }

}
