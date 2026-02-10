import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { faLock } from '@fortawesome/free-solid-svg-icons'; 
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

   lockIcon = faLock

   public loginForm : FormGroup;
   public errorMessage : string = "";

  constructor(private fb: FormBuilder, private userService: UserService, private router: Router) {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    })
   }

  ngOnInit(): void {
  }

  onSubmit() : void {
    if(this.loginForm.valid){
      this.userService.logIn(this.loginForm.value).subscribe(
        (data) => {
          this.userService.setUserData(data);
          this.router.navigate(['/home'])
        },
        (error) => {
          console.error(error);
          this.errorMessage = error.error.message
        }
      )
    }
  }

}
