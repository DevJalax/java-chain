package com.example.blockchain.service;

import org.hyperledger.fabric.gateway.*;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class BlockchainService {

    private final String walletPath = "path/to/your/wallet"; // Update with your wallet path
    private final String connectionProfilePath = "path/to/your/connection/profile.json"; // Update with your connection profile

    @Cacheable("transactionData")
    public String sendTransaction(TransactionRequest request) {
        try {
            // Load the wallet and connection profile as before...
            Wallet wallet = Wallets.newFileSystemWallet(Paths.get(walletPath));
            Path connectionProfile = Paths.get(connectionProfilePath);
            Gateway.Builder builder = Gateway.createBuilder();
            builder.identity(wallet, "user1")
                   .networkConfig(connectionProfile)
                   .discovery(true);

            try (Gateway gateway = builder.connect()) {
                Network network = gateway.getNetwork("mychannel");
                Contract contract = network.getContract("mycontract");

                // Submit the transaction using parallel execution logic if applicable.
                String transactionData = request.getData();
                byte[] result = contract.submitTransaction("createTransaction", transactionData);

                return new String(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error sending transaction: " + e.getMessage();
        }
    }
}
