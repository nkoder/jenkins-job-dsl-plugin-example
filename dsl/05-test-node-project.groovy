/*
 *  1. In project configuration: Check that `node-0.12` is chosen as NodeJS installation to be used.
 *
 *  2. In DSL: Make a typo in NodeJS installation name in `config/Environment` class (and commit),
 *     eg. change `node-0.12` to `node0.12`
 *
 *  3. On Jenkins: Run `create-jobs` job
 *
 *  4. In project configuration: Check that `node-0.10` is chosen as NodeJS installation instead of
 *     `node-0.12`. There were no errors in `create-jobs` to indicate typo in NodeJS installation name :-(
 *
 *     If `node-0.12` is still selected it is because it was first on the list of available installations.
 *
 *  5. Mess with `dist` task in `projects/next-location/gulpfile.js` (eg. rename `dist` task to `dist2`) to check that
 *     build is failing
 *
 */

import config.*

def String projectDir = 'projects/next-location'

job('05-test-node-project') {
    scm {
        git {
            remote {
                url(ThisRepository.localGitUrl())
            }
            branch('*/master')
        }
    }
    wrappers {
        nodejs(Environment.nodeJsInstallation)
    }
    steps {
        shell("cd ${projectDir} && npm install")
        shell("cd ${projectDir} && ./node_modules/.bin/bower install")
        shell("cd ${projectDir} && ./node_modules/.bin/gulp dist")
    }
}

