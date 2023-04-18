# Registration
## Release Rest Controller (TAG REST_CONTROLLER) 
Contains stub methods to handle a few end points. 
This can be used to quickly start developing endpoints.

## Release Basic Spring security (TAG BASIC_SECURE_API) 
Uses a very simple mechanism of securing the endpoint. If you visit http://localhost:8080 you will be asked username : user and password:  spring generates this password  while starting the application. If you happen to use CURL windows terminal behaves in strange way so using MINGW64 `curl -u "user:a986b72a-ca56-4e10-b288-50dc508433c8" http://localhost:8080/api/admin/users` .