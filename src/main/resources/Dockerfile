FROM openjdk:11-jre

MAINTAINER vikas.sharma1@telusinternational.com



# Create gigcustomer Service base directory structure
RUN mkdir -p /com/gigcustomer/app

# Expose 9999
EXPOSE 9999

# Copy gigcustomer Service boot in to the image
COPY ./*.jar  /com/gigcustomer/app

# Add ENTRYPOINT
ENTRYPOINT ["java","-jar","./com/gigcustomer/app/gig-customer-service-0.0.1-SNAPSHOT.jar"]

# Set HostName
ENV HOSTNAME="rpaacceptor"

# Make gigcustomer Service as Linux service
# RUN ln -s /com/gigcustomer/app/initiator-1.0.0..jar /etc/init.d/rpaacceptor


