package com.appspot.egun.money.comp.process;

import java.util.List;

import com.appspot.egun.money.comp.domain.MoneyBook;
import com.appspot.egun.money.comp.domain.MoneyBookAuthorize;
import com.appspot.egun.money.comp.domain.EgunUser;

public interface MoneyBookProcess
{
    /**
     * 장부 등록
     * @param book
     * @return
     */
    public Long reigsterMoneyBook( MoneyBook book );

    /**
     * 사용자의 장부 목록 조회
     * @param userEmail 사용자 이메일
     * @return 장부 목록
     */
    public List<MoneyBook> findMoneyBookByUserEmail( String userEmail );

    /**
     * 사용자의 기본 장부 조회
     * @param userEmail 사용자 이메일
     * @return 장부 
     */
    public MoneyBook findDefaultMoneyBookByUserEmail( String userEmail );

    /**
     * 가계부 권한 부여
     * @param authorize
     * @return
     */
    public Long registerMoneyBookAuthorize( MoneyBookAuthorize authorize );

    /**
     * 가계부 권한 확인
     * @param user
     * @param book
     * @return
     */
    public boolean hasMoneyBookAuthorize( EgunUser user, MoneyBook book );
}
