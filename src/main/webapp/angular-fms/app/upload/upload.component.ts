import {Component, Injectable, Inject} from '@angular/core';
import {
    FormBuilder,
    FormGroup, Validators
} from '@angular/forms';
import {UploadService} from "./upload.service";

@Component({
    moduleId: module.id,
    selector: '<upload>',
    templateUrl: 'upload.component.html'
})
@Injectable()
export class UploadComponent {
    myForm: FormGroup;
    submitAttempt:boolean =false ;

    constructor(fb: FormBuilder,private uploadService:UploadService) {
        console.log("I am constructed") ;
        this.myForm = fb.group({
            'country':['',Validators.required],
            'city':['',Validators.required],
            'location':['',Validators.required],
            'floor':['',Validators.required],
            'upload':['',Validators.required]
        });
    }

    changeListener($event): void {

        this.uploadService.changeListener($event) ;
      //  console.log(" in service: "+$event.target.files[0].name) ;
        //this.uploadService.print() ;
    }

    onSubmit(value: FormGroup): void {
        this.submitAttempt=true ;
        console.log(JSON.stringify(value.value))
        this.uploadService.acceptFormData(value) ;
    }

// <!--<label for="skuInput">SKU</label>  -->
// <!--<input type="text"  -->
// <!--id="skuInput"  -->
// <!--placeholder="SKU"  -->
// <!--[formControl]="myForm.controls['sku']" > -->
// <!--<div *ngIf="myForm.controls['sku'].hasError('required')&&submitAttempt"  -->
//     <!--&gt;SKU is required</div>  -->
// <!--</div>-->
// <!--<br>-->
// <!--<br>-->
// <!--<br>-->
// <!--<div>  -->
// <!--<label for="balanceIn">SKU</label>  -->
// <!--<input type="text"  -->
// <!--id="balanceIn"  -->
// <!--placeholder="balance"  -->
// <!--[formControl]="myForm.controls['balance']">  -->
// <!--</div>-->
//
// <button type="submit">Submit</button>
//     </form>
//     </div>
//     `

}