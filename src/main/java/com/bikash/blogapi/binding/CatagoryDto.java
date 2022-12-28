package com.bikash.blogapi.binding;

import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatagoryDto {

    private Long catagoryId;
    private  String catagoryName;
    private  String catagoryDescription;
}
