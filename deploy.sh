composer archive create -o my-network.bna
composer network install --card myCardName --archiveFile my-network.bna
composer network start --card myCardName --networkName my-network --networkVersion 0.0.1 --networkAdmin admin --file networkadmin.card
