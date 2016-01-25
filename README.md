# jenkins-job-dsl-plugin-example

Example of Jenkins Job DSL Plugin

## Setup

1. Run `./startJenkins.sh`

2. Go to [localhost:8080]( http://localhost:8080 )

3. Create job of type "Freestyle project" named `create-jobs` (or any other name you prefer) and configure it:

    * provide this repo checkout directory as Git repository, eg. `file:///Users/yourUserName/workspace/jenkins-job-dsl-plugin-example/`
    
    * add "Process Job DSLs" build step with `dsl/*` as "DSL Scripts" for "Look on Filesystem" option
    
4. Run `create-jobs` job and check that there were no errors and couple of jobs were created

## Learn

I've prepared a couple of job definitions in `dsl/` directory. You can read each of them and follow instructions
(they are provided in comments).

## Further info about Job DSL Plugin

Official:

* [main site]( https://wiki.jenkins-ci.org/display/JENKINS/Job+DSL+Plugin )

* [GitHub]( https://github.com/jenkinsci/job-dsl-plugin )

* [Wiki]( https://github.com/jenkinsci/job-dsl-plugin/wiki )

* [API reference]( https://jenkinsci.github.io/job-dsl-plugin/ )

Unofficial:

* [ sheehan/job-dsl-gradle-example ]( https://github.com/sheehan/job-dsl-gradle-example )

## ToDo

* maven installation (and how it works if you misspell it's name in DSL)

* credentials to remote repo (and issues with misspelling)

* fix maven job to fail on red test

* publishers

* views?
