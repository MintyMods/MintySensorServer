package info.mintymods.mss.webapp.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditQuery;

import info.mintymods.repository.entities.Reading;

public class MsmAuditService {

	@PersistenceContext
	private EntityManager entityManager;

	public void checkAudit(final Number testid) {
		entityManager = entityManager.getEntityManagerFactory().createEntityManager();
		final AuditReader reader = AuditReaderFactory.get(entityManager);
		try {
			long start = System.currentTimeMillis();
			final List<Number> revisionNumbers = reader.getRevisions(Reading.class, testid);
			long end = System.currentTimeMillis();
			System.out.println("Revisions Count::" + revisionNumbers.size() + " @ " + (end - start));
			if (revisionNumbers.size() > 2) {
				final AuditQuery query = reader.createQuery().forRevisionsOfEntity(Reading.class, false, true);
				// query.add(AuditEntity.property("name").eq("GPU Temperature"));
				// final Number revision = (Number) query.getResultList();
				start = System.currentTimeMillis();
				@SuppressWarnings("unchecked")
				final List<Object[]> entities = query.getResultList();
				end = System.currentTimeMillis();
				System.out.println("Enityt COunt::" + entities.size() + " @ " + (end - start));
				for (final Object[] object : entities) {
					try {
						final Reading reading = (Reading) object[0];
						reading.getName();
					} catch (final Throwable t) {
						System.out.println(t.getMessage());
					}
				}
				final Reading oldReading = reader.findRevision(Reading.class, 1);
				@SuppressWarnings("unused")
				final double value = oldReading.getValue();
			}
		} catch (final Throwable t) {
			System.out.println(t.getMessage());
		}
	}
}
