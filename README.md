# jenkins-job-dsl-plugin-example

Example of Jenkins Job DSL Plugin.

The purpose of this repo is to provide examples of job DSL. These exaple job definitions are available in `dsl/`
directory. You can read each of them and follow instructions which are provided in comments.

## Setup

1. Run `./runJenkins.sh`

2. I've failed to setup `./runJenkins.sh` to have `credentials` plugin in version `1.24` installed so you have
   to perform this udpate manually. Open [http://localhost:8080/pluginManager/]( http://localhost:8080/pluginManager/ ),
   select `Credentials Plugin` and click on update button. Then kill Jenkins in your console and run `./runJenkins.sh`
   again.

3. Open [http://localhost:8080/pluginManager/advanced]( http://localhost:8080/pluginManager/advanced ) in your browser
   and click button `Check now` (on bottom right corner) to fix NodeJS installation versions list.
   It is related to this [issue with NodeJS plugin]( https://gist.github.com/MethodGrab/1462c5fcfcd4f690add8#fix )

4. Open [http://localhost:8080/configure]( http://localhost:8080/configure ) in your browser

5. Setup JDK installations:
   
    * Oracle Java SE Development Kit 7u80 installation named `jdk-1.7`
     
    * Oracle Java SE Development Kit 8u72 installation named `jdk-1.8` 

6. Setup Maven installations:
   
    * Apache Maven 2.2.1 installation named `maven-2`
    
    * Apache Maven 3.3.9 installation named `maven-3`

7. Setup NodeJS installations:
   
    * NodeJS 0.10.41 installation named `node-0.10`
   
    * NodeJS 0.12.9 installation named `node-0.12`

8. Open [http://localhost:8080/credentials/]( http://localhost:8080/credentials/ ) in your browser and create
   "username with password" global credentials for
   [this GitHub repository]( https://github.com/nkoder/jenkins-job-dsl-plugin-example )
   and name them `github-credentials`
   
9. Create job of type "Freestyle project" named `create-jobs` (or any other name you prefer) and configure it:

    * provide this repo checkout directory as Git repository,
      eg. `file:///Users/yourUserName/workspace/jenkins-job-dsl-plugin-example/`
    
    * add "Process Job DSLs" build step with `dsl/*` as "DSL Scripts" for "Look on Filesystem" option
    
    * set "Action for removed jobs" to `Disable`
    
    * set "Action for removed views" to `Delete`
    
10. Run `create-jobs` job and check that there were no errors and couple of jobs were created

## IntelliJ IDEA

JetBrains IntelliJ IDEA will prompt you to provide Groovy SDK when editing `*.groovy` files. If you want quick and
 painless Groovy installation then I suggest:
 
1. Install sdkman as decsribed on [http://sdkman.io/install.html]( http://sdkman.io/install.html )

2. Install Groovy with sdkman: `sdk install groovy`

3. Provide `$HOME/.sdkman/candidates/groovy/current` as Groovy SDK location when prompted in IntelliJ IDEA

## Further info about Job DSL Plugin

Official:

* [main site]( https://wiki.jenkins-ci.org/display/JENKINS/Job+DSL+Plugin )

* [GitHub]( https://github.com/jenkinsci/job-dsl-plugin )

* [Wiki]( https://github.com/jenkinsci/job-dsl-plugin/wiki )

* [API reference]( https://jenkinsci.github.io/job-dsl-plugin/ )

Unofficial:

* [ sheehan/job-dsl-gradle-example ]( https://github.com/sheehan/job-dsl-gradle-example )

## ToDo

* job DSL with "publish over SSH" step

* job DSL for project which needs virtual frame buffer (xvfb) to run test (Portractor?) 

* view DSL
 
* job DSL with jobs for branches fetched from GitHub API

* job DSL with jobs for branches listed in text file

* job DSL with multi-line shell script

* show that jobs created by seed job are tracked

* job DSL with critical blocks

* job DSL with remote shell access

* DSL of parametrized job

* job DSL with custom XML parts
