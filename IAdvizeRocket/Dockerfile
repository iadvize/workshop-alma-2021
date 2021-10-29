##
# NAME             : iadvize/iadvize-rocket:master
# VERSION          : next
# DOCKER-VERSION   : 1.10.2
# DESCRIPTION      : social-api-service Docker image
# TO_BUILD         : docker build --pull=true --no-cache --rm -t iadvize/social-sms-source-service:master .
# TO_SHIP          : docker push iadvize/iadvize-rocket:master
# TO_RUN           : docker run -d -p 9000:9000 --name iadvize-rocket-service iadvize/iadvize-rocket-service:master
##

FROM iadvize/java:8

LABEL MAINTAINER="Pierre Gaultier <pierre.gaultier@iadvize.com>"
    
EXPOSE 9000

WORKDIR /opt/docker

## change after /opt/ here docker depending on the build config for the target directory
CMD ["/opt/docker/bin/social-sms-source-service", "-Dpidfile.path=/dev/null"]

## Change the target depending on the build (Here docker, choose universal or other targets)
COPY --chown=daemon:daemon ./target/universal/stage /opt/docker

USER daemon
