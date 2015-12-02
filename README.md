# java-cart
A simple web cart using java SOAP and REST APIs

# Note
- When you import the client and server to eclipse, you will see errors. 
- Especially in ```SoapCtrl.java``` of Client project.
- Check below for a fixes.

# Fixing server errors
1. You should use ```jdk``` to compile the project instead of the default set ```jre``
2. Install ```jdk``` and change the project setup to use ```jdk```
3. One way is, after 1: Goto project propeties --> Java Build Path --> Libraries --> Select 'JRE System Library'
4. Click ```Edit``` on the right side and select ```JDK``` from the alternatives

# Fixing client errors
1. <b>Start SOAP server</b> from server project's ```SoapStartup.java```
2. Go to the folder ```client/src/``` in a new terminal
3. Run ``` wsimport -keep http://localhost:8090/soap?wsd```
4. Refresh client project and the errors should be gone

# Permanent fix for errors
We will have to write an ANT script which does the above steps
