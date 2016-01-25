/*
 *  1. Change slack properties below to something that will work with your Slack (and commit)
 *
 *  2. Mess with assertions in tests of vending-machine-kata-solution project to check that Slack notifications
 *     are doing their job
 *
 */

def String thisRepositoryDir = System.getProperty('user.dir')
def String projectDir = 'projects/vending-machine-kata-solution'

def String slackTeamDomain = 'PUT_YOUR_SLACK_INTEGRATION_PROPERTIES_HERE'
def String slackIntegrationToken = 'PUT_YOUR_SLACK_INTEGRATION_PROPERTIES_HERE'
def String slackProjectChannel = 'PUT_YOUR_SLACK_INTEGRATION_PROPERTIES_HERE'

job('02-slack-notifications') {
    scm {
        git("file://${thisRepositoryDir}/")
    }
    jdk('jdk-1.8')
    steps {
        maven {
            mavenInstallation('maven-3')
            rootPOM("${projectDir}/pom.xml")
            goals('test')
        }
    }
    publishers {
        slackNotifications {
            teamDomain(slackTeamDomain)
            integrationToken(slackIntegrationToken)
            projectChannel(slackProjectChannel)
            notifyAborted()
            notifyBackToNormal()
            notifyBuildStart()
            notifyFailure()
            notifyNotBuilt()
            notifyRepeatedFailure()
            notifySuccess()
            notifyUnstable()
        }
    }
}

