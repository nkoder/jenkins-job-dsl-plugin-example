#!/usr/bin/env bash

#
# Prepare Jenkins
#

jenkinsHome="./jenkins_home"
jenkinsWar="./jenkins.war"
jenkinsWarDownloadLink="http://mirrors.jenkins-ci.org/war/1.645/jenkins.war"

if [ ! -f ${jenkinsWar} ]; then
    echo "### File ${jenkinsWar} was not found. I will download it..."
    wget ${jenkinsWarDownloadLink} -O ${jenkinsWar}
fi

#
# Prepare plugins
#

pluginsDir="${jenkinsHome}/plugins"

mkdir -p ${pluginsDir}

greenBallsPluginHpi="${pluginsDir}/greenballs.hpi"
if [ ! -f ${greenBallsPluginHpi} ]; then
    echo "### File ${greenBallsPluginHpi} was not found. I will download it..."
    wget "http://updates.jenkins-ci.org/download/plugins/greenballs/1.15/greenballs.hpi" -O ${greenBallsPluginHpi}
fi

jobDslPluginHpi="${pluginsDir}/job-dsl.hpi"
if [ ! -f ${jobDslPluginHpi} ]; then
    echo "### File ${jobDslPluginHpi} was not found. I will download it..."
    wget "http://updates.jenkins-ci.org/download/plugins/job-dsl/1.42/job-dsl.hpi" -O ${jobDslPluginHpi}
fi

scmApiPluginHpi="${pluginsDir}/scm-api.hpi"
if [ ! -f ${scmApiPluginHpi} ]; then
    echo "### File ${scmApiPluginHpi} was not found. I will download it..."
    wget "http://updates.jenkins-ci.org/download/plugins/scm-api/1.0/scm-api.hpi" -O ${scmApiPluginHpi}
fi

gitClientPluginHpi="${pluginsDir}/git-client.hpi"
if [ ! -f ${gitClientPluginHpi} ]; then
    echo "### File ${gitClientPluginHpi} was not found. I will download it..."
    wget "http://updates.jenkins-ci.org/download/plugins/git-client/1.19.0/git-client.hpi" -O ${gitClientPluginHpi}
fi

gitPluginHpi="${pluginsDir}/git.hpi"
if [ ! -f ${gitPluginHpi} ]; then
    echo "### File ${gitPluginHpi} was not found. I will download it..."
    wget "http://updates.jenkins-ci.org/download/plugins/git/2.4.1/git.hpi" -O ${gitPluginHpi}
fi

slackPluginHpi="${pluginsDir}/slack.hpi"
if [ ! -f ${slackPluginHpi} ]; then
    echo "### File ${slackPluginHpi} was not found. I will download it..."
    wget "http://updates.jenkins-ci.org/download/plugins/slack/1.8.1/slack.hpi" -O ${slackPluginHpi}
fi

#
# Run Jenkins
#

echo "### Starting Jenkins on http://localhost:8080/ with home directory set to ${jenkinsHome} ..."
export JENKINS_HOME="${jenkinsHome}"
java -jar ${jenkinsWar}
