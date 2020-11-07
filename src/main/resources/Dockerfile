FROM openjdk:11-jre

MAINTAINER vikaskrsharma1982@gmail.com



# Create mobile connect Service base directory structure
RUN mkdir -p /com/hcl/net

# Expose 9999
EXPOSE 9999

# Copy mobile connect Service boot in to the image
COPY ./target/*.jar  /com/hcl/net

# Add ENTRYPOINT
ENTRYPOINT ["java","-jar","./com/hcl/net/mobileconnect-0.0.1-SNAPSHOT.jar"]

# Set HostName
ENV HOSTNAME="mobileconnect"

# Make mobile connect Service as Linux service
# RUN ln -s /com/hcl/net/mobileconnect-0.0.1-SNAPSHOT /etc/init.d/mobileconnect


