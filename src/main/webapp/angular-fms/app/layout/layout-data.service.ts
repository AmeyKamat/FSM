import {Injectable, OnInit} from "@angular/core";
import {UtilService} from "../util/util.service";
import {Http, Response} from "@angular/http";

@Injectable()
export class LayoutDataService implements OnInit{
    public floorJSON:any;
    public tableJSON:any;

    constructor(private http: Http,
                private utilService:UtilService
    ){}

    ngOnInit(): void {
        this.getData();
    }

    getData(): void {
        this.http
            .get(this.utilService.GET_LAYOUT_URL)
            .map((res: Response) => res.json())
            .subscribe(result=> this.floorJSON= result);

        this.tableJSON= this.floorJSON.tableList;
    }
}