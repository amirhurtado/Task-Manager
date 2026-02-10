import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public dataUser: any = null;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    this.dataUser = this.userService.getUserData();

    if(!this.dataUser) {
      this.router.navigate(['/']);

    }



  }

}
