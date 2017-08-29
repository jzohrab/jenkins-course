pipelineJob('DSL_Pipeline_ex_10') {
    triggers {
        scm('H/5 * * * *')
    }
    description('Pipeline for git://github.com/jzohrab/docker-demo.git')
    definition {
        cpsScm {
            scm {

              git {
                remote { url(repo) }
                branches('branch-that-may-not-exist', 'master')
                scriptPath('misc/Jenkinsfile.v2')
                extensions { }
              }

                // git('https://github.com/jzohrab/docker-demo.git', 'master', { node -> node / 'extensions' << '' } )
		
	        // the below line works
                // git('https://github.com/jzohrab/docker-demo.git', 'master', { node -> node / 'extensions' << '' } )

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
