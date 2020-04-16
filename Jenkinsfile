pipeline {
	agent {
		node {
			label 'master'
		}
	}
	
	options{
		timestamps()
	}
	
	
	stages{
		stage("Checkout, Test & Publish") {
			steps{
				snDevOpsStep()
				checkout scm
				sh 'mvn clean test'
				
				step([$class : 'Publisher', reportFilenamePattern : '**/testng-results.xml'])
				try{
					getCurrentBuildFailedTests()
				} catch(e) {
					throw e
				}
			}
		}
		
		stage("Email"){
			steps{
				emailext (to: 'mohansairam423@gmail.com', replyTo: 'mohansairam423@gmail.com', subject: "Email Report from - '${env.JOB_NAME}' ", body: readFile("target/surefire-reports/emailable-report.html"), mimeType: 'text/html');
			}
		}
	}
	

}

def getCurrentBuildFailedTests() {
					    def failedTests = []
					    def build = currentBuild.build()

					    def action = build.getActions(hudson.tasks.junit.TestResultAction.class)
					    if (action) {
						def failures = build.getAction(hudson.tasks.junit.TestResultAction.class).getFailedTests()
						println "${failures.size()} Test Results Found"
						for (def failure in failures) {
						    failedTests.add(['name': failure.name, 'url': failure.url, 'details': failure.errorDetails])
						}
					    }

					    return failedTests
					}
