package com.manulife.hk.api.controller;

import com.manulife.hk.domain.ChildrenCookieRequest;
import com.manulife.hk.domain.MySqrtRequest;
import com.manulife.hk.domain.SortRequest;
import com.manulife.hk.domain.TwoSumRequest;
import com.manulife.hk.service.BinarySearchService;
import com.manulife.hk.service.GreedService;
import com.manulife.hk.service.SortService;
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
    private TwoPointersService twoPointersService;

    @Autowired
    private BinarySearchService binarySearchService;

    @Autowired
    private SortService sortService;

    @GetMapping(value = "/v1/hello", produces = {"application/json"})
    public String helloWorld() {
        return "Hello world";
    }

    @PostMapping(value = "/v1/children/cookie", produces = {"application/json"})
    public ResponseEntity<Integer> childrenAndCookies(ChildrenCookieRequest request) {
        return ResponseEntity.ok(greedService.assignChildrenWithCookies(request.getChildrenArray(), request.getCookiesArray()));
    }

    @PostMapping(value = "/v1/two-pointers/two-sum", produces = {"application/json"})
    public ResponseEntity<int[]> twoSum(TwoSumRequest request) {
        return ResponseEntity.ok(twoPointersService.twoSum(request.getNumbers(), request.getTarget()));
    }

    @PostMapping(value = "/v1/binary-search/sqrt", produces = {"application/json"})
    public ResponseEntity<Integer> sqrt(MySqrtRequest request) {
        return ResponseEntity.ok(binarySearchService.mySqrt(request.getA()));
    }

    @PostMapping(value = "/v2/binary-search/sqrt", produces = {"application/json"})
    public ResponseEntity<Integer> sqrt2(MySqrtRequest request) {
        return ResponseEntity.ok(binarySearchService.newTonSqrt(request.getA()));
    }

    @PostMapping(value = "/v1/sort/quick-sort", produces = {"application/json"})
    public ResponseEntity<int[]> quickSort(SortRequest request) {
        return ResponseEntity.ok(sortService.quickSort(request.getArr()));
    }
}
