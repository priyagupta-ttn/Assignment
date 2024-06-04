

# Assignment 1 Submission

A brief description of what this project does and who it's for



#### Question 1 1. Define the priority when run mode are applied using options

####  system properties (-D)

#### -r option

#### file name detection

Answer : Run modes according to the Prority 1 having highest priority

1-Using the sling.properties file

The sling.properties file can be used to define the required run mode:

Edit the configuration file:

<cq-installation-dir>/crx-quickstart/conf/sling.properties

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

 renaming the jar file
The following two installation run modes can be activated by renaming the installation jar file before installation:

publish
author
The jar file must use the naming convention:

cq5-<run-mode>-p<port-number>


#### Question 2
#### 2. Start the below AEM instances:        

#### a) Author instance        

#### b) Publish instance

Answer 2 

1- Install Java 11.

2-Install Maven.

3-Get a copy of the AEM QuickStart Jar and a license.properties.

4 -Create a folder structure on your computer like the following:
~/aem-sdk

    /author
    /publish


5-Rename the QuickStart JAR to aem-author-p4502.jar and place it beneath the /author directory. Add the license.properties file beneath the /author directory.

Make a copy of the QuickStart JAR, rename it to aem-publish-p4503.jar and place it beneath the /publish directory. Add a copy of the license.properties file beneath the /publish directory.

6 -Double-click the aem-publish-p4503.jar file to install the Publish instance. This starts the Publish instance, running on port 4503 on the local computer.

or Run jar using - java -jar AEM_author_4502.jar

#### Question  3. Create a project with latest aem archtype

Answer 3 .

1 -Open up a command-line terminal. Verify that Maven is installed:

2-Navigate to a directory in which you want to generate the AEM project. This can be any directory in which you want to maintain your project’s source code. For example, a directory named code beneath the user’s home directory:

3-Paste the following into the command line to generate the project in batch mode:

mvn -B archetype:generate -DarchetypeGroupId=com.adobe.aem -DarchetypeArtifactId=aem-project-archetype -DarchetypeVersion=49 -DappTitle="My FirstSite" -DappId="myfirstsite" -DgroupId="com.myfirstsite" -DgroupId="com.myfirstsite" -DincludeDispatcherConfig=y -DaemVersion=6.5.17

#### Deploy and build the project
Build and deploy the project code to a local instance of AEM.

1-Ensure you have an author instance of AEM running locally on port 4502.

2-Run the following command to build and deploy the entire project to AEM:
mvn clean install -PautoInstallSinglePackage

3-The build takes around a minute and should end with the following message: BUILD SUCCESS

#### Question  4 4.
#### a) How do you check all sites deployed on aem instance    

#### b) How do you check assets uploaded on aem instance

Answer :

1 - Navigate to the Sites Page: http://localhost:4502/sites.html/content. Your Site must be visible

2- Navigate to the Asset Page :http://localhost:4502/assets.html/content/dam Your assests are visible for the Project.







