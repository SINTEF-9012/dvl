package no.sintef.dvl.engine.test.common;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import no.sintef.dvl.engine.Iterator;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import static java.util.Arrays.asList;

/**
 * Specification of the cursor
 */
public class IteratorTest {

    @Test
    public void shouldEnableIterationOverASingletonCollection() {
        verifyIteration(asList(1), allItems(), asList(1));
    }

    @Test
    public void shouldEnableRestrictingTheIteration() {
        verifyIteration(asList(1, 2, 3, 4, 5), onlyEvenItems(), asList(2, 4));
    }

    @Test
    public void shouldPreventIteratingOverEmptyList() {
        verifyIteration(new ArrayList<>(), allItems(), new ArrayList<>());
    }

    @Test(expected = AssertionError.class)
    public void shouldRejectNullListOfItems() {
       new Iterator<>(null);
    }

    private void verifyIteration(List<Integer> list, Function<List<Integer>, Integer> selection, List<Integer> expectation) {
        final Iterator<Integer> cursor = new Iterator<>(list, selection);

        final List<Integer> iteration = new ArrayList<>();
        while (cursor.hasNext()) {
            iteration.add(cursor.next());
            cursor.remove();
        }

        assertThat(iteration, is(equalTo(expectation)));
    }

    protected static Function<List<Integer>, Integer> onlyEvenItems() {
        return (List<Integer> items) -> {
            if (items.isEmpty()) {
                return null;
            }
            for (Integer i : items) {
                if (i % 2 == 0) {
                    return i;
                }
            }
            return null;
        };
    }

    protected static Function<List<Integer>, Integer> allItems() {
        return (List<Integer> items) -> {
            if (items.isEmpty()) {
                return null;
            }
            return items.get(0);
        };
    }

}
