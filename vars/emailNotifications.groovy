def call(String recipientEmail) {

    def jobName  = env.JOB_NAME
    def buildNo  = env.BUILD_NUMBER
    def buildUrl = env.BUILD_URL ?: "http://localhost:8080/job/${jobName}/${buildNo}/"

    //  Failure notification
    if (currentBuild.currentResult == 'FAILURE') {

        echo "📧 Sending FAILURE email to ${recipientEmail}"

        emailext(
            subject: "Jenkins Build Failed: ${jobName} #${buildNo}",
            body: """
Jenkins build has failed 

Job Name : ${jobName}
Build No : ${buildNo}

Please check the logs.

🔗 Build URL:
${buildUrl}

""",
            to: recipientEmail
        )
    }

    // ✅ Fixed notification (Failure → Success)
    else if (currentBuild.previousBuild?.result == 'FAILURE'
          && currentBuild.currentResult == 'SUCCESS') {

        echo "📧 Sending FIXED email to ${recipientEmail}"

        emailext(
            subject: "✅ Jenkins Build Fixed: ${jobName} #${buildNo}",
            body: """
Jenkins build is back to normal 

Job Name : ${jobName}
Build No : ${buildNo}

🔗 Build URL:
${buildUrl}

Pipeline is healthy again.
""",
            to: recipientEmail
        )
    }
}
