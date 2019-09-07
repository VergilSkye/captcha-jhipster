import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { CaptchaSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective } from './';

@NgModule({
  imports: [CaptchaSharedCommonModule],
  declarations: [JhiLoginModalComponent, HasAnyAuthorityDirective],
  entryComponents: [JhiLoginModalComponent],
  exports: [CaptchaSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class CaptchaSharedModule {
  static forRoot() {
    return {
      ngModule: CaptchaSharedModule
    };
  }
}
