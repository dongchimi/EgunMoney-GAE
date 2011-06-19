package com.appspot.egun.money.comp.domain;

/**
 * 자산종류
 * @author 이동규
 */
public enum AssetType {

    CASH("현금"), CARD("카드"), LOAN("대출원금/이자"), LOANPRICIPAL("대출원금"), LOANRATE("대출이자"), SAVING("적금"), INSURANCE("보험");

    private String name;

    private AssetType( String name )
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }
}
