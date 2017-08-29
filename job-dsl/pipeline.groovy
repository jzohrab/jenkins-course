pipelineJob('DSL_Pipeline_example_8') {
    triggers {
        scm('H/5 * * * *')
    }
    description('Pipeline for git://github.com/jzohrab/docker-demo.git')
    definition {
        cpsScm {
            scm {
                git('https://github.com/jzohrab/docker-demo.git', 'master', { node -> node / 'extensions' << '' } )

                // {
                   // configure { it / extensions << '' }
                   // extensions { }  // nothing???
		   // configure { node -> node / extensions << '' } 
                   // branches('some_branch', 'master')
                // }
            }
        }
    }
}
