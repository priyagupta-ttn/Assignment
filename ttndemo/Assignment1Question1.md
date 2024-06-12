#### Question 1 1. Define the priority when run mode are applied using options
##### system properties (-D)
##### -r option
##### file name detection
Answer : Run modes according to the Prority 1 having highest priority

1-Using the sling.properties file

The sling.properties file can be used to define the required run mode:

Edit the configuration file:

/crx-quickstart/conf/sling.properties

Add the following properties; the following example is for author:

sling.run.modes=author

2- Using the -r option

A custom run mode can be activated by using the -r option when launching the quickstart. For example, use the following command to launch a AEM instance with run mode set to dev. ``

java -jar cq-56-p4545.jar -r dev

3-Using a system property in the start script

A system property in the start script can be used to specify the run mode.

For example, use the following to launch an instance as a production publish instance in the US:

-Dsling.run.modes=publish,prod,us

4 -Filename detection -

renaming the jar file The following two installation run modes can be activated by renaming the installation jar file before installation:

publish author The jar file must use the naming convention:

cq5--p