/*
 *  1. Just run `00-hello-world` job on Jenkins and check that:
 *
 *     - there are no errors
 *     - `Hello world!` was printed in the job console
 *
 *  2. Run this job a couple times more to see that log rotator is doing its job
 *
 *  3. Break DSL to see that `create-jobs` job will fail on malformed DSL :-)
 *     For example make typo in `nomToKeep` instruction.
 *
 */

job('00-hello-world') {
    steps {
        shell('echo "Hello world!"')
    }
    logRotator {
        numToKeep(3)
    }
}

