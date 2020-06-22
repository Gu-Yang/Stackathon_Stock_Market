import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { JwtModule } from '@auth0/angular-jwt';
import { NgxEchartsModule } from 'ngx-echarts';

import { AppComponent } from './app.component';
import { TopBarComponent } from './top-bar/top-bar.component';
import { ShowProfileComponent } from './user/personal-profile/show-profile/show-profile.component';
import { EditProfileComponent } from './user/personal-profile/edit-profile/edit-profile.component';
import { ChangePasswordComponent } from './user/personal-profile/change-password/change-password.component';
import { CompanyListComponent } from './common/company-info/company-list/company-list.component';
import { CompanyDetailComponent } from './common/company-info/company-detail/company-detail.component';
import { CompanyChartComponent } from './common/company-info/company-chart/company-chart.component';
import { AddCompanyComponent } from './admin/add-company/add-company.component';
import { EditCompanyComponent } from './admin/edit-company/edit-company.component';

import { UploadFileComponent } from './admin/upload-file/upload-file.component';
import { UploadSummaryComponent } from './admin/upload-summary/upload-summary.component';

import { LoginComponent } from './login/login/login.component';
import { SignUpComponent } from './login/sign-up/sign-up.component';

import { RoleService } from './role.service';

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
    // NgxEchartsModule,
    JwtModule.forRoot({
      config: {
        tokenGetter: () => {
          return localStorage.getItem('token');
        },
        whitelistedDomains: ['localhost:9001'],
        blacklistedRoutes: ['localhost:9001/login/authenticate']
      }
    }),
    RouterModule.forRoot([
      { path: '', component: LoginComponent },
      { path: 'sign-up', component: SignUpComponent},
      { path: 'login', component: LoginComponent},
      { path: 'company-list', component: CompanyListComponent},
      { path: 'company-detail', component: CompanyDetailComponent},
      { path: 'company-chart', component: CompanyChartComponent},
      { path: 'edit-company', component: EditCompanyComponent},
      { path: 'add-company', component: AddCompanyComponent},
      { path: 'upload-file', component: UploadFileComponent},
      { path: 'upload-summary', component: UploadSummaryComponent},
      { path: 'show-profile', component: ShowProfileComponent},
      { path: 'edit-profile', component: EditProfileComponent},
      { path: 'change-password', component: ChangePasswordComponent},
    ])
  ],
  providers: [RoleService],
  bootstrap: [AppComponent]
})
export class AppModule { }
