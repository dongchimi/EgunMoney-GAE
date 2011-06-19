package com.appspot.egun.money.comp.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.jdo.annotations.Persistent;

import com.appspot.egun.money.comp.utility.CU;

public class AccountBookCategoryGroup implements Serializable
{

    /** UID */
    private static final long serialVersionUID = -8523370803207702631L;

    /** �з���� */
    private List<Category> categories;

    /** ����� */
    @Persistent(defaultFetchGroup = "false")
    private AccountBook egunAccountBook;

    /** ���ĵ� ī�װ� ��ȸ */
    public List<Category> getSortedCategories()
    {
        if ( CU.isEmpty( categories ) )
            return new ArrayList<Category>();

        Collections.sort( categories );
        for ( Category category : categories )
        {
            if ( category.hasSubCategories() )
            {
                category.sortingSubCategories();
            }
        }

        return categories;
    }

    public List<Category> getCategories()
    {
        return categories;
    }

    public void setCategories( List<Category> categories )
    {
        this.categories = categories;
    }

    public AccountBook getEgunAccountBook()
    {
        return egunAccountBook;
    }

    public void setEgunAccountBook( AccountBook egunAccountBook )
    {
        this.egunAccountBook = egunAccountBook;
    }

}
