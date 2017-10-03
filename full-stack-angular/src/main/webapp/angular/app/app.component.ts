import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup} from '@angular/forms'
import {Http, Response} from "@angular/http"
import {Observable} from "rxjs/Rx"
import "rxjs/add/operator/map"
import "rxjs/add/operator/catch"

@Component({
  selector: 'app-root',
  templateUrl: './partials/app.component.html',
  styleUrls: ['./css/app.component.css',
  './node_modules/bootstrap/dist/css/bootstrap.css']
})
export class AppComponent implements OnInit{
  roomSearch : FormGroup;
  rooms : Room[];

  private baseUrl = "http://localhost:8080";
  constructor(private http: Http){}

  ngOnInit(){
    this.roomSearch = new FormGroup({
      checkin : new FormControl(''),
      checkout : new FormControl('')
    });
    this.rooms = ROOMS;
  }
  onSubmit({value, valid} : {value: RoomSearch, valid: boolean}){
    console.log(value);
  }

  reserveRoom(value:string){
    console.log(value);
  }

  getAll(){
    this.http.get(this.baseUrl+"/room/reservation/v1?checkin=2017-03-18&&checkout=2017-03-18");
  }
  mapRoom(response : Response):Room[]{
    return response.json().content;
  }
}

export interface RoomSearch{
  checkin : String;
  checkout : String;
}

export interface Room{
  id : String;
  roomNumber : String;
  price : String;
  links : String;
}

var ROOMS : Room[] = [
  {
    id : "2131231",
    roomNumber : "101",
    price : "100",
    links : ""
  },
  {
    id : "2232433",
    roomNumber : "106",
    price : "90",
    links : ""
  },
  {
    id : "5454343",
    roomNumber : "110",
    price : "75",
    links : ""
  }
]