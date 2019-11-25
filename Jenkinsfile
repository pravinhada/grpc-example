node {
    def mvnHome
    def pom

    stage('Prepare') {
        mvnHome = tool 'jenkins_maven'
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
        stage('Uploading Artifacts from develop') {
        if(isUnix()) {
            sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean deploy"
        } else {
            bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean deploy/)
        }
        echo "Finished the snapshots upload."
        }
    }

    if(env.BRANCH_NAME ==~ /release.*/) {
        stage('Build and release') {
            echo "Finished the release build."
        }
    }

}