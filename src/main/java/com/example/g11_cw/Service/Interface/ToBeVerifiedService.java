package com.example.g11_cw.Service.Interface;

import org.springframework.stereotype.Service;

@Service
public interface ToBeVerifiedService {
    public int updateTvstatus(String tvstatus, int pvid);
}
