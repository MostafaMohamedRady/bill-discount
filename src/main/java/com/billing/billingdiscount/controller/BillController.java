package com.billing.billingdiscount.controller;

import com.billing.billingdiscount.entity.BillRequest;
import com.billing.billingdiscount.entity.BillResponse;
import com.billing.billingdiscount.service.BillService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill")
@Api(value = "Bill Calculator System",description = "Providing discount on bill")
public class BillController {

    @Autowired
    BillService billService;

    @PostMapping("/calculateDiscount")
    @ApiOperation(value = "return net amount of bill after discount",response = BillResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved bill amount"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<BillResponse> calculateBill(@ApiParam(value = "Request contain client details and item list with price",required = true) @RequestBody BillRequest request){
        return ResponseEntity.ok().body(billService.calculateNetPayable(request));
    }
}
