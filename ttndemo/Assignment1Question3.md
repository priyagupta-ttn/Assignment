#### Question 3. Create a project with latest aem archtype
Answer 3 .

1 -Open up a command-line terminal. Verify that Maven is installed:

2-Navigate to a directory in which you want to generate the AEM project. This can be any directory in which you want to maintain your project’s source code. For example, a directory named code beneath the user’s home directory:

3-Paste the following into the command line to generate the project in batch mode:

mvn -B org.apache.maven.plugins:maven-archetype-plugin:3.2.1:generate  -D archetypeGroupId=com.adobe.aem  -D archetypeArtifactId=aem-project-archetype  -D archetypeVersion=43  -D appTitle="TTN Demo"  -D appId="ttndemo"  -D groupId="com.ttn.demo"  -D aemVersion=6.5.7  -D singleCountry=n  -D includeExamples=y  -D includeErrorHandler=y

Deploy and build the project
Build and deploy the project code to a local instance of AEM.

1-Ensure you have an author instance of AEM running locally on port 4502.

2-Run the following command to build and deploy the entire project to AEM: mvn clean install -PautoInstallSinglePackage

3-The build takes around a minute and should end with the following message: BUILD SUCCESS