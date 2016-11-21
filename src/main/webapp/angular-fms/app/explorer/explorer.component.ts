import {Component, Injectable, OnInit} from '@angular/core' ;
import {ExplorerService} from "./explorer.service";
import {Country} from "./country/country";
import {Floor} from "./floor/floor";
import {UtilService} from "../util/util.service";
import {LayoutService} from "../layout/layout.service";
@Component({
    moduleId:module.id,
    selector:'explorer',
    templateUrl:'explorer1.component.html',
    providers:[ExplorerService]
})

@Injectable()
export class ExplorerComponent implements OnInit {
    countries: Country[];
    selectedFloor: Floor;

    constructor(private explorerService: ExplorerService,
                private utilService: UtilService,
                private layoutService: LayoutService) {
    }

    ngOnInit() {
        console.log("explorer initialised");
        // this.countries=[new Country(1,"India",[]),new Country(2,"China",[])] ;
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
        this.explorerService.getLayoutData(id).
        subscribe((layoutData)=> {
            this.utilService.calculateGridSize(layoutData);
            this.layoutService.loadLayoutData(layoutData);
        });
    }
}
