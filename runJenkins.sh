#!/usr/bin/env bash

# abort this script if any command fail
set -e
# pipe sequence will result with exit code of last *failed* subcommand
set -o pipefail

# print every command
#set -x

script_name="$0"

function log {
	echo -e "[$script_name] $1"
}

function downloadIfMissing {
    sourceUrl="$1"
    targetFile="$2"
    if [ ! -f $targetFile ]; then
        log "Downloading $sourceUrl ..."
        wget "$sourceUrl" -O "$targetFile"
    fi
}

jenkinsWar="./jenkins.war"
jenkinsHome="./jenkins_home"
pluginsDir="${jenkinsHome}/plugins"
mkdir -p ${pluginsDir}

function downloadJenkins {
    jenkinsVersion="$1"
    jenkinsDownloadUrl="http://mirrors.jenkins-ci.org/war/${jenkinsVersion}/jenkins.war"
    downloadIfMissing ${jenkinsDownloadUrl} ${jenkinsWar}
}

function downloadPlugin {
    pluginName="$1"
    pluginVersion="$2"
    pluginDownloadUrl="http://updates.jenkins-ci.org/download/plugins/${pluginName}/${pluginVersion}/${pluginName}.hpi"
    pluginHpi="${pluginsDir}/${pluginName}.hpi"
    downloadIfMissing ${pluginDownloadUrl} ${pluginHpi}
}

downloadJenkins 1.645

downloadPlugin greenballs 1.15
downloadPlugin job-dsl 1.42
downloadPlugin scm-api 1.0
downloadPlugin git-client 1.19.0
downloadPlugin git 2.4.1
downloadPlugin slack 1.8.1

log "Starting Jenkins on http://localhost:8080/ with home directory set to $jenkinsHome ..."
export JENKINS_HOME="$jenkinsHome"
java -jar ${jenkinsWar}
