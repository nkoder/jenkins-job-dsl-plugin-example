package config

class ThisRepository {

    static String remoteGitUrl() {
        return 'https://github.com/nkoder/jenkins-job-dsl-plugin-example'
    }

    static String localGitUrl() {
        return "file://${thisRepositoryDir()}/".toString()
    }

    private static String thisRepositoryDir() {
        return System.getProperty('user.dir')
    }

}
