package com.apenasum.model;

public class BankCard {

    private String code;
    private String nameBank;
    private String securityCode;
    private String flag;
    private String type;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNameBank() {
        return nameBank;
    }

    public void setNameBank(String nameBank) {
        this.nameBank = nameBank;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }


    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
