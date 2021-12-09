package com.example.shoppingcartfinal;

public class ConcreteProductBuilder implements ProductBuilder {

    String name, desc, sname;
    Double cost;
    @Override
    public ConcreteProductBuilder setProductName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public ConcreteProductBuilder setProductCost(Double cost) {
        this.cost = cost;
        return this;
    }

    @Override
    public ConcreteProductBuilder setProductDesc(String desc) {
        this.desc = desc;
        return this;
    }

    @Override
    public ConcreteProductBuilder setProductSeller(String sname) {
        this.sname = sname;
        return this;
    }
}
