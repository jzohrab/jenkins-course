pipelineJob('DSL Pipeline example') {
    triggers {
        scm('H/5 * * * *')
    }
    description('Pipeline for git://github.com/jzohrab/docker-demo.git')
    definition {
        cpsScm {
            scm {
                git('https://github.com/jzohrab/docker-demo.git') {
		    configure { node -> node.remove(node / extensions) }
		    branch('master')
		}
            }
        }
    }
}
