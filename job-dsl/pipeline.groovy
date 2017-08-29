pipelineJob('DSL_Pipeline') {

  def repo = 'https://github.com/jzohrab/docker-demo.git'

  triggers {
    scm('H/5 * * * *')
  }
  description("Pipeline for $repo")

  definition {
    cpsScm {
      scm {
        git {
          remote { url(repo) }
          branches('master', '**/feature*')
          scriptPath('misc/Jenkinsfile.v2')
          extensions { }
        }

        // the below line also works, but it only covers the 'master' branch
        // git(repo, 'master', { node -> node / 'extensions' << '' } )
      }
    }
  }
}
