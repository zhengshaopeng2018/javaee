package com.Ben.domain;

public class User {
    private int cid;
    private String cname;
    private String csource;
    private String caddress;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCsource() {
        return csource;
    }

    public void setCsource(String csource) {
        this.csource = csource;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", csource='" + csource + '\'' +
                ", caddress='" + caddress + '\'' +
                '}';
    }
}
