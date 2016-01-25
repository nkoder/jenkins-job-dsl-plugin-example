// 1. Just run `00-hello-world` job on Jenkins and check that:
//    - there are no errors
//    - `Hello world!` was printed in the job console

job('00-hello-world') {
    steps {
        shell('echo "Hello world!"')
    }
}

