package com.appspot.egun.money.comp.service;

import java.util.List;

import com.appspot.egun.money.comp.domain.Authorize;
import com.appspot.egun.money.comp.domain.EgunUser;
import com.appspot.egun.money.comp.domain.MoneyBook;
import com.appspot.egun.money.comp.domain.MoneyBookAuthorize;

/**
 * 가계부 Sheet 서비스
 * @author dklee
 * @since 2010.09.03
 *
 */
public interface MoneyBookService
{
    /**
     * 장부 등록
     * @param book
     * @return
     */
    public Long reigsterMoneyBook( MoneyBook book );

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

    /**
     * 해당하는 권한 목록 조회
     * @param userEmail 사용자 email
     * @param authorizes 권한목록
     * @return 사용자 email과 필요한 권한에 해당하는 목록 조회
     */
    public List<MoneyBookAuthorize> findMoneyBookAuthorizeByUserEmail( String userEmail,
                                                                           List<Authorize> authorizes );

    /**
     * id에 해당하는 가계부 조회
     * @param bookId
     * @return 가계부
     */
    public MoneyBook getMoneyBook( long bookId );
}
