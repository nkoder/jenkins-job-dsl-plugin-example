/*
 *  1. Just run `00-hello-world` job on Jenkins and check that:
 *
 *     - there are no errors
 *     - `Hello world!` was printed in the job console
 *
 *  2. Run this job a couple times more to see that log rotator is doing its job
 *
 */

job('00-hello-world') {
    steps {
        shell('echo "Hello world!"')
    }
    logRotator {
        numToKeep(5)
    }
}

