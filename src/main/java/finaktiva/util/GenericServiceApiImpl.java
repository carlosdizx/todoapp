package finaktiva.util;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public abstract class GenericServiceApiImpl<T, ID extends Serializable> implements GenericServiceApi<T, ID> {
    @Override
    @Transactional
    public T save(T entity) {
        return getDao().save(entity);
    }

    @Override
    @Transactional
    public void delete(ID id) {
        getDao().deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public T findByID(ID id) {
        final Optional<T> optionalT = getDao().findById(id);
        return optionalT.orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> getAll() {
        return getDao().findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<T> getAll(Pageable pageable) {
        return getDao().findAll(pageable);
    }

    public abstract JpaRepository<T, ID> getDao();
}
