/*
 *  1. Here we are using remote repository with credentials referenced by their name
 *     (defined in `config.Environment.gitHubCredentials`)
 *
 */

import config.*

def String projectDir = 'projects/vending-machine-kata-solution'

job('06-remote-repo-with-credentials') {
    scm {
        git {
            remote {
                url(ThisRepository.remoteGitUrl())
                credentials(Environment.gitHubCredentials)
            }
            branch('*/failing_tests')
        }
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

