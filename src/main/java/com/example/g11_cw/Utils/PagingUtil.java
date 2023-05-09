package com.example.g11_cw.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * pagingUtil用于分页
 * @Author Aaron
 */
public class PagingUtil {
    public static List<?> pagingData(List<?> list, int pageSize, int pageNum) {
        List<Object> list_new = new ArrayList<>();
        int count = 0;
        for (int i = (pageSize - 1) * pageNum; count < pageSize && i < list.size(); i++) {
            list_new.add(list.get(i));
        }
        return list_new;
    }
}
