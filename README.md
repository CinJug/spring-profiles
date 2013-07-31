Spring Demo
==========

This demonstrates how to use Spring's new profile (new in 3.1) feature to substitute beans. Based on a real world example where it was not practical to replicate the dev environment for each workstation and so instead isolated the event processing for each workstation.

You can learn more about Spring profiles here: http://blog.chariotsolutions.com/2012/01/spring-31-cool-new-features.html

Overview
---
When running MainStart or MainComplete provide the 'spring.profiles.active=[workstation|dev]' JVM argument to enable the desired profile. Technically, multiple profiles can be specified as a comma-delimited list but I have built this example to expect exactly one.

I did not define an assembly for this project so you'll need to execute the Main classes in an IDE. In Eclipse you can do this by:
1. Open MainStart.java in Eclipse
1. Open menu: Run > Run Configurations
1. Click on the Arguments tab (just below Name)
1. In the VM arguments text area put this: -Dspring.profiles.active=workstation
`Be careful to put this in the VM arguments (bottom) not the Program arguments (top)`
1. Click Run

ActiveMQ Installation
---
1. Download ActiveMQ here: http://activemq.apache.org/download.html
1. Unzip to desired location
1. Run bin/activemq.bat or activemq.sh as appropriate
1. Enjoy!

That's it! No configuration necessary. By default queues will be lazy created as needed. You can browse queues in the ActiveMQ admin console at http://localhost:8161 with username=admin and password=admin
