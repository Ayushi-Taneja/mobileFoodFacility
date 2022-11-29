#!/bin/bash

mvn clean install
docker build -t java_api .
docker-compose build
docker-compose up -d
mongo --port 27018 <<EOF
use truck;
db.mobile_food_facility_permit.createIndex( { "location" : "2dsphere" } );
EOF
mongoimport --port 27018 --db=truck --collection=mobile_food_facility_permit --type=json --file=src/main/resources/trucks.json