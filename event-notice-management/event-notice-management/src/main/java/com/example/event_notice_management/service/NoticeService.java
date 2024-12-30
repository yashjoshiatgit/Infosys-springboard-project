package com.example.event_notice_management.service;

import com.example.event_notice_management.model.Notice;
import com.example.event_notice_management.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    public List<Notice> getAllNotices() {
        return noticeRepository.findAll();
    }

    public Notice createNotice(Notice notice) {
        return noticeRepository.save(notice);
    }

    public Optional<Notice> getNoticeById(String id) {
        return noticeRepository.findById(id);
    }

    public Notice updateNotice(String id, Notice notice) {
        Optional<Notice> optionalNotice = noticeRepository.findById(id);
        if (optionalNotice.isPresent()) {
            Notice existingNotice = optionalNotice.get();
            existingNotice.setTitle(notice.getTitle());
            existingNotice.setContent(notice.getContent());
            return noticeRepository.save(existingNotice);
        }
        return null;
    }

    public void deleteNotice(String id) {
        noticeRepository.deleteById(id);
    }
}