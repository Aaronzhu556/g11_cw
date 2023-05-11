package com.example.g11_cw.Service;

import com.example.g11_cw.Service.Interface.ToBeVerifiedService;
import org.springframework.stereotype.Service;

@Service
public class ToBeVerifiedServiceImpl implements ToBeVerifiedService {
    @Override
    public int updateTvstatus(String tvstatus, int pvid) {
        return 0;
    }
}
