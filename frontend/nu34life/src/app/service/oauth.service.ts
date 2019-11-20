import {User} from '../model/user';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OauthService {

  // tslint:disable-next-line:variable-name
  private _user: User;
  // tslint:disable-next-line:variable-name
  private _token: string;

  constructor(private http: HttpClient) {
  }

  public get idUser(): number {
    if (this._user != null) {
      return this._user.id;
    } else if (this._user == null && sessionStorage.getItem('user') != null) {
      this._user = JSON.parse(sessionStorage.getItem('user')) as User;
      return this._user.id;
    }
    return 0;
  }

  public get profileId(): number {
    if (this._user != null) {
      return this._user.profileId;
    } else if (this._user == null && sessionStorage.getItem('user') != null) {
      this._user = JSON.parse(sessionStorage.getItem('user')) as User;
      return this._user.profileId;
    }
    return 0;
  }

  public get user(): User {
    if (this._user != null) {
      return this._user;
    } else if (this._user == null && sessionStorage.getItem('user') != null) {
      this._user = JSON.parse(sessionStorage.getItem('user')) as User;
      return this._user;
    }
    return new User();
  }

  public get token(): string {
    if (this._token != null) {
      return this._token;
    } else if (this._token == null && sessionStorage.getItem('token') != null) {
      this._token = sessionStorage.getItem('token');
      return this._token;
    }
    return null;
  }


  login(user: User): Observable<any> {

    const urlEndpoint = 'http://localhost:8090/api/service-oauth/oauth/token';

    const credentials = btoa('frontendapp' + ':' + '12345');

    const httpHeaders = new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded',
      Authorization: 'Basic ' + credentials
    });


    const params = new URLSearchParams();
    params.set('grant_type', 'password');
    params.set('username', user.username);
    params.set('password', user.password);
    console.log(params.toString());
    return this.http.post<any>(urlEndpoint, params.toString(), {headers: httpHeaders});
  }

  saveUser(accessToken: string): void {
    const payload = this.getInfoToken(accessToken);
    this._user = new User();
    this._user.lastName = payload.lastName;
    this._user.email = payload.email;
    this._user.username = payload.user_name;
    this._user.id = payload.id;
    this._user.profileId = payload.profileId;
    this._user.roles = payload.authorities;
    console.log(payload);
    console.log('OE MIRA ACA :v');
    console.log(this._user);
    sessionStorage.setItem('user', JSON.stringify(this._user));
  }

  saveToken(accessToken: string): void {
    this._token = accessToken;
    sessionStorage.setItem('token', accessToken);
  }

  getInfoToken(accessToken: string): any {
    if (accessToken != null) {
      return JSON.parse(atob(accessToken.split('.')[1])); // Obtenemos payload
    }
    return null;
  }

  isAuthenticated(): boolean {
    const payload = this.getInfoToken(this.token);
    return payload != null && payload.user_name && payload.user_name.length > 0;
  }

  hasRole(role: string): boolean {
    return this.user.roles.includes(role);
  }

  logout(): void {
    this._token = null;
    this._user = null;
    sessionStorage.clear();
    sessionStorage.removeItem('token');
    sessionStorage.removeItem('user');
  }
}
