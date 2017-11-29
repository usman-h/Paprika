package com.usmanhussain.paprika.Session3;

public class GetterSetter {


    public GetterSetter(String policyHolerName, int claimNumber, boolean settled) {
        this.policyHolerName = policyHolerName;
        this.claimNumber = claimNumber;
        this.settled = settled;
    }

    private String policyHolerName;

    public String getPolicyHolerName() {
        return policyHolerName;
    }

    public void setPolicyHolerName(String policyHolerName) {
        this.policyHolerName = policyHolerName;
    }

    public int getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(int claimNumber) {
        this.claimNumber = claimNumber;
    }

    public boolean isSettled() {
        return settled;
    }

    public void setSettled(boolean settled) {
        this.settled = settled;
    }

    private int claimNumber;
    private boolean settled;



}