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
greenBallsPluginHpi="${pluginsDir}/greenballs.hpi"
greenBallsPluginDownloadLink="http://updates.jenkins-ci.org/download/plugins/greenballs/1.15/greenballs.hpi"
jobDslPluginHpi="${pluginsDir}/job-dsl.hpi"
jobDslPluginDownloadLink="http://updates.jenkins-ci.org/download/plugins/job-dsl/1.42/job-dsl.hpi"
scmApiPluginHpi="${pluginsDir}/scm-api.hpi"
scmApiPluginDownloadLink="http://updates.jenkins-ci.org/download/plugins/scm-api/1.0/scm-api.hpi"
gitClientPluginHpi="${pluginsDir}/git-client.hpi"
gitClientPluginDownloadLink="http://updates.jenkins-ci.org/download/plugins/git-client/1.19.0/git-client.hpi"
gitPluginHpi="${pluginsDir}/git.hpi"
gitPluginDownloadLink="http://updates.jenkins-ci.org/download/plugins/git/2.4.1/git.hpi"

mkdir -p ${pluginsDir}

if [ ! -f ${greenBallsPluginHpi} ]; then
    echo "### File ${greenBallsPluginHpi} was not found. I will download it..."
    wget ${greenBallsPluginDownloadLink} -O ${greenBallsPluginHpi}
fi
if [ ! -f ${jobDslPluginHpi} ]; then
    echo "### File ${jobDslPluginHpi} was not found. I will download it..."
    wget ${jobDslPluginDownloadLink} -O ${jobDslPluginHpi}
fi
if [ ! -f ${scmApiPluginHpi} ]; then
    echo "### File ${scmApiPluginHpi} was not found. I will download it..."
    wget ${scmApiPluginDownloadLink} -O ${scmApiPluginHpi}
fi
if [ ! -f ${gitClientPluginHpi} ]; then
    echo "### File ${gitClientPluginHpi} was not found. I will download it..."
    wget ${gitClientPluginDownloadLink} -O ${gitClientPluginHpi}
fi
if [ ! -f ${gitPluginHpi} ]; then
    echo "### File ${gitPluginHpi} was not found. I will download it..."
    wget ${gitPluginDownloadLink} -O ${gitPluginHpi}
fi

#
# Run Jenkins
#

echo "### Starting Jenkins on http://localhost:8080/ with home directory set to ${jenkinsHome} ..."
export JENKINS_HOME="${jenkinsHome}"
java -jar ${jenkinsWar}
