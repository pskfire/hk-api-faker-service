package com.manulife.hk.api.controller;

import com.manulife.hk.domain.ChildrenCookieRequest;
import com.manulife.hk.domain.TwoSumRequest;
import com.manulife.hk.service.GreedService;
import com.manulife.hk.service.TwoPointersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("start")
public class HelloWorldController {

    @Autowired
    private GreedService greedService;

    @Autowired
    TwoPointersService twoPointersService;

    @GetMapping(value = "/v1/hello", produces = {"application/json"})
    public String helloWorld() {
        return "Hello world";
    }

    @PostMapping(value = "v1/children/cookie", produces = {"application/json"})
    public ResponseEntity<Integer> childrenAndCookies(ChildrenCookieRequest request) {
        return ResponseEntity.ok(greedService.assignChildrenWithCookies(request.getChildrenArray(), request.getCookiesArray()));
    }

    @PostMapping(value = "v1/two-pointers/two-sum", produces = {"application/json"})
    public ResponseEntity<int[]> twoSum(TwoSumRequest request) {
        return ResponseEntity.ok(twoPointersService.twoSum(request.getNumbers(), request.getTarget()));
    }
}
