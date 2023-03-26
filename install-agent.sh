#!/bin/bash
JAR_FILE="/home/dado/Documents/personal-projects/oceansale/build/libs/oceansale-0.0.1-SNAPSHOT-plain.jar"

java -javaagent:/home/dado/Documents/APM/apm-agent-1.33.0.jar \
-Delastic.apm.service_name=oceansale \
-Delastic.apm.server_url=http://localhost:8200 \
-Delastic.apm.application_packages=com.ecommerce.oceansale.modules.cart.controller \
-jar $JAR_FILE
