package com.example.demo.java.stream;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

/**
 * @author: lihui
 * @date: 2020-06-08
 */
public class StreamStudy {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class StreamItem {
        Integer id;
        String name;
        Boolean sex;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class SumItem {
        Double d1;
        Double d2;
    }

    public static void main(String[] args) {
        List<StreamItem> list = Lists.newArrayList(new StreamItem(1, "a", true), new StreamItem(2, "b", false),
                new StreamItem(3, "c", true), new StreamItem(1, "d", false), new StreamItem(3, "e", true));
        Map<Integer, List<StreamItem>> map = list.stream().collect(Collectors.groupingBy(StreamItem::getId));
        System.out.println(map);

        Map<Integer, String> map2 =
                list.stream().collect(Collectors.toMap(StreamItem::getId, StreamItem::getName, (k1, k2) -> k1));
        System.out.println(map2);

        Set<Integer> set = list.stream().map(StreamItem::getId).collect(Collectors.toSet());
        System.out.println(set);
    }

    @Test
    public void testSum() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4);
        System.out.println(list.stream().mapToInt(Integer::intValue).sum());
        System.out.println(list.stream().mapToInt(x -> x).sum());
        System.out.println(list.stream().reduce((x, y) -> x + y).get());
        System.out.println(list.stream().reduce(1, (x, y) -> x + y));

        List<SumItem> list2 =
                Lists.newArrayList(new SumItem(1.0, null), new SumItem(3.0, null), new SumItem(4.0, null));
        System.out.println(list2.stream().mapToDouble(x -> x.d1 == null || x.d2 == null ? 0 : x.d1 * x.d2).sum());
        System.out.println(list2.stream().mapToDouble(x -> x.d1 == null ? 0 : x.d1).sum());
        System.out.println(list2.stream().filter(x -> x.d2 != null).mapToDouble(x -> x.d2).sum());
        System.out.println(
                list2.stream()
                        .filter(x -> x.d2 != null)
                        .reduce(null, (x, y) -> new SumItem(null, x.d2 + y.d2)));
        System.out.println(list2);
        System.out.println(
                list2.stream()
                        .filter(x -> x.d1 != null)
                        .reduce(null, (x, y) -> new SumItem(x.d1 + y.d1, null)));
    }
}
