#!/bin/bash

# Define variables
NETWORK_NAME="my-network"
ARCHIVE_NAME="${NETWORK_NAME}.bna"

# Create a new business network archive
composer archive create -o $ARCHIVE_NAME

# Check if the archive was created successfully
if [ -f "$ARCHIVE_NAME" ]; then
    echo "Business Network Archive created successfully: $ARCHIVE_NAME"
else
    echo "Failed to create Business Network Archive."
fi
