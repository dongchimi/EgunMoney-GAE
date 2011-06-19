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

    /** 분류목록 */
    private List<Category> categories;

    /** 가계부 */
    @Persistent(defaultFetchGroup = "false")
    private AccountBook egunAccountBook;

    /** 정렬된 카테고리 조회 */
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
