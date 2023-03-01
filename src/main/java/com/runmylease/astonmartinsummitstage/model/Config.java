package com.runmylease.astonmartinsummitstage.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Config {
    private String browserName;
    private String url;
    private String waitDuration;
    private String options;
}
