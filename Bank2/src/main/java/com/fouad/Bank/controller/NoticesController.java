package com.fouad.Bank.controller;

import com.fouad.Bank.dto.NoticeDTO;
import com.fouad.Bank.repository.NoticeRepository;
import com.fouad.Bank.service.NoticesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NoticesController {

    private final NoticesService noticesService;
    private final NoticeRepository noticeRepository;

    @GetMapping("/notices")
    public ResponseEntity<List<NoticeDTO>> getNotices() {
        return noticesService.getNotices();
    }


}
