pipelineJob('DSL Pipeline example 2') {
    triggers {
        scm('H/5 * * * *')
    }
    description('Pipeline for git://github.com/jzohrab/docker-demo.git')
    definition {
        cpsScm {
            scm {
                git('https://github.com/jzohrab/docker-demo.git') {
                   configure { it / extensions << '' }
		   // extensions { }  // nothing???
		   // TESTESTESTEST
                   branch('master')
		}
            }
        }
    }
}
