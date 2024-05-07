package com.factory.warehouse.controller;


import com.factory.warehouse.dto.DealRequest;
import com.factory.warehouse.dto.DealResponse;
import com.factory.warehouse.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/deals")
public class DealController {

    @Autowired
    private DealService dealService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DealResponse> getAllDeals() {
        return  dealService.getAllDeals();
    }

    @GetMapping("/{uinqueId}")
    public ResponseEntity<DealResponse> getDealById(@PathVariable Long uniqueId) {
        return new ResponseEntity(dealService.getDealByUinqueId(uniqueId), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createDeal(@RequestBody @Valid DealRequest dealRequest) throws Exception {
        dealService.createDeal(dealRequest);
    }

    @PutMapping("/{uniqueId}")
    @ResponseStatus(HttpStatus.CREATED)
    public DealResponse updateDeal(@PathVariable @Valid Long uniqueId,
                                   @RequestBody @Valid DealRequest dealRequest)
            throws Exception {

        return dealService.updateDeal(uniqueId, dealRequest);
    }

    @DeleteMapping("/{uniqueId}")
   @ResponseStatus(HttpStatus.OK)
    public void deleteDeal(@PathVariable Long uniqueId) {
        dealService.deleteDeal(uniqueId);
    }
}