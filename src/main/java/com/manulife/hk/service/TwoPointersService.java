package com.manulife.hk.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TwoPointersService {

    public int[] twoSum(int[] numbers, int target)  {
        int[] result = new int[2];
        int l = 0, r = numbers.length - 1, sum;
        while(l < r) {
            sum = numbers[l] + numbers[r];
            if(sum == target) {
                break;
            }
            if(sum < target) {
                ++l;
            } else {
                --r;
            }
        }
        result[0] = l;
        result[1] = r;

        return result;
    }
}
