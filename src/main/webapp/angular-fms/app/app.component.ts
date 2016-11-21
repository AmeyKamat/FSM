import { Component } from '@angular/core';

@Component({
    moduleId:module.id,
    selector: 'my-app',
    templateUrl:'app.component.html'
    // template: `<explorer></explorer>`
})
export class AppComponent {
    displayExplorere:boolean=false ;
    display():void{
        this.displayExplorere=true ;
        console.log("Open method is being called") ;

    }

}




