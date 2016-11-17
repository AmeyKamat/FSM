import {Coordinate} from "../coordinate/coordinate";
import {Table} from "../table/table";

export class Floor{
    leftTopPoint:Coordinate ;
    rightBottomPoint:Coordinate ;
    height:number ;
    width:number ;
    tables:Table[] ;

}