package com.appspot.egun.money.comp.service;

import java.util.List;

import com.appspot.egun.money.comp.domain.AccountBook;
import com.appspot.egun.money.comp.domain.AccountBookAuthorize;
import com.appspot.egun.money.comp.domain.EgunAuthorize;
import com.appspot.egun.money.comp.domain.EgunUser;

/**
 * 가계부 Sheet 서비스
 * @author dklee
 * @since 2010.09.03
 *
 */
public interface AccountBookService
{
    /**
     * 장부 등록
     * @param book
     * @return
     */
    public Long reigsterAccountBook( AccountBook book );

    /**
     * 사용자의 기본 장부 조회
     * @param userEmail 사용자 이메일
     * @return 장부 
     */
    public AccountBook findDefaultAccountBookByUserEmail( String userEmail );

    /**
     * 가계부 권한 부여
     * @param authorize
     * @return
     */
    public Long registerAccountBookAuthorize( AccountBookAuthorize authorize );

    /**
     * 가계부 권한 확인
     * @param user
     * @param book
     * @return
     */
    public boolean hasAccountBookAuthorize( EgunUser user, AccountBook book );

    /**
     * 해당하는 권한 목록 조회
     * @param userEmail 사용자 email
     * @param authorizes 권한목록
     * @return 사용자 email과 필요한 권한에 해당하는 목록 조회
     */
    public List<AccountBookAuthorize> findAccountBookAuthorizeByUserEmail( String userEmail,
                                                                           List<EgunAuthorize> authorizes );

    /**
     * id에 해당하는 가계부 조회
     * @param bookId
     * @return 가계부
     */
    public AccountBook getAccountBook( long bookId );
}
