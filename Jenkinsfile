node('test') {

	docker.image("b4crenewals/dockerchrome").inside("--privileged -v /var/run/docker.sock:/var/run/docker.sock -v /dev/shm:/dev/shm") {

        try {
            stage('Checkout latest from GIT') {
                git url: "http://git.b4c.directlinegroup.co.uk:3000/DLG/EVO-TestAutomation.git", credentialsId:"git"
            }

            stage('Clean test workspace') {
                sh 'mvn clean'
            }

            stage('Build project test code') {
                sh 'mvn install -DskipTests'
            }

            stage('Execute tests') {
                sh 'xvfb-run --server-args="-screen 0, 1920x1080x24" mvn clean test -Dcucumber.options="--tags @smoketest" -DgenerateHarReport=true -P'+ENV+' -DdriverType=chrome -Dwebdriver.chrome.driver="$CHROMEDRIVER_DIR/chromedriver" -Dsurefire.fork.count=8'
            }

            stage('Test reports') {
                step([$class: 'ArtifactArchiver', artifacts: '**/target/cucumber_reports/regression_results/*.json', fingerprint: true])
                sh 'mvn exec:java -Dexec.mainClass="co.uk.directlinegroup.evo.JSONReportMerger" -Dexec.args="target/cucumber_reports/regression_results" -Dexec.classpathScope=test'
                step([$class: 'ArtifactArchiver', artifacts: '**/target/*.*', fingerprint: true])
                step([$class: 'ArtifactArchiver', artifacts: '**/target/**/*', fingerprint: true])
                step([$class: 'ArtifactArchiver', artifacts: '**/target/generated-test-sources/features/*.*', fingerprint: true])
                step([$class: 'CucumberReportPublisher', fileIncludePattern: '**/cucumber.json', ignoreFailedTests: false, jenkinsBasePath: '', jsonReportDirectory: 'target', parallelTesting: false, pendingFails: false, skippedFails: false, undefinedFails: false])
                echo 'Test Reports should be produced'
		    }

			stage('Emailing test results') {
                step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: 'usman.hussain@directlinegroup.co.uk mandadapu.rao@directlinegroup.co.uk ArunKumar.Ramalingam@cognizant.com', sendToIndividuals: false])
            }

        } catch (e){

            stage('Test reports') {
                step([$class: 'ArtifactArchiver', artifacts: '**/target/cucumber_reports/regression_results/*.json', fingerprint: true])
                sh 'mvn exec:java -Dexec.mainClass="co.uk.directlinegroup.evo.JSONReportMerger" -Dexec.args="target/cucumber_reports/regression_results" -Dexec.classpathScope=test'
                step([$class: 'ArtifactArchiver', artifacts: '**/target/*.*', fingerprint: true])
                step([$class: 'ArtifactArchiver', artifacts: '**/target/**/*', fingerprint: true])
                step([$class: 'ArtifactArchiver', artifacts: '**/target/generated-test-sources/features/*.*', fingerprint: true])
                step([$class: 'CucumberReportPublisher', fileIncludePattern: '**/cucumber.json', ignoreFailedTests: false, jenkinsBasePath: '', jsonReportDirectory: 'target', parallelTesting: false, pendingFails: false, skippedFails: false, undefinedFails: false])
                echo 'Test Reports should be produced'
			}

			stage('Emailing test results') {
                step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: 'usman.hussain@directlinegroup.co.uk mandadapu.rao@directlinegroup.co.uk ArunKumar.Ramalingam@cognizant.com', sendToIndividuals: false])
            }
            throw e
        }
    }
}