Spring Demo
==========

This demonstrates how to use Spring's new profile feature to substitute beans. Based on a real world example where it was not practical to replicate the dev environment for each workstation and so instead isolated the event processing for each workstation.

How to Build
---
mvn clean package -Dspring.profiles.active=workstation
