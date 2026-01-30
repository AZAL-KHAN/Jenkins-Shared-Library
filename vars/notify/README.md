# Email Notifications

Reusable Jenkins Shared Library step for sending build status emails.

## Usage

Import the shared library:
```groovy
@Library('jenkins-shared-library') _
```

Use in the **post** section:
```
post {
  emailNotifications('user@example.com')
}
```

## Email Address

You can pass any valid email address:

```
emailNotifications('devops@company.com')
emailNotifications('alerts@gmail.com')
```