FROM ghcr.io/actions/actions-runner:2.330.0

# temporarily switch to root to install packages
USER root


ARG JAVA_VERSION=17

RUN apt-get update && \
    apt-get install -y git curl openjdk-${JAVA_VERSION}-jdk && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

ENV JAVA_HOME=/usr/lib/jvm/java-${JAVA_VERSION}-openjdk-amd64
ENV PATH="$JAVA_HOME/bin:$PATH"

# switch back to the actions user
USER runner