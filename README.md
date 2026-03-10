# SOFE3290_Lab3Part1_100792709_CRN757566  

## Introduction

The task in this lab was to create and deploy a web application using Kubernetes on Google Cloud Platform/Shell of a binary calculator webapp that was developed in labs 1/2 using Java and Spring Boot. The task was to package the application into a Docker container and then deploy that container into a Kubernetes cluster. During this lab, the calculator application was first built using Maven, then packaged into a Docker image, which had several errors and issues that needed time to fix. The image was uploaded to a Google Artifact Registry so it could be accessed by the Kubernetes cluster. A Kubernetes deployment file was created to run the container, and a service was created to expose the application to the internet using a public/ecternal IP address. After deployment, the application could be accessed from a web browser and used to perform various binary calculations.

## Discussion

### 1. Briefly summarize what you have learned about Docker and Kubernetes, including their terminologies and descriptions.

Docker and Kubernetes are tools that help run applications using containers, which are small environments that include the application and everything it needs to run, such as libraries and dependencies. So the application (webapp) will act the same way wherever it is executed/run.
Docker is mainly used to create these containers, in which developers write instructions in something called a Dockerfile, which tells Docker how to build the application environment. From this file, Docker creates a Docker image, wich  acts like a template, and when it is started it becomes a running container.
Kubernetes is used to manage containers after they’re deployed. Instead of running 1 container manually, Kubernetes can run multiple containers across different machines and keep them working properly. It automatically restarts containers if they fail and even helps distribute workloads. Important terms/items in Kubernetes include pods, deployments, and services. A pod is the unit that runs containers, a deployment controls how many copies of an application should run, and a service allows users to access the application through the network.
In the lab, I learned how Docker is used to package an application into a container, and how Kubernetes is used to deploy and manage that container in a cloud environment. Although there were many mistakes and minor error tripping up the progress of my lab work for late days/etc., such as image problems, artifact registry, github problems, but it helped me learn in detail.


### 2. What are the advantages and disadvantages of using Docker images?

**Advantages:** 
they make applications portable. Since the image includes all the required dependencies, the application can run on different computers without needing to install extra software. This helps avoid the common problem where a program works on one machine but not another. 
Docker images also make deployment faster because the same image can be reused many times. 
containers are lightweight compared to full virtual machines, so they use fewer system resources.  

**Disadvantages:**  
Docker images can become large if too many dependencies are included, which increases download and deployment time. 
Security can also be a concern if images contain outdated software or vulnerabilities. 
managing many images and containers can become complicated in large systems if they are not organized properly. Because of this, container management tools like Kubernetes are often needed when applications become bigger or more complex.


## Laboratory Code Instructions & Steps to Execute

1. A new Google Cloud project was created and configured in Cloud Shell to host the container registry and Kubernetes cluster.  
2. Lab 3 github repository of my own was cloned into Cloud Shell, which had my lab2 calculator application files along with the Dockerfile and Kubernetes configuration files.
3. After cloning the repository, the application was built using Maven to compile the Java source code and generate the application package.  
4. Once the application was compiled, a Docker image was created using the Dockerfile in the repository. This image contained the compiled application along with the runtime environment to execute the webapp/application.  
5. The Docker image was marked and pushed to Google Artifact Registry, so the Kubernetes cluster can download the image when creating containers.  
6. After the image was available in Artifact Registry, a Kubernetes deployment file was used to deploy the application.  
7. Once the deployment was created, Kubernetes started a pod containing the calculator container. The pod status was verified using the command: *kubectl get pods*
8. When the pod reached the Running state, a Kubernetes service was created to expose the application. The service type used in this lab was LoadBalancer, which automatically assigns a public/external IP address.  
9. The service status was checked using: *kubectl get service*  
10. The external IP address provided by the service allowed the calculator to be accessed from a web browser. *http://34.63.45.21:8080*  
