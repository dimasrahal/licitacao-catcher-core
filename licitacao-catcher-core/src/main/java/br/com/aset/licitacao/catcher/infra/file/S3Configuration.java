package br.com.aset.licitacao.catcher.infra.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class S3Configuration {

    @Value("${aws.access.key}")
    private String awsAccessKey;

    @Value("${aws.secret.key}")
    private String awsSecretKey;

    @Value("${aws.region}")
    private String awsRegion;

    public AmazonS3 getCredencials() {
        AWSCredentials credentials = null;
        AmazonS3 s3 = null;
        try {

            credentials = new BasicAWSCredentials("AKIAI4SOEGHWN3NUDQVA", "njIZnpOj+SBXFaN5Irl/7TtLUreTLajGsV9gHfy1");
            s3 = AmazonS3ClientBuilder.standard()
                    .withCredentials(new AWSStaticCredentialsProvider(credentials))
                    .withRegion("us-east-1")
                    // .withRegion("sa-east-1")
                    .build();

        } catch (Exception e) {

            throw new AmazonClientException(

                    "Cannot load the credentials from the credential profiles file. " +

                            "Please make sure that your credentials file is at the correct " +

                            "location (~/.aws/credentials), and is in valid format.",

                    e);

        }

        return s3;
    }

}