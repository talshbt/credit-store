import {
  ChangeDetectionStrategy,
  Component,
  EventEmitter,
  OnInit,
  Output,
} from "@angular/core";
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from "@angular/forms";
import { AnimationOptions } from "ngx-lottie";
import { Observable, BehaviorSubject } from "rxjs";
import { delay } from "rxjs/operators";
import { AppService } from "../app.service";
import { CreditOtpService } from "../services/credit-otp/credit-otp.service";
import { StateStoreService } from "../utils/state/state-store.service";

@Component({
  selector: "app-id-number",
  templateUrl: "./id-number.component.html",
  styleUrls: ["./id-number.component.scss"],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class IdNumberComponent implements OnInit {

  frmStepOne: FormGroup;
  frmStepOne$: Observable<FormGroup>;
  private myFrmStepOne$ = new BehaviorSubject<FormGroup>(null);
  myFrmStepOneListener$: Observable<FormGroup> = this.myFrmStepOne$.asObservable();
  @Output() next = new EventEmitter<void>();
  titleAlert = "שדה זה נדרש";

  nextArrow: AnimationOptions;

  myFrmStepOne(form: FormGroup) {
    this.myFrmStepOne$.next(form);
  }

  formControl(name: string) {
    return this.frmStepOne.get(name) as FormControl;
  }

  constructor(
    private appService: AppService,
    private formBuilder: FormBuilder,
    private stateStore: StateStoreService,
    private creditOtpService: CreditOtpService
  ) {

    this.frmStepOne = this.formBuilder.group({
      name: ['', Validators.required],
      idNumber: ['', Validators.required],
      phone: ['', Validators.required],
    });
  }

  ngOnInit(): void {
    // this.createForm();
    this.myFrmStepOne(this.frmStepOne);
    // this.frmStepOne$ = this.myFrmStepOneListener$.pipe(delay(0));
  }

  // createForm() {

  // }

  onSubmit() {
    if (this.frmStepOne.valid) {
      this.stateStore.name.update(this.frmStepOne.get("name").value);
      this.stateStore.idNumber.update(this.frmStepOne.get("idNumber").value);
      this.stateStore.phone.update(this.frmStepOne.get("phone").value);
      this.appService.sendOtp();

      this.next.emit();
    }
  }
}
