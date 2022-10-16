package ru.otus;


import java.util.AbstractMap;
import java.util.Map;
import java.util.TreeMap;

public class CustomerService {

    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны
    private final TreeMap<Customer, String> map = new TreeMap<>((o1, o2) -> {
        if (o1.getScores() == o2.getScores()) return 0;
        return o1.getScores() > o2.getScores() ? 1 : -1;
    });

    public Map.Entry<Customer, String> getSmallest() {
        //Возможно, чтобы реализовать этот метод, потребуется посмотреть как Map.Entry сделан в jdk
        return copyOf(map.firstEntry());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        return copyOf(map.higherEntry(customer));
    }

    private Map.Entry<Customer, String> copyOf(Map.Entry<Customer, String> source) {
        return source == null ? null :
                new AbstractMap.SimpleEntry<>(Customer.copyOf(source.getKey()), source.getValue());
    }

    public void add(Customer customer, String data) {
        map.put(customer, data);
    }
}
