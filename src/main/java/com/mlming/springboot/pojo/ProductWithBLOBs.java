package com.mlming.springboot.pojo;

import lombok.Data;

@Data
public class ProductWithBLOBs extends Product {
    private String subImages;

    private String detail;
}