import {Component, Injectable, OnInit} from '@angular/core' ;
import {ExplorerService} from "./explorer.service";
import {Country} from "../Region/country/country";
import {Floor} from "../Region/floor/floor";

@Component({
    moduleId:module.id,
    selector:'explorer',
    templateUrl:'explorer1.component.html'
})

@Injectable()
export class ExplorerComponent implements OnInit {
    countries: Country[];
    selectedFloor: Floor;

    constructor(private explorerService: ExplorerService) {
    }

    ngOnInit() {
        this.explorerService.getCountries().
        subscribe((countries)=> {
            this.countries = countries;
            for (var i = 0; i < this.countries.length; i++) {
                this.countries[i].expanded = false;
                console.log(this.countries[i].expanded);
            }
        });
    }

    onSelect(id: number) {
        this.explorerService.drawLayout(id);
    }
}
