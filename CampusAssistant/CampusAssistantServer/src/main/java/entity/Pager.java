package entity;


import java.util.ArrayList;
import java.util.List;

public class Pager {

    public static <T> List<T> getPageList(List<T> olist, int page, int pagesize) {
        List<T> list = new ArrayList<T>();
        if (page <= 0) {
            page = 1;
        }
        if (pagesize <= 0) {
            pagesize = 10;
        }
        int startnum = (page - 1) * pagesize;
        int endnum = page * pagesize - 1;
        if (startnum >= olist.size()) {
            startnum = olist.size() - pagesize - 1;
        }

        if (endnum >= olist.size()) {
            endnum = olist.size() - 1;
        }
        for (int i = startnum; i <= endnum; i++) {
            list.add(olist.get(i));
        }
        return list;
    }
}
