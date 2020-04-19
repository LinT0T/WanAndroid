package com.LinT0T.wanandroid;

import java.util.List;

/**
 * Auto-generated: 2020-04-17 20:25:7
 *
 * @author http://www.itjson.com
 * @website http://www.itjson.com/itjson/json2java.html
 */
public class Data {

    private int curpage;
    private List<Datas> datas;
    private int offset;
    private boolean over;
    private int pagecount;
    private int size;
    private int total;

    public void setCurpage(int curpage) {
        this.curpage = curpage;
    }

    public int getCurpage() {
        return curpage;
    }

    public void setDatas(List<Datas> datas) {
        this.datas = datas;
    }

    public List<Datas> getDatas() {
        return datas;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getOffset() {
        return offset;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public boolean getOver() {
        return over;
    }

    public void setPagecount(int pagecount) {
        this.pagecount = pagecount;
    }

    public int getPagecount() {
        return pagecount;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

}