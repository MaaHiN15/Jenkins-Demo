def gv

pipeline{
    agent any
    parameters{
        string(name: "USER", defaultValue: "Maahin", description: "")
        choice(name: "VERSION", choices: ["1.0", "2.0", "3.0"], description: "")
        booleanParam(name: "executable", defaultValue: true, description: "")
    }
    stages{
        stage("init"){
            steps{
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build"){
            steps{
                script{
                    gv.buildApp()
                    echo "${params.USER}"
                }
            }
        }
        stage("staging"){
            when{
                expression{
                    params.executable == true
                }
            }
            steps{
                script{
                    INPUT = input message: "Select env for deploy", ok: "ok", parameters: [choice(name: "ENV", choices: ["dev", "staging", "prod"], description: "")] 
                    gv.stageApp()
                    echo "selected env ${INPUT}"
                }
            }
        }
        stage("deploy"){
            steps{
                script{
                    gv.deployApp()
                }
            }
        }
        stage("python"){
            steps{
                script{
                    gv.python()
                }
            }
        }
    }
}
