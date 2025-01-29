package com.fouad.Bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@AllArgsConstructor
@Data
public class NoticeDTO {
    private String noticeSummary;

    private String noticeDetails;

    private Date noticeBegDt;

    private Date noticeEndDt;
}
