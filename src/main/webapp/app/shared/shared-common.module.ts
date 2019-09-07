import { NgModule } from '@angular/core';

import { CaptchaSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
  imports: [CaptchaSharedLibsModule],
  declarations: [JhiAlertComponent, JhiAlertErrorComponent],
  exports: [CaptchaSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class CaptchaSharedCommonModule {}
