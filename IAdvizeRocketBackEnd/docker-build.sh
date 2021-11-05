#!/usr/bin/env bash

docker run -w "/app" -v `pwd`/target/cache:/root/.cache/coursier/  -v `pwd`:/app --rm -ti hseeberger/scala-sbt:11.0.13_1.5.5_2.13.7 sbt --batch -Dsbt.server.forcestart=true stage
