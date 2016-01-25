package examples

// File import based on instructions from
//   https://github.com/jenkinsci/job-dsl-plugin/wiki/Real-World-Examples#import-other-files-ie-with-class-definitions-into-your-script

class Example01_importedDsl {
    static void create() {

        job('01-imported-DSL') {
            steps {
                shell('echo "Imported world, you are welcome!"')
            }
        }

    }
}
