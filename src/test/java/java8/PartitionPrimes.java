package java8;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @author Chuck
 * @since 4/9/2021
 * @version 0.0.1
 *
 *          TODO
 **/
public class PartitionPrimes {

}

class PrimeNumbersCollector implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {

    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier() {
        // return () -> new HashMap<Boolean, List<Integer>>() {
        // {
        // put(Boolean.TRUE, new ArrayList<Integer>());
        // put(Boolean.FALSE,new ArrayList<Integer>())
        // }
        // };
        return null;
    }

    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        // TODO Auto-generated method stub
        return null;
    }
}