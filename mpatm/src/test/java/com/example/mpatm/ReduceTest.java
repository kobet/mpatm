package com.example.mpatm;

import com.example.mpatm.util.StringCollector;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReduceTest {

    @Test
    public void test1() {
        // count测试
        List<Integer> list = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());
        // 计算集合中值大于3的个数
        long result = list.stream().filter(v -> v > 3).count();
        assert result == 2;

        // 找出集合中最大值
        Integer maxV = list.stream().max(Integer::compareTo).get();
        assert maxV == 5;

        // 找出集合中最大值
        Integer minV = list.stream().min(Integer::compareTo).get();
        assert minV == 1;
    }

    @Test
    public void test2() {
        // 求和
        List<Integer> list = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());
        Integer total = 0;
        for (Integer v : list) {
            total = total + v;
        }
        assert total == 15;

        total = list.stream().reduce(0, (acc, ele) -> acc + ele).intValue();
        assert total == 15;
    }

    @Test
    public void test3() {
        // 求和
        List<String> list = Stream.of("1", "2", "3", "4", "5").collect(Collectors.toList());
        String result = list.stream().reduce(new StringJoiner(",", "[", "]"), StringJoiner::add, StringJoiner::merge).toString();
        System.out.println(result);
    }

    @Test
    public void test4() {
        List<String> names = Arrays.asList("张三", "李四", "王五");
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (String name : names) {
            if (sb.length() > 1) {
                sb.append(", ");
            }
            sb.append(name);
        }
        sb.append("]");
        System.out.println(sb);
    }

    @Test
    public void test5() {
        List<String> names = Arrays.asList("张三", "李四", "王五");
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        names.stream().forEach(name -> {
            if (sb.length() > 1) {
                sb.append(", ");
            }
            sb.append(name);
        });
        sb.append("]");
        System.out.println(sb);
    }

    @Test
    public void test6() {
        List<String> names = Arrays.asList("张三", "李四", "王五");
        StringBuffer sb = names.stream().reduce(new StringBuffer(), (builder, name) -> {
                    if (builder.length() > 1) {
                        builder.append(", ");
                    }
                    builder.append(name);
                    return builder;
                }, (left, right) ->
                        left.append(right)
        );
        sb.insert(0, "[");
        sb.append("]");
        System.out.println(sb);
    }

    @Test
    public void test7() {
        List<String> names = Arrays.asList("张三", "李四", "王五");
        String result = names.stream().collect(new StringCollector(",","[", "]"));
        System.out.println(result);
    }
}
