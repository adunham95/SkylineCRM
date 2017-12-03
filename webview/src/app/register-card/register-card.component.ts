import { Component, OnInit } from '@angular/core';
import {RequestService} from "../services/request.service";
import {ValidatorService} from "../services/validator.service";

@Component({
  selector: 'register-card',
  templateUrl: './register-card.component.html',
  styleUrls: ['./register-card.component.scss']
})
export class RegisterCardComponent implements OnInit {

  constructor(
    private reqService: RequestService,
    private valService: ValidatorService,
  ) { }

  ngOnInit() {
  }

  name: String;
  email: String;
  username: String;
  password: String;
  admin: boolean;

  createAccount() {
    let currentUser = this.reqService.getLocalUserData();
    // console.log(currentUser)

    //If admin is not checked sets admin to false
    if(this.admin == undefined){
      this.admin = false;
    }

    let householdBody = {
      "name": this.name,
      "admin": this.admin,
      "communityID": currentUser.communityID,
      "email": this.email,
      "username": this.username,
      "password": this.password
    };

    console.log(householdBody);

    if(this.valService.validateHouseHold(householdBody) == false){
      return
    }

    let houseHoldReturn;
    this.reqService.registerUser(currentUser.communityID, householdBody).subscribe(data =>{
      houseHoldReturn = data;
      if(houseHoldReturn.success){
        console.log("Household registered");
      }
      else{
        console.log(houseHoldReturn.msg);
        console.log(houseHoldReturn.error);
      }
    });

  }

}