package lesson18;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Random;
import java.util.function.*;

public class CrazyLambdas {

    /**
     * Returns {@link Supplier} that always supply "Hello"
     *
     * @return a string supplier
     */
    public static Supplier<String> helloSupplier() {
        //throw new UnsupportedOperationException("It's your job to implement this method"); // todo
        return () -> "Hello";
    }

    /**
     * Returns a {@link Predicate} of string that checks if string is empty
     *
     * @return a string predicate
     */
    public static Predicate<String> isEmptyPredicate() {
        //throw new UnsupportedOperationException("It's your job to implement this method"); // todo
        return String::isEmpty;
    }

    /**
     * Return a {@link Function} that accepts {@link String} and returns that string repeated n time, where n is passed
     * as function argument
     *
     * @return function that repeats Strings
     */
    public static BiFunction<String, Integer, String> stringMultiplier() {
        //throw new UnsupportedOperationException("It's your job to implement this method"); // todo
        return String::repeat;
    }

    /**
     * Returns a {@link Function} that converts a {@link BigDecimal} number into a {@link String} that start with
     * a dollar sign and then gets a value
     *
     * @return function that converts adds dollar sign
     */
    public static Function<BigDecimal, String> toDollarStringFunction() {
        //throw new UnsupportedOperationException("It's your job to implement this method"); // todo
        return bigDecimal -> "$" + bigDecimal;

    }

    /**
     * Receives two parameter that represent a range and returns a {@link Predicate<String>} that verifies if string
     * length is in the specified range. E.g. min <= length < max
     *
     * @param min min length
     * @param max max length
     * @return a string predicate
     */
    public static Predicate<String> lengthInRangePredicate(int min, int max) {
        //throw new UnsupportedOperationException("It's your job to implement this method"); // todo
        return s -> s.length() >= min && s.length() < max;

    }

    /**
     * Returns a {@link Supplier} of random integers
     *
     * @return int supplier
     */
    public static IntSupplier randomIntSupplier() {
        //throw new UnsupportedOperationException("It's your job to implement this method"); // todo
        return () -> new Random().nextInt();
    }


    /**
     * Returns an {@link IntUnaryOperator} that receives an int as a bound parameter, and returns a random int
     *
     * @return int operation
     */
    public static IntUnaryOperator boundedRandomIntSupplier() {
        //throw new UnsupportedOperationException("It's your job to implement this method"); // todo
        return operand -> new Random().nextInt(operand);
    }

    /**
     * Returns {@link IntUnaryOperator} that calculates an integer square
     *
     * @return square operation
     */
    public static IntUnaryOperator intSquareOperation() {
        //throw new UnsupportedOperationException("It's your job to implement this method"); // todo
        return operand -> operand * operand;
    }

    /**
     * Returns a {@link LongBinaryOperator} sum operation.
     *
     * @return binary sum operation
     */
    public static LongBinaryOperator longSumOperation() {
        //throw new UnsupportedOperationException("It's your job to implement this method"); // todo
        return Long::sum;
    }

    /**
     * Returns a {@link ToIntFunction<String>} that converts string to integer.
     *
     * @return string to int converter
     */
    public static ToIntFunction<String> stringToIntConverter() {
        //throw new UnsupportedOperationException("It's your job to implement this method"); // todo
        return Integer::parseInt;
    }

    /**
     * Receives int parameter n, and returns a {@link Supplier} that supplies {@link IntUnaryOperator}
     * that is a function f(x) = n * x
     *
     * @param n a multiplier
     * @return a function supplier
     */
    public static Supplier<IntUnaryOperator> nMultiplyFunctionSupplier(int n) {
        //throw new UnsupportedOperationException("It's your job to implement this method"); // todo
        return () -> x -> x * n;
    }

    /**
     * Returns a {@link UnaryOperator} that accepts str to str function and returns the same function composed with trim
     *
     * @return function that composes functions with trim() function
     */
    public static UnaryOperator<Function<String, String>> composeWithTrimFunction() {
        //throw new UnsupportedOperationException("It's your job to implement this method"); // todo
        return stringStringFunction -> stringStringFunction.compose(String::trim);
    }

