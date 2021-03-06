import { Component } from '@angular/core';
import { Subject } from 'rxjs/Subject';
import { appearNoty } from "./animations";


@Component({
  template: `
    <div class="noty"
      [@appearNoty]="animationState"
      (@appearNoty.done)="onAnimationDone($event)"
      (click)="animationState = 'destroyed'"
    >
      {{ message }}
    </div>
  `,
  styles: [`
    .noty {
      position: fixed;
      left: 50%;
      bottom: 0;
      transform: translateX(-50%);
      min-width: 288px;
      max-width: 568px;
      padding: 14px 24px;
      background: #323232;
      border-radius: 2px;
      color: #fff;
    }  
  `],
  animations: [appearNoty()]
})
export class NotyComponent {
  public destroyedStream: Subject<any>;
  public message: string;
  private animationState: string;

  constructor() {
    this.destroyedStream = new Subject();
    this.message = 'Noty message!';
    this.animationState = 'idle';

    setTimeout(() => this.animationState = 'destroyed', 3000);
  }

  private onAnimationDone(e) {
    if (e.toState === 'destroyed') {
      this.destroyedStream.next();
    }
  }

}
