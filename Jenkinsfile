pipeline {
    agent any

    stages{
        stage ('Compilacion'){
            steps {
                withMaven(maven : 'maven3_5_0') {
                        sh 'mvn clean compile'
                }

            }

        }
        stage ('Pruebas'){
            steps {
                withMaven(maven : 'maven3_5_0') {
                        sh 'mvn test'
                }

            }

        }
        stage ('Despliegue'){
            steps {
                withMaven(maven : 'maven3_5_0') {
                        sh 'mvn deploy'
                }

            }

        }


}


}


