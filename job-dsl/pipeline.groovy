pipelineJob('DSL Pipeline example') {
    triggers {
        scm('H/5 * * * *')
    }
    description('Pipeline for git://github.com/jzohrab/docker-demo.git')
    definition {
        cpsScm {
            scm {
                configure { scm -> scm.remove(scm / extensions) }
                git('https://github.com/jzohrab/docker-demo.git') {
		    branch('master')
		}
            }
        }
    }
}
