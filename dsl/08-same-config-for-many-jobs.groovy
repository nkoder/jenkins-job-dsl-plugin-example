/*
 *  1. In this example you can see that thanks to `.with` you can extend job with more instructions
 *     (in this example it is same Slack configuration)
 *
 *  2. At the moment I don't know what happens if instructions conflicted etc.
 *
 */

import config.*

def String projectDir = 'projects/next-location'

def jobs = []

jobs << job('08-same-config-for-many-jobs__job-1') {
    scm {
        git(ThisRepository.localGitUrl())
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

jobs << job('08-same-config-for-many-jobs__job-2') {
    scm {
        git {
            remote {
                url(ThisRepository.localGitUrl())
            }
            branch('*/master')
        }
    }
    wrappers {
        nodejs(Environment.nodeJsInstallation)
    }
    steps {
        shell("cd ${projectDir} && npm install")
        shell("cd ${projectDir} && ./node_modules/.bin/bower install")
        shell("cd ${projectDir} && ./node_modules/.bin/gulp dist")
    }
}

jobs*.with {
    publishers {
        slackNotifications {
            notifyAborted()
            notifyFailure()
            notifyNotBuilt()
            notifyUnstable()
            notifyBackToNormal()
        }
    }
}
