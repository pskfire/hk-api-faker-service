package com.manulife.hk.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BinarySearchService {

    public int mySqrt(int a) {
        if(a == 0 || a == 1) {
            return a;
        }
        int l = 1, r = a, mid, sqrt;
        while(l <= r) {
            mid = l + (r - l) / 2;
            sqrt = a / mid;
            if(sqrt == mid) {
                return mid;
            } else if(mid > sqrt) {
                r =  mid - 1;
            } else {
                l  = mid + 1;
            }
            log.info("l = {}, r = {}", l, r);
        }

        return r;
    }

    public int newTonSqrt(int a) {
        int x = a;
        while(x * x > a) {
            x = (x + a/x)/2;
        }
        return x;
    }
}
