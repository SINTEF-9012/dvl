package no.sintef.dvl.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Iterate over task as they become ready
 *
 * @param <T>
 */
public class Iterator<T> {

    private final List<T> remainingItems;
    private final Function<List<T>, T> selectNext;
    private T currentItem;

    public Iterator(List<T> elements) {
        this(elements,
                (List<T> items) -> {
                    if (items.isEmpty()) {
                        return null;
                    }
                    return items.get(0);
                });
    }

    public Iterator(List<T> items, Function<List<T>, T> selectNext) {
        assert items != null: "Invalid items ('null' found)";
        assert selectNext != null: "Invalid selector function ('null' found)";
        
        this.selectNext = selectNext;
        this.remainingItems = new ArrayList<>(items);
        currentItem = selectNext.apply(remainingItems);
    }
    
    /**
     * @return true if there is other items in this iteration
     */
    public final boolean hasNext() {
        return selectNext.apply(remainingItems) != null;
    }

    /**
     * @return the current item of this iteration
     */
    public final T next() {
        currentItem = selectNext.apply(remainingItems);
        return currentItem;
    }

    /**
     * Move to the next item in this iteration.
     *
     * @throws IllegalStateException when there is no such an item
     */
    public final void remove() {
        if (!hasNext()) {
            throw new IllegalStateException("No 'next' element, the iteration cannot move any further.");
        }
        remainingItems.remove(currentItem);
    }

}
