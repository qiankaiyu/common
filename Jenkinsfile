pipeline{
    // agent {
        // docker {
            // image 'allbears/jenkins-android:1.0.1'
        // }
    // }
    stages {
        stage('Build'){
             steps {
                sh './gradlew clean && rm -rf ./build/'
                sh './gradlew build'
             }
        }
        stage('UnitTest'){   
             steps {
                sh './gradlew test' 
             }
        }
    }
}