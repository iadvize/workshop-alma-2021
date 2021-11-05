#!/usr/bin/env bash

./docker-build.sh

docker run --rm -ti -p 9000:9000 workshop-alma-back:`git branch --show-current`
