import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiUrl = 'http://localhost:8080/api/user'; 

  private userData : any = null;

  constructor(private http: HttpClient) { }

  logIn(loginDataForm: any) : Observable<any>{
    return this.http.post(`${this.apiUrl}/login`, loginDataForm);
  }

  setUserData(userData: any){
    this.userData = userData;
  }

  getUserData(){
    return this.userData;
  }
}
