#!/bin/bash
##############################################################
# Usage ( * = optional ):                                    #
# ./script.sh <db-address> <db-port> *<username> *<password> #
##############################################################

if [ ! -z "$3" ]; then
    if [ ! -z "$4" ]; then
        echo "Using password authentication!"
        auth="--authenticationDatabase admin -u $3 -p $4"
    fi
fi

for file in ./*.json; do
    mongoimport --drop --host $1 --port $2 --db "sample_mflix" --collection "$(basename $file .json)" --file $file $auth
    #echo "$(basename $file .json)"
    #echo "$file"
done
