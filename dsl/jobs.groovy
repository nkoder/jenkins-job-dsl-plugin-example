// The very first example: Hello World job

job('00-hello-world') {
    steps {
        shell('echo "Hello world!"')
    }
}

// All other examples are imported from `examples` directory

import examples.Example01_importedDsl

Example01_importedDsl.create()

