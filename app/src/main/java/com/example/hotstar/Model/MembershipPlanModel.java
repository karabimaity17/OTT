package com.example.hotstar.Model;

public class MembershipPlanModel {
    String id,name,validity,amount;

    public String getId() {
        return id;
    }

    public String getValidity() {
        return validity;
    }

    public String getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public MembershipPlanModel(String id, String name, String validity, String amount) {
        this.id = id;
        this.name = name;
        this.validity = validity;
        this.amount = amount;
    }
}
