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
    snDevOpsArtifact(configurationName:"DevOps-vknvan5.service-now.com-1719848844462",artifactsPayload:"""{"artifacts": [{"name": "devops_scripted_demo.jar","version": "${version}","semanticVersion": "${semanticVersion}","repositoryName": "devops_scripted_demo"}],"stageName": "Tests"}""") 
    //snDevOpsPackage(configurationName:"DevOps-vknvan5.service-now.com-1719848844462",name: "sentimentpackage", artifactsPayload: """{"artifacts": [{"name": "devops_scripted_demo.jar","repositoryName": "devops_scripted_demo","version":"${version}"}]}""")
   }
  }
  stage('Deploy'){
   agent any
   steps{
     //snDevOpsChange(configurationName:"DevOps-vkvan1.service-now.com-1709825996292")  
     //snDevOpsChange(configurationName:"DevOps-vkvan1.service-now.com-1709829438771")
     //snDevOpsChange changeCreationTimeOut: 3600, changeRequestDetails: '{ "attributes": { "short_description": "Test description", "priority": "1","comments": "This update for work notes is from jenkins file", "work_notes": "test work notes"}, "setCloseCode": false, "autoCloseChange": true }', changeStepTimeOut: 18000, configurationName: 'DevOps-vkvan1.service-now.com-1709829438771', pollingInterval: 60
     //snDevOpsChange changeCreationTimeOut: 3600, changeRequestDetails: '{ "attributes": { "short_description": "Test description", "priority": "1","comments": "This update for work notes is from jenkins file", "work_notes": "test work notes"}, "setCloseCode": false, "autoCloseChange": true }', changeStepTimeOut: 18000, configurationName: 'DevOps-dcvbugbash24pi2sow2.service-now.com-1718947039475', pollingInterval: 60
   }
}
}
}
