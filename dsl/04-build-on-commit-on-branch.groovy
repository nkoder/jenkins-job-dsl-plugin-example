/*
 *  1. ...
 *
 */

import config.*

def String projectDir = 'vending-machine-kata-solution'

job('04-build-on-commit-on-branch') {
    scm {
        git {
            remote {
                url(ThisRepository.localGitUrl())
            }
            branch('*/failing_tests')
        }
    }
    triggers {
        scm(CronExpressions.everyMinute)
    }
    jdk(Environment.jdkInstallation)
    steps {
        maven {
            mavenInstallation(Environment.mavenInstallation)
            rootPOM("${projectDir}/pom.xml")
            goals('test')
        }
    }
}

