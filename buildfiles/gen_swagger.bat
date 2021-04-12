REM set CLI_JAR_PATH=..\swagger-codegen-cli.jar
set CLI_JAR_PATH=..\swagger-codegen-cli.jar

set CUSTOM_GEN_JAR_PATH=..\csi-java-swagger-codegen-1.0.0.jar

java -jar %CLI_JAR_PATH% generate -i ..\src\yaml\iscritto.yaml -l csi-jaxrs-resteasy-eap -o ..\tempgen --config swagger_config_java.json


rem echo
rem pause "#### generazione documentazione html ####"
rem java -jar %CLI_JAR_PATH% generate -l html -i ..\src\yaml\iscritto.yaml -o ..\temphelp