    /**
     * Receives a {@link Runnable} parameter, and returns a {@link Supplier<Thread>}. The thread will be started only
     * when you call supplier method {@link Supplier#get()}
     *
     * @param runnable the code you want to run in new thread
     * @return a thread supplier
     */
    public static Supplier<Thread> runningThreadSupplier(Runnable runnable) {
        //throw new UnsupportedOperationException("It's your job to implement this method"); // todo
        return () -> {
            Thread t = new Thread(runnable);
            t.start();
            return t;
        };
    }

    /**
     * Returns a {@link Consumer} that accepts {@link Runnable} as a parameter and runs in in a new thread.
     *
     * @return a runnable consumer
     */
    public static Consumer<Runnable> newThreadRunnableConsumer() {
        //throw new UnsupportedOperationException("It's your job to implement this method"); // todo
        return runnable -> new Thread(runnable).start();
    }

    /**
     * Returns a {@link Function} that accepts an instance of {@link Runnable} and returns a {@link Supplier} of a
     * started {@link Thread} that is created from a given {@link Runnable}
     *
     * @return a function that transforms runnable into a thread supplier
     */
    public static Function<Runnable, Supplier<Thread>> runnableToThreadSupplierFunction() {
        //throw new UnsupportedOperationException("It's your job to implement this method"); // todo
        return runnable -> () -> {
            Thread t = new Thread(runnable);
            t.start();
            return t;
        };
    }

    /**
     * Returns a {@link BiFunction} that has two parameters. First is {@link IntUnaryOperator} which is some integer function.
     * Second is {@link IntPredicate} which is some integer condition. And the third is {@link IntUnaryOperator} which is
     * a new composed function that uses provided predicate (second parameter of binary function) to verify its input
     * parameter. If predicate returns {@code true} it applies a provided integer function
     * (first parameter of binary function) and returns a result value, otherwise it returns an element itself.
     *
     * @return a binary function that receiver predicate and function and compose them to create a new function
     */
    public static BiFunction<IntUnaryOperator, IntPredicate, IntUnaryOperator> functionToConditionalFunction() {
        //throw new UnsupportedOperationException("It's your job to implement this method"); // todo
        return new BiFunction<IntUnaryOperator, IntPredicate, IntUnaryOperator>() {
            @Override
            public IntUnaryOperator apply(IntUnaryOperator intUnaryOperator, IntPredicate intPredicate) {
                return new IntUnaryOperator() {
                    @Override
                    public int applyAsInt(int operand) {
                        return intPredicate.test(operand) ? intUnaryOperator.applyAsInt(operand) : operand;
                    }
                };
            }
        };
    }

    /**
     * Returns a {@link BiFunction} which first parameter is a {@link Map} where key is a function name, and value is some
     * {@link IntUnaryOperator}, and second parameter is a {@link String} which is a function name. If the map contains a
     * function by a given name then it is returned by high order function otherwise an identity() is returned.
     *
     * @return a high-order function that fetches a function from a function map by a given name or returns identity()
     */
    public static BiFunction<Map<String, IntUnaryOperator>, String, IntUnaryOperator> functionLoader() {
        //throw new UnsupportedOperationException("It's your job to implement this method"); // todo
        return new BiFunction<Map<String, IntUnaryOperator>, String, IntUnaryOperator>() {
            @Override
            public IntUnaryOperator apply(Map<String, IntUnaryOperator> stringIntUnaryOperatorMap, String s) {
                return stringIntUnaryOperatorMap.containsKey(s) ? stringIntUnaryOperatorMap.get(s) : IntUnaryOperator.identity();
            }
        };
    }

    /**
     * Returns {@link Supplier} of {@link Supplier} of {@link Supplier} of {@link String} "WELL DONE".
     *
     * @return a supplier instance
     */
    public static Supplier<Supplier<Supplier<String>>> trickyWellDoneSupplier() {
        //throw new UnsupportedOperationException("It's your job to implement this method"); // todo
        return new Supplier<Supplier<Supplier<String>>>() {
            @Override
            public Supplier<Supplier<String>> get() {
                return new Supplier<Supplier<String>>() {
                    @Override
                    public Supplier<String> get() {
                        return new Supplier<String>() {
                            @Override
                            public String get() {
                                return "WELL DONE!";
                            }
                        };
                    }
                };
            }
        };
    }
}