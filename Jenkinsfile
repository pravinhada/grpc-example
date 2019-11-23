node {
    def mvnHome
    def pom

    stage('Prepare') {
        mvnHome = tool 'maven'
    }

    stage('Checkout') {
        checkout scm
    }

    stage('Build') {
        if(isUnix()) {
            sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
        } else {
            bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
        }
    }

    if(env.BRANCH_NAME == 'develop') {
        stage('Snapshot Build and Upload Artifacts') {
            echo "Finished the develop build."
        }
    }
}