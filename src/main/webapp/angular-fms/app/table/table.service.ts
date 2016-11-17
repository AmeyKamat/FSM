import { Injectable } from '@angular/core';

import { Table } from "./table";
import { Coordinate } from "../coordinate/coordinate";
import { Orientation } from "../util/orientation";

@Injectable()
export class TableService {
  getTable(tableJSONString: string): Table {
    let tableJSON: any = JSON.parse(tableJSONString);
    return new Table(
      new Coordinate(tableJSON.topLeftX, tableJSON.topLeftY),
      tableJSON.height,
      tableJSON.width,
      (tableJSON.length<tableJSON.width)?Orientation.Horizontal:Orientation.Vertical
    );
  }
}