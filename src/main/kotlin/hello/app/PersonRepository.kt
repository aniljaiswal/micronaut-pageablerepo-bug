package hello.app

import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.data.model.Sort
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.r2dbc.annotation.R2dbcRepository
import io.micronaut.data.repository.jpa.kotlin.CoroutineJpaSpecificationExecutor
import io.micronaut.data.repository.kotlin.CoroutineCrudRepository
import io.micronaut.data.repository.kotlin.CoroutinePageableCrudRepository
import kotlinx.coroutines.flow.Flow

@R2dbcRepository(dialect = Dialect.POSTGRES)
interface PersonRepository : CoroutinePageableCrudRepository<Person, Long> {
    suspend fun existsByName(name: String): Boolean

    suspend fun findByName(name: String): Person

    suspend fun findByNameIlikeOrderByIdDesc(searchTerm: String, pageable: Pageable): Page<Person>
}
