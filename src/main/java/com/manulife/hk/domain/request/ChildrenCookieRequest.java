package com.manulife.hk.domain.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ChildrenCookieRequest {

    private int[] childrenArray;
    private int[] cookiesArray;
}
