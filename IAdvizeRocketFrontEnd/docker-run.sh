#!/usr/bin/env bash

echo "building front image"

./docker-build.sh

echo "starting dev server on port 3000"

docker run \
    -it \
    --rm \
    -v ${PWD}:/app \
    -v /app/node_modules \
    -p 3000:3000 \
    -e CHOKIDAR_USEPOLLING=true \
    workshop-alma-front:dev