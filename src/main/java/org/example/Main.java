package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // Stream API
        // 연속된 데이터들을 처리하는 Operation들의 모음
        // Functional in nature: 데이터 소스를 변경하지 않는다.

        // stream pipeline
        // 여러개의 오퍼레이션과 한계의 종료 오퍼레이션으로 구성된다.
        // 중계 오퍼레이션
        // Stream을 리턴한다. Lazy하다 -> 종료 오퍼레이션이 오기전까지는 실행되지 않는다.
        // 종료 오퍼레이션
        // Stream을 리턴하지 않는다. 중계 오퍼레이션을 가공된 데이터를 특정 자료형으로 변환시킨다.

        List<String> names = new ArrayList<>();
        names.add("A");
        names.add("B");
        names.add("C");

        Stream<String> stringStream = names.stream().map(String::toLowerCase);
        List<String> result = names.stream().map(String::toLowerCase).collect(Collectors.toList());

        // parallelStream을 사용하면 stream을 병렬적으로 실행시캬준다
        names.parallelStream().map(String::toLowerCase)
                .collect(Collectors.toList());
    }
}
