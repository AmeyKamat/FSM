import {Floor} from "./floor"
import {Coordinate} from "../util/coordinate";
import {Injectable} from "@angular/core";
@Injectable()
export class FloorService{
    getFloor(floorData: any): Floor {
        return new Floor(
            new Coordinate(floorData.minimumX, floorData.minimumY),
            floorData.maximumY,  floorData.maximumX
        );
    }
}