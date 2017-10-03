import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup} from '@angular/forms'

@Component({
  selector: 'app-root',
  templateUrl: './partials/app.component.html',
  styleUrls: ['./css/app.component.css',
  './node_modules/bootstrap/dist/css/bootstrap.css']
})
export class AppComponent implements OnInit{
  roomSearch : FormGroup;
  rooms : Room[];

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