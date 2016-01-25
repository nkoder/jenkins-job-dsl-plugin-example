package config

class ThisRepository {

    static String localGitUrl() {
        return "file://${thisRepositoryDir()}/".toString()
    }

    private static String thisRepositoryDir() {
        return System.getProperty('user.dir')
    }

}
