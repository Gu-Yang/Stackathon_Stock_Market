import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { TopBarComponent } from './top-bar/top-bar.component';
import { ShowProfileComponent } from './user/personal-profile/show-profile/show-profile.component';
import { EditProfileComponent } from './user/personal-profile/edit-profile/edit-profile.component';
import { ChangePasswordComponent } from './user/personal-profile/change-password/change-password.component';
import { CompanyListComponent } from './user/company-info/company-list/company-list.component';
import { CompanyDetailComponent } from './user/company-info/company-detail/company-detailcomponent';

@NgModule({
  declarations: [
    AppComponent,
    TopBarComponent,
    ShowProfileComponent,
    EditProfileComponent,
    ChangePasswordComponent,
    CompanyListComponent,
    CompanyDetailComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot([])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
