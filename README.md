## Notes to all viewers

ledger = record keeping book

decentralised (data shared among multiple nodes)

immutable (data cannot be updated)

consensus (need permission from all nodes to add data)

secure (crypt data)


block (single unit) chain (linkedlist of hashes) :

Block Header - Metadata about the block
Previous Block Hash - Links to the prior block
Merkle Root - Hash summarizing all transactions
Timestamp - Time when the block was mined
Difficulty Target - Mining difficulty level
Nonce - Random number used in mining
Transactions - List of all transactions within this block (ledger data of that block)
Block Size - Total size of the block in bytes
Transaction Counter - Number of transactions included
Block Reward - Reward for miner (if applicable)

world state (snapshot of all txn and who owns that rn)(can be stored in file,db,in-memory)

Miners - specific nodes which perform the block verification process before adding anything to the blockchain structure

.cto(contract type object(smart contracts)) , .js (validate form/dynamic webpage), .acl(access control list (Who can read/write)) , .qry(data retrieval queries) , .bna (Contains .cto, .js, .acl, and other files that define the business logic, data models, and access controls.) and then deploy .bna in hyperledger cloud fabric.

UTXOs are referenced as the inputs of a transaction and are also the outputs generated from a transaction.
(Unspent Transaction Output)

The structure of a UTXO includes:

A unique identifier of the transaction that created the UTXO
An index of the position of the UTXO in the transaction output lists
A value of the transaction
An optional script that specifies the conditions of which the output can be spent


blockchain operations : 


2 participants - txn senders/receivers , miners (provide resource,solve hash puzzle and claim reward)

miners do the below : 

Verify transactions
Broadcast transactions
Compete for the right to create a block
Reach consensus by validating the block
Broadcast the new block
Confirm transactions
