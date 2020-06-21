package com.gy.entity.request;

import lombok.Data;

@Data
public class CompanyRequest {

    private String companyCode;
    private String companyName;
    private String ceoName;
    private int boardMember;
    private String description;
    private boolean active;
}