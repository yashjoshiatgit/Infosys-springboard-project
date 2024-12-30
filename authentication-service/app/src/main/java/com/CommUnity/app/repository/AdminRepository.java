    package com.CommUnity.app.repository;

    import com.CommUnity.app.model.Admin;
    import org.springframework.data.mongodb.repository.MongoRepository;
    import java.util.Optional;

    /**
     * Repository for Admin entity with MongoDB.
     */
    public interface AdminRepository extends MongoRepository<Admin, String> {
        Optional<Admin> findByUsername(String username);
    }
