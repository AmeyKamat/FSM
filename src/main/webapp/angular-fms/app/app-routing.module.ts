import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CanvasComponent} from "./canvas/canvas.component";

const routes = [
    {
        path: '',
        redirectTo: '/UploadComponent',
        pathMatch: 'full'
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }

