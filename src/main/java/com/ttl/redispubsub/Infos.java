package com.ttl.redispubsub;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Infos implements Serializable {
    private String appName;
    private String content;
}
