package com.fouad.Bank.service;

import com.fouad.Bank.dto.NoticeDTO;
import com.fouad.Bank.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticesService {

    private final NoticeRepository noticeRepository;

    public ResponseEntity<List<NoticeDTO>> getNotices() {
        List<NoticeDTO> notices = noticeRepository.findAll().stream().map(
                notice -> new NoticeDTO(
                        notice.getNoticeSummary(),
                        notice.getNoticeDetails(),
                        notice.getNoticeBegDt(),
                        notice.getNoticeEndDt()
                )).toList();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(notices);
    }
}
