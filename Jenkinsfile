def semanticVersion = "${env.BUILD_NUMBER}.0.0"
def packageName = "spboot-package_${env.BUILD_NUMBER}"
def version = "${env.BUILD_NUMBER}.0"
pipeline {
 agent none
 tools {
    	maven 'Maven'
 }
 stages {
  stage("Checkout"){
   agent any
   steps{
     checkout scm
     //sh 'mvn clean test'
    
    // test
   }
   
  }
  //configurationName:"DevOps-vkvan3.service-now.com-1708610875306"
  stage("Tests") {
   agent any
   steps {
    checkout scm
    snDevOpsArtifact(configurationName:"DevOps-vkvan1.service-now.com-1709829438771",artifactsPayload:"""{"artifacts": [{"name": "devops_scripted_demo.jar","version": "${version}","semanticVersion": "${semanticVersion}","repositoryName": "devops_scripted_demo"}],"stageName": "Tests"}""") 
    snDevOpsPackage(configurationName:"DevOps-vkvan1.service-now.com-1709829438771",name: "sentimentpackage", artifactsPayload: """{"artifacts": [{"name": "devops_scripted_demo.jar","repositoryName": "devops_scripted_demo","version":"${version}"}]}""")
   }
  }
  stage('Deploy'){
   agent any
   steps{
     //snDevOpsChange(configurationName:"DevOps-vkvan1.service-now.com-1709825996292")  
     snDevOpsChange(configurationName:"DevOps-vkvan1.service-now.com-1709829438771")
   }
}
}
}
