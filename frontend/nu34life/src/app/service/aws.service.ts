import {Injectable} from '@angular/core';
import * as AWS from 'aws-sdk';

const region = 'us-east-2';
const bucketName = 'nu34life';
const IdentityPoolId = 'us-east-2:fa425738-74e0-4e2d-8f6e-d8fbcd1fc83b';


export const getResource = (filename): string => {
  return `https://nu34life.s3.us-east-2.amazonaws.com/${filename}`;
};

@Injectable({
  providedIn: 'root'
})
export class AwsService {

  constructor() {
  }

  uploadFile(files: any): string {
    const file = files[0];
    // Configures the AWS service and initial authorization
    AWS.config.update({
      region,
      credentials: new AWS.CognitoIdentityCredentials({
        IdentityPoolId
      })
    });
    // adds the S3 service, make sure the api version and bucket are correct
    const s3 = new AWS.S3({
      apiVersion: '2006-03-01',
      params: {Bucket: bucketName}
    });
    // I store this in a variable for retrieval later
    const image = file.name;
    s3.upload({Key: file.name, Bucket: bucketName, Body: file, ACL: 'public-read'}, (err, data) => {
      if (err) {
        console.log(err, 'there was an error uploading your file');
      }
    });
    return image;
  }
}
