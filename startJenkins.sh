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
jobDslPluginHpi="${pluginsDir}/job-dsl.hpi"
jobDslPluginDownloadLink="http://updates.jenkins-ci.org/download/plugins/job-dsl/1.42/job-dsl.hpi"

mkdir -p ${pluginsDir}

if [ ! -f ${jobDslPluginHpi} ]; then
    echo "### File ${jobDslPluginHpi} was not found. I will download it..."
    wget ${jobDslPluginDownloadLink} -O ${jobDslPluginHpi}
fi

#
# Run Jenkins
#

echo "### Starting Jenkins on http://localhost:8080/ with home directory set to ${jenkinsHome} ..."
export JENKINS_HOME="${jenkinsHome}"
java -jar ${jenkinsWar}
