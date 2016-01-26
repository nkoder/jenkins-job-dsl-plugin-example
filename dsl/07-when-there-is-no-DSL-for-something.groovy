/*
 *  1. Open http://job-dsl.herokuapp.com/ in your browser and try DSLs below to see that
 *     nodes prefixed with 'SIMILAR_' in XML are similar to those without 'SIMILAR_' prefix.
 *
 *     Note that 'configure' block is available for not every DSL command.
 *
 *     For more info see https://github.com/jenkinsci/job-dsl-plugin/wiki/The-Configure-Block
 *
 */

def String thisRepositoryDir = System.getProperty('user.dir')
def String projectDir = 'projects/vending-machine-kata-solution'

job('07-when-there-is-no-DSL-for-something') {
    scm {
        git("file://${thisRepositoryDir}/")
    }
    jdk('jdk-1.8')
    steps {
        maven {
            mavenInstallation('maven3')
            rootPOM("${projectDir}/pom.xml")
            goals('test')
            configure { hudsonTasksMaven ->
                hudsonTasksMaven / "SIMILAR_pom"("${projectDir}/pom.xml")
            }
        }
    }
    logRotator {
        numToKeep(3)
    }
    configure { project ->
        project / "SIMILAR_logRotator" {
            "daysToKeep"(-1)
            "numToKeep"(3)
            "artifactDaysToKeep"(-1)
            "artifactNumToKeep"(-1)
        }
    }
}
