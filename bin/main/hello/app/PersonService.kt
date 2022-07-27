package hello.app

import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import jakarta.inject.Singleton
import javax.transaction.Transactional

@Singleton
open class PersonService(private val personRepository: PersonRepository) {

    @Transactional
    open suspend fun addPerson(name: String): Person {
        try {

            if (personRepository.existsByName("John")) {
                return personRepository.findByName("John")
            }

            return personRepository.save(Person(id = 1, name = "John"))
        } catch (e: Exception) {
            throw e
        }
    }

    open suspend fun list(searchTerm: String, pageable: Pageable): Page<Person> {
        return personRepository.findByNameIlikeOrderByIdDesc(searchTerm, pageable)
    }
}
