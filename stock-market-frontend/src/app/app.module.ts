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
import { CompanyDetailComponent } from './user/company-info/company-detail/company-detail.component';
import { CompanyChartComponent } from './user/company-info/company-chart/company-chart.component';
import { AddCompanyComponent } from './admin/add-company/add-company.component';
import { EditCompanyComponent } from './admin/edit-company/edit-company.component';

import { UploadFileComponent } from './admin/upload-file/upload-file.component';
import { UploadSummaryComponent } from './admin/upload-summary/upload-summary.component';

import { LoginComponent } from './login/login/login.component';
import { SignUpComponent } from './login/sign-up/sign-up.component';

@NgModule({
  declarations: [
    AppComponent,
    TopBarComponent,
    ShowProfileComponent,
    EditProfileComponent,
    ChangePasswordComponent,
    CompanyListComponent,
    CompanyDetailComponent,
    CompanyChartComponent,
    AddCompanyComponent,
    EditCompanyComponent,
    UploadFileComponent,
    UploadSummaryComponent,
    LoginComponent,
    SignUpComponent
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
