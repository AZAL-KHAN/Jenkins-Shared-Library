def call(String recipientEmail) {

    return [
        failure: {
            steps.echo "📧 Sending FAILURE email to ${recipientEmail}"

            steps.emailext(
                subject: "❌ Jenkins Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
❌ BUILD FAILED

Job Name : ${env.JOB_NAME}
Build No : ${env.BUILD_NUMBER}

🔗 Build URL:
${env.BUILD_URL}

Please check the logs and take action.
""",
                to: recipientEmail
            )
        },

        fixed: {
            steps.echo "📧 Sending FIXED email to ${recipientEmail}"

            steps.emailext(
                subject: "✅ Jenkins Build Fixed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
✅ BUILD BACK TO NORMAL

Job Name : ${env.JOB_NAME}
Build No : ${env.BUILD_NUMBER}

🔗 Build URL:
${env.BUILD_URL}

The pipeline is healthy again 🎉
""",
                to: recipientEmail
            )
        }
    ]
}
