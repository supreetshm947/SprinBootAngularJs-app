System.register(['@angular/core', '@angular/forms'], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
        var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
        if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
        else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
        return c > 3 && r && Object.defineProperty(target, key, r), r;
    };
    var __metadata = (this && this.__metadata) || function (k, v) {
        if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
    };
    var core_1, forms_1;
    var AppComponent, ROOMS;
    return {
        setters:[
            function (core_1_1) {
                core_1 = core_1_1;
            },
            function (forms_1_1) {
                forms_1 = forms_1_1;
            }],
        execute: function() {
            AppComponent = (function () {
                function AppComponent() {
                }
                AppComponent.prototype.ngOnInit = function () {
                    this.roomSearch = new forms_1.FormGroup({
                        checkin: new forms_1.FormControl(''),
                        checkout: new forms_1.FormControl('')
                    });
                    this.rooms = ROOMS;
                };
                AppComponent.prototype.onSubmit = function (_a) {
                    var value = _a.value, valid = _a.valid;
                    console.log(value);
                };
                AppComponent.prototype.reserveRoom = function (value) {
                    console.log(value);
                };
                AppComponent = __decorate([
                    core_1.Component({
                        selector: 'app-root',
                        templateUrl: './partials/app.component.html',
                        styleUrls: ['./css/app.component.css',
                            './node_modules/bootstrap/dist/css/bootstrap.css']
                    }), 
                    __metadata('design:paramtypes', [])
                ], AppComponent);
                return AppComponent;
            }());
            exports_1("AppComponent", AppComponent);
            ROOMS = [
                {
                    id: "2131231",
                    roomNumber: "101",
                    price: "100",
                    links: ""
                },
                {
                    id: "2232433",
                    roomNumber: "106",
                    price: "90",
                    links: ""
                },
                {
                    id: "5454343",
                    roomNumber: "110",
                    price: "75",
                    links: ""
                }
            ];
        }
    }
});
//# sourceMappingURL=app.component.js.map