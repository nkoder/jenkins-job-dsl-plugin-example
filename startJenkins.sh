#!/usr/bin/env bash

jenkinsWar="./jenkins.war"
jenkinsWarDownloadLink="http://mirrors.jenkins-ci.org/war/latest/jenkins.war"
jenkinsHome="./jenkins_home"

if [ ! -f ${jenkinsWar} ]; then
    echo "### File ${jenkinsWar} was not found. I will download it..."
    wget ${jenkinsWarDownloadLink} -O ${jenkinsWar}
fi

echo "### Starting Jenkins on http://localhost:8080/ with home directory set to ${jenkinsHome} ..."
export JENKINS_HOME="${jenkinsHome}"
java -jar ${jenkinsWar}
