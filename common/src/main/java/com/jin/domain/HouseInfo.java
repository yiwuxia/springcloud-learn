package com.jin.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description TODO
 * @Author lijin
 * @Date 2019/7/25 9:46
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HouseInfo {

    private long id;
    private String city;
    private String address;
    private String street;



}
