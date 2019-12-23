package com.hst.reminder.member.infra;

import com.hst.reminder.member.domain.Member;
import com.hst.reminder.member.domain.MemberId;
import com.hst.reminder.member.domain.MemberRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * @author dlgusrb0808@gmail.com
 */
@Repository
public class JpaMemberRepository implements MemberRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Member> findAll() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Member> criteriaQuery = cb.createQuery(Member.class);
		TypedQuery<Member> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public Member findById(MemberId memberId) {
		return entityManager.find(Member.class, memberId);
	}

	@Override
	public void save(Member member) {
		entityManager.persist(member);
	}
}
