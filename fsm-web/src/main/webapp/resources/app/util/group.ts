export class Group{
    private id:number;
    private name:string;
    private parentGroup:Group;

    constructor(id: number, name: string, parentGroup: Group) {
        this.id = id;
        this.name = name;
        this.parentGroup = parentGroup;
    }

    public getId(): number {
        return this.id;
    }

    public getName(): string {
        return this.name;
    }

    public getParentGroup(): Group {
        return this.parentGroup;
    }
}