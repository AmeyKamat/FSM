import {Group} from "./group";
export class Employee{
    private id:string;
    private brid:string ;
    private name:string ;
    private group:any;


    constructor(id: string, brid: string, name: string, group: any) {
        this.id = id;
        this.brid = brid;
        this.name = name;
        this.group = group;
    }
    public getId(): string {
        return this.id;
    }
    public getBrid(): string {
        return this.brid;
    }
    public getName(): string {
        return this.name;
    }
    public getGroup(): any {
        return this.group;
    }
}