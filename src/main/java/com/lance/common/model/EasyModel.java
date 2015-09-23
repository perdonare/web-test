package com.lance.common.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by perdonare on 2015/8/16.
 */
@Data
public class EasyModel<T> implements Serializable{
    private static final long serialVersionUID = 7533733366938078014L;
    private int total;
    private List<T> rows;
}
