package com.fouad.Bank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.sql.Date;

@Entity
@Data
@Slf4j
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long noticeId;

    private String noticeSummary;

    private String noticeDetails;

    private Date noticeBegDt;

    private Date noticeEndDt;

    private Date createdAt;

    private Date updatedAt;
}
