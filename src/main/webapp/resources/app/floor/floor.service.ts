import {Floor} from "./floor"
import {Coordinate} from "../util/coordinate";
import {Injectable} from "@angular/core";
@Injectable()
export class FloorService{
    getFloor(floorData: any): Floor {
        return new Floor(
            new Coordinate(floorData.minX, floorData.minY),
            floorData.maxY,  floorData.maxX
        );
    }
}