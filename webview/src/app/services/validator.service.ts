import { Injectable } from '@angular/core';

@Injectable()
export class ValidatorService {

  constructor() {
  }

  validateCommunity(community){
    if (community.name == undefined) {
      return false
    }
    else {
      return true
    }
  }

  validateHouseHold(household) {
    if (household.name == undefined || household.email == undefined || household.username == undefined || household.password == undefined) {
      return false
    }
    else {
      return true
    }
  }

  validateEmail(email) {
    const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
  }

}
