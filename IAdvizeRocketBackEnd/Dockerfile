FROM hseeberger/scala-sbt:11.0.13_1.5.5_2.13.7

EXPOSE 9000

WORKDIR /app

RUN sbt stage

COPY ./target/universal/stage /app

## change after /opt/ here docker depending on the build config for the target directory
CMD ["/app/bin/iadvize-rocket-api", "-Dpidfile.path=/dev/null"]
