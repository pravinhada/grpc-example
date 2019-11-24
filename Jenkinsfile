node {
    def mvnHome
    def pom

    stage('Prepare') {
        mvnHome = tool 'maven_3.6.2'
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

    if(env.BRANCH_NAME == 'master') {
        stage('Build from master') {
            echo "Finished the master build."
        }
    }

    if(env.BRANCH_NAME == 'develop') {
        stage('Snapshot Build and Upload Artifacts from develop') {
            echo "Finished the develop build."
        }
    }

    if(env.BRANCH_NAME ==~ /release.*/) {
        stage('Build and release') {
            echo "Finished the release build."
        }
    }

}