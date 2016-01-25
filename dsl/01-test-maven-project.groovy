/*
 *  1. In project configuration: Check that `jdk-1.8` is chosen as JDK to be used.
 *
 *  2. In DSL: Make a typo in JDK installation name below (and commit), eg. change `jdk-1.8` to `jdk1.8`
 *
 *  3. On Jenkins: Run `create-jobs` job
 *
 *  4. In project configuration: Check that `(System)` or `(Default)` is chosen as JDK instead of `jdk-1.8`.
 *     There were no errors in `create-jobs` to indicate typo in JDK installation name :-(
 *
 *  5. Same goes for Maven installations :-(
 *
 *  6. Mess with assertions in tests of vending-machine-kata-solution project to check that Unit publisher is doing
 *  its job
 */

def String thisRepositoryDir = System.getProperty('user.dir')
def String projectDir = 'vending-machine-kata-solution'

job('01-test-maven-project') {
    scm {
        git("file://${thisRepositoryDir}/")
    }
    jdk('jdk-1.8')
    steps {
        maven {
            mavenInstallation('maven3')
            rootPOM("${projectDir}/pom.xml")
            goals('test')
        }
    }
    publishers {
        archiveJunit("${projectDir}/**/surefire-reports/*.xml")
    }
}

