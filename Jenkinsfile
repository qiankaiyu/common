pipeline{
    agent any
    // agent {
        // docker {
            // image 'allbears/jenkins-android:1.0.1'
        // }
    // }
    tools{
        gradle 'Gradle-7.0'
    }
    stages {
        stage('Build'){
             steps {
                sh 'print env' 
                sh 'gradle clean && rm -rf ./build/'
                sh 'gradle build'
             }
        }
        // stage('UnitTest'){   
        //      steps {
        //         sh './gradlew test' 
        //      }
        // }
    }
}