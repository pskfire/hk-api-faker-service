package com.manulife.hk.service.study;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Slf4j
public class GreedService {

    public int assignChildrenWithCookies(int[] childrenArray, int[] cookiesArray) {
        try {
            int child = 0, cookie = 0;
            Arrays.sort(childrenArray);
            Arrays.sort(cookiesArray);

            while(child < childrenArray.length && cookie < cookiesArray.length) {
                if(childrenArray[cookie] >= cookiesArray[cookie]) {
                    child++;
                }
                cookie++;
            }
            return child;
        } catch (Exception e) {
            return 0;
        }

    }
}
