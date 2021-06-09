import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { JwtModel } from '../models/jwt-model';
import { LoginModel } from '../models/login-model';
import { MessageModel } from '../models/message-model';
import { UserModel } from '../models/user-model';

const baseUrl = 'http://localhost:9900/api/auth';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {
  // Dependency Injection
  constructor(private http: HttpClient) {}
  //registers
  registerUser(user: UserModel): Observable<MessageModel> {
    return this.http.post<MessageModel>(`${baseUrl}/register`, user);
  }
  //login
  loginUser(login: LoginModel) :Observable<JwtModel> {
    return this.http.post<JwtModel>(`${baseUrl}/login`,login);
  }
}
