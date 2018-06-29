/**
 * The MIT License (MIT)
 *
 * MSUSEL DataModel
 * Copyright (c) 2015-2018 Montana State University, Gianforte School of Computing,
 * Software Engineering Laboratory
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package edu.montana.gsoc.msusel.dao

import com.google.inject.persist.Transactional
import edu.montana.gsoc.msusel.datamodel.measures.Rule
import edu.montana.gsoc.msusel.datamodel.measures.RuleRepository

import javax.persistence.NonUniqueResultException
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Root
/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
class RuleDAOImpl extends GenericDAOImpl<Rule, Long> implements RuleDAO {

    RuleDAOImpl() {
        super(Rule.class)
    }

    @Transactional
    RuleRepository findParent(String key) {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder()
            CriteriaQuery<RuleRepository> f = em.getCriteriaBuilder().createQueury(RuleRepository.class)
            Root<Rule> r = f.from(entityClass)
            f.select(r.<RuleRepository>get("repository")).where(cb.equal(r.get("ruleKey"), key))
            return em.createQuery(f).getSingleResult()
        } catch (NonUniqueResultException ex) {
            return null
        }
    }

    @Transactional
    @Override
    Rule findByKey(String key) {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder()
            CriteriaQuery<Rule> c = em.getCriteriaBuilder().createQuery(entityClass)
            Root<Rule> r = c.from(entityClass)
            c.select(r).where(cb.equal(r.get("ruleKey"), key))
            return em.createQuery(c).getSingleResult()
        } catch (NonUniqueResultException ex) {
            return null
        }
    }

    @Transactional
    @Override
    List<Rule> findAll(String ownerKey) {
        CriteriaBuilder cb = em.getCriteriaBuilder()
        CriteriaQuery<Rule> cq = cb.createQuery(entityClass)
        Root<Rule> c = cq.from(entityClass)
        cq.select(c).where(cb.equal(c.<RuleRepository>get("repository").<String>get("repoKey"), ownerKey))
        return em.createQuery(cq).getResultList()
    }
}