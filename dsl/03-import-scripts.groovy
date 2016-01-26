/*
 *  1. The new thing here is that we import environment configuration form other file. Nice :-)
 *
 *  2. Sadly, I haven't achieved to have IntelliJ IDEA autocomplete Environment fields for me :-(
 *
 *  3. For more info see https://github.com/jenkinsci/job-dsl-plugin/wiki/Real-World-Examples#import-other-files-ie-with-class-definitions-into-your-script
 */

import config.*

def String projectDir = 'projects/vending-machine-kata-solution'

job('03-import-scripts') {
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

