package com.example.demo.java.annotation;

/**
 * @author: lihui
 * @date: 2020-07-04
 */
public class SingleElementAnnotationsStudy {
}

@interface Single {
    String value() default "name";
}

@interface Marker {
}

@interface Normal {
    String id();

    String name();
}

@interface NormalWithValue {
    String id() default "id";

    String value();
}

@Marker
@Single("123")
@Normal(id = "123", name = "123")
@NormalWithValue("123")
class AnnotationMain {
}


