// 1. Run this job

def dir = System.getProperty("user.dir")

job('01-test-maven-project') {
    scm {
        git("file://${dir}/")
    }
    steps {
        maven {
            rootPOM('vending-machine-kata-solution/pom.xml')
            goals('verify')
        }
    }
}

