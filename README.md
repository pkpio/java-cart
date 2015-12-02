# java-cart
A simple web cart using java SOAP and REST APIs

# Note
When you import the client to eclipse, you will see errors in ```SoapCtrl.java``` Check below for a fix.

# Fixing import errors
1. <b>Start SOAP server</b> from server project's ```SoapStartup.java```
2. Go to the folder ```client/src/``` in a new terminal
3. Run ``` wsimport -keep http://localhost:8090/soap?wsd```
4. Refresh client project and the errors should be gone

# Permanent fix for errors
We will have to write an ANT script which does the above steps
