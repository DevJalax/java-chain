package com.example.blockchain.controller;

import com.example.blockchain.service.BlockchainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private BlockchainService blockchainService;

    @PostMapping("/send")
    public String sendTransaction(@RequestBody TransactionRequest request) {
        return blockchainService.sendTransaction(request);
    }
}
