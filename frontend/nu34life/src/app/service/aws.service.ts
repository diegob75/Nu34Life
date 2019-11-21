import {Injectable} from '@angular/core';
import * as AWS from 'aws-sdk';
import {Observable} from 'rxjs';
import {ManagedUpload} from 'aws-sdk/lib/s3/managed_upload';


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

  uploadFile(files: any): Observable<ManagedUpload.SendData> {
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

    const params = {
      Key: file.name,
      Bucket: bucketName,
      Body: file,
      ACL: 'public-read'
    };
    // I store this in a variable for retrieval later
    return new Observable(observer => {
      s3.upload(params, (err, data) => {
        if (err) {
          observer.error(err);
        }
        observer.next(data);
        observer.complete();
      });
    });
  }
}
