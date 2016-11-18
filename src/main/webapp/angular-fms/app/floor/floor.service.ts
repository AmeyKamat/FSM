import {Floor} from "./floor"
import {Coordinate} from "../coordinate/coordinate";
import {Injectable} from "@angular/core";
@Injectable()
export class FloorService{
    getFloor(floorJSON: any): Floor {
        return new Floor(
            new Coordinate(floorJSON.minimumX, floorJSON.minimumY),
            floorJSON.maximumY,  floorJSON.maximumX
        );
    }
}