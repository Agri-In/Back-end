#!/bin/bash
set -e

# Check if the init.flag file exists
if [ ! -f /var/lib/postgresql/data/init.flag ]; then
    # Run the script
    psql -U postgres -d agriin -a -f /docker-entrypoint-initdb.d/agriin.sql

    # Create the init.flag file
    touch /var/lib/postgresql/data/init.flag
fi

# Run the main command
exec "$@"