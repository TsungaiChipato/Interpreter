/*
 *
 * Elements: Identifier
 * Structure: no structure
 * Domain: Not larger than 20 identifiers, no duplicates of identifiers
 *
 * constructors
 *
 * Set();
 *   PRE  -
 *   POST - A new Set-object has been made and contains an array of size 20 getCharacter
 *          is of type identifier.
 *
 * Set(Set src);
 *   PRE  -
 *   POST - A new Set-object has been made and contains a copy of src.
 *
 */
public interface SetInterface<E extends Comparable>{
    SetInterface<E> init();
    /* PRE  -
    *  POST - A new Set-object has been made and contains an array of size 20 getCharacter
    *         is of type identifier.
    */

    boolean isFull();
    /* PRE  -
    *  POST - true: Counter is larger than or equal to 20.
    *         false: Counter is less than or equal to 20.
    */
    boolean contains(E d);
    int size();
    void pushIdentifier(E d);
    SetInterface<E> popIdentifier(E d);
    boolean goToLastElement();
    boolean goToFirstElement();
    boolean goToNextElement();
    SetInterface<E> union(SetInterface<E> set);
    SetInterface<E> intersection(SetInterface<E> set);
    SetInterface<E> difference(SetInterface<E> set);
    SetInterface<E> symdiff(SetInterface<E> set);

}
