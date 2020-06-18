package com.example.demo.stream;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
