/*
 *  1. In this example you can see that job is created for every branch listed in external file
 *
 *  2. FIXME: to be continued because something failed
 */

import config.*

// Why we cannot defined variable here with `def` keyword? Something about scopes?
projectDir = 'projects/next-location'

def createJobForBranch(branchName) {
    job("09-read-from-file_${branchName}") {
        scm {
            git {
                remote {
                    url(ThisRepository.localGitUrl())
                }
                branch("*/${branchName}")
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
}

streamFileFromWorkspace('dsl/09-branches.txt').withReader { input ->
    new BufferedReader(input).eachLine { line ->
        if (!line.startsWith("#")) {
            def branchName = line.trim()
            createJobForBranch(branchName)
        }
    }
}
