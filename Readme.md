## create openId connect

* create identity provider (OpenId connect)
* create web identity role to give access to S3 and code deploy
    * assign it to identity provider
* You need to add role's arn to GitHub repository in secret section

## Prepare the Aws environment (You can do this by CloudFormation but for this project we are doing it manually)

### create roles

* Create service role for EC2 to access the S3
* Create service role for CodeDeploy to have permission to be able to deploy the application.

### Create EC2 instance

* create EC2
    * assign role to access the s3.
    * Give tag to it(we need this in our code deployment process)
    * add Security group to access the service using http
* install necessary software on ec2 by ssh
    * Install CodeDeploy agent (You can do this step when you create deployment group)
    * Install java
    * you can use the file inside the documentation folder.

### Create bucket

### CodeDeploy

* Create Application
* Create Deployment group
    * assign created role to it
    * we can select environment config -> ASG or using tags
    * type of deployment in place or blue/green
    * You can select to install code deploy agent on instance, but we don't select it because we installed it ourselves
    * you can select load balancer or not
    * you can use deployment group to create new deployment with different source GitHub or bucket. You can do this step
      manually but in this project we are using GitHub actions to create deployment
      using  ```aws deploy create-deployment --application-name ${{ env.CODE_DEPLOY_APPLICATION_NAME }} --deployment-group-name ${{ env.CODE_DEPLOY_GROUP_NAME }} --s3-location bucket=${{ env.CODE_DEPLOY_BUCKET_NAME }},bundleType=zip,key=${{ env.CODE_DEPLOY_BUCKET_KEY }} --ignore-application-stop-failures```

### Clean up

* remove bucket
* remove CodeDeply application
* remove EC2 instance
* remove roles
* remove identity provider
* Delete the GitHub Secret

## Links

* [Integrating with GitHub Actions – CI/CD pipeline to deploy a Web App to Amazon EC2](https://aws.amazon.com/blogs/devops/integrating-with-github-actions-ci-cd-pipeline-to-deploy-a-web-app-to-amazon-ec2/)
* [aws create-deployment](https://docs.aws.amazon.com/cli/latest/reference/deploy/create-deployment.html)
* [Github OpenId document](https://docs.github.com/en/actions/deployment/security-hardening-your-deployments/configuring-openid-connect-in-amazon-web-services)
* [CodeDeploy Hands On](https://hexaware.udemy.com/course/aws-certified-developer-associate-dva-c01/learn/lecture/11851340#overview)