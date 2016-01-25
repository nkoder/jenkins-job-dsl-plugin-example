# jenkins-job-dsl-plugin-example

Example of Jenkins Job DSL Plugin

## Setup

1. Run `./startJenkins.sh`

2. Go to [localhost:8080]( http://localhost:8080 )

3. Create job of type "Freestyle project" named `create-jobs` (or any other name you prefer) and configure it:

    * provide this repo checkout directory as Git repository, eg. `file:///Users/yourUserName/workspace/jenkins-job-dsl-plugin-example/`
    
    * add "Process Job DSLs" build step with `dsl/jobs.groovy` as "DSL Scripts" for "Look on Filesystem" option
    
4. Run `create-jobs` job and check that there were no errors

5. Run created `hello-world` job and check that there were no errors and `Hello world!` was printed in the console

6. (to be continued)

## Further info about Job DSL Plugin

* [main site]( https://wiki.jenkins-ci.org/display/JENKINS/Job+DSL+Plugin )

* [GitHub]( https://github.com/jenkinsci/job-dsl-plugin )

* [Wiki]( https://github.com/jenkinsci/job-dsl-plugin/wiki )

* [API reference]( https://jenkinsci.github.io/job-dsl-plugin/ )
