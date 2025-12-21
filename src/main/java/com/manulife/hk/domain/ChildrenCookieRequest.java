package com.manulife.hk.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ChildrenCookieRequest {

    private int[] childrenArray;
    private int[] cookiesArray;
}
