package com.appspot.egun.money.comp.domain;

/**
 * �ڻ�����
 * @author �̵���
 */
public enum AssetType {

    CASH("����"), CARD("ī��"), LOAN("�������/����"), LOANPRICIPAL("�������"), LOANRATE("��������"), SAVING("����"), INSURANCE("����");

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
