package lesson17;

public interface GenericProcessor<K> {
    K apply(K s);
}
