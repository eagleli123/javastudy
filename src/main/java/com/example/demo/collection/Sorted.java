package com.example.demo.collection;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

/**
 * @author: lihui
 * @date: 2020-07-03
 */
public class Sorted {

    @Test
    public void testSortedSet() {
        TreeSet<Integer> treeSet = Sets.newTreeSet(Lists.newArrayList(1, 2, 4, 5, 6, 7, 8, 10));
        Pair<Integer, Integer> pair = Pair.of(3, 10);
        NavigableSet<Integer> navigableSet = treeSet.subSet(pair.getLeft(), true, pair.getRight(), true);
        Iterator<Integer> iterator = navigableSet.descendingIterator();
        Integer value = null;
        List<String> list = Lists.newArrayList();
        Integer start = pair.getLeft();
        Integer right = pair.getRight();
        while (start <= right) {
            if (value == null && iterator.hasNext()) {
                value = iterator.next();
            }
            String v;
            if (value != null && value == right) {
                v = value + "*";
                value = null;
            } else {
                v = String.valueOf(right);
            }
            list.add(v);
            right--;
        }
        System.out.println(list);
    }
}
