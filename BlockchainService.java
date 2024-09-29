package com.example.blockchain.service;

import org.hyperledger.fabric.gateway.*;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

@Service
public class BlockchainService {

    private final String walletPath = "path/to/your/wallet"; // Update with your wallet path
    private final String connectionProfilePath = "path/to/your/connection/profile.json"; // Update with your connection profile

    public String sendTransaction(TransactionRequest request) {
        try {
            // Load the wallet
            Wallet wallet = Wallets.newFileSystemWallet(Paths.get(walletPath));

            // Load a connection profile
            Path connectionProfile = Paths.get(connectionProfilePath);
            Gateway.Builder builder = Gateway.createBuilder();
            builder.identity(wallet, "user1") // Replace with your identity name
                   .networkConfig(connectionProfile)
                   .discovery(true);

            // Create a gateway to connect to the peer node
            try (Gateway gateway = builder.connect()) {
                // Get the network and contract
                Network network = gateway.getNetwork("mychannel"); // Replace with your channel name
                Contract contract = network.getContract("mycontract"); // Replace with your contract name

                // Create a transaction
                String transactionData = request.getData(); // Assuming request has a method getData()
                byte[] result = contract.submitTransaction("createTransaction", transactionData);

                return new String(result); // Return the result of the transaction
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error sending transaction: " + e.getMessage();
        }
    }
}
