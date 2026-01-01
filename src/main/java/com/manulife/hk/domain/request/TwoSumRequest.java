package com.manulife.hk.domain.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TwoSumRequest {

    private int[] numbers;
    private int target;
}
