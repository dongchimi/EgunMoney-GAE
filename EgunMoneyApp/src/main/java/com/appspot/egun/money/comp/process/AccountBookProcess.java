package com.appspot.egun.money.comp.process;

import java.util.List;

import com.appspot.egun.money.comp.domain.AccountBook;
import com.appspot.egun.money.comp.domain.AccountBookAuthorize;
import com.appspot.egun.money.comp.domain.EgunUser;

public interface AccountBookProcess {
	
	/**
	 * 장부 등록
	 * @param book
	 * @return
	 */
	public Long reigsterAccountBook(AccountBook book);
	
	/**
	 * 사용자의 장부 목록 조회
	 * @param userEmail 사용자 이메일
	 * @return 장부 목록
	 */
	public List<AccountBook> findAccountBookByUserEmail(String userEmail);
	
	/**
	 * 사용자의 기본 장부 조회
	 * @param userEmail 사용자 이메일
	 * @return 장부 
	 */
	public AccountBook findDefaultAccountBookByUserEmail(String userEmail);
	
	/**
	 * 가계부 권한 부여
	 * @param authorize
	 * @return
	 */
	public Long registerAccountBookAuthorize(AccountBookAuthorize authorize);
	
	/**
	 * 가계부 권한 확인
	 * @param user
	 * @param book
	 * @return
	 */
	public boolean hasAccountBookAuthorize(EgunUser user, AccountBook book);
}
